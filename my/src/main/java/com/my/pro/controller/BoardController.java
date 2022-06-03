package com.my.pro.controller;


import com.my.pro.dto.BoardDto;
import com.my.pro.dto.PageHandler;
import com.my.pro.dto.SearchCondition;
import com.my.pro.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")// 1.리스트 목록이 보여야한다. 2.검색하면 원하는 게시물이나와야한다.
    public String list(SearchCondition sc, HttpServletRequest request, Model m) {
        if(!logcheck(request)) {
            return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
        }
    //게시물 목록 출력 :페이지랑 전체 게시물 갯수랑 네비게이션 필요
        try {
            int totalCnt= boardService.getSearchResultCount(sc);
            PageHandler ph = new PageHandler(totalCnt, sc);
                // 그리고 전달해줄 모델필요   네비게이션 만들어질려면 page, total,rowCnt 필요
            m.addAttribute("totalCnt",totalCnt);
            List<BoardDto> list = boardService.getSearchResultPage(sc);
            System.out.println(list);
            System.out.println(sc);
            System.out.println(ph);

            m.addAttribute("list",list);
            m.addAttribute("sc",sc);
            m.addAttribute("ph",ph);
        } catch (Exception e) {
           e.printStackTrace(); // 오류나면 게시글 안보여야지
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        m.addAttribute("sc",sc);
        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    //게시글 읽기 :게시글의 번호(bno)를 기준으로! 번호받아서 찾고 제목,내용을 담아서 출력
    @GetMapping("/read")
    public String read(SearchCondition sc,Integer bno, Model m,RedirectAttributes attr){
        try {
            //1. 해당번호를 가진 게시물을 읽기
            BoardDto boardDto = boardService.read(bno);
            //2. 읽은걸 뷰에 전달하자
            m.addAttribute("boardDto", boardDto);
            //3. 근데 나중에 목록으로 돌아올때 내가 있던 페이지에 있어야해!
            // 그럼 페이지가 필요한데 목록한테 달라고한다. 리스트가 줘야 알수있어
            // 근데 위에 매개변수로 들어가게되면 @ModelAttribute가 붙어서 간다!

        } catch (Exception e) {
            e.printStackTrace();
            attr.addAttribute("msg", "READ_ERR");
            return "redirect:/board/list"+sc.getQueryString();
        }
        return "board";
    }

    //게시물삭제하기
    @PostMapping("/remove")
    public String remove(HttpSession session, Integer bno,SearchCondition sc,
                         Model m ,RedirectAttributes attr){
        //삭제버튼누르면 해당 번호의 게시물을 삭제하자. (작성자만 삭제하기)
        //삭제되면 목록페이지로가야지, 그리고 목록도 그게삭제된지 알아야지
        //목록페이지로 가려면 내가 있던 페이지알아야해유
        //1. 작성자를 알아내야지 >> 세션에서
        String writer = (String)session.getAttribute("id");
        try {
            //2. 삭제하면 목록으로 돌아가기위해 모델에 페이지담아주기
                //쿼리스트링으로 붙게된다!!\
            //3. 작성자랑 게시물번호 확인해서 삭제하기
                int cnt = boardService.remove(bno,writer);
                //3-1 삭제안되면 에러던지기
            if(cnt!=1) {
                throw new Exception("Board remove Err");
            }
                //3-2삭제 잘됐으면 알려주자 목록으로 가면서 메세지 던지
             attr.addAttribute("msg", "OK");
                return "redirect:/board/list";

        } catch (Exception e) {
            e.printStackTrace();
            //삭제안되서 예외발생하면???
            attr.addAttribute("msg","ERR");

        }
        return "redirect:/board/list"+sc.getQueryString();

    }

    //게시글 쓰기 창보여주는 메소드
    @GetMapping("/write")
    public String write(Model m, SearchCondition sc){
        // 원래는 뷰만 보여주면되는데 지금 같은 뷰로 글쓰기 읽기 하니까!! 구분가게해주기!!
        m.addAttribute("mode","new"); //이게 가면 글쓰기
        return "board";
    }


    //게시글 등록하는 메소드
    @PostMapping("/write")
    public String write(SearchCondition sc, BoardDto boardDto , Model m, HttpSession session,RedirectAttributes attr){
        //게시글 쓴게 넘어오겠지? 그걸 등록해야됨. 근데 작성자는? 세션이겠지?
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);
        
        try {
          //작성자까지 넣어줬으면 등록하셈 근데 예외발생할수있겠쥬
            //예외는 아니더라고 0 이면 작성안된거
            if (boardService.write(boardDto) != 1)
                throw new Exception("Write failed.");
            //잘등록됐으면 메세지보내주자
            attr.addAttribute("msg","WR_OK");
            //등록하고 목록으로 가라
            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            //실패하면 입력했던 내용들 다 없어져버려서 그거 다시줘야지
            m.addAttribute(boardDto);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "WRT_ERR");

            //예외 발생하면 다시 글쓰기화면 보여줘야지
            return "board";
            
        }
    }

    //게시글 수정하기
    @PostMapping("/modify")
    public String modify(SearchCondition sc, BoardDto boardDto , Model m, HttpSession session,RedirectAttributes attr){
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);

        try {

            if(boardService.modify(boardDto)!=1)
                throw new Exception("Mod_Fail");
            //잘등록됐으면 메세지보내주자

            attr.addAttribute("msg","MOD_OK");
            //등록하고 목록으로 가라
            m.addAttribute("sc",sc);
            return "redirect:/board/list"+sc.getQueryString();
        } catch (Exception e) {
            e.printStackTrace();
            //실패하면 입력했던 내용들 다 없어져버려서 그거 다시줘야지
            m.addAttribute("boardDto",boardDto);

            attr.addAttribute("msg","MOD_ERR");
            //예외 발생하면 다시 글쓰기화면 보여줘야지
            return "board";
        }
    }


    private boolean logcheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("id")!=null;


    }

}

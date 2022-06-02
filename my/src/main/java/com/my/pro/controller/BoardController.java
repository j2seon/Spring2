package com.my.pro.controller;


import com.my.pro.dto.BoardDto;
import com.my.pro.dto.PageHandler;
import com.my.pro.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/list")// 리스트 목록이 보여야한다.
    public String list(Integer page, Integer rowCnt, HttpServletRequest request, Model m) {
        if(!logcheck(request)) {
            return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
        }

        if(page==null) page=1;
        if(rowCnt==null) rowCnt=10;


        try { //게시물 목록 출력 : page랑 전체 게시물 갯수랑 네비게이션 필요
                // 그리고 전달해줄 모델필요   네비게이션 만들어질려면 page, total,rowCnt 필요
            int totalCnt=boardService.getCount();
            PageHandler ph = new PageHandler(totalCnt,page,rowCnt);
            m.addAttribute("totalCnt",totalCnt);

            Map map = new HashMap();
            map.put("offset",(page-1)*rowCnt);
            map.put("rowCnt",rowCnt);
            System.out.println(map);
            List<BoardDto> list = boardService.getPage(map);
            m.addAttribute("list",list);
            m.addAttribute("ph",ph);
            m.addAttribute("page",page);
            m.addAttribute("rowCnt",rowCnt);

        } catch (Exception e) {
           e.printStackTrace();
        }


        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }


    //게시글 읽기 :게시글의 번호(bno)를 기준으로! 번호받아서 찾고 제목,내용을 담아서 출력
    @GetMapping("/read")
    public String read(Integer page, Integer rowCnt ,Integer bno, Model m){
        try {
            //1. 해당번호를 가진 게시물을 읽기
            BoardDto boardDto = boardService.read(bno);
            //2. 읽은걸 view에게 전달하자
            m.addAttribute("boardDto", boardDto);
            //3. 근데 나중에 목록으로 돌아올때 내가 있던 페이지에 있어야해!
            // 그럼 페이지랑 페이지row가 필요한데 list한테 달라고한다. 리스트가 줘야 알수있어!
            m.addAttribute("page",page);
            m.addAttribute("rowCnt",rowCnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board";
    }

    //게시물삭제하기
    @PostMapping("/remove")
    public String remove(HttpSession session, Integer bno, Integer page, Integer rowCnt , Model m,RedirectAttributes rttr){
        //삭제버튼누르면 해당 번호의 게시물을 삭제하자. (작성자만 삭제하기)
        //삭제되면 list페이지로가야지, 그리고 list도 그게삭제된지 알아야지
        //목록페이지로 가려면 내가 있던 페이지알아야해유
        //1. 작성자를 알아내야지 >> 세션에서
        String writer = (String)session.getAttribute("id");

        try {
            //2. 삭제하면 list로 돌아가기위해 model에 page담아주기
                //쿼리스트링으로 붙게된다!!
                m.addAttribute("page",page);
                m.addAttribute("rowCnt",rowCnt);
            //3. 작성자랑 게시물번호 확인해서 삭제하기
                int cnt = boardService.remove(bno,writer);
                //3-1 삭제안되면 에러던지기
            if(cnt!=1) throw new Exception("Board remove Err");
                //3-2삭제 잘됐으면 알려주자 list로 가면서 메세지 던지기

                rttr.addFlashAttribute("msg", "OK");
                return "redirect:/board/list";

        } catch (Exception e) {
            e.printStackTrace();
            //삭제안되서 예외발생하면???
            rttr.addFlashAttribute("msg","ERR");

        }
        return "redirect:/board/list";
    }



    private boolean logcheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("id")!=null;
    }

}

package com.fastcampus.ch4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.PageHandler;
import com.fastcampus.ch4.domain.SearchCondition;
import com.fastcampus.ch4.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public String write(Model m){ //글쓰는 화면으로 넘어가기
        //borad 읽기 전용과 쓰기 까지 가능한 버전 두개로 해야된다.
        m.addAttribute("mode","new");
        return "board"; //쓰기가 가능할때 new 라고 주기 >> mode=new 일때는 쓰기가 가능하게 세팅한다.
    }
    @PostMapping("/write")//글 다쓰고 전송하기
    public String write(BoardDto boardDto, HttpSession session, Model m, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);//글쓴사람 id를 넣고

        try {
            int rowCnt = boardService.write(boardDto);

            if(rowCnt!=1) //1이 아닐때 예외를 만든다.
                throw new Exception("Write Failed");

            //세션을 이용한 일회성 저장임.
            rattr.addFlashAttribute("msg","WRT_OK");



            return "redirect:/board/list";//redirect를 통해서 리스트페이지가 보이게 할것임.
        } catch (Exception e) {
            e.printStackTrace();
            //m.addAttribute("boardDto",boardDto); //다시 입력했던 곳으로 이동
            m.addAttribute(boardDto);
            rattr.addFlashAttribute("msg","WRT_ERR");
            return "board";
        }

    }

    @PostMapping("/modify")//수정해서 등록하기
    public String modify(Integer page, Integer pageSize, BoardDto boardDto, HttpSession session, Model m, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);//글쓴사람 id를 넣고

        try {
            int rowCnt = boardService.modify(boardDto);

            if(rowCnt!=1) //1이 아닐때 예외를 만든다.
                throw new Exception("Modify Failed");

            //세션을 이용한 일회성 저장임.
            rattr.addFlashAttribute("msg","MOD_OK");
            m.addAttribute("page",page);
            m.addAttribute("pageSize", pageSize);


            return "redirect:/board/list";//redirect를 통해서 리스트페이지가 보이게 할것임.
        } catch (Exception e) {
            e.printStackTrace();
            //m.addAttribute("boardDto",boardDto); //다시 입력했던 곳으로 이동
            m.addAttribute(boardDto);
            rattr.addFlashAttribute("msg","MOD_ERR");
            return "board";
        }

    }




    @PostMapping("/remove") //RedirectAttributes에다가 저장하면 메세지가 한번만 뜨개된다!!
    public String remove(Integer bno, Integer page, Integer pageSize, Model m , HttpSession session, RedirectAttributes rattr) {
        //삭제할 페이지의 번호와 페이지, 페이지 사이즈, 전달할 모델이 필요
        String writer = (String)session.getAttribute("id");
        try {
                m.addAttribute("page", page);
                m.addAttribute("pageSize", pageSize);

           int rowCnt = boardService.remove(bno,writer);

           if(rowCnt!=1)
               throw new Exception("Board remove error");

           //한번쓰고 없어진다
            rattr.addFlashAttribute("msg","Delete");

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","Delete_Err");
        }

        //삭제 후에 리스트페이지로 돌아가야한다.
        return "redirect:/board/list";
    }


    @GetMapping("/read")
    public String read(Integer bno,Integer page, Integer pageSize, Model m){
        //요청받은 걸 읽고 view에 전달해야함. > model필요
        try {
            BoardDto boardDto = boardService.read(bno);
           // m.addAttribute("boardDto", boardDto);//아래와 동일
            m.addAttribute(boardDto); //이름을 생략할 수 있다. 타입의 첫글자로 소문자한걸 이름으로 두면됨.
            m.addAttribute("page", page);
            m.addAttribute("pageSize",pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //읽어서 board.jsp로 보여줘야한다.
        return "board";
    }


    @GetMapping("/list")//Integer page, Integer pageSize,String keyword, String option >>SearchCondition 으로 바꿀수있다.
    public String list(SearchCondition sc, Model m, HttpServletRequest request) {
        if (!loginCheck(request))
            return "redirect:/login/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동



        try {
            int totalCnt = boardService.getsearchResultCnt(sc);
            //네비게이션을 만들기 위함 .
            PageHandler pageHandler = new PageHandler(totalCnt , sc);


            List<BoardDto> list = boardService.getrSearchResultPage(sc);
            m.addAttribute("list" , list);
            m.addAttribute("pageHandler",pageHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id") != null;
    }
}
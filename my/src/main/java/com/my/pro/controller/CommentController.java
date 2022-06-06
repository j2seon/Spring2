package com.my.pro.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.my.pro.dto.CommentDto;
import com.my.pro.service.CommentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    //댓글 보여주는 컨트롤러

    @Autowired
    CommentService commentService;

    //댓글 리스트
    @GetMapping("/comments") //어떤 게시물지 알아야함. bno를 받아야할듯
    @ResponseBody
    public ResponseEntity<List<CommentDto>> list(Integer bno) {
        List<CommentDto> list = null;
        try {
            list = commentService.getList(bno);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.BAD_REQUEST);
        }
    }

    //댓글 삭제
    @DeleteMapping("/comments/{cno}") // 어떤 댓글? 삭제할 댓글 번호 이렇게 적으려면 PathVariable명시 쿼리스트링이 아님!!!
    @ResponseBody
    public ResponseEntity<String> reomve(@PathVariable Integer cno, Integer bno, HttpSession session) {
        //댓글 번호, 게시글번호 작성자를 알아야 그 댓글을 없앤다  . 작성자일때만 없애도록 commenter을 가져오자
        String commenter = (String)session.getAttribute("id");
        try {
            int rowCnt = commentService.remove(cno, bno, commenter);

            if (rowCnt != 1)
                throw new Exception("Delete Fail");
            return new ResponseEntity<String>("Del_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Del_Err", HttpStatus.BAD_REQUEST);
        }
    }


    //댓글 저장
    @PostMapping("/comments") //어떤 게시글인지?
    @ResponseBody
    public ResponseEntity<String> write(@RequestBody CommentDto dto, Integer bno, HttpSession session) {
        String commenter = (String)session.getAttribute("id");
//        String commenter = "asdf";
        //현재 세션가지고 있는애가 작성하는거니까 작성자를 setter로 지정/ 어떤 게시물인지 알아야하니까 ! bno도
        dto.setCommenter(commenter);
        dto.setBno(bno);

        try {
            int rowCnt = commentService.write(dto);
            System.out.println(dto);

            if (rowCnt != 1)
                throw new Exception("Write Fail");
            return new ResponseEntity<String>("Write_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Write_Fail", HttpStatus.BAD_REQUEST);

        }
    }

    //댓글 수정
    @PatchMapping("/comments/{cno}") //어떤 댓글인지
    @ResponseBody
    public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody CommentDto dto, HttpSession session) {
        String commenter = (String)session.getAttribute("id");
        dto.setCommenter(commenter);
        dto.setCno(cno);


        try {

            int rowCnt = commentService.modify(dto);
            if (rowCnt != 1)
                throw new Exception("MOD Fail");

            return new ResponseEntity<String>("MOD_OK", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("MOD_Fail", HttpStatus.BAD_REQUEST);
        }
    }
}
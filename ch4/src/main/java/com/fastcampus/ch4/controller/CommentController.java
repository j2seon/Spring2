package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.CommentDto;
import com.fastcampus.ch4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody //클래스에 붙게되면 메서드에는 작성하지 않아도 되지롱!!
public class CommentController {

    //서비스 주입받아야지유
    @Autowired
    CommentService service;

    @GetMapping("/comments") //comments bno를 받야할듯!! (게시물 번호)
    @ResponseBody // 에러가 일어나도 200번으로 성공한다. 그럴때 구분할 수 있어야함.ResponseEntity이용
    public ResponseEntity<List<CommentDto>>list(Integer bno){//어렵게 생각 x 그냥 상태코드를 보내는 것!!
        List<CommentDto> list =null;
        try {
             list = service.getList(bno);
        return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK); //200
        } catch (Exception e) {
            e.printStackTrace();
        return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST); //400
        }
    }

    //지정된 댓글을 삭제하는 메소드
    @DeleteMapping("/comments/{cno}") //comments/1&bno=111 <<< 삭제할 댓글번호 뒤에 오는 bno부터는 쿼리스트링
                        //이렇게 cno를 읽어올거면 PathVariable를 붙여야한다 쿼리스트링이 x
    @ResponseBody
    public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno, HttpSession session){
        //작성자는 세션에서 가져와야한다.
        //String commenter = (String)session.getAttribute("id");
        String commenter = "asdf";

        try {
            int rowCnt = service.remove(cno,bno,commenter);

            if(rowCnt != 1) throw new Exception("DeleteFailed"); //실패할경우

            return new ResponseEntity<String>("DEL_OK",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("DEL_ERR",HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @PostMapping("/comments") //?bno=
    //댓글을 저장하는 메서드 cno 필요없음 왜 ? 자동증가로 해놔서!
    public ResponseEntity<String> write(@RequestBody CommentDto dto,Integer bno, HttpSession session){
        //작성자는 세션에서 가져와야한다. 댓글 쓴 사람 필요, 입력한 내용 필요
        //String commenter = (String)session.getAttribute("id");
        String commenter = "asdf";
        dto.setCommenter(commenter); //dto를 입력한 사람 설정
        dto.setBno(bno);

        System.out.println(dto);

        try {
            if(service.write(dto) != 1)
                throw new Exception("Write failed");

            return new ResponseEntity<String>("WRT_OK",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("WRT_ERR",HttpStatus.BAD_REQUEST);
        }
    }
/* json 코드
{ 헤더에다가 ContentType  application/json 내가 보내는 타입이 json이야 ~ 가 있어야함.
"pcno":0,
"comment" : "hi"
}

*/
//    { 수정 시
//        "pcno":0,
//        "comment" : "hihihi",
//       "commenter" : "asdf"
//    }


    //댓글을 수정하는 메소드
    @ResponseBody
    @PatchMapping("/comments/{cno}") // 수정은 PATCH를 이용한다.
    public ResponseEntity<String> modify(@PathVariable Integer cno ,@RequestBody CommentDto dto, HttpSession session){
        //작성자는 세션에서 가져와야한다.
        //String commenter = (String)session.getAttribute("id");
        String commenter = "asdf";
        dto.setCommenter(commenter);
        dto.setCno(cno);
        System.out.println(dto);

        try {
            if(service.modify(dto) != 1)
                throw new Exception("MOD failed");

            return new ResponseEntity<>("MOD_OK",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("MOD_ERR",HttpStatus.BAD_REQUEST);
        }
    }




}

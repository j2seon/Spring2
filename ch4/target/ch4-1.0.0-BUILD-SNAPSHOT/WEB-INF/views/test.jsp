<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<h2>{name:"abc", age:10}</h2>
comment:<input type="test" name="comment"><br> <!--글쓰기를 위한 자리-->
<button id="sendBtn" type="button">SEND</button>
<button id="modBtn" type="button">수정</button>
<div id="commentList"></div> <!--comment 목룍을 보여줄 자리-->
<script>
    let bno =11;//호출될 게시물 번호!! 변수선언
    let showList = function(bno){ //특정목록을 가져와야해서
        $.ajax({ //데이터 타입이 생략되면 json을 기본으로 받는다.
            type:'get',       // 요청 메서드
            url: '/ch4/comments?bno='+bno,  // 요청 URI
            success : function(result){ //들어오는 배열을 toHtml에 변환 함.
                $("#commentList").html(toHtml(result));    // 서버로부터 응답이 도착하면 commentList에 결과를 담음
                alert("received="+result);       // result는 서버가 전송한 데이터
            },
            error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    }
    $(document).ready(function(){ //글쓰기니까 post bno가 전역변수로 쓰여져 있음,
        showList(bno);
        $("#sendBtn").click(function(){
            let comment = $("input[name=comment]").val();
            if(comment.trim()==''){
                alert("댓글을 입력해주세요.");
                $("input[name=comment]").focus()
                return;
            }


            $.ajax({
                type:'POST',       // 요청 메서드
                url: '/ch4/commnets',  // 요청 URI //pro/comments?bno=111 이런식으로 가야함
                headers : { "content-type": "application/json"}, // 요청 헤더
                data : JSON.stringify({bno:bno, comment:comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success : function(result){
                    alert(result);
                    showList(bno); //등록이 새로 됐으니까 목록을 다시 불러와야함.
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
           //#sendBtn 클릭하면 showList(bno) 가 실행된다.
        });








        $("#commentList").on("click",".modBtn",function() {
            let cno = $(this).parent().attr("data-cno");
            let bno = $(this).parent().attr("data-bno");
            let comment =$("span.comment",$(this).parent()).text(); //텍스트를 가져오는데 한번에 가져와서 제약을 준다.
            //1. comment의 내용을 input에 뿌려주기               //클릭되면 클릭된 애의 부모에(li) 있는 span만가져옴
            $("input[name=comment]")
            //2. cno 전달하기
            $("modBtn").attr("data-cno",cno);
        });

        //$(".delBtn").click(function(){ //delBtn이 안만들어졌는데 요청한거라 실행이 안된다.
        $("#commentList").on("click",".delBtn",function(){  //따라서 고정된 요소에 걸어야함.
            let cno =$(this).parent().attr("data-cno");
            let bno =$(this).parent().attr("data-bno");

            $.ajax({ //데이터 타입이 생략되면 json을 기본으로 받는다.
                type:'DELTE',       // 요청 메서드
                url: '/ch4/comments/'+cno+'?bno='+bno,  //cno 값을 가져와야함.
                success : function(result){ //삭제가 성공하면
                    alert("received="+result);
                    showList(bno); //목록을 계속 나오게해야 보이겠지?
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $
        });
    });
    //html로 변환할 메소드
    let toHtml = function (comments){
        let tmp ="<ul>";
        comments.forEach(function (comment){
            tmp +='<li data-cno' + comment.cno
            tmp +='<li data-pcno' + comment.pcno
            tmp +='<li data-bno' + comment.bno + '>'
            tmp +='commenter=<span class="commenter">'+ comment.commenter+'</span>'
            tmp +='comment=<span class="comment">'+comment.commment + '</span>'
            tmp +='<button class="delBtn">삭제</button>'
            tmp +='<button class="modBtn">수정</button>'
            tmp +='</li>'
        })
        return tmp="</ul>"; //배열 들어온걸 html로 직접 변환해서 출력
    }


</script>
</body>
</html>
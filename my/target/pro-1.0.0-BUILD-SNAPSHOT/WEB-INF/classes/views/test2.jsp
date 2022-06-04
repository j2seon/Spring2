<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>

<body>



<div id="commstart">
    <div id="commentList">
    </div>
    <div id="comment-writeForm">
        comment : <textarea name="comment"></textarea><br>
        <button id="sendBtn" type="button">SEND</button>
        <button id="modBtn" type="button">MOD</button>
    </div>
    <div id="relyForm" style="display: none">
        <textarea  name="replyComment"></textarea>
        <button id="writeRepBtn" type="button">등록</button>
    </div>
</div>


<script>
    let bno = 629;
    //댓글목록을 가져와서 보여주자 게시물 번호에
    let showList = function (bno) {
        $.ajax({
            type:'GET',       // 요청 메서드
            url: '/pro/comments?bno='+ bno,  // 요청 URI
            success : function(result){
                $("#commentList").html(toHTML(result));
            },
            error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    }

    $(document).ready(function(){
        showList(bno);

        $("#sendBtn").click(function(){
            let comment=$("textarea[name=comment]").val()

            if(comment.trim()==''){
                alert("댓글을 입력해주세요");
                $("textarea[name=comment]").focus();
                return;
            }

            $.ajax({
                type:'POST',       // 요청 메서드
                url: '/pro/comments?bno='+bno,  // 요청 URI
                headers : { "content-type": "application/json"}, // 요청 헤더
                data : JSON.stringify({bno:bno, comment:comment }),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success : function(result){
                    alert(result);       // result는 서버가 전송한 데이터
                    showList(bno);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        });

        $("#commentList").on("click",".modBtn",function() {
            let cno = $(this).parent().attr("data-cno");
            let comment = $("div.comment",$(this).parent()).text();
            //1. 수정버튼 클릭시 내용을 input에 나오게하기
            $("textarea[name=comment]").val(comment);
            //2.cno 번호 전달
            $("#modBtn").attr("data-cno",cno);
        });

        $("#modBtn").click(function(){
            let comment=$("textarea[name=comment]").val()
            let cno=$(this).attr("data-cno");
            if(comment.trim()==''){
                alert("댓글을 입력해주세요");
                $("textarea[name=comment]").focus();
                return;
            }

            $.ajax({
                type:'PATCH',       // 요청 메서드
                url: '/pro/comments/'+cno,  // 요청 URI
                headers : { "content-type": "application/json"}, // 요청 헤더
                data : JSON.stringify({cno:cno, comment:comment }),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success : function(result){
                    alert(result);       // result는 서버가 전송한 데이터
                    showList(bno);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        });

        $("#commentList").on("click",".delBtn",function(){
            let cno= $(this).parent().attr("data-cno");
            let bno= $(this).parent().attr("data-bno");
            $.ajax({ //삭제버튼 누르면 넘어가는 데이터~
                type:'DELETE',       // 요청 메서드
                url: '/pro/comments/'+cno+'?bno='+ bno,  // 요청 URI
                success : function(result){//삭제되고 목록을 새로가져온다.
                    showList(bno);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        });

        $("#commentList").on("click",".replyBtn",function() {
            // 2.해당 댓글에 또 댓글다는거니까 바로 밑에 나올수 있도록 옮겨주기
            $("#relyForm").appendTo($(this).parent());
            //1.답글을 입력할 폼이 필요함. //폼을 만들어두고 속성값을 바꿔주자
            $("#relyForm").css("display","block");
        });

        $("#writeRepBtn").click(function(){
            let comment=$("textarea[name=replyComment]").val();
            let pcno = $("#relyForm").parent().attr("data-pcno");

            if(comment.trim()==''){
                alert("댓글을 입력해주세요");
                $("input[name=replyComment]").focus();
                return;
            }

            $.ajax({
                type:'POST',       // 요청 메서드
                url: '/pro/comments?bno='+bno,  // 요청 URI
                headers : { "content-type": "application/json"}, // 요청 헤더
                data : JSON.stringify({pcno:pcno, bno:bno, comment:comment }),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success : function(result){
                    alert(result);       // result는 서버가 전송한 데이터
                    showList(bno);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
            $("#relyForm").css("display","none");
            $("textarea[name=replyComment]").val('');
            $("#relyForm").appendTo("body");
        });



    });


    let toHTML = function (comments) {
        let tmp = "<ul>";

        comments.forEach(function (comment){
            tmp +='<li data-cno='+comment.cno
            tmp +=' data-pcno='+comment.pcno
            tmp +=' data-bno='+comment.bno +'>'
            tmp += '<div class="commenter">'+comment.commenter+'</div>'
            tmp += '<div class="comment">'+comment.comment+'</div>'
            tmp += '<div class="up_date">'+comment.up_date+'</div>'
            tmp += '<button class="delBtn">삭제</button>'
            tmp += '<button class="modBtn">수정</button>'
            tmp += '<button class="replyBtn">답글</button>'
            tmp += '</li>'

        })
        return tmp+"</ul>"
    }

</script>
</body>
</html>
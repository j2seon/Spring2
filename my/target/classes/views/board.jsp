<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId==''  ? 'Login' : loginId}"/>
<c:set var="RegisterLink" value="${loginId==''? '/register/add' : ''}"/>
<c:set var="Registercheck" value="${loginId=='' ? 'Sign Up' : 'My Cart'}"/>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/head.jsp"%>
    <link rel="stylesheet" href="<c:url value="/css/board.css"/>">
</head>
<body>
<script>
    let msg = "${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>

    <%@ include file="header.jsp"%>
    <div class="container">
        <h2 class="writing-header">게시판 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
        <form id="form" class="frm" action="" method="post">
            <input type="hidden" name="bno" value="${boardDto.bno}">

            <input name="title" type="text" value="<c:out value="${boardDto.title}"/> " placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
            <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value="${boardDto.content}"/> </textarea><br>
            <div id="boradBtn">
                <c:if test="${mode eq 'new'}">
                    <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
                </c:if>
                <c:if test="${mode ne 'new'}">
                    <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>
                </c:if>
                <c:if test="${boardDto.writer eq loginId}">
                    <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
                    <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
                </c:if>
                <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
            </div>
        </form>

        <div id="commstart">
            <div id="comment-writeForm">
                comment : <textarea name="comment" placeholder="댓글을 입력하세요"></textarea><br>
                <button id="sendBtn" type="button">SEND</button>
                <button id="modBtn" style="display: none"  type="button">MOD</button>
            </div>
            <div id="commentList"></div>
            <div id="relyForm" style="display: none">
                <textarea  name="replyComment"placeholder="댓글을 입력하세요"></textarea>
                <button id="writeRepBtn" type="button">등록</button>
                <button id="writeRepCan" type="button">취소</button>
            </div>

            <div id="modalWin" class="modal">
                <!-- Modal content -->
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p>
                        <h2>  댓글 수정</h2>
                        <div id="modify-writebox">
                        <div class="commenter commenter-writebox"><i class="fa fa-user-circle" aria-hidden="true"></i></div>
                                <div class="modify-writebox-content">
                                    <textarea name="comm" id="comm" cols="30" rows="5" placeholder="댓글을 남겨보세요"></textarea>
                                </div>
                            <div id="modify-writebox-bottom">
                                <div class="register-box">
                                    <a href="#" class="btn" id="btn-write-modify">등록</a>
                                </div>
                            </div>
                        </div>
                    </p>
                </div>
             </div>
        </div>
    </div>

<script>
    <c:if test="${mode ne 'new'}">
    let bno = <c:out value="${boardDto.bno}"/>;
    </c:if>
    let showList = function (bno) {
        $.ajax({
            type:'GET',       // 요청 메서드
            url: '/pro/comments?bno='+ bno,  // 요청 UURI
            success : function(result){
                $("#commentList").html(toHTML(result));
            },
            error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    }



    $(document).ready(function() {
        let formCheck = function() {
            let form = document.getElementById("form");
            if($('input[name=title]').val().trim()=='') {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }
            if(form.content.length==0) {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $("#writeNewBtn").on("click", function(){
            location.href="<c:url value='/board/write'/>";
        });
        $("#writeBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/board/write'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });

        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');
            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $(".writing-header").html("게시판 수정");
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                return;
            }
            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/board/modify${searchCondition.queryString}'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });

        $("#removeBtn").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;
            let form = $("#form");
            form.attr("action", "<c:url value='/board/remove${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#listBtn").on("click", function(){
            location.href="<c:url value='/board/list${searchCondition.queryString}'/>"
        });

        showList(bno);

        $("#sendBtn").click(function () {
            let comment = $("textarea[name=comment]").val();
            if (comment.trim() == '') {
                alert("댓글을 입력해주세요");
                $("textarea[name=comment]").focus();
                return;
            }
            $.ajax({
                type: 'POST',       // 요청 메서드
                url: '/pro/comments?bno=' + bno,  // 요청 URI
                headers: {"content-type": "application/json"}, // 요청 헤더
                data: JSON.stringify({bno: bno, comment: comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success: function () {
                    alert("등록되었습니다.");       // result는 서버가 전송한 데이터
                    showList(bno);
                },
                error: function () {
                    alert("error")
                } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
            $("input[name=comment]").val('');
        });

        $("#commentList").on("click",".replyBtn",function() {
            // 2.해당 댓글에 또 댓글다는거니까 바로 밑에 나올수 있도록 옮겨주기
            $("#relyForm").appendTo($(this).parent());
            //1.답글을 입력할 폼이 필요함. //폼을 만들어두고 속성값을 바꿔주자
            $("#relyForm").css("display","block");
        });

        $("#writeRepCan").click(function (){
            $("#relyForm").css("display","none");
        });


        $("#writeRepBtn").click(function(){
            let comment=$("textarea[name=replyComment]").val();
            let pcno = $(".replyBtn").attr("data-pcno");
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



        $("#commentList").on("click",".delBtn",function(){
            let cno= $(this).attr("data-cno");
            let bno= $(this).attr("data-bno");
            $.ajax({ //삭제버튼 누르면 넘어가는 데이터~f
                type:'DELETE',       // 요청 메서드
                url: '/pro/comments/'+cno+'?bno='+ bno,  // 요청 URI
                success : function(){//삭제되고 목록을 새로가져온다.
                    alert("삭제되었습니다.")
                    showList(bno);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        });

        $("#commentList").on("click",".modBtn",function() {
            let cno = $(this).attr("data-cno");
            let comment = $("#com-comment").text();
            let bno = $(this).attr("data-bno");
            let pcno = $(this).attr("data-pcno");
            let commenter = $("#com-commenter").text();

            $("#modalWin .commenter").text(commenter);
            $("#modalWin textarea").text(comment);
            $("#btn-write-modify").attr("data-cno", cno);
            $("#btn-write-modify").attr("data-pcno", pcno);
            $("#btn-write-modify").attr("data-bno", bno);

            // 팝업창을 열고 내용을 보여준다.
            $("#modalWin").css("display","block");
        });

        $("#btn-write-modify").click(function(){
            let comment = $("textarea[name=comm]").val();
            let cno = $("#btn-write-modify").attr("data-cno");
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

        $(".close").click(function(){
            $("#modalWin").css("display","none");
        });

    });

    let toHTML = function (comments) {
        let tmp = "<ul>";

        comments.forEach(function (comment){
            tmp +='<li data-cno='+comment.cno
            tmp +=' data-pcno='+comment.pcno
            tmp +=' data-bno='+comment.bno +'>'
            if(comment.cno!=comment.pcno){
            tmp += '<div style="background-color: azure" id="com-commenter" name="commenter" class="commenter"><i class="fa fa-user-circle" aria-hidden="true"></i>&ensp;'+comment.commenter+'님의 답글</div>'
            tmp += '<div id="com-comment" name="comment" class="comment">'+comment.comment+'</div>'
            }else{
            tmp += '<div id="com-commenter" name="commenter" class="commenter"><i class="fa fa-user-circle" aria-hidden="true"></i>&ensp;'+comment.commenter+'</div>'
            tmp += '<div id="com-comment" name="comment" class="comment">'+comment.comment+'</div>'
            }
            // tmp += '<div id="com-comment" name="comment" class="comment">'+comment.comment+'</div>'
            tmp += '<div class="comment-bott">'
            tmp +='<a href="#" class="delBtn" data-cno='+comment.cno
            tmp +=' data-pcno='+comment.pcno
            tmp +=' data-bno='+comment.bno +'>삭제</a>'
            tmp +='<a href="#" class="modBtn" data-cno='+comment.cno
            tmp +=' data-pcno='+comment.pcno
            tmp +=' data-bno='+comment.bno +'>수정</a>'
            tmp +='<a href="#" class="replyBtn" data-cno='+comment.cno
            tmp +=' data-pcno='+comment.pcno
            tmp +=' data-bno='+comment.bno +'>답글</a>'
            tmp += '<span class="up_date">'+comment.up_date+'</span>'
            tmp +='</div>'
            tmp += '</li>'
        })
        return tmp+"</ul>"
    }




</script>
</body>
</html>
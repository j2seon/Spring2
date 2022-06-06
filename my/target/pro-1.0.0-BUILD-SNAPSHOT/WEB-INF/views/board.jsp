<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<c:set var="RegisterLink" value="${loginId==''? '/register/add' : ''}"/>
<c:set var="Registercheck" value="${loginId=='' ? 'Sign Up' : 'My Cart'}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BOARD</title>
    <link rel="stylesheet" href="<c:url value='/css/board.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: "Noto Sans KR", sans-serif;
        }
        .container ,#commstart{
            width : 50%;
            margin : auto;
        }
        #commstart{
            margin-bottom: 50px;
        }
        .writing-header {
            position: relative;
            margin: 20px 0 0 0;
            padding-bottom: 10px;
            border-bottom: 1px solid #323232;
        }
        input {
            width: 100%;
            height: 35px;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            padding: 8px;
            background: #f8f8f8;
            outline-color: #e6e6e6;
        }
        textarea {
            width: 100%;
            background: #f8f8f8;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            resize: none;
            padding: 8px;
            outline-color: #e6e6e6;
        }
        .frm {
            width:100%;
        }
        .container{
            margin-bottom: 30px;
        }



        .btn {
            background-color: rgb(236, 236, 236); /* Blue background */
            border: none; /* Remove borders */
            color: black; /* White text */
            padding: 6px 12px; /* Some padding */
            font-size: 16px; /* Set a font size */
            cursor: pointer; /* Mouse pointer on hover */
            border-radius: 5px;
        }
        .btn:hover {
            text-decoration: underline;
        }

        .sidbtn{
            position:fixed;
            top:0px;
            left:20px;

        }
        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 30px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }

        .navbar {
            width: 100%;
            background-color: #ffff;
            overflow: auto;
        }
        .navbar a {
            float: right;
            padding: 22px;
            color:black;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: #04AA6D;
        }

        .active  {
            /* background-color: #04AA6D; */
        }

        @media screen and (max-width: 500px) {
            .navbar a {
                float: none;
                display: block;
            }
        }
        #modify-writebox {
            background-color: white;
            border : 1px solid #e5e5e5;
            border-radius: 5px;
            margin : 10px;
        }

        #modify-writebox-bottom {
            padding : 3px 10px 10px 10px;
            min-height : 35px;
        }

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
        ul {
            border:  1px solid rgb(235,236,239);
            border-bottom : 0;
        }
        li {
            background-color: #f9f9fa;
            list-style-type: none;
            border-bottom : 1px solid rgb(235,236,239);
            padding : 18px 18px 0 18px;
            position: relative;
        }
        .comment-bott, .up_date{
            font-size:9pt;
            color : rgb(97,97,97);
            padding: 8px 0 8px 0;
        }

        .comment-bott > a {
            color : rgb(97,97,97);
            text-decoration: none;
            margin : 0 6px 0 0;
        }

        #comment-writeForm {
            background-color: white;
            border : 1px solid #e5e5e5;
            border-radius: 5px;
        }
        #sendBtn, #writeRepBtn {
            color : #009f47;
            background-color: #e0f8eb;
            text-decoration: none;
            padding :5px;
            border-radius: 5px;
            border: none;
            margin: 3px;
        }


    </style>
</head>
<body>
<div class="navbar">
    <a class="active" href="<c:url value='${loginOutLink}'/>"><i class="fa fa-fw fa-user"></i>${loginOut}</a>
    <a href="<c:url value='${RegisterLink}'/>">${Registercheck}</a>
    <a href="#"><i class="fa fa-fw fa-home"></i>My Page</a>
    <a class="logo" style="margin-right: 18%; padding: 15px;" href="<c:url value='/'/>"><img src="/resources/image/logo_w.png" ></a>
</div>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#">About</a>
    <a href="">Product</a>
    <a href="<c:url value="/board/list"/>">Board</a>
    <a href="#">Contact</a>
</div>
<span class="sidbtn" style="font-size:40px;cursor:pointer"onclick="openNav()">&#9776;</span>


<script>
    let msg = "${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>
<div class="container">
    <h2 class="writing-header">게시판 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="bno" value="${boardDto.bno}">

        <input name="title" type="text" value="<c:out value="${boardDto.title}"/> " placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value="${boardDto.content}"/> </textarea><br>

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
    </form>
</div>

<div id="commstart">
    <div id="comment-writeForm">
        comment : <textarea name="comment" placeholder="댓글을 입력하세요"></textarea><br>
        <button id="sendBtn" type="button">SEND</button>
        <button id="modBtn" style="display: none"  type="button">MOD</button>
    </div>
    <div id="commentList">
    </div>
    <div id="relyForm" style="display: none">
        <textarea  name="replyComment"placeholder="댓글을 입력하세요"></textarea>
        <button id="writeRepBtn" type="button">등록</button>
    </div>

    <div id="modalWin" class="modal">
        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <p>
                <h2>  댓글 수정</h2>
                <div id="modify-writebox">
                <div class="commenter commenter-writebox"></div>
                        <div class="modify-writebox-content">
                            <textarea name="comm" id="" cols="30" rows="5" placeholder="댓글을 남겨보세요"></textarea>
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

<script>
    let bno = <c:out value="${boardDto.bno}"/>;

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

    let addZero = function(value=1){
        return value > 9 ? value : "0"+value;
    }

    let dateToString = function(ms=0) {
        let date = new Date(ms);

        let yyyy = date.getFullYear();
        let mm = addZero(date.getMonth() + 1);
        let dd = addZero(date.getDate());

        let HH = addZero(date.getHours());
        let MM = addZero(date.getMinutes());
        let ss = addZero(date.getSeconds());

        return yyyy+"."+mm+"."+dd+ " " + HH + ":" + MM + ":" + ss;
    }


    $(document).ready(function() {
        showList(bno);


        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value=="") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }
            if(form.content.value=="") {
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
            location.href="<c:url value='/board/list${searchCondition.queryString}'/>";
        });


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
        });

        $("#commentList").on("click",".replyBtn",function() {
            // 2.해당 댓글에 또 댓글다는거니까 바로 밑에 나올수 있도록 옮겨주기
            $("#relyForm").appendTo($(this).parent());
            //1.답글을 입력할 폼이 필요함. //폼을 만들어두고 속성값을 바꿔주자
            $("#relyForm").css("display","block");
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
            $.ajax({ //삭제버튼 누르면 넘어가는 데이터~
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
            let comment = $("div[name=comment]").val();
            let bno = $(this).attr("data-bno");
            let pcno = $(this).attr("data-pcno");
            let commenter = $("div[name=commenter]").val();

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
            tmp += '<div id="com-commenter" name="commenter" class="commenter">'+comment.commenter+'</div>'
            tmp += '<div id="com-comment" name="comment" class="comment">'+comment.comment+'</div>'
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
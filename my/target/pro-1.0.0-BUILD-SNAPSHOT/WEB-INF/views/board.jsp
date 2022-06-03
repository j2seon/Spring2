<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: white;
        }
        * {
            box-sizing: border-box;
        }





        .sidbtn{
            position:fixed;
            top:20px;

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
            background-color: #555;
            overflow: auto;
        }

        .navbar a {
            float: right;
            padding: 12px;
            color: white;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: #000;
        }

        .active {
            background-color: #04AA6D;
        }

        @media screen and (max-width: 500px) {
            .navbar a {
                float: none;
                display: block;
            }
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Add a blue text color to links */
        a {
            color: #04AA6D;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }



        /* Add a grey background color on mouse-over */
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
    </style>
    <title> b</title>
</head>
<body>
<div class="navbar">
    <a class="active" href="<c:url value='/'/>"><i class="fa fa-fw fa-user"></i> Home</a>
    <a href="<c:url value='${loginOutLink}'/>"><i class="fa fa-fw fa-envelope"></i>${loginOut}</a>
    <a href="#"><i class="fa fa-fw fa-home"></i> My Page</a>
</div>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#">About</a>
    <a href="#">Product</a>
    <a href="">Board</a>
    <a href="#">Contact</a>
</div>
<script>
    let msg = "${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");

</script>

<span class="sidbtn" style="font-size:40px;cursor:pointer"onclick="openNav()">&#9776;</span>

<h2 class="writing-header">게시물 ${mode=="new"? "작성":"읽기"}</h2>
<form id="form" class="frm" action="" method="post">
    <input type="hidden" name="bno" value="${boardDto.bno}"  placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
    <input type="text" name="title" value="${boardDto.title}" ${mode=="new" ? "" : "readonly='readonly'"}>
    <textarea name="content" id="content" cols="300" rows="10"${mode=="new" ? "" : "readonly='readonly'"}>${boardDto.content}</textarea>
    <c:if test="${mode=='new'}">
        <button type="button" id="writeBtn" class="btn">등록</button>
    </c:if>
    <c:if test="${boardDto.writer eq loginId}">
        <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
        <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
    </c:if>
    <button type="button" id="listBtn" class="btn">목록</button>
</form>

</body>
<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }

   <!--목록 버튼 클릭시 이동(get) -->
    $(document).ready(function (){
        $('#listBtn').on("click",function (){ //클릭하면 무슨일을할지 적음
            location.href="<c:url value="/board/list"/>?page=${page}&rowCnt=${rowCnt}";
        });
    <!--삭제버튼 클릭 시 이동(post)-->
        $('#removeBtn').on("click",function (){ //클릭하면 무슨일을할지 적음
            if(!confirm("삭제하시겠습니까?")) return;
            let form = $('#form');
            form.attr("action","<c:url value="/board/remove"/>?page=${page}&rowCnt=${rowCnt}"); //remove로 이동
            form.attr("method","post"); // 보내는 방식
            form.submit(); //제출
        });
        <!--등록버튼 누르면 게시글 등록(write)됨(post)-->
        $('#writeBtn').on("click",function (){ //클릭하면 무슨일을할지 적음
            let form = $('#form');
            form.attr("action","<c:url value="/board/write"/>");
            form.attr("method","post"); // 보내는 방식
            form.submit(); //제출
        });
        <!--수정버튼 클릭시 읽기 상태로 변경 / 읽기상태에서 내용 전송-->
        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');
            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly) {
                $(".writing-header").html("게시판 수정");
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                return;
            }
            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/board/modify?page=${page}&rowCnt=${rowCnt}'/>");
            form.attr("method", "post");
                form.submit();
        });
    });



</script>
</html>

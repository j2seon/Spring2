<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<%@ page import="java.net.URLDecoder"%>
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
        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password],input[type=email] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 5px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
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
        /* Pagination links */
        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
        }

        /* Style the active/current link */
        .pagination a.active {
            background-color: #04AA6D;
            color: white;
        }

        /* Add a grey background color on mouse-over */
        .pagination a:hover:not(.active) {background-color: #ddd;}

    </style>
</head>
<body>
<script>
    let msg="${msg}" // get방식으로 전달되서 param쓰자
    if(msg=="OK") alert("게시글이 삭제되었습니다.");
    if(msg=="ERR") alert("게시글 삭제에 실패했습니다.");
    if(msg=="WR_OK") alert("게시물이 등록됐습니다.");
    if(msg=="MOD_OK") alert("성공적으로 수정되었습니다.");

</script>


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

<span class="sidbtn" style="font-size:40px;cursor:pointer"onclick="openNav()">&#9776;</span>


<button type="button" id="writeBtn" onclick="location.href='<c:url value="/board/write"/>'">글쓰기</button>
<table class="center" >
    <tr>
        <th class="no">번호</th>
        <th class="title">제목</th>
        <th class="writer">내용</th>
        <th class="regdate">등록일</th>
        <th class="viewcnt">조회수</th>
    </tr>
    <c:forEach var="board" items="${list}">
    <tr>
        <td>${board.bno}</td>
        <td><a href="<c:url value="/board/read?bno=${board.bno}&page=${page}&rowCnt=${rowCnt}"/>">${board.title}</a></td>
        <td>${board.content}</td>
        <td>${board.reg_date}</td>
        <td>${board.view_cnt}</td>
    </tr>
    </c:forEach>
</table>
<br>
<div class="pagination">
    <c:if test="${ph.showPrev}">
        <a href="<c:url value="/board/list?page=${ph.startNavi-1}&rowCnt=${ph.rowCnt}"/>">&laquo;</a>
    </c:if>
    <c:forEach var="i" begin="${ph.startNavi}" end="${ph.endNavi}">
        <a href="<c:url value="/board/list?page=${i}&rowCnt=${ph.rowCnt}"/>">${i}</a>
    </c:forEach>
    <c:if test="${ph.showNext}">
    <a href="<c:url value="/board/list?page=${ph.endNavi+1}&rowCnt=${ph.rowCnt}"/>">&raquo;</a>
    </c:if>
</div>







</body>
<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }

</script>
</html>

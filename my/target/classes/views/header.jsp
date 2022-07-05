<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<header id="header">
    <h1 class="logo">
        <a href="<c:url value="/"/>"></a>
    </h1>
    <div class="right_menu">
        <ul>
            <li><a href="<c:url value="/login/login"/>">로그인</a></li>
            <li><a href="<c:url value="/register/add"/>"> 회원가입 </a></li>
        </ul>
    </div>
    <nav id="topmenu" class="topnav">
        <a href="<c:url value="/show/list"/>">메뉴소개</a>
        <a href="<c:url value="/show/list/"/>">list</a>
        <a href="<c:url value="/board/list"/>">Board</a>
        <a href="#">Contact</a>
        <a href="#">About</a>
        <a class="icon" href="javascript:void(0);" onclick="myFunction()" ><i class="fa fa-bars" aria-hidden="true"></i></a>
    </nav>
    <script>
        function myFunction() {
            var x = document.getElementById("topmenu");
            if (x.className === "topnav") {
                x.className += " responsive";
            } else {
                x.className = "topnav";
            }
        }
    </script>
</header>
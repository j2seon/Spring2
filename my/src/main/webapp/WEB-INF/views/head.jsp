<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<c:set var="RegisterLink" value="${loginId==''? '/register/add' : ''}"/>
<c:set var="Registercheck" value="${loginId=='' ? 'Sign Up' : 'My Cart'}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" >
    <title>Title</title>
    <style>
        * {
            box-sizing: border-box;
        }

        /* Style the body */
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
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
            color: #ffffff;
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
            background-color: #04AA6D;
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
        .logo{
            display: flex;
            justify-content: center;
            padding: 15px;
        }
    </style>
</head>
<body>
<div>
    <a class="logo"  href="<c:url value='/'/>"><img src="${pageContext.request.contextPath}/image/logo_w.png"></a>
</div>

<div class="navbar">
    <a class="active" href="<c:url value='${loginOutLink}'/>"><i class="fa fa-fw fa-user"></i>${loginOut}</a>
    <a href="<c:url value='${RegisterLink}'/>">${Registercheck}</a>
    <a href="#"><i class="fa fa-fw fa-home"></i>My Page</a>
</div>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#">About</a>
    <a href="<c:url value="/product/list"/>">Product</a>
    <a href="<c:url value="/board/list"/>"> Board </a>
    <a href="#">Contact</a>
    <a href="<c:url value="/product/add"/>">Add</a>
</div>

<!--버튼-->
<span class="sidbtn" style="font-size:40px;cursor:pointer"onclick="openNav()">&#9776;</span>


<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }
</script>

</body>
</html>

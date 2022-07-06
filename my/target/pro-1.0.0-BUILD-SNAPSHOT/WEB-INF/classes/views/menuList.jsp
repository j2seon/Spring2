<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<c:set var="RegisterLink" value="${loginId==''? '/register/add' : ''}"/>
<c:set var="Registercheck" value="${loginId=='' ? 'Sign Up' : 'My Cart'}"/>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/head.jsp"%>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }
        .menu-image {
            background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url("${pageContext.request.contextPath}/image/productmain.jpg");
            height: 50%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }
        .menu-text {
            text-align: center;
            position: absolute;
            display: flex;
            flex-wrap: wrap;
            flex-direction: column;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
        }

        @media screen and (max-width: 600px) {
            .column {
                width: 100%;
                display: block;
                margin-bottom: 20px;
            }
        }
        .container{
            height: 100%;
            position: relative;
        }
        .topnav{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
        }
        .topnav a{
            text-decoration: none;
            color: #f1f1f1;
            font-size: 20px;
            padding: 20px;
            background-color: black;
            border-radius :10px;
            margin: 10px;
        }


        #tab {height: 50px; width: 100%; }
        #tab ul a{text-decoration: none; color: #111111;}
        #tab ul { list-style: none; margin: 0px auto; padding: 0px; width: 100%; height: 50px;}
        #tab .meumain > li  {background-color: orange; float: left; width: 33%; height: 50px; line-height: 50px; text-align: center; position: relative;}
        #tab .meumain > li > a{ display:block; text-decoration: none; color: #ffffff}
        #tab .meumain>li:hover .sub {display: block;}
        #tab .meumain>li >a {display: block;}
        #tab .sub {position: absolute; display: none; z-index: 100;}
        #tab .meumain .sub li {background-color: whitesmoke}
        #tab .meumain .sub li a{display: block}

        section#itemMain{position: absolute}
        section#items{position: relative}
        section#item-contents ul {display: flex; flex-wrap: wrap; justify-content: center; padding: 0;}
        section#item-contents ul li{list-style: none; position: relative; text-align: center; float:left; text-decoration: none; margin: 10px; width: 370px; height: 330px}
        section#item-contents div.goodsImg{position: relative; margin: 20px auto 0; z-index: 1;}
        section#item-contents div.goodsName {text-align: center; text-decoration:none; margin:10px 0 6px;}
        section#item-contents div.goodsName a{ color: #111111; text-decoration: none; font-size: 22px; font-weight: bold;position: relative; }
        section#item-contents span.subName{margin: 0 0 13px; display: block; font-size: 16px; letter-spacing: -0.06em;}
        section#item-contents span.energy{display: block; font-size: 16px; letter-spacing: -0.06em; color:#ffc300;}
        section#item-contents div.summary{opacity: 0}
        section#item-contents div.summary div.summary > i{position: absolute; top:30%}
        section#item-contents ul li:hover div.goodsName{position: absolute; z-index: 5; transform: translate(-50%,-50%); width:100%; top: 50%; left: 50%;}
        section#item-contents ul li:hover div.summary {transition: all 0.6s ease 0.2s;position: absolute; top: 0; width: 100%; height: 100%; opacity: 1; background-color: #04AA6D; z-index: 2; text-align: center}
        section#item-contents ul li:hover div.summary > p{position: absolute; top: 60%;text-align: center}
    </style>
</head>
<%@ include file="header.jsp"%>

<body>
<div class="container">
    <div class="menu-image">
        <div class="menu-text">
        </div>
    </div>
    <%@ include file="list/list.jsp"%>
    <section id="itemMain">
        <div id="items">
            <section id="item-contents">
                <ul>
                <c:forEach items="${list}" var="list">
                    <li>
                        <c:if test="${list==null}">
                            <div> 게시물이 없습니다. </div>
                        </c:if>
                        <div class="goodsImg"><a href=""><img src="${pageContext.request.contextPath}${list.gdThum}"></a></div>
                        <div class="goodsName"><a href=""><strong>${list.goodsName}</strong></a></div>
                        <span class="subName">${list.subName}</span>
                        <span class="energy">${list.energy}kcal</span>
                        <div class="summary">
                            <p>${list.content}</p>
                            <i class="fa fa-search-plus fa-3x" style="color: yellow; position: absolute;top: 24%;left: 43% " aria-hidden="true"><a href=""></a> </i>
                        </div>
                    </li>
                </c:forEach>
                </ul>
            </section>
        </div>
    </section>


</div>



</body>
<script>

</script>
</html>

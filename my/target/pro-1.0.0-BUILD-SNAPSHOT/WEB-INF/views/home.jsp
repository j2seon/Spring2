<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="include/head.jsp"%>
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>
<body>
<div id="wrap">
    <%@ include file="header.jsp"%>
    <section id="banner">

    </section>
    <section id="content1">
        <nav class="nav"></nav>
        <article class="article_right1"></article>
        <article class="article_right2"></article>
    </section>
    <section id="content2">
        <article class="article_box1"></article>
        <article class="article_box2"></article>
        <article class="article_box3"></article>
    </section>
    <section id="content3">
        <article class="article_square1"></article>
        <article class="article_square2"></article>
        <article class="article_square3"></article>
        <article class="article_square4"></article>
    </section>
    <footer id="footer"></footer>
</div>
</body>
</html>

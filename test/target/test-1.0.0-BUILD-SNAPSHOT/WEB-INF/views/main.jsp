
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    빵메인 뷰
</h1>

<a href="<c:url value="/tour/region"/>"> 지역별 투어 추천</a>

<a href="<c:url value="/store/list"/>"> 빵집 맞춤검색</a>

<a href="<c:url value="/tour/register"/>"> 투어 등록페이지</a>

<a href="<c:url value="/bread/search"/>"> 키워드별 검색(할지말찌...)</a>
<p></p>
</body>
</html>

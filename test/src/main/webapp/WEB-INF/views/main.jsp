
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

<a href="<c:url value="/tour/region"/>"> map 이동</a>
<a href="<c:url value="/bread/api"/>"> api 이동</a>
<a href="<c:url value="/bread/tour"/>"> bread tour이동</a>
<a href="<c:url value="/bread/search"/>"> keyword</a>
<a href="<c:url value="/store/list"/>"> list</a>
<p></p>
</body>
</html>

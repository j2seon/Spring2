<%@ page language="java" contentType="text/html; charset=EUC-KR"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href = "<c:url value="/bread"/>"> bread 메인뷰이동 </a>
</body>
</html>

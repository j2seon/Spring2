<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>첫번째 페이지</title>
</head>
<body>

	
 <a href = "<c:url value="/join/firstlist"/>">
 조인 테이블 출력  (resultMap 사용) </a>
<p> <p>
 <a href = "<c:url value="/join/secondlist"/>">
 조인 테이블 출력2 (resultType 사용)  </a>
</body>
</html>
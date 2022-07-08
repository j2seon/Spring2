<%--
  Created by IntelliJ IDEA.
  User: ddj04
  Date: 2022-07-08
  Time: 오전 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <li>이미지 : ${storeDto.mainimg}</li>
        <li>가게이름 : ${storeDto.storeName}</li>
        <li>주소 : ${storeDto.address}</li>
        <li>우편번호 : ${storeDto.post_num}</li>
        <li>위도 : ${storeDto.lat}</li>
        <li>경도 : ${storeDto.lon}</li>
        <li>휴일 : ${storeDto.holiday}</li>
        <li>좋아요수  : ${storeDto.good}</li>
        <li>등록일자 : <fmt:formatDate value="${storeDto.reg_date}" pattern="yyyy-MM-dd" type="date"/></li>
        <li>메인 빵 종류 : ${storeDto.mainMenu}</li>
        <li>취식 여부: ${storeDto.eat}</li>
        <li>단체 가능여부 : ${storeDto.corps}</li>
    </ul>
    <span><a href="${before}">목록</a></span>
    <span>즐겨찾기</span>
</body>
</html>

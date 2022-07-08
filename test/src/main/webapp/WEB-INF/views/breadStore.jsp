<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<li><a href="<c:url value="/store/list"/>">전체</a></li>
<li><a href="<c:url value="/store/list?type=master"/>">명장</a></li>
<li><a href="<c:url value="/store/list?type=corps"/>">단체</a></li>
<li><a href="<c:url value="/store/list?type=eat"/>">취식</a></li>
<li><a href="<c:url value="/store/list?type=franchise"/>">프랜차이즈</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&k=1"/>">비건</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&k=2"/>">크림</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&k=3"/>">카페</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&k=3"/>">카페</a></li>

<li><a href="<c:url value="/store/list?type=holiday&k=0"/>">월</a></li>
<li><a href="<c:url value="/store/list?type=holiday&k=1"/>">화</a></li>
<li><a href="<c:url value="/store/list?type=holiday&k=2"/>">수</a></li>
<li><a href="<c:url value="/store/list?type=holiday&k=3"/>">목</a></li>
<li><a href="<c:url value="/store/list?type=holiday&k=4"/>">금</a></li>
<li><a href="<c:url value="/store/list?type=holiday&k=5"/>">토</a></li>
<li><a href="<c:url value="/store/list?type=holiday&k=6"/>">일</a></li>

      <ul>
  <c:forEach items="${list}" var="StoreDto">
          <li><a href="<c:url value="/store/read?id=${StoreDto.id}"/>">${StoreDto.storeName}</a></li>
      <li><a href="">${StoreDto.address}</a></li>
  </c:forEach>
      </ul>
</body>
</html>

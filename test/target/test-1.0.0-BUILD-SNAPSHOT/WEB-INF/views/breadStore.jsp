<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        .paging {
            color: black;
            width: 100%;
            align-items: center;
        }
        .page {
            color: black;
            padding: 6px;
            margin-right: 10px;
        }
        .paging-active:hover {
            background-color: rgb(216, 216, 216);
            border-radius: 5px;
            color: rgb(24, 24, 24);
        }
        .paging-container {
            width:100%;
            height: 70px;
            display: flex;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<li><a href="<c:url value="/store/list"/>">전체</a></li>
<li><a href="<c:url value="/store/list?type=master"/>">명장</a></li>
<li><a href="<c:url value="/store/list?type=corps"/>">단체</a></li>
<li><a href="<c:url value="/store/list?type=eat"/>">취식</a></li>
<li><a href="<c:url value="/store/list?type=franchise"/>">프랜차이즈</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&keyword=1"/>">비건</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&keyword=2"/>">크림</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&keyword=3"/>">카페</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu&keyword=3"/>">카페</a></li>
<li><a href="<c:url value="/store/list?type=mainMenu"/>">메뉴</a></li>
<li><a href="<c:url value="/store/list?type=holiday"/>">휴일</a></li>
<li><a href="<c:url value="/store/list?type=holiday&keyword=0"/>">월</a></li>
<li><a href="<c:url value="/store/list?type=holiday&keyword=1"/>">화</a></li>
<li><a href="<c:url value="/store/list?type=holiday&keyword=2"/>">수</a></li>
<li><a href="<c:url value="/store/list?type=holiday&keyword=3"/>">목</a></li>
<li><a href="<c:url value="/store/list?type=holiday&keyword=4"/>">금</a></li>
<li><a href="<c:url value="/store/list?type=holiday&keyword=5"/>">토</a></li>
<li><a href="<c:url value="/store/list?type=holiday&keyword=6"/>">일</a></li>

<table>
    <tr>
        <th class="no">번호</th>
        <th class="storeName">가게이름</th>
        <th class="address">주소</th>
        <th class="regdate">등록일</th>
    </tr>
    <c:forEach var="storeDto" items="${list}">
        <tr>
            <td class="no"><c:out value="${storeDto.id}"/> </td>
            <td class="storeName"><a href="<c:url value="/store/read${ph.sc.queryString}&id=${storeDto.id}"/>">${storeDto.storeName}</a></td>
            <td class="address">${storeDto.address}</td>
            <c:choose>
                <c:when test="${storeDto.reg_date.time >= startOfToday}">
                    <td class="regdate"><fmt:formatDate value="${storeDto.reg_date}" pattern="HH:mm" type="time"/></td>
                </c:when>
                <c:otherwise>
                    <td class="regdate"><fmt:formatDate value="${storeDto.reg_date}" pattern="yyyy-MM-dd" type="date"/></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>



<div class="paging">
    <c:if test="${totalCnt==null || totalCnt==0}">
        <div> 게시물이 없습니다. </div>
    </c:if>
    <c:if test="${totalCnt!=null && totalCnt!=0}">
        <c:if test="${ph.prev}">
            <a class="page" href="<c:url value="/store/list${ph.sc.getQueryString(ph.startPage-1)}"/>">prev</a>
        </c:if>
        <c:forEach var="i" begin="${ph.startPage}" end="${ph.endPage}">
            <a class="page ${i==ph.sc.pageNum? "paging-active" : ""}" href="<c:url value="/store/list${ph.sc.getQueryString(i)}"/>">${i}</a>
        </c:forEach>
        <c:if test="${ph.next}">
            <a class="page" href="<c:url value="/store/list${ph.sc.getQueryString(ph.endPage+1)}"/>">next</a>
        </c:if>
    </c:if>
</div>
</body>
</html>

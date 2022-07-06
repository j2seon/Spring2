<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head lang="ko">
    <%@ include file="include/head.jsp"%>
<style>
    #producTb{display: flex; flex-direction: column;}
    #producTb .producttop {display: flex; flex-direction: column;}
    h2{padding: 12px; margin-top: 15px;}
    #producTb span{display: flex; justify-content: flex-end;}
    #producTb .regiBtn{padding: 9px; border: 1px solid;margin-left: 5px;background-color: #04AA6D;margin-right: 10px; color: white; font-size: 15pt;}
    #producTb .example{display: flex; justify-content: center; margin-bottom: 15px;}
    #producTb .example input{width: 30%;}
    #producTb .example button {margin-left:10px; padding: 10px; background: #04AA6D; color: white; font-size: 17px; border: 1px solid grey; cursor: pointer;}
    table{margin: 20px; border: 1px solid #04AA6D;}
    th, td {text-align: center;padding: 16px; border: #04AA6D 1px solid;}
    tr:nth-child(even) {background-color: #f2f2f2}

</style>
</head>

<body>
<script>
    let msg = "${msg}";
    if(msg=="ADD_OK") alert("상품등록을 완료했습니다.");
    if(msg=="READ_ERR") alert("상품조회에 실패했습니다.");
    if(msg=="MOD_OK") alert("상품수정을 완료했습니다.");
    if(msg=="DEL_OK") alert("상품을 삭제했습니다.");
</script>
    <div id="wrap">
        <%@ include file="header.jsp"%>
        <section id="producTb">
            <div class="producttop">
                <h2>상품 목록</h2>
                <span><a class="regiBtn" href="<c:url value="/product/add"/> ">상품 등록</a></span>
                <form class="example" action="">
                    <input type="text" placeholder="Search.." name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <table class="st">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>상품명</th>
                        <th>sub상품명</th>
                        <th>가격</th>
                        <th>내용</th>
                        <th>중량</th>
                        <th>열량</th>
                        <th>단백질</th>
                        <th>지방</th>
                        <th>당류</th>
                        <th>나트륨</th>
                        <th>카테고리1</th>
                        <th>카테고리2</th>
                        <th>등록일</th>
                        <th>업데이트</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="productdto">
                        <tr>
                            <td>${productdto.goodsNum}</td>
                            <td><a href="<c:url value="/product/read?goodsNum=${productdto.goodsNum}"/>">${productdto.goodsName}</a></td>
                            <td><a href="<c:url value="/product/read?goodsNum=${productdto.goodsNum}"/>">${productdto.subName}</a></td>
                            <td>${productdto.price}</td>
                            <td>${productdto.content}</td>
                            <td>${productdto.per}</td>
                            <td>${productdto.energy}</td>
                            <td>${productdto.protein}</td>
                            <td>${productdto.fat}</td>
                            <td>${productdto.suger}</td>
                            <td>${productdto.sodium}</td>
                            <td>${productdto.cateCode}</td>
                            <td>${productdto.cateCodeRef}</td>
                            <c:choose>
                                <c:when test="${productdto.reg_date.time >= startOfToday}">
                                    <td><fmt:formatDate value="${productdto.reg_date}" pattern="HH:mm" type="time"/></td>
                                </c:when>
                                <c:otherwise>
                                    <td><fmt:formatDate value="${productdto.reg_date}" pattern="yyyy-MM-dd" type="date"/></td>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${productdto.up_date.time >= startOfToday}">
                                    <td><fmt:formatDate value="${productdto.up_date}" pattern="HH:mm" type="time"/> </td>
                                </c:when>
                                <c:otherwise>
                                    <td><fmt:formatDate value="${productdto.up_date}" pattern="yyyy-MM-dd" type="date"/></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
<%--            <div class="paging-container">--%>
<%--                <div class="paging">--%>
<%--                    <c:if test="${totalCnt==null || totalCnt==0}">--%>
<%--                        <div> 게시물이 없습니다. </div>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${totalCnt!=null && totalCnt!=0}">--%>
<%--                        <c:if test="${ph.showPrev}">--%>
<%--                            <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.startNavi-1)}"/>">&lt;</a>--%>
<%--                        </c:if>--%>
<%--                        <c:forEach var="i" begin="${ph.startNavi}" end="${ph.endNavi}">--%>
<%--                            <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/list${ph.sc.getQueryString(i)}"/>">${i}</a>--%>
<%--                        </c:forEach>--%>
<%--                        <c:if test="${ph.showNext}">--%>
<%--                            <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.endNavi+1)}"/>">&gt;</a>--%>
<%--                        </c:if>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--            </div>--%>
        </section>
    </div>
    <footer id="footer"></footer>
</body>

<script>


</script>

</html>

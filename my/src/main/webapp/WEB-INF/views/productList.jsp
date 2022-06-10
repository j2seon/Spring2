<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>상품등록</title>
</head>
<style>
    /* Style inputs, select elements and textareas */


    input[type=text], select, textarea{
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        resize: vertical;
    }

    /* Style the label to display next to the inputs */
    label {
        padding: 12px 12px 12px 0;
        display: inline-block;
    }

    /* Style the submit button */
    input[type=submit] {
        background-color: #04AA6D;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        float: right;
    }


    /* Style the container */
    .container {
        display: flex;
        justify-content: center;
        border-radius: 5px;
        background-color: #f2f2f2;
        position: relative;
        padding: 20px;
    }

    /* Floating column for labels: 25% width */
    .col-25 {
        float: left;
        width: 25%;
        margin-top: 6px;
    }

    /* Floating column for inputs: 75% width */
    .col-75 {
        float: left;
        width: 75%;
        margin-top: 6px;
    }

    /* Clear floats after the columns */
    .row:after {
        content: "";
        display: table;
        clear: both;
    }

    /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
    @media screen and (max-width: 600px) {
        .col-25, .col-75, input[type=submit] {
            width: 50%;
            margin-top: 0;
        }
    }
    .vertical-center {
        margin: 0;
        position: relative;

    }
    .ckeck_warn{						/* 입력란 공란 경고 태그 */
        display: none;
        padding-top: 10px;
        text-align: center;
        color: red;
        font-weight: 300;
    }



</style>
<jsp:include page="head.jsp" flush="false"/>

<body>
    <div class="container">
        <div class="vertical-center">
            <table>
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
                            <td><a href="/product/read?=${productdto.goodsNum}">${productdto.goodsName}</a></td>
                            <td><a href="/product/read?=${productdto.goodsNum}">${productdto.subName}</a></td>
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

        </div>
    </div>
</body>

<script>


</script>

</html>

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
    table {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        border: 1px solid #ddd;
    }

    /* Style table headers and table data */
    th, td {
        text-align: center;
        padding: 16px;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2
    }

    th:first-child, td:first-child {
        text-align: left;
    }

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
    .ckeck_warn{
        display: none;
        padding-top: 10px;
        text-align: center;
        color: red;
        font-weight: 300;
    }
    form.example{
        float: right;
        display: inline-flex;
    }
    form.example button {
        float: right;
        padding: 10px;
        background: #04AA6D;
        color: white;
        font-size: 17px;
        border: 1px solid grey;
        border-left: none; /* Prevent double borders */
        cursor: pointer;
    }
    form.example::after {
        content: "";
        clear: both;
        display: table;
    }
    .regiBtn{
        text-decoration: none;
        padding: 9px;
        color: #111111;
        border: 1px solid;
        margin-left: 5px;
        float: right;
        background-color: #04AA6D;
    }

</style>
<jsp:include page="head.jsp" flush="false"/>

<body>
<script>
    let msg = "${msg}";
    if(msg=="ADD_OK") alert("상품등록을 완료했습니다.");
    if(msg=="READ_ERR") alert("상품조회에 실패했습니다.");
    if(msg=="MOD_OK") alert("상품수정을 완료했습니다.");
    if(msg=="DEL_OK") alert("상품을 삭제했습니다.");
</script>
    <div class="container">
        <div class="vertical-center">
            <h2>상품 목록</h2>
            <a class="regiBtn" href="<c:url value="/product/add"/> ">상품 등록</a>
            <form class="example" action="">
                <input type="text" placeholder="Search.." name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
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

        </div>
    </div>
<jsp:include page="footer.jsp" flush="false"/>

</body>

<script>


</script>

</html>

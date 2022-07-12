<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<c:set var="RegisterLink" value="${loginId==''? '/register/add' : ''}"/>
<c:set var="Registercheck" value="${loginId=='' ? 'Sign Up' : 'My Cart'}"/>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/head.jsp"%>
    <style>
        #board-container {display: flex; text-align: center;flex-direction: column;}
        #board-container .search-container{background-color: rgb(253, 253, 250);border: 1px solid #ddd;display: flex;justify-content: center;align-items: center; padding: 50px; margin:30px 0px;}
        .search-form{display: flex;}
        .search-option {
            width: 100px;
            outline: none;
            margin-right: 5px;
            border: 1px solid #ccc;
            color: gray;
        }
        .search-input {
            color: gray;
            background-color: white;
            border: 1px solid #ccc;
            height: 100%;
            width: 300px;
            font-size: 15px;
            padding: 5px 7px;
        }
        .search-input::placeholder {
            color: gray;
        }
        .search-button {
            /* 메뉴바의 검색 버튼 아이콘  */
            width: 20%;
            background-color:#04AA6D;
            margin-left: 5px;
            color: #ffffff;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 15px;
            border: none;
        }
        table{border-collapse: collapse;display: flex; justify-content: center;}
        tbody{border-top: solid;}
        tr:nth-child(even) {
            background-color: #f0f0f070;
        }
        th,
        td {
            width:300px;
            text-align: center;
            padding: 10px 12px;
            border-bottom: 1px solid #ddd;
        }
        td {
            color: rgb(53, 53, 53);
        }
        .no      { width:150px;}
        .title   { width:50%;  }
        td.title   { text-align: left;  }
        td.writer  { text-align: left;  }
        td.viewcnt { text-align: right; }
        td.title:hover {
            text-decoration: underline;
        }
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
        .btn-write {
            background-color: rgb(236, 236, 236); /* Blue background */
            border: none; /* Remove borders */
            color: black; /* White text */
            padding: 6px 12px; /* Some padding */
            font-size: 16px; /* Set a font size */
            cursor: pointer; /* Mouse pointer on hover */
            border-radius: 5px;
            margin-left: 30px;
        }
        .btn-write:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>

<script>
    let msg = "${msg}";
    if(msg=="LIST_ERR")  alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if(msg=="READ_ERR")  alert("삭제되었거나 없는 게시물입니다.");
    if(msg=="DEL_ERR")   alert("삭제되었거나 없는 게시물입니다.");
    if(msg=="DEL_OK")    alert("성공적으로 삭제되었습니다.");
    if(msg=="WRT_OK")    alert("성공적으로 등록되었습니다.");
    if(msg=="MOD_OK")    alert("성공적으로 수정되었습니다.");
</script>
    <div id="wrap" style="text-align:center">
        <%@ include file="header.jsp"%>
        <section id="board-container">
            <div class="search-container">
                <form action="<c:url value="/board/list"/>" class="search-form" method="get">
                    <select class="search-option" name="option">
                        <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                        <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                        <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                    </select>

                    <input type="text" name="keyword" class="search-input" type="text" value="<c:out value="${ph.sc.keyword}"/>" placeholder="검색어를 입력해주세요">
                    <input type="submit" class="search-button" value="검색">
                </form>
                <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/board/write"/>'"><i class="fa fa-pencil"></i>작성</button>
            </div>

            <table>
                <tr>
                    <th class="no">번호</th>
                    <th class="title">제목</th>
                    <th class="writer">이름</th>
                    <th class="regdate">등록일</th>
                    <th class="viewcnt">조회수</th>
                </tr>
                <c:forEach var="boardDto" items="${list}">
                    <tr>
                        <td class="no"><c:out value="${boardDto.bno}"/> </td>
                        <td class="title"><a href="<c:url value="/board/read${ph.sc.queryString}&bno=${boardDto.bno}"/>">${boardDto.title}</a></td>
                        <td class="writer">${boardDto.writer}</td>
                        <c:choose>
                            <c:when test="${boardDto.reg_date.time >= startOfToday}">
                                <td class="regdate"><fmt:formatDate value="${boardDto.reg_date}" pattern="HH:mm" type="time"/></td>
                            </c:when>
                            <c:otherwise>
                                <td class="regdate"><fmt:formatDate value="${boardDto.reg_date}" pattern="yyyy-MM-dd" type="date"/></td>
                            </c:otherwise>
                        </c:choose>
                        <td class="viewcnt">${boardDto.view_cnt}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <div class="paging-container">
                <div class="paging">
                    <c:if test="${totalCnt==null || totalCnt==0}">
                        <div> 게시물이 없습니다. </div>
                    </c:if>
                    <c:if test="${totalCnt!=null && totalCnt!=0}">
                        <c:if test="${ph.showPrev}">
                            <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.startNavi-1)}"/>">&lt;</a>
                        </c:if>
                        <c:forEach var="i" begin="${ph.startNavi}" end="${ph.endNavi}">
                            <a class="page ${i==ph.sc.? "paging-active" : ""}" href="<c:url value="/board/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                        </c:forEach>
                        <c:if test="${ph.showNext}">
                            <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.endNavi+1)}"/>">&gt;</a>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </section>
    </div>
</body>
</html>
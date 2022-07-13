<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    var path = "${pageContext.request.contextPath }";

    $(function(){
        $("#resTb tbody").append($("#resInfoTr").html());
    });

    function resOpenPopup(){
        var pop = window.open("/test/tour/popup","resPopup","width=1100,height=900, scrollbars=yes, resizable=yes");
        pop.focus();
    }

</script>


    <h2>투어 등록</h2>
    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="no" value="${TourDto.no}">

        <input name="title" type="text" value="<c:out value="${TourDto.title}"/> " placeholder="  제목을 입력해 주세요."><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요."></textarea><br>
        <div class="text-center">
            <a href="javascript:void(0);" onclick="resOpenPopup();return false;" class="btn btn-dark btn-lg">출발지</a>
        </div>
        <div>
            <span>출발지</span><br>
            <span></span>

        </div>
        <div class="text-center">
            <a href="javascript:void(0);" onclick="resOpenPopup();return false;" class="btn btn-dark btn-lg">중간지점</a>
        </div>
        <div class="text-center">
            <a href="javascript:void(0);" onclick="resOpenPopup();return false;" class="btn btn-dark btn-lg">도착지</a>
        </div>



        <div id="boradBtn">
            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
            <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>
            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
        </div>
    </form>



</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>잘못된 요청입니다. 확인후 다시 한번 요청해주세요.</div>
    <p>발생한 예외 : ${e}</p>
    <p>발생한 메세지 : ${e.message}</p>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
    <style>
        * { box-sizing:border-box; }
        a { text-decoration: none; }
        body{height: auto; display: flex; flex-direction: column;}
        form {
            width:400px;
            height:500px;
            display : flex;
            flex-direction: column;
            align-items:center;
            position : relative;
            left:50%;
            transform: translate(-50%, 10%) ;
            border: 1px solid #04AA6D;;
            border-radius: 10px;
        }
        input[type='text'], input[type='password'] {
            width: 300px;
            height: 40px;
            border : solid #04AA6D;;
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }
        button {
            background-color: #04AA6D;;
            color : white;
            width:300px;
            height:50px;
            font-size: 17px;
            border : none;
            border-radius: 5px;
            margin : 20px 0 30px 0;
        }
        .loginfo{

        }
        #title {
            font-size : 50px;
            margin: 40px 0 30px 0;
        }
        #msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            color:red;
            margin-bottom: 20px;
        }
    </style>
<jsp:include page="head.jsp" flush="false"/>
</head>
<div class="loginfo">
    <form action="<c:url value="/login/login"/>" method="post" onsubmit="return formCheck(this);">
        <h3 id="title">Login</h3>
        <div id="msg">
            <c:if test="${not empty msg}">
                <i class="fa fa-exclamation-circle"> ${msg}</i>
            </c:if>
        </div>              <!--value에 회원 id가 들어가야한다.-->
        <input type="text" name="id" value="${cookie.id.value}" placeholder="아이디 입력" autofocus>
        <input type="password" name="pwd" placeholder="비밀번호">
        <input type="hidden" name="toURL" value="${param.toURL}">
        <button>로그인</button>
        <div>
            <label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> 아이디 기억</label> |
            <a href="">비밀번호 찾기</a> |
            <a href="<c:url value='/register/add'/>">회원가입</a>
        </div>


        <script>
            function formCheck(frm) {
                let msg ='';
                if(frm.id.value.length==0) {
                    setMessage('id를 입력해주세요.', frm.id);
                    return false;
                }
                if(frm.pwd.value.length==0) {
                    setMessage('password를 입력해주세요.', frm.pwd);
                    return false;
                }
                return true;
            }
            function setMessage(msg, element){
                document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
                if(element) {
                    element.select();
                }
            }
        </script>
    </form>
</div>
</body>
</html>
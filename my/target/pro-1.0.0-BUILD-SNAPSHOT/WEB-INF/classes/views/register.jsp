<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>--%>
<%--<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>--%>
<%--<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>--%>
<%--<c:set var="RegisterLink" value="${loginId==''? '/register/add' : ''}"/>--%>
<%--<c:set var="Registercheck" value="${loginId=='' ? 'Sign Up' : 'My Cart'}"/>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="include/head.jsp"%>
    <style>
        #container {display: block}
        #container .form{display: flex; justify-content: center; margin: 25px;}
        #container .register{display: flex; flex-direction: column; margin:50px 0px; padding: 45px;}
        input[type=text], input[type=password],input[type=email] {
            width: 100%;
            margin: 5px 0 5px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }
        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }
        .btn{display: flex; flex-direction: column; justify-content: center; align-items: center;}
        .registerbtn, .cancel {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 3px;
            border: none;
            cursor: pointer;
            width: 180px;
            opacity: 0.9;
        }
        .registerbtn,.cancel:hover {
            opacity: 1;
        }
    </style>
</head>
<body>
    <div id="wrap">
        <%@ include file="header.jsp"%>
         <section id="container">
            <form class=form method="post" action="<c:url value='/register/add'/>" onsubmit="return checkIt()" >
                <div class="register">
                    <h1>Register</h1>
                    <p>Please fill in this form to create an account.</p>
                    <hr>
        <%--            <div id="msg" class="msg"><form:errors path="id"/></div>--%>
                    <label for="id"><b>ID</b></label>
                    <button id="checkId">CHECK ID</button>
                    <input type="text" placeholder="Enter ID" name="id" id="id" required>
                    <label for="pwd"><b>PASSWORD</b></label>
                    <input type="password" placeholder="Enter PASSWORD" name="pwd" id="pwd" required>
                    <label for="repass"><b>Repeat</b></label>
                    <input type="password" placeholder="Repeat PASSWORD" name="repass" id="repass" required>
                    <label for="name"><b>Name</b></label>
                    <input type="text" placeholder="Enter NAME" name="name" id="name" required>
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" id="email" required>
                    <label for="phone"><b>PHONE</b></label>
                    <input type="text" placeholder="Enter phone" name="phone" id="phone" required>
                    <label for="address"><b>address</b></label>
                    <input type="text" placeholder="Enter address" name="address" id="address" required>
                    <hr>
                </div>
                <div class="btn">
                    <button id="process" type="" class="registerbtn">Register</button>
                    <button id="cancel" class="cancel">Cancle</button>
                </div>
            </form>
        </section>
</div>
</body>
<script>
    let status = true;
    $(document).ready(function(){
        //[ID중복확인]버튼을 클릭하면 자동실행
       // 입력한 아이디 값을 갖고 서버에 전달
        $("#checkId").click(function(){
            if($("#id").val()){
                //아이디를 입력하고 [ID중복확인]버튼을 클릭한 경우
                let id = {id:$("#id").val()};
                $.ajax({
                    type:'POST',//요청방식
                    url:'/pro/register/idCheck',//요청페이지
                    data : id,//파라미터
                    dataType:"json",
                    success:function(data){//요청페이지 처리에 성공시
                        if(data == 1){//사용할 수 없는 아이디
                            alert("사용할 수 없는 아이디");
                            $("#id").val("");
                        }else if(data == 0){ //사용할 수 있는 아이디
                            alert("사용할 수 있는 아이디");
                        }
                    }
                });
            }else{//아이디를 입력하지 않고 [ID중복확인]버튼을 클릭한 경우
                alert("사용할 아이디를 입력");
                $("#id").focus();
            }
        });

        //[가입하기]버튼을 클릭하면 자동실행
        //사용자가 가입폼인 registerForm.jsp페이지에 입력한 내용을 갖고
        //registerPro.jsp페이지 실행
        // $("#process").click(function(){`
        //     checkIt(); //입력폼에 입력한 상황 체크
        //
        //     if(status){
        //         var query = {id:$("#id").val(),
        //             passwd:$("#passwd").val(),
        //             name:$("#name").val(),
        //             address:$("#address").val(),
        //             phone:$("#phone").val()};
        //
        //         $.ajax({
        //             type:"post",
        //             url:"registerPro.jsp",
        //             data:query,
        //             success:function(data){
        //                 window.location.href='main.jsp';
        //             }
        //         });
        //     }
        // });

        //[취소]버튼을 클릭하면 자동실행
        $("#cancel").click(function(){
            window.location.href='/pro';
        });

    });

    //사용자가 입력폼에 입력한 상황을 체크
    function checkIt() {
        status = true;

        if(!$("#id").val()) {//아이디를 입력하지 않으면 수행
            alert("아이디를 입력하세요");
            $("#id").focus();
            status = false;
            return false;//사용자가 서비스를 요청한 시점으로 돌아감
        }

        if(!$("#pwd").val() ) {//비밀번호를 입력하지 않으면 수행
            alert("비밀번호를 입력하세요");
            $("#pwd").focus();
            status = false;
            return false;
        }
        //비밀번호와 재입력비밀번호가 같지않으면 수행
        if($("#pwd").val() != $("#repass").val()){
            alert('"비밀번호를 동일하게 입력하세요"')
            $("#repass").focus();
            status = false;
            return false;
        }

        if(!$("#name").val()) {//이름을 입력하지 않으면 수행
            alert('이름을 입력해주세요')
            $("#name").focus();
            status = false;
            return false;
        }

        if(!$("#address").val()) {//주소를 입력하지 않으면 수행
            alert("주소를 입력해주세요")
            $("#address").focus();
            status = false;
            return false;
        }

        if(!$("#phone").val()) {//전화번호를 입력하지 않으면 수행
            alert("핸드폰 번호를 입력해주세요")
            $("#phone").focus();
            status = false;
            return false;
        }
        if(!$("#email").val()) {//이름을 입력하지 않으면 수행
            alert("이메일을 형식에 맞게 입력해주세요")
            $("#email").focus();
            status = false;
            return false;
        }
        return true;
    }


</script>
</html>

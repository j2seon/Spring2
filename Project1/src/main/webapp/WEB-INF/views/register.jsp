<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: white;
        }
        * {
            box-sizing: border-box;
        }

        .regi{
            width :100%;
            position: absolute;
            display: flex;
            justify-content: center;

        }

        .form{
            width:400px;
            height:500px;
            display : flex;
            flex-direction: column;
            position : absolute;
            /* top:50%;
            left:50%; */

        }


        .sidbtn{
            position:fixed;
            top:20px;

            left:20px;

        }
        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 30px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }

        .navbar {
            width: 100%;
            background-color: #555;
            overflow: auto;
        }

        .navbar a {
            float: right;
            padding: 12px;
            color: white;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: #000;
        }

        .active {
            background-color: #04AA6D;
        }

        @media screen and (max-width: 500px) {
            .navbar a {
                float: none;
                display: block;
            }
        }
        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password],input[type=email] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 5px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn  {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 3px;
            border: none;
            cursor: pointer;
            width: 48%;
            opacity: 0.9;
            float: left;
        }

        .registerbtn:hover {
            opacity: 1;
        }
        .cancel {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 48%;
            opacity: 0.9;
            float: right;

        }
        .cancel:hover {
            opacity: 1;
        }

        .regi{
            position: relative;
        }



        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        #checkId{
            float: right;
        }

        .msg {
            color:red;
            text-align:center;
            margin-bottom: 20px;
        }

    </style>
</head>
<body>


<section class="regi">
    <form class=form method="post" action="<c:url value='/register/add'/>" onsubmit="return checkIt()" >
        <div class="container">
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
            <button id="process" type="" class="registerbtn">Register</button>
            <button id="cancel" class="cancel">Cancle</button>
        </div>
    </form>
</section>
</body>
<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }

    // let status = true;
    // $(document).ready(function(){
    //     //[ID중복확인]버튼을 클릭하면 자동실행
    //    // 입력한 아이디 값을 갖고 서버에 전달
    //     $("#checkId").click(function(){
    //         if($("#id").val()){
    //             //아이디를 입력하고 [ID중복확인]버튼을 클릭한 경우
    //             let id = {id:$("#id").val()};
    //             $.ajax({
    //                 type:'POST',//요청방식
    //                 url:'/pro/register/idCheck',//요청페이지
    //                 data : id,//파라미터
    //                 dataType:"json",
    //                 success:function(data){//요청페이지 처리에 성공시
    //                     if(data == 1){//사용할 수 없는 아이디
    //                         alert("사용할 수 없는 아이디");
    //                         $("#id").val("");
    //                     }else if(data == 0){ //사용할 수 있는 아이디
    //                         alert("사용할 수 있는 아이디");
    //                     }
    //                 }
    //             });
    //         }else{//아이디를 입력하지 않고 [ID중복확인]버튼을 클릭한 경우
    //             alert("사용할 아이디를 입력");
    //             $("#id").focus();
    //         }
    //     });
    //
    //     //[가입하기]버튼을 클릭하면 자동실행
    //     //사용자가 가입폼인 registerForm.jsp페이지에 입력한 내용을 갖고
    //     //registerPro.jsp페이지 실행
    //     // $("#process").click(function(){`
    //     //     checkIt(); //입력폼에 입력한 상황 체크
    //     //
    //     //     if(status){
    //     //         var query = {id:$("#id").val(),
    //     //             passwd:$("#passwd").val(),
    //     //             name:$("#name").val(),
    //     //             address:$("#address").val(),
    //     //             phone:$("#phone").val()};
    //     //
    //     //         $.ajax({
    //     //             type:"post",
    //     //             url:"registerPro.jsp",
    //     //             data:query,
    //     //             success:function(data){
    //     //                 window.location.href='main.jsp';
    //     //             }
    //     //         });
    //     //     }
    //     // });
    //
    //     //[취소]버튼을 클릭하면 자동실행
    //     $("#cancel").click(function(){
    //         window.location.href='/pro';
    //     });
    //
    // });
    //
    // //사용자가 입력폼에 입력한 상황을 체크
    // function checkIt() {
    //     status = true;
    //
    //     if(!$("#id").val()) {//아이디를 입력하지 않으면 수행
    //         alert("아이디를 입력하세요");
    //         $("#id").focus();
    //         status = false;
    //         return false;//사용자가 서비스를 요청한 시점으로 돌아감
    //     }
    //
    //     if(!$("#pwd").val() ) {//비밀번호를 입력하지 않으면 수행
    //         alert("비밀번호를 입력하세요");
    //         $("#pwd").focus();
    //         status = false;
    //         return false;
    //     }
    //     //비밀번호와 재입력비밀번호가 같지않으면 수행
    //     if($("#pwd").val() != $("#repass").val()){
    //         alert('"비밀번호를 동일하게 입력하세요"')
    //         $("#repass").focus();
    //         status = false;
    //         return false;
    //     }
    //
    //     if(!$("#name").val()) {//이름을 입력하지 않으면 수행
    //         alert('이름을 입력해주세요')
    //         $("#name").focus();
    //         status = false;
    //         return false;
    //     }
    //
    //     if(!$("#address").val()) {//주소를 입력하지 않으면 수행
    //         alert("주소를 입력해주세요")
    //         $("#address").focus();
    //         status = false;
    //         return false;
    //     }
    //
    //     if(!$("#phone").val()) {//전화번호를 입력하지 않으면 수행
    //         alert("핸드폰 번호를 입력해주세요")
    //         $("#phone").focus();
    //         status = false;
    //         return false;
    //     }
    //     if(!$("#email").val()) {//이름을 입력하지 않으면 수행
    //         alert("이메일을 형식에 맞게 입력해주세요")
    //         $("#email").focus();
    //         status = false;
    //         return false;
    //     }
    //     return true;
    // }


</script>
</html>

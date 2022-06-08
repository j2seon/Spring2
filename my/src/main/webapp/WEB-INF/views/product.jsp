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
<title>product</title>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  body, html {
    height: 100%;
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
  }

  .menu-image {
    background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url("/pro/img/main_PC_1920x440_20201006040046969.jpg");
    height: 50%;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
  }

  .menu-text {
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: white;
  }
  .tablink {
    background-color: white;
    color: green;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px ;
    width: 20%;
  }

  .tablink:hover {
    background-color: #777;
  }
  /* Float four columns side by side */
  .column {
    float: left;
    width: 25%;
    padding: 0 10px;
  }

  /* Remove extra left and right margins, due to padding */
  .row {margin: 0 -5px;}

  /* Clear floats after the columns */
  .row:after {
    content: "";
    display: table;
    clear: both;
  }


  /* Responsive columns */
  @media screen and (max-width: 600px) {
    .column {
      width: 100%;
      display: block;
      margin-bottom: 20px;
    }
  }

  .container{
    height: 100%;
    position: relative;
  }

  .topnav a{
    text-decoration: none;
    color: #f1f1f1;
    font-size: 20px;
    padding: 20px;
    background-color: black;
    border-radius :10px;
    margin: 10px;
  }
  #con-menu{
    height: 100%;
  }


  /* Style the

  counter cards */
  .card {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    padding: 16px;
    text-align: center;
    background-color: #f1f1f1;
  }
  /* Style the tab content (and add height:100% for full page content) */
  .tabcontent {
    color: white;
    display: none;
    padding: 100px 20px;
    height: 100%;
  }

  #Home {background-color: red;}
  #News {background-color: green;}
  #Contact {background-color: blue;}
  #About {background-color: orange;}
</style>
</head>
<jsp:include page="head.jsp" flush="false"/>
<body>
<div class="container">
  <div class="menu-image">
    <div class="menu-text">
      <h1 style="font-size:50px">product</h1>
      <div class="topnav">
        <a href="#home">샌드위치</a>
        <a href="#news">샐러드</a>
        <a href="#contact">랩/기타</a>
      </div>
    </div>
  </div>
  <div id="con-menu">
    <button class="tablink" onclick="openPage('Home', this, 'red')">전체</button>
    <button class="tablink" onclick="openPage('News', this, 'green')" id="defaultOpen">클래식</button>
    <button class="tablink" onclick="openPage('Contact', this, 'blue')">프레쉬&라이트</button>
    <button class="tablink" onclick="openPage('About', this, 'pink')">프리미엄</button>
    <button class="tablink" onclick="openPage('About', this, 'pink')">신제품</button>

    <div id="Home" class="tabcontent">
      <h3>ppp</h3>
      <div>
        <table>
          <thead>
          <tr>
            <th>상품명</th>
            <th>sub상품명</th>
            <th>가격</th>
            <th>중량</th>
            <th>열량</th>
            <th>단백질</th>
            <th>지방</th>
            <th>당류</th>
            <th>나트륨</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          </tbody>

        </table>
      </div>
    </div>

    <div id="News" class="tabcontent">
      <h3>News</h3>
    </div>

    <div id="Contact" class="tabcontent">
      <h3>Contact</h3>
      <p>Get in touch, or swing by for a cup of coffee.</p>
    </div>

    <div id="About" class="tabcontent">
      <h3>About</h3>
      <p>Who we are and what we do.</p>
    </div>
  </div>
</div>



</body>
<script>
  function openPage(pageName,elmnt,color) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].style.backgroundColor = "";
    }
    document.getElementById(pageName).style.display = "block";
    elmnt.style.backgroundColor = color;
  }

  // Get the element with id="defaultOpen" and click on it
  document.getElementById("defaultOpen").click();
</script>
</html>
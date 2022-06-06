<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title></title>
<head>
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body, html {
      height: 100%;
      margin: 0;
      font-family: Arial, Helvetica, sans-serif;
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

    .menu-image {
      background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url("<c:url value="/resources/image/productmain.jpg"/>");
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

    /* Style the counter cards */
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
<body>

<div class="navbar">
  <a class="active" href="<c:url value='/'/>"><i class="fa fa-fw fa-user"></i> Home</a>
  <a href="<c:url value='${loginOutLink}'/>"><i class="fa fa-fw fa-envelope"></i>${loginOut}</a>
  <a href="#"><i class="fa fa-fw fa-home"></i> My Page</a>
</div>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
  <a href="#">Product</a>
  <a href="#">Board</a>
  <a href="#">Contact</a>
</div>

<span class="sidbtn" style="font-size:40px;cursor:pointer"onclick="openNav()">&#9776;</span>





<div class="container">
  <div class="menu-image">
    <div class="menu-text">
      <h1 style="font-size:50px">product</h1>
      <p>ssssssssss</p>
    </div>
  </div>
  <div id="con-menu">
    <button class="tablink" onclick="openPage('Home', this, 'red')">전체</button>
    <button class="tablink" onclick="openPage('News', this, 'green')" id="defaultOpen">클래식</button>
    <button class="tablink" onclick="openPage('Contact', this, 'blue')">프레쉬&라이트</button>
    <button class="tablink" onclick="openPage('About', this, 'pink')">프리미엄</button>
    <button class="tablink" onclick="openPage('About', this, 'pink')">신제품</button>

    <div id="Home" class="tabcontent">
      <h3>Home</h3>
      <p>Home is where the heart is..</p>
    </div>

    <div id="News" class="tabcontent">
      <h3>News</h3>
      <div class="row">
        <div class="column">
          <div class="card flip-horizontal-bottom">
            <h3>Card 1</h3>
            <p>Some text</p>
            <p>Some text</p>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h3>Card 2</h3>
            <p>Some text</p>
            <p>Some text</p>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h3>Card 3</h3>
            <p>Some text</p>
          </div>
        </div>

        <div class="column">
          <div class="card">
            <h3>Card 4</h3>
          </div>
        </div>
      </div>
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


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>simpleMap</title>
<script src="https://apis.openapi.sk.com/tmap/js?version=1&format=javascript&appKey=l7xx51365b973fc14a1990eeb179b36326df"></script>

    <script type="text/javascript">
    // 페이지가 로딩이 된 후 호출하는 함수입니다.
    function initTmap(){
        // map 생성
        // Tmap.map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
        map = new Tmap.Map({div:'map_div', // map을 표시해줄 div
            width:'100%',  // map의 width 설정
            height:'400px' // map의 height 설정
        });
        map.setCenter(new Tmap.LonLat("126.986072", "37.570028").transform("EPSG:4326", "EPSG:3857"), 15);

    }
    </script>
</head>
<body onload="initTmap()">
    <div id="map_div"></div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: ddj04
  Date: 2022-06-26
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>simpleMap</title>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script
          src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx51365b973fc14a1990eeb179b36326df"></script>
  <script type="text/javascript">


    var map;
    function initTmap(){

      // 1. 지도 띄우기
      map = new Tmapv2.Map("map_div", {
        center: new Tmapv2.LatLng(37.570028, 126.986072),
        width : "100%",
        height : "400px",
        zoom : 15,
        zoomControl : true,
        scrollwheel : true

      });

      // 2. API 사용요청
      var lon, lat;
      map.addListener("click", function onClick(evt){
        var mapLatLng = evt.latLng;

        coordConvert(mapLatLng._lng, mapLatLng._lat);
      });

      function coordConvert(lon, lat){
        var selectLevel = $("#selectLevel").val();
        $.ajax({
          method:"GET",
          url:"https://apis.openapi.sk.com/tmap/geo/coordconvert?version=1&format=json&callback=result",
          async:false,
          data:{

            "appKey" : "l7xx51365b973fc14a1990eeb179b36326df",
            "lon" : lon,
            "lat" : lat,
            "toCoord" : selectLevel
          },
          success:function(response){
            var resultCoordinate = response.coordinate;

            var lon2 = resultCoordinate.lon;
            var lat2 = resultCoordinate.lat;

            var result = lon+","+lat+"->"+lon2+","+lat2;
            var resultDiv = document.getElementById("result");
            resultDiv.innerHTML = result;
          },
          error:function(request,status,error){
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
          }
        });

      }

    }
  </script>
</head>
<body onload="initTmap();">

<select id="selectLevel">
  <option value="EPSG3857" selected="selected">EPSG3857</option>
  <option value="KATECH">KATECH</option>
  <option value="BESSELGEO">BESSELGEO</option>
  <option value="BESSELTM">BESSELTM</option>
  <option value="GRS80GEO">GRS80GEO</option>
  <option value="GRS80TM">GRS80TM</option>
</select>
<span id="result"></span>



<div id="map_wrap" class="map_wrap">
  <div id="map_div"></div>
</div>

</body>
</html>

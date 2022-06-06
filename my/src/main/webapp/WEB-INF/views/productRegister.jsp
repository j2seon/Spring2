<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>상품등록</title>
</head>
<body>
    <form>
        <label>1차분류</label>
        <select class="cate1">
            <option value="">전체</option>
        </select>

        <label>2차분류</label>
        <select class="cate2">
            <option value="">전체</option>
        </select>
        <div class="inputArea">
            <label for="gdsName">상품명</label>
            <input type="text" id="gdsName" name="gdsName" />
        </div>

        <div class="inputArea">
            <label for="gdsPrice">상품가격</label>
            <input type="text" id="gdsPrice" name="gdsPrice" />
        </div>

        <div class="inputArea">
            <label for="gdsStock">상품수량</label>
            <input type="text" id="gdsStock" name="gdsStock" />
        </div>

        <div class="inputArea">
            <label for="gdsDes">상품소개</label>
            <textarea rows="5" cols="50" id="gdsDes" name="gdsDes"></textarea>
        </div>

        <div class="inputArea">
            <button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
        </div>

    </form>

</body>

<script>
    // 컨트롤러에서 데이터 받기
    var jsonData = JSON.parse('${category}');

    var cate1Arr = new Array();
    var cate1Obj = new Object();
    var select1 = $(".cate1");

    // 1차 분류 셀렉트 박스에 삽입할 데이터 준비
    for(var i = 0; i < jsonData.length; i++) {

        if(jsonData[i].tier === 1) {
            cate1Obj = new Object();  //초기화
            cate1Obj.cateCode = jsonData[i].cateCode;
            cate1Obj.cateName = jsonData[i].cateName;
            cate1Obj.cateCodeRef = jsonData[i].cateCodeRef;
            cate1Arr.push(cate1Obj);
        }
    }

    for(var i = 0; i < cate1Arr.length; i++) {
        select1.append("<option value='"+cate1Arr[i].cateCode+"'>" + cate1Arr[i].cateName + "</option>");
    }
    // for(var i = 0; i < cate2Arr.length; i++) {
    //     select2.append("<option value='"+cate2Arr[i].cateCode+"'>" + cate2Arr[i].cateName + "</option>");
    // }


    $(document).on("change", "select.cate1", function(){

        var cate2Arr = new Array();
        var cate2Obj = new Object();

        // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
        for(var i = 0; i < jsonData.length; i++) {

            if(jsonData[i].tier === 2) {
                cate2Obj = new Object();  //초기화
                cate2Obj.cateCode = jsonData[i].cateCode;
                cate2Obj.cateName = jsonData[i].cateName;
                cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;

                cate2Arr.push(cate2Obj);
            }
        }

        var select2 = $("select.cate2");
        select2.children().remove();

        $("option:selected", this).each(function(){

            var selectVal = $(this).val();
            select2.append("<option value=''>전체</option>");

            for(var i = 0; i < cate2Arr.length; i++) {
                if(selectVal == cate2Arr[i].cateCodeRef) {
                    select2.append("<option value='" + cate2Arr[i].cateCode + "'>"
                        + cate2Arr[i].cateName + "</option>");
                }
            }

        });

    });
</script>

</html>

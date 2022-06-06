<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>상품등록</title>
</head>
<style>
    /* Style inputs, select elements and textareas */
    input[type=text], select, textarea{
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        resize: vertical;
    }

    /* Style the label to display next to the inputs */
    label {
        padding: 12px 12px 12px 0;
        display: inline-block;
    }

    /* Style the submit button */
    input[type=submit] {
        background-color: #04AA6D;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        float: right;
    }

    /* Style the container */
    .container {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }

    /* Floating column for labels: 25% width */
    .col-25 {
        float: left;
        width: 25%;
        margin-top: 6px;
    }

    /* Floating column for inputs: 75% width */
    .col-75 {
        float: left;
        width: 75%;
        margin-top: 6px;
    }

    /* Clear floats after the columns */
    .row:after {
        content: "";
        display: table;
        clear: both;
    }

    /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
    @media screen and (max-width: 600px) {
        .col-25, .col-75, input[type=submit] {
            width: 100%;
            margin-top: 0;
        }
    }



</style>
<body>
    <form>
        <div class="inputArea">
            <label for="gdsName">상품명 /sub 상품명</label>
            <input type="text" id="gdsName" name="gdsName" />
            <input type="text" id="subName" name="subName" />
        </div>
        <div class="inputArea">
            <label for="price">상품가격</label>
            <input type="text" id="price" name="price" />
        </div>
        <div class="inputArea">
            <label for="gdsDes">상품소개</label>
            <textarea rows="5" cols="50" id="gdsDes" name="gdsDes"></textarea>
        </div>
        <div class="inputArea">
            <label for="kcal">열량</label>
            <input type="text" id="kcal" name="kcal" />
        </div>
        <div class="inputArea">
            <label for="per">중량</label>
            <input type="text" id="per" name="per" />
        </div>
        <div class="inputArea">
            <label for="protein">단백질</label>
            <input type="text" id="protein" name="protein" />
        </div>
        <div class="inputArea">
            <label for="fat">지방</label>
            <input type="text" id="fat" name="fat" />
        </div>
        <div class="inputArea">
            <label for="sodium">나트륨</label>
            <input type="text" id="sodium" name="sodium" />
        </div>
        <div class="inputArea">
            <label for="protein">당류</label>
            <input type="text" id="suger" name="suger" />
        </div>
        <div class="inputArea">
            <label for="protein">단백질</label>
            <input type="text" id="protein" name="protein" />
        </div>



        <label>1차분류</label>
        <select class="cate1">
            <option value="">전체</option>
        </select>

        <label>2차분류</label>
        <select class="cate2">
            <option value="">전체</option>
        </select>


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

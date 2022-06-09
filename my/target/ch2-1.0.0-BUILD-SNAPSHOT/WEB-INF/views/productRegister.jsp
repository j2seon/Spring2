<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
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
        display: flex;
        justify-content: center;
        border-radius: 5px;
        background-color: #f2f2f2;
        position: relative;
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
            width: 50%;
            margin-top: 0;
        }
    }
    .vertical-center {
        margin: 0;
        position: relative;

    }



</style>
<jsp:include page="head.jsp" flush="false"/>

<body>
    <div class="container">
        <div class="vertical-center">
            <form action="<c:url value='/product/add'/>" method="post" autocomplete="off" id="addForm" enctype="multipart/form-data">
                <div class="inputArea">
                    <label for="goodsName">상품명</label>
                    <input type="text" id="goodsName" name="goodsName" />
                </div>
                <div class="inputArea">
                    <label for="subName">sub상품명</label>
                    <input type="text" id="subName" name="subName" />
                </div>
                <div class="inputArea">
                    <label for="price">상품가격</label>
                    <input type="text" id="price" name="price" />
                </div>
                <div class="inputArea">
                    <label for="content">상품소개</label>
                    <textarea rows="5" cols="50" id="content" name="content"></textarea>
                </div>
                <div class="inputArea">
                    <label for="energy">열량</label>
                    <input type="text" id="energy" name="energy" />
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
                    <label for="suger">당류</label>
                    <input type="text" id="suger" name="suger" />
                </div>
                <label>1차분류</label>
                <select class="cate1" name="cateCodeRef">
                    <option value="" >전체</option>
                </select>

                <label>2차분류</label>
                <select class="cate2" name="cateCode">
                    <option value="">전체</option>
                </select>


<%--                <div class="inputArea">--%>
<%--                    <label for="uploadFile">이미지</label>--%>
<%--                    <input type="file" id="uploadFile" name="uploadFile" />--%>
<%--                </div>--%>

                    <div class="inputArea">
                        <label for="gdImg">이미지</label>
                        <input type="file" id="gdImg" name="gdImg" />
                    <div class="select_img"><img src="" /></div>

                        <script>
                            $("#gdImg").change(function (){
                               if(this.files && this.files[0]){
                                   let reader = new FileReader;
                                   reader.onload=function (data){
                                       $(".select_img img").attr("src", data.target.result).width(500);
                                   }
                                   reader.readAsDataURL(this.files[0]);
                               }
                            });
                        </script>
                    </div>

                <div class="inputArea">
                    <button type="submit" id="add_Btn" class="">등록</button>
                    <button type="cancle" id="cancle_Btn" class="">취소</button>
                </div>
            </form>
        </div>
    </div>
</body>

<script>
    // 컨트롤러에서 데이터 받기 배열로 옴!!!
    var cateList = JSON.parse('${category}');
    let cate1Arr = new Array();
    let cate1Object = new Object();
    let cateSelect1 = $(".cate1");
    for (let i=0; i<cateList.length; i++){
        if(cateList[i].tier === 1){
            cate1Object = new Object();
            cate1Object.cateName =cateList[i].cateName;
            cate1Object.cateCode =cateList[i].cateCode;
            cate1Object.cateCodeRef =cateList[i].cateCodeRef;
            cate1Arr.push(cate1Object);
        }
    }
    let cate2Arr = new Array();
    let cate2Object = new Object();
    let cateSelect2 = $(".cate2");
    for (let i=0; i<cateList.length; i++){
        if(cateList[i].tier === 2){
            cate2Object = new Object();
            cate2Object.cateName = cateList[i].cateName;
            cate2Object.cateCode = cateList[i].cateCode;
            cate2Object.cateCodeRef = cateList[i].cateCodeRef;
            cate2Arr.push(cate2Object);
        }
    }
    for(let i=0; i<cate1Arr.length;i++){
        cateSelect1.append("<option value='"+cate1Arr[i].cateCode+"'>"+cate1Arr[i].cateName+"</option>");
    }
    $(cateSelect1).on("change",function (){
        let selectVal1 = $(this).find("option:selected").val();
        cateSelect2.children().remove();
        cateSelect2.append("<option value=''>선택</option>");
        for(let i=0; i<cate2Arr.length; i++){
            if(selectVal1 === cate2Arr[i].cateCodeRef){
                cateSelect2.append("<option value='"+cate2Arr[i].cateCode+"'>"+cate2Arr[i].cateName+"</option>");
            }

        }
    });
    <%--$("input[type='file']").on("change",function (e){--%>
    <%--    let fileInput = $('input[name="uploadFile"]');--%>
    <%--    let fileList = fileInput[0].files;--%>
    <%--    let fileobj = fileList[0];--%>
    <%--    let formData = new FormData();--%>
    <%--    // console.log("fileList"+fileList); //확인용!--%>
    <%--    // console.log("fileobj"+fileobj);--%>
    <%--    // console.log("fileName"+fileobj.name);--%>
    <%--    // console.log("filesize"+fileobj.size);--%>
    <%--    // console.log("filetype"+fileobj.type);--%>

    <%--    if(!fileCheck(fileobj.name, fileobj.size)){--%>
    <%--        return false;--%>
    <%--    }--%>

    <%--    formData.append("uploadFile",fileobj); //한개! 여러개하고싶은면 for문으로 배열로 저장하기--%>
    <%--                                                // for(let i=0; i<fileList.length; i++){--%>
    <%--                                         //  formData.append("uploadFile",fileList[i]);--%>
    <%--                                                // }--%>
    <%--    $.ajax({--%>
    <%--       url:'<c:url value="/product/uploadAction"/>',--%>
    <%--        processData : false,--%>
    <%--        contentType : false,--%>
    <%--        data : formData,--%>
    <%--        type : 'POST',--%>
    <%--        dataType : 'json',--%>
    <%--        success :function () {--%>
    <%--            alert("ddddd");--%>
    <%--        }--%>
    <%--    });--%>
    <%--});--%>

    <%--let regex = new RegExp("(.?)\.(jpg|png)$");--%>
    <%--let maxSize = 1048576;--%>

    <%--function fileCheck(fileName, fileSize){--%>
    <%--    if(fileSize>=maxSize){--%>
    <%--        alert("파일 용량 초과");--%>
    <%--        return false;--%>
    <%--    }--%>
    <%--    if(!regex.test(fileName)){--%>
    <%--        alert("jpg,png 이미지만 업로드가능합니다.");--%>
    <%--        return false;--%>
    <%--    }--%>
    <%--    return true;--%>
    <%--}--%>






</script>

</html>

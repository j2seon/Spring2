<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
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
    .ckeck_warn{						/* 입력란 공란 경고 태그 */
        display: none;
        padding-top: 10px;
        text-align: center;
        color: red;
        font-weight: 300;
    }



</style>
<jsp:include page="head.jsp" flush="false"/>
<script>
</script>
<body>
    <div class="container">
        <div class="vertical-center">
            <h2>상품 ${mode=="new" ? "등록" :" 조회"}</h2>
            <form method="post" autocomplete="off" name="addForm" id="addForm" enctype="multipart/form-data">
                <input type="hidden" name="goodsNum" value="${productDto.goodsNum}">
                <div class="inputArea">
                    <label for="goodsName">상품명</label>
                    <input type="text" id="goodsName" name="goodsName" value="<c:out value="${productDto.goodsName}"/>" ${mode=="new"? "" : "readonly='readonly'"}>
                    <span class="ckeck_warn goodsN_warn">상품명을 입력해주세요(영문)</span>
                </div>
                <div class="inputArea">
                    <label for="subName">서브상품명(영문)</label>
                    <input type="text" id="subName" name="subName" />
                    <span class="ckeck_warn subGdN_warn">서브상품명(영문)을 입력해주세요(영문)</span>
                </div>
                <div class="inputArea">
                    <label for="price">상품가격(숫자만)</label>
                    <input type="text" id="price" name="price" placeholder="숫자만 입력"/>
                    <span class="ckeck_warn price_warn">상품가격을 입력해주세요(숫자)</span>
                </div>
                <div class="inputArea">
                    <label for="content">상품소개</label>
                    <textarea rows="5" cols="50" id="content" name="content"></textarea>
                    <span class="ckeck_warn content_warn">상품내용을 입력해주세요(숫자)</span>
                </div>
                <div class="inputArea">
                    <label for="energy">열량</label>
                    <input type="text" id="energy" name="energy" placeholder="숫자만 입력" />
                    <span class="ckeck_warn energy_warn">열량을 입력해주세요(숫자)</span>
                </div>
                <div class="inputArea">
                    <label for="per">중량</label>
                    <input type="text" id="per" name="per" placeholder="숫자만 입력" />
                    <span class="ckeck_warn per_warn">중량을 입력해주세요(숫자)</span>
                </div>
                <div class="inputArea">
                    <label for="protein">단백질</label>
                    <input type="text" id="protein" name="protein" placeholder="숫자만 입력" />
                    <span class="ckeck_warn protein_warn">단백질을 입력해주세요(숫자)</span>
                </div>
                <div class="inputArea">
                    <label for="fat">지방</label>
                    <input type="text" id="fat" name="fat" placeholder="숫자만 입력" />
                    <span class="ckeck_warn fat_warn">지방을 입력해주세요(숫자)</span>
                </div>
                <div class="inputArea">
                    <label for="sodium">나트륨</label>
                    <input type="text" id="sodium" name="sodium" placeholder="숫자만 입력" />
                    <span class="ckeck_warn sodium_warn">나트륨을 입력해주세요(숫자)</span>
                </div>
                <div class="inputArea">
                    <label for="suger">당류</label>
                    <input type="text" id="suger" name="suger" placeholder="숫자만 입력" />
                    <span class="ckeck_warn suger_warn">댱류을 입력해주세요(숫자)</span>
                </div>
                <div class="selectArea">
                    <span class="ckeck_warn select1_warn">1차분류를 선택해주세요</span><br>
                    <label>1차분류</label>
                    <select class="cate1" name="cateCodeRef" id="cateCode">
                        <option value="" >전체</option>
                    </select>
                </div>

                <div class="selectArea">
                    <span class="ckeck_warn select2_warn">2차분류를 선택해주세요</span><br>
                    <label>2차분류</label>
                    <select class="cate2" name="cateCode" id="cateCodeRef">
                        <option value="">전체</option>
                    </select>
                </div>


<%--                <div class="inputArea">--%>
<%--                    <label for="uploadFile">이미지</label>--%>
<%--                    <input type="file" id="uploadFile" name="uploadFile" />--%>
<%--                </div>--%>

                    <div class="inputArea">
                        <span class="ckeck_warn gdImg_warn">이미지파일을 업로드해주세요</span><br>
                        <label for="gdImg">이미지</label>
                        <input type="file" id="gdImg" name="file" />
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
                    <button type="submit" id="add_Btn" class="" onsubmit="formCheck()">등록</button>
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

    $(document).ready(function (){
        $("#add_Btn").click(function (){
            let goodsNum = $("#goodsName").val();
            let subNum = $("#subName").val();
            let price = $("#price").val();
            let content = $("#content").val();
            let energy = $("#energy").val();
            let protein = $("#protein").val();
            let per = $("#per").val();
            let sodium = $("#sodium").val();
            let suger = $("#suger").val();
            let fat = $("#fat").val();
            let cateCode = $("#cateCode").val();
            let cateCodRef = $("#cateCodeRef").val();
            let gdImg = $("#gdImg").val();


            if(goodsNum == ""){
                $(".goodsN_warn").css('display','block');
                alert("상풍명을 입력해주세요");
                document.addForm.goodsName.focus();
                return false;
            }
            if(subNum == ""){
                $(".subGdN_warn").css('display','block');
                alert("서브상품명(영어)을 입력해주세요");
                document.addForm.subName.focus();
                return false;
            }
            if(price == ""){
                $(".price_warn").css('display','block');
                alert("가격을 입력해주세요");
                document.addForm.price.focus();
                return false;
            }
            if(content == ""){
                $(".content_warn").css('display','block');
                alert("상세내용을 입력해주세요");
                document.addForm.content.focus();
                return false;
            }
            if(energy == ""){
                $(".energy_warn").css('display','block');
                alert("열량(kcal)을 입력해주세요");
                document.addForm.price.focus();
                return false;
            }
            if(protein == ""){
                $(".protein_warn").css('display','block');
                alert("단백질 (g) 을 입력해주세요");
                document.addForm.protein.focus();
                return false;

            }
            if(per == ""){
                $(".per_warn").css('display','block');
                alert("중량(g)을 입력해주세요");
                document.addForm.per.focus();
                return false;

            }
            if(sodium == ""){
                $(".sodium_warn").css('display','block');
                alert("나트륨(mg)을 입력해주세요");
                document.addForm.sodium.focus();
                return false;

            }
            if(suger == ""){
                $(".suger_warn").css('display','block');
                alert("당류(g)을 입력해주세요");
                document.addForm.suger.focus();
                return false;

            }
            if(fat ==""){
                $(".fat_warn").css('display','block');
                alert("지방(g)을 입력해주세요");
                document.addForm.fat.focus();
                return false;

            }
            if(cateCodeRef ==""){
                $(".select1_warn").css('display','block');
                alert("1차분류를 입력해주세요");
                document.addForm.cateCodeRef.focus();
                return false;
            }
            if(cateCode == ""){
                $(".select2_warn").css('display','block');
                alert("2차분류를 입력해주세요");
                document.addForm.cateCodeRef.focus();
                return false;
            }
            if(gdImg == ""){
                $(".gdImg_warn").css('display','block');
                alert("이미지를 추가해주세요");
                document.addForm.file.focus();
                return false;
            }
            document.addForm.action ="<c:url value="/product/add"/>";
            document.addForm.submit();
        });

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

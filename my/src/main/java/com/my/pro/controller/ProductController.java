package com.my.pro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.pro.dto.CateDto;
import com.my.pro.dto.ProductDto;
import com.my.pro.service.CateService;
import com.my.pro.service.ProductServie;
import com.my.pro.util.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    CateService cateService;

    @Autowired
    ProductServie productServie;

   @Autowired
   UploadFileUtils uploadFileUtils;



    @GetMapping("/list")
    public String goodslist(){
        return "product";
    }


    @GetMapping("/add")
    public String goodAdd(HttpSession session, Model m){
        //상품등록화면 보이게하기
        //추후 관리자만 등록할 수 있도록 바꾸기(세션이용하면 될듯)

        ObjectMapper objm = new ObjectMapper();

        try {
            //카테고리 페이지 누르면 카테고리의 값을 받아야하니까!
            List<CateDto> list = cateService.categoryList();
            String category = objm.writeValueAsString(list);
            m.addAttribute("category",category);
            return "productRegister";

        } catch (Exception e) {
            e.printStackTrace();
            return "main";
        }
    }

    @PostMapping("/add")
        public String goodAdd(ProductDto dto, Model m, RedirectAttributes rattr, MultipartFile file) throws Exception {

        String path = "C:\\Users\\ddj04\\IdeaProjects\\my\\src\\main\\webapp\\resources";
        String imgUploadPath = path + File.separator+"upload";
        String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
        String fileName = null;

        if(file != null){
            fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
        }else{
            fileName = path+File.separator + "upload" + File.separator+"none.png";
        }
        dto.setGdImg(File.separator + "path" + ymdPath + File.separator + fileName);
        dto.setGdThum(File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_"+fileName);

        int rowcnt = productServie.add(dto);
        if(rowcnt != 1) {
            rattr.addFlashAttribute("msg", "File_Upload_Fail");
            throw new Exception("File_Upload_Fail");
        }else{
            rattr.addFlashAttribute("msg", "File_Upload_Success");
        }
        return "redirect:/product/list";

    }
//        try {
//            int rowCnt=productServie.add(dto);
//
//            if(rowCnt!=1)
//            throw new Exception("ADD_Fail");
//            System.out.println(dto);
//            m.addAttribute(dto);
//            m.addAttribute("msg", "ADD_OK");
//            return "product";
//        } catch (Exception e) {
//            e.printStackTrace();
//            m.addAttribute("msg", "ADD_Fail");
//            return "productRegister";
//        }

//    @PostMapping("/uploadAction")
//        public void uploadfilePost(MultipartFile[] uploadFile){
//
//
//        String uploadFolder = "C:\\upload";
////        //날짜가져와서 설정하기 위함.
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String str = sdf.format(date); //- 를 기준으로 잘라서 폴더만들거임.
//        String dataPath = str.replace("-", File.separator);
//
//        File uploadPath = new File(uploadFolder,dataPath);
//
//        if(uploadPath.exists()==false){
//            uploadPath.mkdirs();
//        }
//
//        for(MultipartFile multipartFile : uploadFile) {
//            //파일이름
//            String uploadFileName = multipartFile.getOriginalFilename();
//            String uuid = UUID.randomUUID().toString();
//            uploadFileName =uuid + "_" + uploadFileName; //동일한 이름이면 덮어쓰기 때문에 식별자지정!
//            //파일 위치,이름
//            File saveFile = new File(uploadPath,uploadFileName);
//            //파일 저장함.transferTo
//            try {
//                multipartFile.transferTo(saveFile);
//                //썸네일로 이미지 추가저장!!! try catch 안에 적는게 좋다.
//                //File BufferdImage ImageIo를 상ㅅㅇ한다.
//                File thumbnailFile = new File(uploadPath,"s_"+uploadFileName);
//                BufferedImage im = ImageIO.read(saveFile); //버파로 한번 감싸줘야함
//                //썸네일 사이스 생각해서 적기
//                BufferedImage bff_image= new BufferedImage(300,250,BufferedImage.TYPE_3BYTE_BGR);
//                Graphics2D graphic = bff_image.createGraphics(); // 섬네일 을 그림
//                graphic.drawImage(im,0,0,300,250,null);
//                //생성한 썸네일을 파일로 저장하자
//                ImageIO.write(bff_image,"jpg",thumbnailFile);//이미지,형식,경로/이름적힌 파일객체
//
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
}

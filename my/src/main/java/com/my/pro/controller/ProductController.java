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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

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

   // 상품리스트 보여주기
//    @GetMapping("/list")
//    public String goodslist(HttpServletRequest request){
//
//        HttpSession session = request.getSession(false);
//
//        return "product";
//    }
    // 하고싶은 거
    //1. 등록된 상품전체 출력(list) 가능하면 페이징.......
    //2. 등록된 상품 선택시 해당 상세페이지로 이동(read)
    //3. 상세페이지 에서 수정페이지 이동 write //
    //4. 상세페이지에서 수정/삭제 구현 >> 필요한거 상품,상품번호,상품페이지?

    //등록된 상품 리스트
    @GetMapping("/list")
    public String goodstotallist(Model m,HttpServletRequest request,RedirectAttributes rattr){
        String msg="Access_Ok";

        try {
        if(!adminCheck(request))
            throw new Exception("Access_Fail");

            List<ProductDto> list = productServie.selectAll();
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
            m.addAttribute("list",list);
            return "productList";
            
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Access_ERR";
        }
        rattr.addFlashAttribute("msg",msg);
        return "redirect:/login/login?toURL="+request.getRequestURL();
    }


    // 상품등록 화면이동 //
    @GetMapping("/add")
    public String goodAdd(HttpServletRequest request, Model m){
        //일단 로그인 안하면 이동하도록 조치 >> 추후 관리자만!으로 변경예정
            if(!adminCheck(request))
                return "redirect:/login/login?toURL="+request.getRequestURL();
            
        //카테고리 정보받는 객체만들기 등록할때 카테고리 select 때문
            ObjectMapper objm = new ObjectMapper();
        try {
            //카테고리 페이지 누르면 카테고리의 값을 받아야하니까!
            List<CateDto> list = cateService.categoryList();
            String category = objm.writeValueAsString(list);
            m.addAttribute("category",category);
            
            return "productRegister"; //뷰페이지로 이동하게!

        } catch (Exception e) {
            e.printStackTrace();
            return "main";
        }
    }
    
    //상품등록 >> 등록후에 리스트 페이지로 이동
    @PostMapping("/add")
        public String goodAdd(ProductDto dto, Model m, RedirectAttributes rattr, MultipartFile file,HttpServletRequest request) throws Exception {
        if(!adminCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL();

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
    //관리자만...
    private boolean adminCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서(false는 session이 없어도 새로 생성하지 않는다. 반환값 null)
        HttpSession session = request.getSession(false);
        // 2. 세션이 null이 아니고 id 값이 asdf일때 true
        return session!=null && session.getAttribute("id").equals("asdf");


    }

}

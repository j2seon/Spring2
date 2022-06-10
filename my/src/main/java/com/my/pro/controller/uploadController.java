package com.my.pro.controller;

public class uploadController {


// 나중에 사용시에 참고!! >> ajax로 서버에 파일 + 썸네일 + 이름변환하는 내용!!
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

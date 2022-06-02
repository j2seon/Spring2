package com.fastcampus.ch4;

import org.apache.commons.codec.binary.Base64;

import static com.google.common.io.BaseEncoding.base64;

public class Base64Test2 {

    public static void main(String[] args) {
        base64();

    }
    public static void base64(){
        String text ="1234";

        byte[] encodeBytes = Base64.encodeBase64(text.getBytes());
        String encodedTxt = new String(encodeBytes);
        System.out.println("===========인코딩=============");
        System.out.println("인코딩전 데이터 : "+text);
        System.out.println("인코딩gn 데이터 : "+encodedTxt);

        //디코딩
        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        byte[] decodeBytes2 = Base64.decodeBase64(encodedTxt);

        String decodeTxt = new String(decodeBytes);
        String decodeTxt2 = new String(decodeBytes2);

        System.out.println("===========디코딩=============");
        System.out.println("디코딩(byte배열) : " + decodeTxt);
        System.out.println("디코딩 (인코딩된 String ): "+decodeTxt2);
    }


}

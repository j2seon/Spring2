package com.fastcampus.ch3.aop;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception{
        Myadvice myAdvice = new Myadvice();
        Class myClass = Class.forName("com.fastcampus.ch3.aop.MyClass");
        Object obj = myClass.newInstance();

        for(Method m : myClass.getDeclaredMethods()){
            myAdvice.invoke(m,obj,null);//myClass에 있는 것들이 myAdvice에 담긴다.
        }

    }
}

class Myadvice{ //각메소드에 해당 내용을 추가하지않고 따로 빼냄.
    //원하는 곳만 반영하 는 법 :Pattern해주기
    Pattern pattern =Pattern.compile("a.*"); //a로시작하는 단어
    boolean matches(Method m){
        Matcher matcher =pattern.matcher(m.getName());
        return matcher.matches();
    }

    void invoke(Method m, Object obj, Object...args)throws Exception{ //밑의 클래스의 메서드를 호출하는 메서드
       // if(matches(m)) //패턴에 맞는 메소드만{
        if(m.getAnnotation(Transactional.class)!=null) //애너테이션으로도 가능하다.
            System.out.println("[before]{");

        m.invoke(obj,args);//aaa() aaa2() bbb() 호출가능

        //if(matches(m)) //패턴에 맞는 메소드만
        if(m.getAnnotation(Transactional.class)!=null)
             System.out.println("}[after]");
    }
}

class MyClass{

    @Transactional
    void aaa(){
        System.out.println("aaa{} is called");
    }
    void aaa2(){
        System.out.println("aa2{} is called");
    }
    void bbb(){
        System.out.println("bbb{} is called");
    }
}
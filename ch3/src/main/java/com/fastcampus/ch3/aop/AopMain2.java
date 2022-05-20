package com.fastcampus.ch3.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain2 {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context_aop.xml");
        MyMath my = (MyMath) ac.getBean("myMath");
        my.add(3,5);
        my.subtract(7,1); //출력안해서 안나온것
        my.multiply(3,5);


    }
}

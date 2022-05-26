//package com.fastcampus.ch4.domain;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class PageHandlerTest {
//
//    @Test
//    public void testprint() {
//        PageHandler p = new PageHandler(250,11);
//        p.print();
//        System.out.println(p);
//        assertTrue(p.getBeginPage() ==11);
//        assertTrue(p.getEndPage() ==20);
//    }
//
//    @Test
//    public void testprint1() {
//        PageHandler p = new PageHandler(255,25);
//        p.print();
//        System.out.println(p);
//        assertTrue(p.getBeginPage() ==21);
//        assertTrue(p.getEndPage() ==26);
//    }
//
//    @Test
//    public void testprint2() {
//        PageHandler p = new PageHandler(255,10);
//        p.print();
//        System.out.println(p);
//        assertTrue(p.getBeginPage() ==1);
//        assertTrue(p.getEndPage() ==10);
//    }
//
//    @Test
//    public void testToString() {
//    }
//}
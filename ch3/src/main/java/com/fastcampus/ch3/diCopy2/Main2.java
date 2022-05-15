package com.fastcampus.ch3.diCopy2;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Truck extends Car{}
class Engine {}


class AppContext{
    Map map ;  //객체를 저장소!

    AppContext(){
//        map = new HashMap();
//        map.put("car", new SportsCar()); 하드코딩임 이걸 바꿔보자
//        map.put("engin", new Engine());

        try {
            Properties p = new Properties(); //properties 를 만들어서 String String 형태로 저장되었음
            p.load(new FileReader("config.txt")); 
            
            //properties를 map으로 변환
            map = new HashMap(p); //properties에 저장되어잇는 내용을 map에 저장.

            //반복문으로 클래스이름을 얻어서 객체를 생성해서 다시 map에 저장한다.
            for(Object key : map.keySet()){ //map에 저장된 key를 돌면서
            Class clazz = Class.forName((String) map.get(key)); //map에 저장된 키를 이용해서 value인 클래스를 가져오겠다.
            map.put(key,clazz.newInstance()); //map 돌면서 얻은 key와 나온 값의 객체를 생성해줌(new 객체)
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    Object getBean(String key){ //맵에 답겨있는 객체를 반환해야한다.
        return map.get(key);
    }
}

public class Main2 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
        Car car1 = (Car)ac.getBean("car");
        Engine engine = (Engine)ac.getBean("engine") ;
        System.out.println("car = "+ car1);
        System.out.println("engine = "+ engine);

    }
//    static Car getCar() throws Exception {
//        Properties p = new Properties();
//        p.load(new FileReader("config.txt"));
//
//        Class clazz = Class.forName(p.getProperty("car"));
//
//        return (Car) clazz.newInstance();
//    }




}

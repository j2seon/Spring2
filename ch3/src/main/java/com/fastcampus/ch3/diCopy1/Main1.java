package com.fastcampus.ch3.diCopy1;

import java.lang.Exception;
import java.io.FileReader;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Truck extends Car{}
class Engine {}

public class Main1 {
    public static void main(String[] args) throws Exception {
        Car car = getCar();
        Car car1 = (Car)getObject("car");
        Engine engine = (Engine)getObject("engine") ;
        System.out.println("car = "+ car);
        System.out.println("engine = "+ engine);

    }
    static Car getCar() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car")); //key가 car인 value를 얻어오는것!!!

        return (Car) clazz.newInstance(); //그리고 그 value를 반환해준다. object 형태라서 형번환 필요 
    }
    static Object getObject (String key) throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return (Object) clazz.newInstance();
    }



}

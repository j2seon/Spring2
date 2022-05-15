package com.fastcampus.ch3.diCopy3;

import com.google.common.reflect.ClassPath;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component class Car{}
@Component class SportsCar extends Car{}
@Component class Truck extends Car{}
@Component class Engine {}


class AppContext {
    Map map;  //객체를 저장소!

    AppContext() {
        map = new HashMap();
        doComponentScan();

    }

    private void doComponentScan() {
        try {
            //1. 패키지내의 클래스 목록을 가져와야한다.
            //2. 반복문으로 클래스를 하나씩 읽어와서 @Component이 붙어있는지 확인해야한다.
            //3. @Component이 붙어있으면 객체를 생성해서 map에 저장.
            ClassLoader classLoader = AppContext.class.getClassLoader(); //클래스로더의 정보를 얻어오고
            ClassPath classPath = ClassPath.from(classLoader); // 클래스 path를 가져온다.

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fastcampus.ch3.diCopy3"); //클래스목록을 가져온다.

            for (ClassPath.ClassInfo classInfo : set) { // for 문으로 set에 담긴 목록을 읽어서
                Class clazz = classInfo.load(); //클래스의 정보를 담고
                Component component = (Component) clazz.getAnnotation(Component.class); //Component가 있는지 확인
                if (component != null) {//Component가 있는지 확인
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName()); // 첫번째를 대문자로 바꿔서
                    map.put(id, clazz.newInstance()); //id를 key로 value 를 객체로 저장해야함!!
                }
            }
        } catch (Exception e) {
        }
    }

    Object getBean(String key) { //맵에 답겨있는 객체를 반환해야한다.
        return map.get(key); //이름으로 반환
    }
    Object getBean(Class clazz){ //타입으로 반환
        for(Object obj : map.values()){
            if(clazz.isInstance(obj))
                return obj;
        }
        return null;
    }
}

public class Main3 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
        Car car1 = (Car) ac.getBean("car");
        Car ca2 = (Car) ac.getBean(Car.class);
        Engine engine = (Engine) ac.getBean("engine");
        System.out.println("car = " + car1);
        System.out.println("engine = " + engine);

    }
}
//    static Car getCar() throws Exception {
//        Properties p = new Properties();
//        p.load(new FileReader("config.txt"));
//
//        Class clazz = Class.forName(p.getProperty("car"));
//
//        return (Car) clazz.newInstance();
//    }






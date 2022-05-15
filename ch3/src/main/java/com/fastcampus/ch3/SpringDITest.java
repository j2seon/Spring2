package com.fastcampus.ch3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

@Component
class Car{
    @Value("red") String color;
    @Value("150") int oil;
    @Autowired
    Door[] doors;
   // @Autowired
   // @Qualifier("superEngine")     //byname
    @Resource                       //bytype
    Engine engine;

    public Car(){} //기본생성자는 꼭 만들어주는 습관을 들이자
    public Car(String color, int oil, Engine engine, Door[] doors) {
        this.color = color;
        this.oil = oil;
        this.engine = engine;
        this.doors = doors;
    }

    //xml에서 property를 사용하기 위해선 setter가 필요하다!!!! >> 추가로 생성자로도 가능하다. perperty를 constructor로 변경
    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}
@Component
class Door {}

@Component("engine") class Engine{} // <bean id="engine" class="com.fastcampus.ch3.Engine"/>

@Component class SuperEngine extends Engine{}
@Component class TurboEngine extends Engine{}



public class SpringDITest {
    public static void main(String[] args) {
        //xml 파일을 설정파일로 쓰는 메서드 사용
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");//map형태로 config.xml을 보낸다.
        //Car car = (Car) ac.getBean("car"); //이름으로 !! / 아래와 같은문장임
        Car car = (Car) ac.getBean("car",Car.class); //클래스 타입을 뒤에 적어주면 형변환을 하지 않아도 된다!!
       // 기본적으로 싱글톤이기 때문에 car와 car2가 같은 객체가 반환된다. >> 근데 가끔은 다른객체로도 필요한데?>xml에 파일에서scope="prototype" 으로 바꿔주기
      // Car car2 = ac.getBean(Car.class); //타입으로 가져온다.
       Engine engine = (Engine) ac.getBean("engine");
        //Engine engine = (Engine) ac.getBean(Engine.class);
       // Door door = (Door) ac.getBean("door");

//setter로 처리하기 >> xml에서 처리하는 방법이 있다!!!
//        car.setColor("red");
//        car.setOil(100);
//        car.setEngine(engine);
//        car.setDoors(new Door[]{(Door) ac.getBean("door"),ac.getBean("door",Door.class)});

       // System.out.println("car = " + car);
         System.out.println("engine = " + engine);

    }


}

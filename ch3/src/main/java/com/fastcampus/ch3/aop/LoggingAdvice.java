package com.fastcampus.ch3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//pointcut : 부가기능이 적용될 메서드의 패턴
@Component
@Aspect
public class LoggingAdvice {//ch3.aop에 있는 모든 클래스와 메서드 (..)<매개변수의 개수가 상관없음을 의미 )
    @Around("execution(* com.fastcampus.ch3.aop.MyMath.add*(..))")
    public Object methodCallLog(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start "+pjp.getSignature().getName()+ Arrays.toString(pjp.getArgs()));
                                    //pjp 의 선언부를 얻어오고 메서드이름을 가져오고 args들을 가져옴(이건 배열)

        Object result = pjp.proceed(); //target의 메서드를 호출

        System.out.println("result :"+result);
        System.out.println("end : "+ (System.currentTimeMillis() - start+"ms"));
        
        return result;

    }
}

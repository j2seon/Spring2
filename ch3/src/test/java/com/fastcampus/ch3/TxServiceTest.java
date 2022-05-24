package com.fastcampus.ch3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //이게 있어서 ApplicationContext 객체를 만들지 않아도 생성해줌
//그러고 context.xml에 bean으로 DataSource의 내용을 정해주면 됌
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//xml설정파일 위치
public class TxServiceTest extends TestCase {
    @Autowired
    TxService txService;

    @Test
    public void insertA1WithoutTxTest() throws Exception {
        txService.insertWithTxFail();
    }
}

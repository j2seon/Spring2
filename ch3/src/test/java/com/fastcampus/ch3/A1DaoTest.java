package com.fastcampus.ch3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class) //이게 있어서 ApplicationContext 객체를 만들지 않아도 생성해줌
//그러고 context.xml에 bean으로 DataSource의 내용을 정해주면 됌
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})//xml설정파일 위치
public class A1DaoTest extends TestCase {
    @Autowired
    A1Dao a1Dao;
    @Autowired
    DataSource ds;


    @Test
    public void insertTest() {
        //원하는 조건 : 둘다 성공시에만 커밋!
        // 1. Transaction을 생성
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        //2. 트렌젝션 매니져를 사용해서 트렌젝션을 가져오고 그 속성은 뭐다 ~
        //그리고 그걸 TransactionStatus 트렌젝션 상태에 가져온다. 이렇게 하면 시작됨.
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());

        try {//하나라도 예외발생되면 실행 안되게 묶고
            a1Dao.deleteAll();
            a1Dao.insert(1,100); //성공 >> 이건 값이 들어오게 된다.
            a1Dao.insert(1,200); //실패
            tm.commit(status); //성공하면 해당상태를 커밋
        } catch (Exception e) {
            tm.rollback(status); //실패하면 이전상태로 롤백.
        }
    }

}
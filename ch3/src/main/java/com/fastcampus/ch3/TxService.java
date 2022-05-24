package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxService {
    @Autowired A1Dao a1Dao;
    @Autowired B1Dao b1Dao;

    public void insertA1withoutTx() throws Exception{
        a1Dao.insert(1,100);
        a1Dao.insert(1,200);
    }
    //@Transactional - runtime, Error만 rollback을 한다 그래서 밑의 방법을 사용한다.
    @Transactional(rollbackFor = Exception.class)
    public void insertWithTxFail() throws Exception{
        a1Dao.insert(1,100);
        throw new RuntimeException();
        //throw new Exception();
       // a1Dao.insert(1,200);
    }
    @Transactional
    public void insertWithTxSuccess() throws Exception{
        a1Dao.insert(1,100);
        a1Dao.insert(2,200);
    }


}

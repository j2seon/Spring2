package com.test.test.service.ex;


import com.test.test.dao.ex.Joindao;
import com.test.test.domain.ex.JoinDto;
import com.test.test.domain.ex.JoinDto2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    Joindao joindao;
    @Override
    public List<JoinDto> getList1(){
        return joindao.selectAll();
    }


    @Override
    public List<JoinDto2> getList2(){
        return joindao.selectAll2();
    }



}


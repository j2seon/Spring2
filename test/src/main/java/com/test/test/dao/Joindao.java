package com.test.test.dao;



import com.test.test.domain.JoinDto;
import com.test.test.domain.JoinDto2;

import java.util.List;

public interface Joindao {
    List<JoinDto> selectAll();

    List<JoinDto2> selectAll2();

}

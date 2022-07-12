package com.test.test.dao.ex;



import com.test.test.domain.ex.JoinDto;
import com.test.test.domain.ex.JoinDto2;

import java.util.List;

public interface Joindao {
    List<JoinDto> selectAll();

    List<JoinDto2> selectAll2();

}

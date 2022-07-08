package com.test.test.service;

import com.test.test.dao.StoreDao;
import com.test.test.domain.SearchCondition;
import com.test.test.domain.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreDao storeDao;

    @Override
    public List<StoreDto> regionStore(String address){
        return storeDao.Region(address);
    }

    @Override
    public List<StoreDto>AllStore() throws Exception {
        return storeDao.selectAll();
    }

//    @Override
//    public List<StoreDto> category(SearchCondition sc){
//        if(sc.getKeyword()==null||sc.getKeyword().equals("")){
//            return storeDao.searchStore1(sc);
//        }else {
//            return storeDao.searchStore2(sc);
//        }
//    }//

    @Override
    public StoreDto getStore(Integer id){
        return storeDao.selectOne(id);
    }

    @Override
    public List<StoreDto> getList(SearchCondition sc){
        return storeDao.selectResultpage(sc);
    }
}

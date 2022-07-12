package com.test.test.service;

import com.test.test.dao.TourDao;
import com.test.test.domain.TourDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourDao tourDao;

    @Override
    public List<TourDto> regionGetTour(String address){
        return tourDao.region(address);
    }
    @Override
    public int regionGetCount(String address){return tourDao.regionCount(address);}

    @Override
    public List<TourDto> allTour(){
        return tourDao.selectAll();
    }

    @Override
    public TourDto getRead(String no){
        return tourDao.read(no);
    }

}

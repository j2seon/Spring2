package com.test.test.service;

import com.test.test.dao.TourDao;
import com.test.test.domain.TourDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TourServiceImplTest {

    @Autowired
    TourDao tourDao;

    @Autowired
    TourService tourService;

    @Test
    public void regionGetTour() {
        String address= "인천";
        List<TourDto> list = tourService.regionGetTour(address);
        System.out.println(list);
    }
}
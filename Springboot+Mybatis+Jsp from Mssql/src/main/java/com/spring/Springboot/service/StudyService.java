package com.spring.Springboot.service;

import com.spring.Springboot.dao.StudyDao;
import com.spring.Springboot.vo.Vo_study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudyService {

    @Autowired
    StudyDao studyDao;

        // total select
    public List<Vo_study> doStudyList(){

        List<Vo_study> list = new ArrayList<>();
        list=studyDao.doStudyList();

        return list;

    }
        // one row select
    public Vo_study doStudyListOne(String strKeyId){

        Vo_study vo_study = new Vo_study();

        vo_study=studyDao.doStudyListOne(strKeyId);

        return vo_study;

    }
    // update
    public Integer doStudyUp(Vo_study vo_study){

        Integer intI = studyDao.doStudyUp(vo_study);

        return intI;

    }

    //Delete
    public Integer doStudyDel(String strKeyId) {


        Integer intI=studyDao.doStudyDel(strKeyId);

        return intI;

    }

    //INSERT
    public Integer doStudyIns(Vo_study vo_study) {

        Integer intI = studyDao.doStudyIns(vo_study);

        return intI;
    }
}



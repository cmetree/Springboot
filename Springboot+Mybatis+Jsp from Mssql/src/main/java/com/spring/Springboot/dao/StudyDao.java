package com.spring.Springboot.dao;

import com.spring.Springboot.vo.Vo_study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


// Data Access Object
//-Mssql 서버에 접근하여 SQL문을 실행할 수 있는 객체입니다

@Mapper
public interface  StudyDao {

    //전체 리스트
    public List<Vo_study> doStudyList();

    //one row
    public Vo_study doStudyListOne(String strKeyId);

    //update
    public Integer doStudyUp(Vo_study vo_study);

    //Delete
    public Integer doStudyDel(String strKeyId);

   public Integer doStudyIns(Vo_study voStudy);
}

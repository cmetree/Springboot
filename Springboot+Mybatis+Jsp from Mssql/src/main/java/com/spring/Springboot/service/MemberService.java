package com.spring.Springboot.service;


import com.spring.Springboot.dao.MemberDao;
import com.spring.Springboot.vo.Vo_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

    /* 멤버 리스트 */
    public List<Vo_member> doMemberList(){

        List<Vo_member> list = new ArrayList<>();
        list = memberDao.doMemberList();
        return  list;
    }

    /* One Row Select */
    public Vo_member doMemberListOne(String strMemberId){


        Vo_member vo_member = memberDao.doMemberListOne(strMemberId);
        return  vo_member;
    }

    /* 멤버 수정 */
    public Integer doMemberUp(Vo_member vo_member){

        Integer intI = memberDao.doMemberUp(vo_member);

        return  intI;
    }

    /* 공부기록 삭제 */
    public Integer doMemberDel(String strMemberId){

        Integer intI  = memberDao.doMemberDel(strMemberId);
        return  intI;
    }

    /* 공부하기 등록 */
    public Integer doMemberIns(Vo_member vo_member){

        Integer intI = memberDao.doMemberIns(vo_member);

        return  intI;
    };




}

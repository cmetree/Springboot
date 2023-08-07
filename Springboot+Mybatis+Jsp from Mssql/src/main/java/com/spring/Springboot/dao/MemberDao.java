package com.spring.Springboot.dao;


import com.spring.Springboot.vo.Vo_member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {

    // 공부기록 전체 리스트
    public List<Vo_member> doMemberList();

    // 공부기록 One row
    public Vo_member doMemberListOne(String strKeyId);

    // 공부기록 수정
    public Integer doMemberUp(Vo_member vo_member);

    // 공부기록 삭제
    public Integer doMemberDel(String strKeyId);

    // 공부하기 등록
    public Integer doMemberIns(Vo_member vo_member);


}

package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;

public class BoardDAO {

	private SqlSession mybatis;
	
	
	public BoardDAO() {
		mybatis=SqlSessionFactoryBean.getSqlSessionInstance();
	}

	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard",vo);
		mybatis.commit();
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.updateBoard",vo);
		mybatis.commit();
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.deleteBoard",vo);
		mybatis.commit();
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard",vo);
	}

	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
}
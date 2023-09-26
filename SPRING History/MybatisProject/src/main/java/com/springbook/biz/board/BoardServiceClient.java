package com.springbook.biz.board;

import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.impl.BoardDAO;

public class BoardServiceClient {
	public static void main(String[] args) {
		
		BoardDAO boardDAO = new BoardDAO();
		
//		// 3. 글 등록 기능 테스트
//		BoardVO vo = new BoardVO();
//		vo.setSeq(222);
//		vo.setTitle("임시2");
//		vo.setWriter("홍길동2");
//		vo.setContent("임시 내용.........2222.....");
//		boardDAO.insertBoard(vo);
		
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
}
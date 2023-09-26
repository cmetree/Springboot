package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVo;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB 연동 처리
		UserVo vo = new UserVo();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVo user = userDAO.getUser(vo);

		// 3. 화면 네비게이션
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login";
		}
	}

}

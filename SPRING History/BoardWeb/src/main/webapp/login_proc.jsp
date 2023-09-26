<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVo"%>
<%@page contentType="text/html; charset=UTF-8" %>


<% 

	//1. 사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//2. DB 연동 처리
	UserVo vo = new UserVo();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVo user = userDAO.getUser(vo);
	
	//3. 화면 네비게이션
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
		
	}else{
		response.sendRedirect("login.jsp");
	}

%>
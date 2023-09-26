package com.springbook.biz.user.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserVo getUser(UserVo vo) {
		return userDAO.getUser(vo);
	}
	
	

}

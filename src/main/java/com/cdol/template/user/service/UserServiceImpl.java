package com.cdol.template.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cdol.template.user.dao.UserDAO;
import com.cdol.template.user.dto.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO userDao;
	
	@Override
	public void insertUser(UserVO vo) {
		userDao.insertUser(vo);
	}
	
}

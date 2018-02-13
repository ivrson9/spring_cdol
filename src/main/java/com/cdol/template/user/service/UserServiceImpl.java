package com.cdol.template.user.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdol.template.user.dao.UserDAO;
import com.cdol.template.user.dto.UserVO;

/**
 * UserService implementation
 * 
 * @author wonsuk Cha
 */
@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO userDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void insertUser(UserVO vo) {
		// Bcrypt Encode
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		userDao.insertUser(vo);
	}

	@Override
	public UserVO authentication(UserVO vo, HttpSession session, HttpServletRequest req) {
		UserVO result = userDao.authentication(vo);
		if( result != null) {
			if(passwordEncoder.matches(vo.getPassword(), result.getPassword())) {
				String ip = req.getHeader("X-FORWARDED-FOR");
		        if (ip == null) {
		            ip = req.getRemoteAddr();
		        }
		        result.setIp_address(ip);
		        result.setIs_login(true);
	            
		        session.setAttribute("user", result);
	            
				return result;
			}
		}
		return null;
	}
	
}

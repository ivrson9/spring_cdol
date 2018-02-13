package com.cdol.template.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cdol.template.user.dto.UserVO;

/**
 * UserService interface
 * 
 * @author wonsuk Cha
 */
public interface UserService {
	
	/**
	 * user authentication
	 * 
	 * @param UserVO
	 * @param HttpSession
	 * @param HttpServletRequest
	 * @return UserVO
	 */
	public UserVO authentication(UserVO vo, HttpSession session, HttpServletRequest req);
	
	/**
	 * user register
	 * 
	 * @param UserVO
	 */
	public void insertUser(UserVO vo);
}

package com.cdol.template.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdol.template.user.dto.UserVO;
import com.cdol.template.user.service.UserService;

/**
 * UserController class
 * 
 * @author wonsuk Cha
 */
@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService userService;
	
	/**
	 * view login page
	 * 
	 * @param HttpServletRequest
	 * @return ModelAndView
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		String returnURL = request.getHeader("REFERER");
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnURL", returnURL);
		mav.setViewName("login");
		
		return mav;
	}
	
	/**
	 * view sign up page
	 * 
	 * @return Redirect
	 */
	@RequestMapping(value = "signup")
	public String signup() {
		return "register";
	}
	
	/**
	 * user authentication
	 * 
	 * @param UserVO
	 * @param HttpSession
	 * @param HttpServeltRequest
	 * @param HttpServletResponse
	 */
	@RequestMapping(value = "authentication", method = RequestMethod.POST)
	public void authentication(@ModelAttribute UserVO vo, HttpSession session, 
								HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		UserVO resultVo = userService.authentication(vo, session, request);
		
		try {
			if(resultVo != null) {
				resultVo.setReturnURL(vo.getReturnURL());
			}
			response.getWriter().print(mapper.writeValueAsString(resultVo));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * user register
	 * 
	 * @param UserVO
	 * @return Redirect
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute UserVO vo) {
		userService.insertUser(vo);
		return "redirect:/";
	}
	
	/**
	 * Log out (session kill)
	 * 
	 * @param UserVO
	 * @return ResponseEntity<UserVO>
	 * @throws Exception
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}

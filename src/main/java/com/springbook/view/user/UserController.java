package com.springbook.view.user;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.join.JoinVO;
import com.springbook.biz.join.impl.JoinDAO;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;

@Controller
@RequestMapping("/*")
public class UserController {

	//�α��� ���� ����
	private static final Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService userService;
	
	/*
	 * @Bean (name ="entityManagerFactory") public LocalSessionFactoryBean
	 * sessionFactory () { LocalSessionFactoryBean sessionFactory = new
	 * LocalSessionFactoryBean (); return sessionFactory; }
	 */
	
	//�α��� ȭ��
	@RequestMapping("/login.do")
	public String login() {
		return "/login.jsp";
	}
	
	//�α��� ó��
	@RequestMapping("/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute UserVO vo, HttpSession session) {
		boolean result = userService.loginCheck(vo,session);
		ModelAndView mav = new ModelAndView();
		if(result == true) { //�α��� ����
			//list.jsp�� �̵�(���� ���� �������� �̵����� ����)
			mav.setViewName("list.do");
			mav.addObject("msg","success");
		} else {
			mav.setViewName("login.jsp");
			mav.addObject("msg","failure");
		}

		return mav;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		userService.logout(session);
		//session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		mav.addObject("msg","logout");
		return mav;
	}
	

}

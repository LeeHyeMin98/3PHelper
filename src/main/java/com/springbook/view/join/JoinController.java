package com.springbook.view.join;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.join.JoinService;
import com.springbook.biz.join.JoinVO;

@Controller
@SessionAttributes("join")
public class JoinController {
	private static final Logger Logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	JoinService service;
	
	//회원가입
	@RequestMapping(value="/register.do")
	public String insertUser(JoinVO vo) throws Exception{
		System.out.println("회원가입 화면 이동");
		service.insertUser(vo);
		return "redirect:login.do";
	}
	
	
}

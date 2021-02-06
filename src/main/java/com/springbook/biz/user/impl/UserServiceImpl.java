package com.springbook.biz.user.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	//회원 로그인 체크
	@Override
	public boolean loginCheck(UserVO vo, HttpSession session) {
		boolean result= userDAO.loginCheck(vo);
		if(result) { //true일 경우 세션에 등록
			UserVO vo2 = viewMember(vo);
			//세션 변수 등록
			session.setAttribute("uname", vo2.getUname());
		}
		return result;
	}
	//로그인 정보
	@Override
	public UserVO viewMember(UserVO vo) {
		return userDAO.viewMember(vo);
	}
	//회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate(); //세션 정보 초기화
	}
	
}

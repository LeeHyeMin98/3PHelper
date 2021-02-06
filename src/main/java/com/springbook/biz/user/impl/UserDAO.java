package com.springbook.biz.user.impl;

import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserVO;

public interface UserDAO {
	//로그인 체크
	public boolean loginCheck(UserVO vo);
	//로그인 정보
	public UserVO viewMember(UserVO vo);
	//회원 로그아웃
	public void logout(HttpSession session);

}

package com.springbook.biz.user.impl;

import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserVO;

public interface UserDAO {
	//�α��� üũ
	public boolean loginCheck(UserVO vo);
	//�α��� ����
	public UserVO viewMember(UserVO vo);
	//ȸ�� �α׾ƿ�
	public void logout(HttpSession session);

}

package com.springbook.biz.user;

import javax.servlet.http.HttpSession;

public interface UserService {
	//ȸ�� �α��� üũ
	public boolean loginCheck(UserVO vo, HttpSession session);

	//ȸ�� �α��� ����
	public UserVO viewMember(UserVO vo);
	//ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
	
}

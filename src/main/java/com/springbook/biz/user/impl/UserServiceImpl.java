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

	//ȸ�� �α��� üũ
	@Override
	public boolean loginCheck(UserVO vo, HttpSession session) {
		boolean result= userDAO.loginCheck(vo);
		if(result) { //true�� ��� ���ǿ� ���
			UserVO vo2 = viewMember(vo);
			//���� ���� ���
			session.setAttribute("uname", vo2.getUname());
		}
		return result;
	}
	//�α��� ����
	@Override
	public UserVO viewMember(UserVO vo) {
		return userDAO.viewMember(vo);
	}
	//ȸ�� �α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		session.invalidate(); //���� ���� �ʱ�ȭ
	}
	
}

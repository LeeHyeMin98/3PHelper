package com.springbook.biz.user.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository //���� Ŭ������ ���������� �����ϴ� dao bean ���� ���
public class UserDAOImpl implements UserDAO {
	//SqlSession ��ü�� ���������� �����Ͽ� ����
	//�������� ����
	@Inject
	SqlSession sqlSession; //mybatis ���� ��ü
	

	//�α��� üũ
	@Override
	public boolean loginCheck(UserVO vo) {
		String uname = sqlSession.selectOne("member.loginCheck",vo);
		return (uname ==null) ? false :true;
	}

	//ȸ�� �α��� ����
	@Override
	public UserVO viewMember(UserVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember",vo);
	}

	//ȸ�� �α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
		
	}
	
	

}

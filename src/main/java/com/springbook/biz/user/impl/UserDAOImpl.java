package com.springbook.biz.user.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository //현재 클래스를 스프링에서 관리하는 dao bean 으로 등록
public class UserDAOImpl implements UserDAO {
	//SqlSession 객체를 스프링에서 생성하여 주입
	//의존관계 주입
	@Inject
	SqlSession sqlSession; //mybatis 실행 객체
	

	//로그인 체크
	@Override
	public boolean loginCheck(UserVO vo) {
		String uname = sqlSession.selectOne("member.loginCheck",vo);
		return (uname ==null) ? false :true;
	}

	//회원 로그인 정보
	@Override
	public UserVO viewMember(UserVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember",vo);
	}

	//회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
		
	}
	
	

}

package com.springbook.biz.join.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.join.JoinVO;


@Repository
public class JoinDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertUser(JoinVO vo) {
		System.out.println("===> Mybatis로 insertUser() 기능 처리");
		mybatis.insert("JoinDAO.insertUser", vo);
	}
}

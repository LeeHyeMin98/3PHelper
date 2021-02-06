package com.springbook.biz.join.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.join.JoinVO;

//DAO(Data Access Object)
@Repository
public class JoinDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String USER_INSERT = "insert into user(uname, upw, uemail, uage, ujob) values(?, ?, ?, ?, ?)";	
	
	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertUser(JoinVO vo) {
		System.out.println("===> Spring JDBC�� insertBoard() ��� ó��");
		jdbcTemplate.update(USER_INSERT, vo.getUname(), vo.getUpw(), vo.getUemail(), vo.getUage(), vo.getUjob());
	}
}

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
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertUser(JoinVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(USER_INSERT, vo.getUname(), vo.getUpw(), vo.getUemail(), vo.getUage(), vo.getUjob());
	}
}

package com.springbook.biz.join.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.join.JoinVO;


public class JoinRowMapper implements RowMapper<JoinVO>{
	public JoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		JoinVO join = new JoinVO();
		join.setUname(rs.getString("UNAME"));
		join.setUpw(rs.getString("UPW"));
		join.setUemail(rs.getString("UEMAIL"));
		join.setUage(rs.getInt("UAGE"));
		join.setUjob(rs.getBoolean("UJOB"));
		return join;
	}
}

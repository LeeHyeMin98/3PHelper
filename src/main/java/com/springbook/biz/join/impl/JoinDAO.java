package com.springbook.biz.join.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.JDBCUtil;
import com.springbook.biz.join.JoinVO;
import com.springbook.biz.user.UserVO;

@Repository("joinDAO")
public class JoinDAO {
	// JDBC 관련 변수
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		
		private final String USER_INSERT = "insert into user(uname, upw, uemail, uage, ujob) values(?,?,?,?,?)";	
		private final String USER_GET = "select * from user where uname=? and upw=?";

		
		// CRUD 기능의 메소드 구현
		// 글 등록
		public void insertUser(JoinVO vo) {
			System.out.println("===> JDBC로 insertUser() 기능 처리");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(USER_INSERT);
				stmt.setString(1, vo.getUname());
				stmt.setString(2, vo.getUpw());
				stmt.setString(3, vo.getUemail());
				stmt.setInt(4, vo.getUage());
				stmt.setBoolean(5, vo.getUjob());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
			
		}
		
		// 회원 등록
		public JoinVO getUser(JoinVO vo) {
			JoinVO user = null;
			try {
				System.out.println("===> JDBC로 getUser() 기능 처리");
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(USER_GET);
				System.out.println(vo.getUname());
				System.out.println(vo.getUpw());
				stmt.setString(1, vo.getUname());
				stmt.setString(2, vo.getUpw());
				rs = stmt.executeQuery();
				if (rs.next()) {
					user = new JoinVO();
					user.setUname(rs.getString("UNAME"));
					user.setUpw(rs.getString("UPW"));
					user.setUemail(rs.getString("UEMAIL"));
					user.setUage(rs.getInt("UAGE"));
					user.setUjob(rs.getBoolean("UJOB"));
				}
				System.out.println("아이디 비번 설정");
				System.out.println(vo.getUname());
				System.out.println(vo.getUpw());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return user;
		}
		//회원가입
		//public void register(JoinVO vo) throws Exception;
}

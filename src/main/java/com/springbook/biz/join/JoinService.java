package com.springbook.biz.join;

import javax.servlet.http.HttpServletResponse;

public interface JoinService {
		// 회원 가입 처리 
		void insertUser(JoinVO vo);
		
		public JoinVO getUSer(JoinVO vo);
		
	
}

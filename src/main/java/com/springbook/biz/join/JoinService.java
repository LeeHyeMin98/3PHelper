package com.springbook.biz.join;

import javax.servlet.http.HttpServletResponse;

public interface JoinService {
		// ȸ�� ���� ó�� 
		void insertUser(JoinVO vo);
		
		public JoinVO getUSer(JoinVO vo);
		
	
}

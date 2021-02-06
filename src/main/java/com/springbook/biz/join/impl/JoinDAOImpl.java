package com.springbook.biz.join.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.join.JoinService;
import com.springbook.biz.join.JoinVO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


@Service("joinService")
public class JoinDAOImpl implements JoinService {
	//@Autowired
	//private JoinDAOJPA joinDAO;
	@Autowired
	private JoinDAO joinDAO;
	/*
	 * //mybatis private SqlSession sql;
	 * 
	 * //mapper private static final String NAMESPACE =
	 * "com.potfolio.web.mappers.userMapper";
	 * 
	 * // 회원가입처리
	 * 
	 * @Override public void register(JoinVO JoinVO) throws Exception {
	 * sql.insert(NAMESPACE + ".register", JoinrVO);
	 * 
	 * }
	 */
	public void insertUser(JoinVO vo) {
		joinDAO.insertUser(vo);
	}
	public void setUserDAO(JoinDAO joinDAO) {
		this.joinDAO = joinDAO;
	}

	/*
	 * public JoinVO getUser(JoinVO vo) { return joinDAO.getUser(vo); }
	 */
	@Override
	public JoinVO getUSer(JoinVO vo) {
		// TODO Auto-generated method stub
		return joinDAO.getUser(vo);
	}
}

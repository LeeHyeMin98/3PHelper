package com.springbook.biz.board.reply;

import java.util.List;

import javax.inject.Inject;
import com.springbook.biz.board.reply.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<ReplyVO> list(Integer seq) {
		return sqlSession.selectList("reply.listReply",seq);
	}

	@Override
	public void create(ReplyVO vo) {
		sqlSession.insert("reply.insertReply",vo);
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
		
	}
	

}

package com.springbook.biz.board.reply;

import java.util.List;

import javax.inject.Inject;
import com.springbook.biz.board.reply.ReplyVO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	ReplyDAO replyDAO;
	
	//´ñ±Û ¸ñ·Ï
	@Override
	public List<ReplyVO> list(Integer seq){
		return replyDAO.list(seq);
	}

	//´ñ±Û ÀÛ¼º
	@Override
	public void create(ReplyVO vo) {
		replyDAO.create(vo);
		
	}
	//´ñ±Û ¼öÁ¤
	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}
	//´ñ±Û »èÁ¦
	@Override
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
		
	}

}

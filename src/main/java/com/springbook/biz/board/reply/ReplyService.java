package com.springbook.biz.board.reply;

import java.util.List;
import com.springbook.biz.board.reply.ReplyVO;
public interface ReplyService {
	//��� ���
	public List<ReplyVO> list(Integer seq);
	//��� �Է�
	public void create(ReplyVO vo);
	//��� ����
	public void update(ReplyVO vo);
	//��� ����
	public void delete(Integer rno);
}

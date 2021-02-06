package com.springbook.biz.board.reply;

import java.util.List;

public interface ReplyDAO{
	//´ñ±Û ¸ñ·Ï
	public List<ReplyVO> list(Integer seq);
	//´ñ±Û ÀÔ·Â
	public void create(ReplyVO vo);
	//´ñ±Û ¼öÁ¤
	public void update(ReplyVO vo);
	//´ñ±Û »èÁ¦
	public void delete(Integer rno);

}

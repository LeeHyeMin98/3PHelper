package com.springbook.biz.board.impl;

import java.util.List;

import com.springbook.biz.board.BoardVO;

public interface BoardDAO {
	
	//�Խñ� �ۼ�
	public void insertBoard(BoardVO vo);
	//�Խñ� ����
	public void updateBoard(BoardVO vo);
	//�Խñ� ����
	public void deleteBoard(int seq);
	//�Խñ� �󼼺���
	public BoardVO getBoard(int seq);
	//�Խñ� ��ü ���
	public List<BoardVO> getBoardList(BoardVO vo);
	//�Խñ� ��ȸ ����
	public void increaseViewcnt(int seq);

	//�Խñ� ��ü ���
	public List<BoardVO> listAll(int start, int end,String searchOption, String keyword);

	//�Խñ� ���ڵ� ���� �޼��� �߰�
	public int countArticle(String searchOption, String keyword);
}

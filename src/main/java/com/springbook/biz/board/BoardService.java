package com.springbook.biz.board;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface BoardService {
	// CRUD ����� �޼ҵ� ����
	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(int seq);

	// �� �� ��ȸ
	BoardVO getBoard(int seq);

	// �� ��� ��ȸ
	List<BoardVO> getBoardList();
	
	//�Խñ� ��ü ��� , �˻��ɼ�, Ű���� �Ű� ���� �߰�
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword);
	
	//�� ��ȸ
	public void increaseViewcnt(int seq, HttpSession session) throws Exception;

	//�Խñ� ���ڵ� ���� �޼��� �߰�
	int countArticle(String searchOption, String keyword);

	
}

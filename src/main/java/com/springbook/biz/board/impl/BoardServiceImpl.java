package com.springbook.biz.board.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	public void insertBoard(BoardVO vo) {
		// boardDAO.insertBoard(vo);
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();

		// *�±� ���� ó��
		// replace(A,B) A�� B�� ������
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer=writer.replace("<", "&lt;"); 
		writer=writer.replace("<", "&gt;");
	
		// *���鹮�� ó��
		title = title.replace(" ", "&nbsp;&nbsp;");
		writer = writer.replace(" ", "&nbsp;&nbsp;");
		// *�ٹٲ� ���� ó��
		content = content.replace("\n", "<br>");

		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		boardDAO.insertBoard(vo);

	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(int seq) {
		boardDAO.deleteBoard(seq);
	}

	public BoardVO getBoard(int seq) {
		return boardDAO.getBoard(seq);
	}

//	public List<BoardVO> getBoardList(BoardVO vo) {
//		return boardDAO.getBoardList(vo);
//	}

	// �Խñ� ��ü ���
	@Override
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) {
		return boardDAO.listAll(start, end, searchOption, keyword);
	}

	// �Խñ� ���ڵ� ����
	@Override
	public int countArticle(String searchOption, String keyword) {
		return boardDAO.countArticle(searchOption, keyword);
	}

	// �Խñ� ��ȸ�� ����
	public void increaseViewcnt(int seq, HttpSession session) throws Exception {
		long update_time = 0;
		// ���ǿ� ����� ��ȸ �ð� �˻�
		// ���ʷ� ��ȸ�� ��� ���ǿ� ����� ���� ���� ������ if���� ������� ����
		if (session.getAttribute("update_time_" + seq) != null) {
			
			update_time = ((Number) session.getAttribute("update_time_"+seq)).longValue();
		}
		// �ý����� ����ð��� current_time�� ����
		long current_time = System.currentTimeMillis();
		// ���� �ð��� ��� �� ��ȸ�� ���� ó��
		// �ý��� ���� �ð� - �����ð� > �����ð�(��ȸ�� ������ �����ϵ��� ������ �ð�)
		if (current_time - update_time > 5 * 1000) {
			boardDAO.increaseViewcnt(seq);
			// ���ǿ� �ð��� ����: "update_time_"+SEQ�� �ٸ� ������ �ߺ����� �ʰ� ����� ��
			session.setAttribute("update_time_" + seq, current_time);
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}




}
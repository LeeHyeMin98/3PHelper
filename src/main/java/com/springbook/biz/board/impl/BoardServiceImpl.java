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

		// *태그 문자 처리
		// replace(A,B) A를 B로 변경함
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer=writer.replace("<", "&lt;"); 
		writer=writer.replace("<", "&gt;");
	
		// *공백문자 처리
		title = title.replace(" ", "&nbsp;&nbsp;");
		writer = writer.replace(" ", "&nbsp;&nbsp;");
		// *줄바꿈 문자 처리
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

	// 게시글 전체 목록
	@Override
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) {
		return boardDAO.listAll(start, end, searchOption, keyword);
	}

	// 게시글 레코드 갯수
	@Override
	public int countArticle(String searchOption, String keyword) {
		return boardDAO.countArticle(searchOption, keyword);
	}

	// 게시글 조회수 증가
	public void increaseViewcnt(int seq, HttpSession session) throws Exception {
		long update_time = 0;
		// 세션에 저장된 조회 시간 검색
		// 최초로 조회할 경우 세션에 저장된 값이 없기 땜누에 if문은 실행되지 않음
		if (session.getAttribute("update_time_" + seq) != null) {
			
			update_time = ((Number) session.getAttribute("update_time_"+seq)).longValue();
		}
		// 시스템의 현재시간을 current_time에 저장
		long current_time = System.currentTimeMillis();
		// 일정 시간이 경과 후 조회수 증가 처리
		// 시스템 현재 시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
		if (current_time - update_time > 5 * 1000) {
			boardDAO.increaseViewcnt(seq);
			// 세션에 시간을 저장: "update_time_"+SEQ는 다른 변수와 중복되지 않게 명명한 것
			session.setAttribute("update_time_" + seq, current_time);
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}




}
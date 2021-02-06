package com.springbook.biz.board;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface BoardService {
	// CRUD 기능의 메소드 구현
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(int seq);

	// 글 상세 조회
	BoardVO getBoard(int seq);

	// 글 목록 조회
	List<BoardVO> getBoardList();
	
	//게시글 전체 목록 , 검색옵션, 키워드 매개 변수 추가
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword);
	
	//글 조회
	public void increaseViewcnt(int seq, HttpSession session) throws Exception;

	//게시글 레코드 갯수 메서드 추가
	int countArticle(String searchOption, String keyword);

	
}

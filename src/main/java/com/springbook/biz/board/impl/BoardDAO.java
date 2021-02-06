package com.springbook.biz.board.impl;

import java.util.List;

import com.springbook.biz.board.BoardVO;

public interface BoardDAO {
	
	//게시글 작성
	public void insertBoard(BoardVO vo);
	//게시글 수정
	public void updateBoard(BoardVO vo);
	//게시글 삭제
	public void deleteBoard(int seq);
	//게시글 상세보기
	public BoardVO getBoard(int seq);
	//게시글 전체 목록
	public List<BoardVO> getBoardList(BoardVO vo);
	//게시글 조회 증가
	public void increaseViewcnt(int seq);

	//게시글 전체 목록
	public List<BoardVO> listAll(int start, int end,String searchOption, String keyword);

	//게시글 레코드 갯수 메서드 추가
	public int countArticle(String searchOption, String keyword);
}

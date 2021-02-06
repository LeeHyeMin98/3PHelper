package com.springbook.biz.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession SqlSession;
	
	//게시글 작성
	@Override
	public void insertBoard(BoardVO vo) {
		SqlSession.insert("board.insertBoard",vo);
	}
	
	//게시글 상세보기
	@Override
	public BoardVO getBoard(int seq) {
		return SqlSession.selectOne("board.view",seq);
	}

	//게시글 수정
	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		SqlSession.update("board.updateBoard",vo);
		
	}

	//게시글 삭제
	@Override
	public void deleteBoard(int seq) {
		// TODO Auto-generated method stub
		SqlSession.delete("board.deleteBoard",seq);
		
	}

	//게시글 전체 목록 
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return SqlSession.selectList("board.listAll");
	}

	//게시글 조회수 증가
	@Override
	public void increaseViewcnt(int seq) {
		// TODO Auto-generated method stub
		SqlSession.update("board.increaseViewcnt",seq);
	}
	
	//게시그 전체 목록
	@Override
	public List<BoardVO> listAll(int start, int end,String searchOption, String keyword){
		//검색 옵션, 키워드 맵에 저장
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		map.put("start",start);
		map.put("end",end);
		
		return SqlSession.selectList("board.listAll", map);
	}
	
	//게시글 레코드 갯수
	@Override
	public int countArticle(String searchOption, String keyword) {
		//검색옵션, 키워드 맵에 저장
		Map<String, String> map = new HashMap<String,String>();
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		return SqlSession.selectOne("board.countArticle", map);
	}
}

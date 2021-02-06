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
	
	//�Խñ� �ۼ�
	@Override
	public void insertBoard(BoardVO vo) {
		SqlSession.insert("board.insertBoard",vo);
	}
	
	//�Խñ� �󼼺���
	@Override
	public BoardVO getBoard(int seq) {
		return SqlSession.selectOne("board.view",seq);
	}

	//�Խñ� ����
	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		SqlSession.update("board.updateBoard",vo);
		
	}

	//�Խñ� ����
	@Override
	public void deleteBoard(int seq) {
		// TODO Auto-generated method stub
		SqlSession.delete("board.deleteBoard",seq);
		
	}

	//�Խñ� ��ü ��� 
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return SqlSession.selectList("board.listAll");
	}

	//�Խñ� ��ȸ�� ����
	@Override
	public void increaseViewcnt(int seq) {
		// TODO Auto-generated method stub
		SqlSession.update("board.increaseViewcnt",seq);
	}
	
	//�Խñ� ��ü ���
	@Override
	public List<BoardVO> listAll(int start, int end,String searchOption, String keyword){
		//�˻� �ɼ�, Ű���� �ʿ� ����
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		map.put("start",start);
		map.put("end",end);
		
		return SqlSession.selectList("board.listAll", map);
	}
	
	//�Խñ� ���ڵ� ����
	@Override
	public int countArticle(String searchOption, String keyword) {
		//�˻��ɼ�, Ű���� �ʿ� ����
		Map<String, String> map = new HashMap<String,String>();
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		return SqlSession.selectOne("board.countArticle", map);
	}
}

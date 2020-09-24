package com.bjts.board.dao.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bjts.board.domain.board.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	private static final String namespace="com.bjts.board.dao.board.BoardDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public BoardVO getBoardInfo(int boardNum) {
		return sqlSession.selectOne(namespace + ".getBoardInfo", boardNum);
	}
	
	@Override
	public List<BoardVO> getBoardInfoAll(HashMap<String, String> map) {
		String field = map.get("field");
		if(!field.equals("titleNick")) {
			System.out.println("here");
			return sqlSession.selectList(namespace + ".getBoardInfoAll", map);
		}
		else {
			map.put("userNickname", "userNickname");
			map.put("boardTitle", "boardTitle");
			return sqlSession.selectList(namespace + ".getBoardInfoTitleNick", map);
		}
	}

	@Override
	public int getBoardCount(String field, String query) {
		HashMap<String , String> map = new HashMap<String , String>();
		if(!field.equals("titleNick")) {
			map.put("field", field);
			map.put("query", query);
			return sqlSession.selectOne(namespace + ".getBoardCount", map);
		}
		else {
			map.put("query", query);
			map.put("userNickname", "userNickname");
			map.put("boardTitle", "boardTitle");
			return sqlSession.selectOne(namespace + ".getBoardCountTitleNick", map);
		}
	}
	
	@Override
	@Transactional
	public BoardVO getBoardView(int boardNum) {
		sqlSession.update(namespace + ".updateView",boardNum);
		return sqlSession.selectOne(namespace + ".getBoardView", boardNum);
	}

	@Override
	public void insertBoardInfo(BoardVO boardVo) {
		sqlSession.insert(namespace + ".insertBoardInfo", boardVo);
	}

	@Override
	public void updateBoardInfo(BoardVO boardVo) {
		sqlSession.update(namespace + ".updateBoardInfo", boardVo);
	}
	
	@Override
	public void deleteBoardInfo(int boardNum) {
		sqlSession.delete(namespace + ".deleteBoardInfo", boardNum);
  }

}

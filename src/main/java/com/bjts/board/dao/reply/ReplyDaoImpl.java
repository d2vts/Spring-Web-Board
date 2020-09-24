package com.bjts.board.dao.reply;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjts.board.domain.reply.ReplyVO;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	private static final String namespace="com.bjts.board.dao.reply.ReplyDao";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> getReplyView(int boardNum) {
		return sqlSession.selectList(namespace + ".getReplyView", boardNum);
	}
  
  @Override
	public void insertReplyInfo(ReplyVO replyVO) {
		sqlSession.insert(namespace + ".insertReplyInfo", replyVO);
	}

  @Override
  	public void updateReplyInfo(ReplyVO replyVO) {
		sqlSession.update(namespace + ".updateReplyInfo",replyVO);
}
  
@Override
	public void deleteReplyInfo(int boardNum) {
		sqlSession.selectList(namespace + ".deleteReplyInfo", boardNum);
  }
}

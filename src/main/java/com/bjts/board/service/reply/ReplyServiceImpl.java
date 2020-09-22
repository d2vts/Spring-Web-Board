package com.bjts.board.service.reply;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.reply.ReplyDao;
import com.bjts.board.domain.reply.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao replyDao;
	

	@Override
	public List<ReplyVO> getReplyView(int boardNum) {
		return replyDao.getReplyView(boardNum);
	}

	@Override
	public void deleteReply(int boardNum) {
		replyDao.deleteReply(boardNum);
	}
	
	@Override
	public void insertReply(ReplyVO replyVO) {
		replyDao.insertReply(replyVO);
	}

	@Override
	public void updateReply(ReplyVO replyVO) {
		replyDao.updateReply(replyVO);
		
	}

}

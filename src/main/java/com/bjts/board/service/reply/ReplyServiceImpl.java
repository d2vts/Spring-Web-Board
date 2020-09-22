package com.bjts.board.service.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjts.board.dao.reply.ReplyDao;
import com.bjts.board.domain.reply.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao replyDao;
	
	
	@Override
	public void insertReply(ReplyVO replyVO) {
		
		replyDao.insertReply(replyVO);
		
	}
	

	

}

package com.bjts.board.service.reply;

import java.util.List;

import com.bjts.board.domain.reply.ReplyVO;

public interface ReplyService {

	List<ReplyVO> getReplyView(int boardNum);

	void deleteReply(int boardNum);

	void insertReply(ReplyVO replyVO);

}

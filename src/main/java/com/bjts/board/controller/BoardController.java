package com.bjts.board.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bjts.board.domain.board.BoardVO;
import com.bjts.board.domain.reply.ReplyVO;
import com.bjts.board.service.board.BoardService;
import com.bjts.board.service.reply.ReplyService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	
	@RequestMapping("list")
	public String list(Model model) {
		logger.info("list()-GET");
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		boardlist = boardService.getBoardInfoAll();
		model.addAttribute("boardInfo", boardlist);
		
		System.out.println("보드컨트롤러에서 리스트에 값이 넘어오는지 테스트중 : " + boardlist);
				
		return "board/list_board";
	}
	
	@RequestMapping("list/modify_board")
	public String modify_board(BoardVO boardVo, @RequestParam("boardNum") int boardNum, Model model) {
		logger.info("modify_board()-GET");

		boardVo = boardService.getBoardInfo(boardNum);
		System.out.println(boardVo);
		model.addAttribute("board", boardVo);

		return "board/modify_board";
	}
	
	@RequestMapping(value="list/modify_board", method = RequestMethod.POST)
	public String modify_board(BoardVO boardVo, Model model, HttpServletRequest request) {
		logger.info("modify_board()-GET");
		boardVo.setIdNum(Integer.parseInt(request.getParameter("boardNum")));
		boardVo.setBoardTitle(request.getParameter("boardTitle"));
		boardVo.setBoardContent(request.getParameter("boardContent"));
		boardService.updateBoard(boardVo);
		return "redirect:/list";
	}
	
	@RequestMapping("list/write_board")
	public String write_board(Model model) {
		logger.info("write_board()-GET");
		
		return "board/write_board";
	}
	
	@RequestMapping("list/view")
	public String view(@RequestParam("boardNum") int boardNum, Model model) {
		logger.info("view()-GET");
		BoardVO boardVO = boardService.getBoardView(boardNum);
		model.addAttribute("board",boardVO);
	
		return "board/view_board";
		
	}
	
	
	@RequestMapping(value="list/view/write_reply", method = RequestMethod.POST)
    public String write_reply(HttpServletRequest request, Model model, HttpSession session) {
        logger.info("view()-POST");
        Map<String, String> reply_info = new HashMap<String, String>();
        
        String boardNum = request.getParameter("boardNum");
        String re_content = request.getParameter("re_content");
        String re_userNickname = (String)session.getAttribute("userNickname");
        String re_userId = (String)session.getAttribute("userId");
        
        ReplyVO replyVO = new ReplyVO(Integer.parseInt(boardNum), re_userId, re_userNickname, re_content);
        
        replyService.insertReply(replyVO);
        return "redirect:/list/view?boardNum="+boardNum; // 매핑오류나면 볼것

    }
	
	
	@RequestMapping("list/delete_board")
	public String delete_board(@RequestParam("boardNum") int boardNum, Model model) {
		
		System.out.println("boardNum"+boardNum);
		logger.info("delete_board()-GET");
		
		boardService.deleteBoard(boardNum);
		
		return "redirect:/list";
	}
	

	@RequestMapping(value="list/write_board", method = RequestMethod.POST)
	public String write_board(BoardVO boardVo, HttpServletRequest request, Model model, HttpSession session) {
		logger.info("write_board()-POST");
		boardVo.setUserId((String)session.getAttribute("userId"));
		boardVo.setUserNickname((String)session.getAttribute("userNickname"));
		boardVo.setBoardTitle(request.getParameter("boardTitle"));
		boardVo.setBoardContent(request.getParameter("boardContent"));
		boardVo.setBoardView(1); 
		boardService.insertBoard(boardVo);
		return "redirect:/list";
	}
	
	
	
}

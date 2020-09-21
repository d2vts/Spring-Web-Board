package com.bjts.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bjts.board.domain.board.BoardVO;
import com.bjts.board.service.board.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private BoardService boardService;
	
	
	
	
	@RequestMapping("list")
	public String list(Model model) {
		logger.info("list()-GET");
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		boardlist = boardService.getBoardInfo();
		model.addAttribute("boardInfo", boardlist);
		
		System.out.println("보드컨트롤러에서 리스트에 값이 넘어오는지 테스트중 : " + boardlist);
				
		return "board/list_board";
	}
	
	@RequestMapping("list/modify_board")
	public String modify_board(Model model) {
		logger.info("modify_board()-GET");
		
		
		return "board/modify_board";
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
	
	@RequestMapping("list/delete_board")
	public String delete_board(@RequestParam("boardNum") int boardNum, Model model) {
		
		System.out.println("boardNum"+boardNum);
		logger.info("delete_board()-GET");
		
		boardService.deleteBoard(boardNum);
		
		return "redirect:/list";
	}
	
	
	
}

package com.bjts.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("list")
	public String list(Model model) {
		logger.info("list()-GET");
		
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
	
}

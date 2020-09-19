package com.bjts.board.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {

	@RequestMapping
	public String show(Model model) {
		return "list";
	}
	
	@RequestMapping
	public String test(Model model){
		return "test";
	}
}

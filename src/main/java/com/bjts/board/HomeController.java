package com.bjts.board;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home(Locale locale, HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
		logger.info("userId = " + userId);
		model.addAttribute("userId", userId);
		return "home";
	}
}

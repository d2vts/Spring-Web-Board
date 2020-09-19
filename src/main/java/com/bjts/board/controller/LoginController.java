package com.bjts.board.controller;

<<<<<<< HEAD
=======


>>>>>>> bf025d95abf79feb7af7077f76ef10cdaf76c553
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjts.board.service.login.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
	
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
	
		return "login";
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, HttpSession session) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if (id.equals("") || password.equals("")) {
			session.setAttribute("error", "로그인 실패 했습니다.");
		}
		else {
			if(id.equals(loginService.valueCheckId(id))) {
				if(loginService.valueCheckPassword(id, password)) {
					model.addAttribute("success", "성공");
					return "login_test";
				}
				else {
					model.addAttribute("success", "실패");
					return "login_test";
				}
			}
		}
		return "login_test";
	}

}

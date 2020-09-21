package com.bjts.board.service.member;

import org.springframework.ui.Model;

import com.bjts.board.domain.member.MemberVO;

public interface MemberService {
	
	// 회원가입 아이디 중복 체크
//	String checkIdRegisterd(String userId);
	// 회원가입 아이디 형식 체크
//	String checkIdForm(String userId);
	// 회원가입 비밀번호 형식 체크
//	String checkPassword(String userPassword);
	/*
	 * 한글 이름 2~4자 이내 var reg = /^[가-힣]{2,4}$/;
	 * 영문 이름 2~10자 이내 : 띄어쓰기(\s)가 들어가며 First, Last Name 형식 var reg =
	 * /^[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
	 */
	// 회원가입 이름 형식 체크
//	String checkNameForm(String userName);
	// 회원가입 닉네임 중복 체크
//	String checkNicknameRegistered(String userNickname);
	// 회원가입 이메일 형식 체크
//	String checkEmailForm(String userEmail);
	// Address와 Gender는 형식과 중복체크 X
	void join(Model model);
	
	MemberVO getMemberInfo(String id);

	void update(MemberVO memberVo);
	
}

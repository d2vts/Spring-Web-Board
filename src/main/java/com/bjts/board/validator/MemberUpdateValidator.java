package com.bjts.board.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bjts.board.domain.member.MemberVO;

public class MemberUpdateValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVo = (MemberVO)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNickname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "required");
		if(memberVo.getUserNickname().length() < 2 || memberVo.getUserNickname().length() > 8) {
			errors.rejectValue("userNickname", "userNicknameLength");
		}
	}
}

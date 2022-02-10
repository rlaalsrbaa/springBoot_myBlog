package com.kmg.exam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmg.exam.demo.service.MemberService;
import com.kmg.exam.demo.vo.Member;

@Controller
public class UsrMemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/usr/member/join")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {

		if (loginId == null) {
			return "loginId(을)를 입력해주세요.";
		}

		if (loginPw == null) {
			return "loginPw(을)를 입력해주세요.";
		}

		if (name == null) {
			return "name(을)를 입력해주세요.";
		}

		if (nickname == null) {
			return "nickname(을)를 입력해주세요.";
		}

		if (cellphoneNo == null) {
			return "cellphoneNo(을)를 입력해주세요.";
		}

		if (email == null) {
			return "email(을)를 입력해주세요.";
		}

		int id = memberService.doJoin(loginId, loginPw, name, nickname, cellphoneNo, email);

		if (id == -1) {
			return "사용중인 로그인 아이디입니다.";
		}
		
		Member member = memberService.getMemberById(id);

		return member;
	}

}

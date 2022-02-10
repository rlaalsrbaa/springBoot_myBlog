package com.kmg.exam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmg.exam.demo.service.MemberService;

@Controller
public class UsrMemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/usr/member/join")
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String name,
			String nickname, String cellphoneNo, String email) {
		memberService.doJoin(loginId, loginPw, name,
				nickname, cellphoneNo, email);
		return "안녕하세요.";
	}

}

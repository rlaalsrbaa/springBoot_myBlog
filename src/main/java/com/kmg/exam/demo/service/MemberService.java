package com.kmg.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmg.exam.demo.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memeberRepository;
	
	
	public void doJoin(String loginId, String loginPw, String name,
			String nickname, String cellphoneNo, String email) {
		memeberRepository.createMember(loginId, loginPw, name, nickname,
				cellphoneNo, email); 
	}

}
package com.kmg.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmg.exam.demo.repository.MemberRepository;
import com.kmg.exam.demo.vo.Member;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	public int doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {

		Member oldMember = getMemberByLoginId(loginId);
		if (oldMember != null) {
			return -1;
		}
		
		oldMember = getMemberByNameAndEmail(name, email);

		if (oldMember != null) {
			return -2;
		}

		memberRepository.createMember(loginId, loginPw, name, nickname, cellphoneNo, email);
		return memberRepository.getLastInsertId();
	}

	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

}
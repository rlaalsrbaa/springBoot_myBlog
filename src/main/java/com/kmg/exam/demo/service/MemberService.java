package com.kmg.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmg.exam.demo.repository.MemberRepository;
import com.kmg.exam.demo.vo.Member;
import com.kmg.exam.demo.vo.ResultData;
import com.kmg.exam.demo.util.Ut;

@Service
public class MemberService {

	private MemberRepository memberRepository;
	private AttrService attrService;

	public MemberService(AttrService attrService, MemberRepository memberRepository) {
		this.attrService = attrService;
		this.memberRepository = memberRepository;
	}

	public ResultData<Integer> join(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		Member oldMember = getMemberByLoginId(loginId);
		if (oldMember != null) {
			return ResultData.from("F-7", Ut.f("해당 로그인아이디(%s)는 이미 사용중입니다.", loginId));
		}
		
		oldMember = getMemberByNameAndEmail(nickname, email);

		if (oldMember != null) {
			return ResultData.from("F-8", Ut.f("해당 이름(%s)과 이메일(%s)은 이미 사용중입니다.", name, email));
		}

		memberRepository.createMember(loginId, loginPw, name, nickname, cellphoneNo, email);
		int id = memberRepository.getLastInsertId();

		return ResultData.from("S-1", "회원가입이 완료되었습니다.", "id", id);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	public ResultData modify(int id, String loginPw, String name, String nickname, String email, String cellphoneNo) {

		memberRepository.modify(id, loginPw, name, nickname, email, cellphoneNo);

		return ResultData.from("S-1", "회원정보가 수정되었습니다.");
	}
	
	public String genMemberModifyAuthKey(int actorId) {
		String memberModifyAuthKey = Ut.getTempPassword(10);

		attrService.setValue("member", actorId, "extra", "memberModifyAuthKey", memberModifyAuthKey, Ut.getDateStrLater(60 * 5));

		return memberModifyAuthKey;
	}
	
	public ResultData checkMemberModifyAuthKey(int actorId, String memberModifyAuthKey) {
		String saved = attrService.getValue("member", actorId, "extra", "memberModifyAuthKey");

		if ( !saved.equals(memberModifyAuthKey) ) {
			return ResultData.from("F-1", "일치하지 않거나 만료되었습니다.");
		}

		return ResultData.from("S-1", "정상적인 코드입니다.");
	}
}
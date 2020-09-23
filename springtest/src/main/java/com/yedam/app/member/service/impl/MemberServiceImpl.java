package com.yedam.app.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberVo;
import com.yedam.app.member.mapper.MemberDAO;
import com.yedam.app.member.service.MemberService;

@Service //컨테이너에 빈등록
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDAO memberDAO;

	@Override
	public MemberVo selectOne(MemberVo memberVo) {
		if (memberVo.getMailyn() != null) {
			memberVo.setMailyn("Y");
		} else {
			memberVo.setMailyn("N");
		}

		String strHobby = "";
		
		
		memberVo.setHobby(strHobby);
		return memberDAO.selectOne(memberVo);
	}

	@Override
	public int delete(MemberVo memberVo) {
		return memberDAO.delete(memberVo);
	}

	@Override
	public int update(MemberVo memberVo) {
		return memberDAO.update(memberVo);
	}

	@Override
	public int insert(MemberVo memberVo) {
		return memberDAO.insert(memberVo);
	}

	@Override
	public ArrayList<MemberVo> selectAll() {
		return memberDAO.selectAll();
	}



}

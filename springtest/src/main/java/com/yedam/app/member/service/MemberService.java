package com.yedam.app.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.app.member.MemberVo;

public interface MemberService {

	MemberVo selectOne(MemberVo memberVo);

	int delete(MemberVo memberVo);

	int update(MemberVo memberVo);

	int insert(MemberVo memberVo);

	List<MemberVo> selectAll();
	
	List<Map<String,Object>> selectAllMap();

}
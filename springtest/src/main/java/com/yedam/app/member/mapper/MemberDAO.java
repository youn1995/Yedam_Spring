package com.yedam.app.member.mapper;

import java.util.List;

import com.yedam.app.member.MemberVo;

public interface MemberDAO {

	MemberVo selectOne(MemberVo memberVo);

	int delete(MemberVo memberVo);

	int update(MemberVo memberVo);

	int insert(MemberVo memberVo);

	List<MemberVo> selectAll();
}
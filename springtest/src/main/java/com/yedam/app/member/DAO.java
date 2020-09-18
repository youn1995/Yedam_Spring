package com.yedam.app.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DAO {

	MemberVo selectOne(MemberVo memberVo);

	int delete(MemberVo memberVo);

	int update(MemberVo memberVo);

	int insert(MemberVo memberVo);

	ArrayList<MemberVo> selectAll();

	// 메일 수신회원수
	int getMailYnCnt();

	// 성별 인원 수
	List<HashMap<String, Object>> getGenderCnt();

}
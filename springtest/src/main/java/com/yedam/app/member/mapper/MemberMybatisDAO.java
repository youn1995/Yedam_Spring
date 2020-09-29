package com.yedam.app.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.member.MemberVo;

//@Repository
public class MemberMybatisDAO implements MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 전체조회
	@Override
	public List<MemberVo> selectAll() {
		System.out.println("mybatis selectAll run");
		return sqlSession.selectList("memberDAO.selectAll");
	}

	@Override
	public MemberVo selectOne(MemberVo memberVo) {
		return sqlSession.selectOne("memberDAO.selectOne", memberVo);
	}

	@Override
	public int delete(MemberVo memberVo) {
		return 0;	
	}

	@Override
	public int update(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(MemberVo memberVo) {
		return 0;
	}

//	@Override
//	public int getMailYnCnt() {
//		return 0;
//	}
//
//	@Override
//	public List<HashMap<String, Object>> getGenderCnt() {
//		return null;
//	}



}

package com.yedam.app.member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yedam.app.member.MemberVo;

//@Component
public class MemberSpringDAO implements MemberDAO {

	@Autowired JdbcTemplate template;
	final static String INSERT_MEMBER = "insert into member (id, pw, job, gender, mailyn, reason, hobby, regdate) "
						+ "values (?,?,?,?,?,?,?,sysdate)";
	
	final static String DELETE_MEMBER = "DELETE MEMBER WHERE ID = ?";
	final static String SELECT_MEMBER_ONE = "SELECT ID, PW, JOB, GENDER, MAILYN, REASON, HOBBY, REGDATE FROM MEMBER WHERE ID = ?";
	final static String SELECT_MEMBER_ALL = "SELECT ID, PW, JOB, GENDER, MAILYN, REASON, hobby, regdate" + " FROM MEMBER ORDER BY ID";
	
	@Override
	public int insert(MemberVo memberVo) {
		Object[] args = {memberVo.getId(), memberVo.getPw(), memberVo.getJob(), memberVo.getGender(),
						memberVo.getMailyn(), memberVo.getReason(), memberVo.getHobby()};
		return template.update(INSERT_MEMBER, args);
		
	}
	@Override
	public int delete(MemberVo memberVo) {
		return template.update(DELETE_MEMBER, memberVo.getId());
	}
	@Override
	public MemberVo selectOne(MemberVo memberVo) {
		return template.queryForObject(SELECT_MEMBER_ONE, new Object[]{memberVo.getId()}, new MemberRowMapper());
			//단일값이라도 배열을 넣어줘야함
	}


	@Override
	public int update(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ArrayList<MemberVo> selectAll() {
		return (ArrayList<MemberVo>) template.query(SELECT_MEMBER_ALL, new MemberRowMapper());
	}

	
	class MemberRowMapper implements  RowMapper<MemberVo>{
		@Override
		public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVo resultVo = new MemberVo();
			resultVo.setId(rs.getString(1));
			resultVo.setPw(rs.getString(2));
			resultVo.setJob(rs.getString(3));
			resultVo.setGender(rs.getString(4));
			resultVo.setMailyn(rs.getString(5));
			resultVo.setReason(rs.getString(6));
			resultVo.setHobby(rs.getString(7));
			resultVo.setRegdate(rs.getString(8));
			return resultVo;
		}
	}


}

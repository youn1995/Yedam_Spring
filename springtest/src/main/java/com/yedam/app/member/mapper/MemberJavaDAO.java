package com.yedam.app.member.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yedam.app.common.ConnectionManager;
import com.yedam.app.member.MemberVo;

//@Component //스프링컨테이너가 관리하도록 빈등록//singletone으로 관리
public class MemberJavaDAO implements MemberDAO {
	Connection conn;
	PreparedStatement pstmt;

// 스프링에서는 이거 없어도 됨 스프링컨테이너가 관리
//	// 싱글톤 //////////
//	static MemberDAO instance;
//	public static MemberDAO getInstance() {
//		if (instance == null) {
//			instance = new MemberDAO();
//		}
//		return instance;
//	}
//	/////////////////

	@Override
	public MemberVo selectOne(MemberVo memberVo) {
		ResultSet rs = null;
		MemberVo resultVo = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ID, PW, JOB, GENDER, MAILYN, REASON, HOBBY" + " FROM MEMBER" + " WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
//				resultVo = MemberVo.builder().build();
//				resultVo.setId(rs.getString(1));
//				resultVo.setPw(rs.getString(2));
//				resultVo.setJob(rs.getString(3));
//				resultVo.setGender(rs.getString(4));
//				resultVo.setMailyn(rs.getString(5));
//				resultVo.setReason(rs.getString(6));
//				resultVo.setHobby(rs.getString(7));
			} else {
				System.out.println("No data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo;
	}

	@Override
	public int delete(MemberVo memberVo) {
		int r = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getId());
			r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		return r;
	}

	@Override
	public int update(MemberVo memberVo) {
		int r = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE MEMBER SET PW = ?, JOb = ?, gender = ?, mailyn = ?, reason = ?, hobby = ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getPw());
			pstmt.setString(2, memberVo.getJob());
			pstmt.setString(3, memberVo.getGender());
			pstmt.setString(4, memberVo.getMailyn());
			pstmt.setString(5, memberVo.getReason());
			pstmt.setString(6, memberVo.getHobby());
			pstmt.setString(7, memberVo.getId());
			r = pstmt.executeUpdate();
			System.out.println(r + "건 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		return r;
	}

	@Override
	public int insert(MemberVo memberVo) {
		int r = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "insert into member (id, pw, job, gender, mailyn, reason, hobby, regdate) "
					+ "values (?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPw());
			pstmt.setString(3, memberVo.getJob());
			pstmt.setString(4, memberVo.getGender());
			pstmt.setString(5, memberVo.getMailyn());
			pstmt.setString(6, memberVo.getReason());
			pstmt.setString(7, memberVo.getHobby());
			r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return r;
	}

	@Override
	public ArrayList<MemberVo> selectAll() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ID, PW, JOB, GENDER, MAILYN, REASON, hobby, regdate" + " FROM MEMBER ORDER BY ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//MemberVo resultVo = MemberVo.builder().build();
//				resultVo.setId(rs.getString(1));
//				resultVo.setPw(rs.getString(2));
//				resultVo.setJob(rs.getString(3));
//				resultVo.setGender(rs.getString(4));
//				resultVo.setMailyn(rs.getString(5));
//				resultVo.setReason(rs.getString(6));
//				resultVo.setHobby(rs.getString(7));
//				resultVo.setRegdate(rs.getString(8));
//				list.add(resultVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}

	// 메일 수신회원수
//	@Override
//	public int getMailYnCnt() {
//		int cnt = 0;
//		ResultSet rs = null;
//		try {
//			conn = ConnectionManager.getConnnect();
//			String sql = "SELECT COUNT(ID) CNT FROM MEMBER WHERE UPPER(MAILYN) = 'Y'";
//			Statement stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			rs.next();
//			cnt = rs.getInt(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionManager.close(rs, pstmt, conn);
//		}
//		return cnt;
//	}
//
//	// 성별 인원 수
//	@Override
//	public List<HashMap<String, Object>> getGenderCnt() {
//		ResultSet rs = null;
//		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//		try {
//			conn = ConnectionManager.getConnnect();
//			String sql = "SELECT GENDER, COUNT(ID) CNT FROM MEMBER GROUP BY GENDER";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				HashMap<String, Object> map = new HashMap<String, Object>();
//				map.put("gender", rs.getString("gender"));
//				map.put("cnt", rs.getString("cnt"));
//				list.add(map);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionManager.close(rs, pstmt, conn);
//		}
//		return list;
//	}
}

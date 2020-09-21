package com.yedam.app.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberVo {
	private String id;
	private String pw;
	private String job;
	private String gender;
	private String mailyn;
	private String reason;
	private String hobby;
	private String regdate;
	

	
}

package com.yedam.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired // <= getBean("memberDAO") <= new MemberDAO()
	DAO dao;
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		//회원조회
		model.addAttribute("list", dao.selectAll());
		
		//model.addAttribute("name", "홍길동");
		return "member/memberAll";
	}
	
	//동록처리
	@RequestMapping("/memberInsert")
	public String memberInsert(MemberVo vo) {
		System.out.println(vo);
		//return "redirect:/memberList"; // 리다이렉트
		return "/member/memberList"; //default는 포워드
	}
}

package com.yedam.app.member.web;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.member.MemberVo;
import com.yedam.app.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired // <= getBean("memberDAO") <= new MemberDAO()
	MemberService memberService;
	
	@RequestMapping("/memberList")
	public String memberList(Model model, HttpServletRequest request, HttpSession session) {
		//회원조회
		model.addAttribute("list", memberService.selectAll());
		
		//model.addAttribute("name", "홍길동");
		return "/member/memberAll";
	}
	
	//등록페이지
	@RequestMapping(value ="/memberInsert", method=RequestMethod.GET)
	public String memberInsertForm() {
		return "member/memberInsert";
	}
	
	//동록처리
	@RequestMapping(value ="/memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberVo vo) {
		memberService.insert(vo);
		//System.out.println(vo);
		return "redirect:/memberList"; // 리다이렉트
		//return "/member/memberList"; //default는 포워드
	}
	
	@RequestMapping("/memberSelect")
	public String memberOne(@RequestParam(name = "id", required = false, defaultValue = "user1") String id, Model model, HttpServletRequest request
							) {
		//String ids = request.getParameter("id"); 이거랑 @RequestParam이랑 동일함
		MemberVo mem = new MemberVo();
		mem.setId(id);
		model.addAttribute("member", memberService.selectOne(mem));
		return "/member/memberSelect";
		
	}
	//경로명에 변수가 포함 (pathVariable)
	//url / 경로에서 파라미터값가져오기
	@RequestMapping("/userSelectPath/{id}") //url에서 중괄로해서 {id}/{email}이런식으로 여러개 지정할수있음
	public String userselectPath(Model model, @PathVariable String id) {
		MemberVo mem = new MemberVo();
		mem.setId(id);
		model.addAttribute("member", memberService.selectOne(mem));
		return "/member/memberSelect";
	}
	
	@RequestMapping("/userSelectMap")
	public String userSelectMap(@RequestParam Map map) {
		System.out.println(map);
		
		return "";
	}
	
	@RequestMapping("/memberListAjax")
	@ResponseBody
	public ArrayList<MemberVo> memberListAjax(Model model, HttpServletRequest request, HttpSession session) {
		//회원조회
		return memberService.selectAll();
	}
	
	
}

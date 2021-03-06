package com.yedam.app.member.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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
		return "member/memberAll";
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
	@ResponseBody // json String 변환
	public List<MemberVo> memberListAjax(Model model, HttpServletRequest request, HttpSession session) {
		//회원조회
		return memberService.selectAll();
	}
	
	@RequestMapping("/memberOneAjax")
	@ResponseBody
	public MemberVo memberOneAjax(MemberVo memberVo) {
		return memberService.selectOne(memberVo);
	}
	
	//엑셀출력
	@RequestMapping("/memberExcelView.do")
	public ModelAndView excelView(MemberVo vo, HttpServletResponse response) throws IOException{
	List<Map<String,Object>> list = memberService.selectAllMap();
	HashMap<String, Object> map = new HashMap<String, Object>(); String[] header = {"ID","JOB","PW","GENDER","MAILYN","REASON","HOBBY","REGDATE"};
	map.put("headers", header);
	map.put("filename", "excel_member");
	map.put("datas", list);
	return new ModelAndView("commonExcelView", map);
	}
	// 등록처리
	@RequestMapping("fileupload")
	@ResponseBody
	public HashMap<String, Object> fileupload(HttpServletRequest request) throws IllegalStateException, IOException {
		String folder = request.getSession().getServletContext().getRealPath("/images");
		System.out.println("folder -------> " + folder);
		String path = "./images";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		MultipartFile multipartFile = multipartRequest.getFile("upload");
		String fileName = multipartFile.getOriginalFilename();
		multipartFile.transferTo(new File(folder,fileName ));
		
		HashMap<String, Object> map = new HashMap<String, Object>(); 
		map.put("uploaded", true);
		map.put("url",  path + "/" + fileName);
		return map;
	}
	
}

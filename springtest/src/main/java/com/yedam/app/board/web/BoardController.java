package com.yedam.app.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.app.board.BoardVo;
import com.yedam.app.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping("/boardList")
	public String boardList(Model model, HttpServletRequest request, HttpSession session) {
		// 회원조회
		//model.addAttribute("list", boardService.selectAll(bVo));

		// model.addAttribute("name", "홍길동");
		return "/board/boardSelectAll";
	}
	@RequestMapping(value ="/boardInsert", method=RequestMethod.GET)
	public String memberboardInsertForm() {
		return "board/boardInsert";
	}
	@RequestMapping(value ="/boardInsert", method=RequestMethod.POST)
	public String boardInsert(BoardVo bVo) {
		boardService.insert(bVo);
		return "redirect:/boardList";
	}
}

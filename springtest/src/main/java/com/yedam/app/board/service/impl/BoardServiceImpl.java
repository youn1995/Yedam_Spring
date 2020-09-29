package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.BoardVo;
import com.yedam.app.board.mapper.BoardDAO;
import com.yedam.app.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardDAO boardDAO;

	
	@Override
	public List<BoardVo> selectAll(BoardVo bVo) {
		
		return boardDAO.selectAll(bVo);
	}



	@Override
	public void insert(BoardVo bVo) {
//		System.out.println(bVo);
		boardDAO.insert(bVo);
//		boardDAO.updateSeq();
	}



}

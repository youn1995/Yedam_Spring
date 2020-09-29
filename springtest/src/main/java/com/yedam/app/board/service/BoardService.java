package com.yedam.app.board.service;

import java.util.List;

import com.yedam.app.board.BoardVo;



public interface BoardService {
	public List<BoardVo> selectAll(BoardVo bVo);
	
	public void insert(BoardVo bVo);
	
	
}

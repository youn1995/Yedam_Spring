package com.yedam.app.board.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.board.BoardVo;



public interface BoardDAO {
	public List<BoardVo> selectAll(BoardVo bVo);
	public void updateSeq();
	public void insert(BoardVo bVo);
	public int selectSeq();
	public void delete(BoardVo bVo);
	public List<Map<String,Object>> selectMap();
	public int selectCnt();
}

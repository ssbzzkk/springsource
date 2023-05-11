package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BoardDTO;

public interface BoardMapper {
	public int insert(BoardDTO dto);
	public int update(int bno);
	public int delete(BoardDTO dto);
	public BoardDTO getRow(int bno);
	public List<BoardDTO> getRows();
}

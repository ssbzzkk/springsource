package com.spring.service;

import java.util.List;

import com.spring.domain.BoardDTO;

public interface BoardService {
	boolean insert(BoardDTO dto);
	boolean delete(BoardDTO dto);
	boolean update(int bno);
	BoardDTO getRow(int bno);
	List<BoardDTO> getRows();
}

package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardDTO;
import com.spring.mapper.BoardMapper;

@Service("board")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public boolean insert(BoardDTO dto) {
		return mapper.insert(dto) ==1?true:false;
	}

	@Override
	public boolean update(int bno) {
		return mapper.update(bno) ==1?true:false;
	}

	@Override
	public boolean delete(BoardDTO dto) {
		return mapper.delete(dto) ==1?true:false;
	}

	@Override
	public BoardDTO getRow(int bno) {
		return mapper.getRow(bno);
	}

	@Override
	public List<BoardDTO> getRows() {
		return mapper.getRows();
	}

}

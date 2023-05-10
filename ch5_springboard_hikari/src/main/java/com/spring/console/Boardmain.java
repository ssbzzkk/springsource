package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardDTO;
import com.spring.service.BoardService;

public class Boardmain {
public static void main(String[] args) {
		
		//컨테이너 띄우기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		//Service호출
		BoardService service = (BoardService)ctx.getBean("board");
		
		//게시글 작성
//		BoardDTO dto = new BoardDTO();
//		dto.setTitle("스프링");
//		dto.setContent("스프링 게시판");
//		dto.setWriter("홍길동");
//		boolean result=service.insertBoard(dto);
//		service.insertBoard(dto);
		
		//게시글 업데이트
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(1);
//		dto.setTitle("스프링개념");
//		dto.setContent("스프링 제어의 역전");
//		boolean result=service.updateBoard(dto);
//		System.out.println(result ? "수정성공":"수정실패");
		
		//게시글 삭제
//		boolean result = service.deleteBoard(5);
//		System.out.println(result ? "삭제성공":"삭제실패");

		//게시글 하나 조회
		System.out.println(service.getRow(1));
		
		
		//게시글  전체 조회
		List<BoardDTO> list = service.getRows();
		for(BoardDTO boardDTO:list) {
			System.out.println(boardDTO);
		}
		
		
		
		
	}
}

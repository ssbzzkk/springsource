package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.spring.domain.BookDTO;
import com.spring.persistence.BookDAO;
import com.spring.service.BookService;
import com.spring.service.BookServiceImpl;

public class BookMain {

	public static void main(String[] args) {
		
		//컨테이너 띄우기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		//Service호출
		BookService service = (BookService)ctx.getBean("bookService");

		//도서 추가
//		BookDTO insertDto = new BookDTO(1008,"모두의알고리즘","이승찬", 25000,"파이썬 구현");
//		if(service.insertBook(insertDto)){
//			System.out.println("입력성공");
//		}
		
		//도서 수정
//		BookDTO updateDto = new BookDTO();
//		updateDto.setCode(1008);
//		updateDto.setPrice(20000);
//		if(service.updateBook(updateDto)) {
//			System.out.println("수정성공");
//		}
		
		//특정 도서 조회
//		BookDTO row = service.getBook(3333);
//		System.out.println(row);		
		
		//도서 삭제
//		if(service.deletetBook(1001)) {
//			System.out.println("삭제성공");
//		}
				
		
		//전체 도서 목록 가져오기
//		BookService service = new BookServiceImpl(new BookDAO());
		List<BookDTO> list = service.getBookList();
		for(BookDTO bookDTO:list) {
			System.out.println(bookDTO);
		}
	}

}

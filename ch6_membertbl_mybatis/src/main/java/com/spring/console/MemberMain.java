package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

public class MemberMain {

	public static void main(String[] args) {
		// 컨테이너 띄우기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		// Service호출
		MemberService service = (MemberService) ctx.getBean("member");

		//멤버추가
//		MemberDTO insertDto = new MemberDTO("hong1234","1234", "홍길동", "남", "hong@naver.com");
//		System.out.println(service.insertMember(insertDto)?"추가성공":"추가실패");
		
		
		//멤버삭제
//		System.out.println(service.deleteMember("asdf", "123")?"삭제성공":"삭제실패");
		
		
		//멤버 수정
//		MemberDTO updateDto = new MemberDTO();
//		updateDto.setUserid("123aa");
//		updateDto.setPassword("aaaaa");
//		updateDto.setEmail("123@naver.com");
//		System.out.println(service.updateMember(updateDto)?"수정성공":"수정실패");
		
		//멤버 조회
		System.out.println(service.getRow("홍", "123"));
		
		//전체 조회
		List<MemberDTO> list = service.getRows();
		for (MemberDTO memberDTO:list) {
			System.out.println(memberDTO);
		}
		
		
	}

}

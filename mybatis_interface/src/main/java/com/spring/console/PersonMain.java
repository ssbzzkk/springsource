package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonDTO;
import com.spring.service.PersonService;

public class PersonMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		PersonService service = (PersonService) ctx.getBean("person");
		
		//삽입
//		PersonDTO insertPerson = new PersonDTO("kim123","김길동");
//		System.out.println(service.insertPerson(insertPerson)?"성공":"실패");

		//update
//		System.out.println(service.updatePerson(new PersonDTO("kim123","김동주"))?"성공":"실패");

		//삭제
//		System.out.println(service.deletePerson("kang1234")?"성공":"실패");
		
		//특정 사람 조회
//		System.out.println(service.getRow("hong123"));
		
		//전체조회
		List<PersonDTO> list = service.getRows();
		for(PersonDTO personDTO:list) {
			System.out.println(personDTO);
		
		
		
	}

	}}

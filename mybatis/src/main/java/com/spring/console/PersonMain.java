package com.spring.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonDTO;
import com.spring.service.PersonService;

public class PersonMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		PersonService service = (PersonService) ctx.getBean("person");
		
		//삽입
//		PersonDTO insertPerson = new PersonDTO("hong123","홍길동");
//		System.out.println(service.insertPerson(insertPerson)?"성공":"실패");

		//삭제
//		System.out.println(service.deletePerson("kang123")?"성공":"실패");
		
		//update
		System.out.println(service.updatePerson(new PersonDTO("knag1234","강동주"))?"성공":"실패");
		
		
	}

}

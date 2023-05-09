package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Spring framework
// 인스턴스를 생성하고 관리해줌 ==> 모든 인스턴스를 생성하고 관리하는 것은 아니고, 지정한 인스턴스만 처리
// 							지정한 인스턴스=> config.xml에 기록
// 							인스턴스 생성 시 singleton 방식으로 생성

public class HelloApp {
	public static void main(String[] args) {
		
		System.out.println("===컨테이너 구동 전===");
		
		// src/main/resources == ClassPath라고 불리우
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml"); //메인클래스에서 스프링 사용하는것, 기억안해도됨
		
		System.out.println("===컨테이너 구동 후===");
		MessageBean msg = (MessageBean) ctx.getBean("msg"); // id(msg)로 찾아옴
		msg.sayHello("홍길동");
		
		

	}

}

package com.spring.basic;

public class HelloApp {

	public static void main(String[] args) {
		MessageBean msg = new MessageBeanKo();
		msg.sayHello("홍길동");
		
		//new MessageBeanEn().sayHello("성춘향");

	}

}

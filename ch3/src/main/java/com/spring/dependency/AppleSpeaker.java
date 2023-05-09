package com.spring.dependency;

import org.springframework.stereotype.Component;

@Component("apple") //빈(인스턴스) 생성 == AppleSpeaker 객체 생성 
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() { 
		System.out.println("AppleSpeaker 인스턴스 생성");
	}
	
	@Override
	public void volumUp() {
		System.out.println("AppleSpeaker Volum Up");

	}

	@Override
	public void volumDown() {
		System.out.println("AppleSpeaker Volum Down");

	}

}

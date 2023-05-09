package com.spring.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") //빈(인스턴스) 생성 == SamsungTV 객체 생성
public class SamsungTV implements TV {
	
	@Autowired // 주입(스프링 컨테이너가 관리하는 빈 중에서 하나가 주입됨)
	@Qualifier("apple")
	private Speaker speaker; // 포함하는 관계, has-a 관계
	
	//매개변수를 받지 않는 생성자 : default생성자
	public SamsungTV() {
		System.out.println("SamsungTV 인스턴스 생성 - default 생성자");
	}
	
	public SamsungTV(Speaker speaker) {//매개변수를 받는 생성자
		super();
		this.speaker = speaker; //맴버 변수 초기화
		System.out.println("SamsungTV 인스턴스 생성 - 인자 생성자");

	}

	//setter 메소드
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV-파워 On");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV-파워 Off");
	}
	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV-볼륨 Up");
		speaker.volumUp();
	}
	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV-볼륨 Down");
		speaker.volumDown();
	}
}

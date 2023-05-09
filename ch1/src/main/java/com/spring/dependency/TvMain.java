package com.spring.dependency;

public class TvMain {
//	String str="String";
	//String 은 new 안해도 됌
 
	public static void main(String[] args) {
		 //생성자를 사용한 멤버 변수 초기화
		//SonySpeaker speaker = new SonySpeaker();
		//TV tv=new SamsungTV(speaker);
		// =>간단하게 하면
		//TV tv=new SamsungTV(new SonySpeaker());
		
		 //setter를 사용한 멤버 변수 초기화
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(new SonySpeaker());
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

		//TvMain obj = new TvMain();
		//obj.test();

	}
//	public void test() {
//		System.out.println(str.length());
//		
//	}
}

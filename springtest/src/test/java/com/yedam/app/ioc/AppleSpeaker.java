package com.yedam.app.ioc;

import org.springframework.stereotype.Component;

//Component //빈등록 //으름안주면 클래스명의 첫글자 소문자로 해서생성
public class AppleSpeaker implements Speaker  {

	public AppleSpeaker() {
		System.out.println("AppleSpeaker 생성");
	}
	public void volumeUp() {
		System.out.println("AppleSpeaker 소리 올림");	
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker 소리 내림");		
	}

}

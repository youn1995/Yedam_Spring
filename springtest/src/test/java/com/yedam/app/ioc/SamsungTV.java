package com.yedam.app.ioc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class SamsungTV implements TV {
//	@Resource(name="sonySpeaker") // name 생략시 class이름이랑 같은거 autowired랑 qualifer 합친거
//	@Autowired //주입 factory.getBean("speaker")랑 같은 역활//의존관계 있는 놈중 등록한 놈을 주입함
//	@Qualifier("sonySpeaker") //같은 이름의 빈이 두개있으면 그중에 멀들고 올지 정하는거
	private Speaker speaker;	
	private int price;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public SamsungTV() {}
	
	public void initMethod() {
		System.out.println("SamsungTV 초기화");
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn 가격:"  );
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV volumeUp");
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("SamsungTV volumeDown");
	}	
}

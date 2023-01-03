package kr.co.ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ltv")
public class LgTV implements TV{
	
	@Autowired
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("LgTV PowerOn...");
	}
	public void powerOff() {
		System.out.println("LgTV powerOff...");
	}
	
	public void chUp() {
		System.out.println("LgTV chUp...");
	}
	public void chDown() {
		System.out.println("LgTV chDown...");
	}
	
	public void soundUp() {
		spk.soundUp();
	}
	public void soundDown() {
		spk.soundDown();
	}
	
}

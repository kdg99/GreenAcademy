package kr.co.ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("stv")
public class SamsungTV implements TV{

	@Autowired
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("SamsungTV PowerOn...");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerOff...");
	}
	
	public void chUp() {
		System.out.println("SamsungTV chUp...");
	}
	public void chDown() {
		System.out.println("SamsungTV chDown...");
	}
	
	public void soundUp() {
		spk.soundUp();
	}
	public void soundDown() {
		spk.soundDown();
	}
	
}

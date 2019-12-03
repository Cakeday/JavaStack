package com.whatever.phone;

public class IPhone extends Phone implements Ringable{

	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	
	
	
	
	@Override
	public void displayInfo() {
		System.out.println("Iphone X from AT&T");
	}
	@Override
	public String ring() {
		return "Zing";
	}
	@Override
	public String unlock() {
		return "UNlocking via facial recognition";
	}

}

package com.whatever.phone;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	@Override
	public void displayInfo() {
		System.out.println("Galaxy S9 from Verizon");
	}
	@Override
	public String ring() {
		return "Ring Ring Ring";
	}
	@Override
	public String unlock() {
		return "UNlocking via finger print";
	}

}

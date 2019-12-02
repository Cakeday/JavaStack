package com.whatever.zookeeper;

public class Mammal {
	
	public Mammal() {
		
	}
	private int energyLevel = 100;
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
	
	
	
	
	public void displayEnergy() {
		System.out.println(energyLevel);
	}
	
	
	
}

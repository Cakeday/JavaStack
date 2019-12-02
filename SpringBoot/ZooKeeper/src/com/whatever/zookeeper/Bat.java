package com.whatever.zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		super.setEnergyLevel(300);
	}
	
	public void fly() {
		int energy = super.getEnergyLevel();
		energy -= 50;
		super.setEnergyLevel(energy);	
		System.out.println("FLY FLY FLY FLY FLY"); 
		System.out.println("its energy level is now " + energy); 
	}
	public void eatHumans() {
		int energy = super.getEnergyLevel();
		energy += 25;
		super.setEnergyLevel(energy);	
		System.out.println("crunch crunch crunch crunch"); 
		System.out.println("its energy level is now " + energy); 
	}
	public void attackTown() {
		int energy = super.getEnergyLevel();
		energy -= 100;
		super.setEnergyLevel(energy);	
		System.out.println("FIRE FIRE FIRE FIRE FIRE"); 
		System.out.println("its energy level is now " + energy); 
	}
	
}

package com.whatever.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla () {
	}
	
	public void throwSomething() {
		int energy = super.getEnergyLevel();
		energy -= 5;
		super.setEnergyLevel(energy);	
		System.out.println("the gorilla has thrown something"); 
		System.out.println("its energy level is now " + energy); 
	}
	
	public void eatBananas() {
		int energy = super.getEnergyLevel();
		energy += 10;
		super.setEnergyLevel(energy);	
		System.out.println("the gorilla is a satisfied boi"); 
		System.out.println("its energy level is now " + energy); 
	}
	
	public void climb() {
		int energy = super.getEnergyLevel();
		energy -= 10;
		super.setEnergyLevel(energy);	
		System.out.println("the gorilla has climbed a tree"); 
		System.out.println("its energy level is now " + energy); 
	}
}

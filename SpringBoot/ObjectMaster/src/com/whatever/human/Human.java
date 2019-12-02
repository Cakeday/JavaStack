package com.whatever.human;

public class Human {
	
	public Human() {
		
	}
	int strength = 3;
	int intelligence = 3;
	int stealth = 3;
	int health = 100;
	static int amountOfSams = 0;
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStealth() {
		return stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	
	public void attack(Human human) {
		int attackedHealth = human.getHealth();
		int attackerStrength = this.getStrength();
		attackedHealth -= attackerStrength;
		human.setHealth(attackedHealth);
		System.out.println("human has been attacked. Health is now down to " + attackedHealth + ".");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

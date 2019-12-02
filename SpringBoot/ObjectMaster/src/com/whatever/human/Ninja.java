package com.whatever.human;

public class Ninja extends Human {

	public Ninja() {
		super.setStealth(10);
		super.setIntelligence(8);
	}
		
	public void steal(Human human) {
		int amount = this.getStealth();
		human.setHealth(human.getHealth() - amount);
		this.setHealth(this.getHealth() + amount);
		System.out.println("The ninja has stolen " + amount + " health from the human. Ninja's health is now " + this.getHealth() + ". " + "Human's health is now " + human.getHealth() + ".");
	}
		
	public void runAway() {
		this.setHealth(this.getHealth() - 10);
		System.out.println("The ninja has run away and lost 10 health. Health is now " + this.getHealth() + ".");
	}

}

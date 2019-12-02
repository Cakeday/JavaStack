package com.whatever.human;

public class Wizard extends Human {

	public Wizard() {
		super.setHealth(50);
		super.setIntelligence(8);
	}
	
	public void heal(Human human) {
		int amount = this.getIntelligence();
		human.setHealth(human.getHealth() + amount);
		System.out.println("The wizard has healed this human by " + amount + " points.");
	}
	
	public void fireball(Human human) {
		int amount = this.getIntelligence() * 3;
		System.out.println("The wizard will deal " + amount + " damage to the human");
		human.setHealth(human.getHealth() - amount);
		System.out.println("The wizard has reduced this human's health to " + human.getHealth() + " points.");
	}

}

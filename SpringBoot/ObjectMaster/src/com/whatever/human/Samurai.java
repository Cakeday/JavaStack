package com.whatever.human;

public class Samurai extends Human {

	public Samurai() {
		this.setHealth(200);
		amountOfSams += 1;
	}
	
	public void deathBlow(Human human) {
		int amount = human.getHealth();
		human.setHealth(amount - amount);
		this.setHealth(this.getHealth()/2);
		System.out.println("The samurai has reduced the human's health to " + human.getHealth() + ". Now the human is dead. The samurai's health is now " + this.getHealth() + ".");
	}

	public void meditate() {
		int amount = this.getHealth()/2;
		this.setHealth(this.getHealth() + amount);
		System.out.println("The samurai has regained " + amount + " health. Health is now " + this.getHealth() + ".");
	}
	
	public void howMany() {
		System.out.println("There are " + amountOfSams + " samurai in the game.");
	}
}

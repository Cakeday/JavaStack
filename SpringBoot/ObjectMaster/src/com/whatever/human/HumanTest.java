package com.whatever.human;

public class HumanTest {

	public static void main(String[] args) {
		Human human1 = new Human();
		Human human2 = new Human();
		Human human3 = new Human();
		Wizard wiz1 = new Wizard();
		Ninja nin1 = new Ninja();
		Samurai sam1 = new Samurai();
		Samurai sam2 = new Samurai();
		Samurai sam3 = new Samurai();
		
		wiz1.fireball(human1);
		wiz1.heal(human1);
		
		nin1.steal(human2);
		nin1.runAway();
		
		sam1.deathBlow(human3);
		sam1.meditate();
		sam1.howMany();
	}
	

}

package model;

public class Weapon implements Iweapon {

	String name;
	int maxDmg;
	int minDmg;
	
	public Weapon(String name, int maxDmg, int minDmg) {
		this.name = name;
		this.maxDmg = maxDmg;
		this.minDmg = minDmg;
	}

}

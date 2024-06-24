package entities;

public class Weapon {

	String name;
	int maxDmg;
	int minDmg;
	
	public Weapon(String name, int maxDmg, int minDmg) {
		this.name = name;
		this.maxDmg = maxDmg;
		this.minDmg = minDmg;
	}

public int getDamage(float crit) {
		return (int) (minDmg + (maxDmg - minDmg) * Math.random() * crit);
	}

public String getName() {
		return this.name;
}
}

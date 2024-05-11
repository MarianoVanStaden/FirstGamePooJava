package model;

public class GameCharacter {
String name;
int maxHp;
int curHp;
Weapon myWeapon;

public GameCharacter (String name, int maxHp, int curHp) {
	this.name = name;
	this.maxHp = maxHp;
	this.curHp = curHp;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMaxHp() {
	return maxHp;
}
public void setMaxHp(int maxHp) {
	this.maxHp = maxHp;
}
void setWeapon(Weapon weapon) {
    this.myWeapon = weapon;
}
}

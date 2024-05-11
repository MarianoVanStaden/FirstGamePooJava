package model;

public class GameCharacter implements IgameCharacter {
String name;
int maxHp;
int curHp;
Weapon myWeapon;

public GameCharacter (String name, int maxHp, int curHp) {
	this.name = name;
	this.maxHp = maxHp;
	this.curHp = curHp;
}

@Override
public String getName() {
	return name;
}
@Override
public void setName(String name) {
	this.name = name;
}
@Override
public int getMaxHp() {
	return maxHp;
}
@Override
public void setMaxHp(int maxHp) {
	this.maxHp = maxHp;
}
void setWeapon(Weapon weapon) {
    this.myWeapon = weapon;
}
}

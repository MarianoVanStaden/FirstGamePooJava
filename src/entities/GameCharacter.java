package entities;

public abstract class GameCharacter  {
int maxHp;
int curHp;

public GameCharacter (int maxHp, int curHp) {
	this.maxHp = maxHp;
	this.curHp = curHp;
}
public GameCharacter() {
}
public int getMaxHp() {
	return maxHp;
}
public void setMaxHp(int maxHp) {
	this.maxHp = maxHp;
}
public int getCurHp() {
	return curHp;
}
public void setCurHp(int curHp) {
	this.curHp = curHp;
}
}

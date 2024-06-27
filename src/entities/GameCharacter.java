package entities;

public abstract class GameCharacter {
    int maxHp;
    int curHp;

    public GameCharacter(int maxHp, int curHp) {
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

    public boolean isInRange(GameCharacter target) {
        int distance = Math.abs(this.getX() - target.getX()) + Math.abs(this.getY() - target.getY());
        // Suponiendo que cada paso en el mapa equivale a una unidad de distancia
        return distance <= 1;
    }

    public abstract int getX();

    public abstract int getY();
}

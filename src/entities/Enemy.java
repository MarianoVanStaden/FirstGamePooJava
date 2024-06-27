package entities;

public class Enemy extends GameCharacter implements interfaces.ICombatant {
    private int damage;
    private int x;
    private int y;

    public Enemy(int maxHp, int curHp, int damage, int x, int y) {
        super(maxHp, curHp);
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
    public int getDamage() {
        return damage;
    }

    @Override
    public int attack() { //Inicializo damage a través del constructor
        damage = (int)(damage * Math.random());
        return damage;
    }
}
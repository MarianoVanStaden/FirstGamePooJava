package entities;

public class Enemy extends GameCharacter implements interfaces.ICombatant {
    private int damage;

    public Enemy(int damage) {
        super(); 
        this.damage = damage;
    }
    public Enemy(int maxHp, int curHp, int damage) {
        super(maxHp, curHp);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack() {
        System.out.println("Enemy attacks with " + damage + " damage");
    }
}
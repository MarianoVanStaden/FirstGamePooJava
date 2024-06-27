package entities;

public class Player extends GameCharacter implements interfaces.ICombatant {
    private String name;
    private Weapon weapon;
    private int x;
    private int y;

    public Player(String name, Weapon weapon, int x, int y) {
        super();
        this.name = name;
        this.weapon = weapon;
        this.x = x;
        this.y = y;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int attack() {
        System.out.println("Player attacks with " + weapon.getDamage(curHp) + " damage");
        return weapon.getDamage(curHp);
    }

    
    
}
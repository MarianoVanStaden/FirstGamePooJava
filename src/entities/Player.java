package entities;

public class Player  extends GameCharacter implements interfaces.ICombatant{
    private String name;
    private Weapon weapon;

    public Player(String name, Weapon weapon) {
        super();
        this.name = name;
        this.weapon = weapon;
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

    public void attack() {
        System.out.println("Player attacks with " + weapon.getDamage(curHp) + " damage");
    }

    public boolean isInRange(Enemy enemy1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInRange'");
    }
}
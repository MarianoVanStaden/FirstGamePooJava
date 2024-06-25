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

    @Override
    public int attack() {
       // System.out.println("Player attacks with " + weapon.getDamage(curHp) + " damage");
        //return weapon.getDamage(curHp);
        return 10;
    }

    public boolean isInRange(Enemy enemy1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInRange'");
    }
}
package controllers;

import entities.GameCharacter;
import entities.Map;
import views.Console;


public class GameController {
    private GameCharacter[] characters;
    private Map gameMap;
    private Console view;

    public GameController(GameCharacter[] characters, Map gameMap, Console view) {
        this.characters = characters;
        this.gameMap = gameMap;
        this.view = view;
    }

    public void combat(GameCharacter attacker, GameCharacter defender) {
        int damage = (int) (Math.random() * (attacker.getMaxHp() - attacker.getCurHp()) + attacker.getCurHp());
        defender.setCurHp(defender.getCurHp() - damage);
        view.showStatus(attacker.getClass().getSimpleName() + " attacked " + defender.getClass().getSimpleName() + " for " + damage + " damage.");
    }

    public void move(GameCharacter character, int x, int y) {

    }
}
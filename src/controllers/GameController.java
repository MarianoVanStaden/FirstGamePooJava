package controllers;

import entities.GameCharacter;
import entities.Map;
import entities.Player;
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
        // Obtener el daño del atacante
        int damage = attacker.attack();
        defender.setCurHp(defender.getCurHp() - damage);

        // Mostrar el resultado del ataque en la vista
        view.showStatus(attacker.getClass().getSimpleName() + " attacked " + defender.getClass().getSimpleName() + " for " + damage + " damage.");

        // Verificar si el defensor ha sido derrotado
        if (defender.getCurHp() <= 0) {
            gameMap.removeCharacter(defender.getX(), defender.getY());
            view.showStatus(defender.getClass().getSimpleName() + " has been defeated!");
        }

    public void move(GameCharacter character, int x, int y) {
        if (character instanceof Player) {
            // Cast a Player para acceder a los métodos específicos del jugador
            Player player = (Player) character;

            // Guardar las coordenadas actuales del jugador
            int currentX = player.getX();
            int currentY = player.getY();

            // Verificar que las nuevas coordenadas estén dentro de los límites del mapa
            if (x >= 0 && x < gameMap.getWidth() && y >= 0 && y < gameMap.getHeight()) {
                // Actualizar las coordenadas del jugador
                player.setX(x);
                player.setY(y);

                // Mover al jugador en el mapa
                //gameMap.moveCharacter(currentX, currentY, x, y);
                gameMap.removeCharacter(currentX, currentY);
                gameMap.addCharacter(currentX, currentY, player);
            } else {
                view.showStatus("Movimiento no válido. Las coordenadas están fuera de los límites del mapa.");
            }
        } else {
            view.showStatus("No se puede mover a este personaje.");
        }
    }
}

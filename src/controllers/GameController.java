package controllers;

import entities.GameCharacter;
import entities.Enemy;
import entities.Map;
import entities.Player;
import views.Console;

public class GameController {
    private Player attacker;
    private Enemy defender;
    private Map gameMap;
    private Console view;

    public GameController(Player attacker, Enemy defender, Map gameMap, Console view) {
        this.attacker = attacker;
        this.defender = defender;
        this.gameMap = gameMap;
        this.view = view;
    }

    public void combat(Player attacker, Enemy defender) {
    	System.out.println("El héroe posee " + attacker.getCurHp() + " puntos de vida");
    	System.out.println("El enemigo posee " + defender.getCurHp() + " puntos de vida");
        // Mientras ambos tengan puntos de vida mayores que cero
        while (defender.getCurHp() > 0 && attacker.getCurHp() > 0) {
 
            // Obtener el daño del atacante y aplicar al defensor
            int damageAttacker = attacker.attack();
            defender.setCurHp(defender.getCurHp() - damageAttacker);
            System.out.println("El ataque del héroe será de: " +  damageAttacker);
            System.out.println("La vida de Enemy es:" + defender.getCurHp());
            // Mostrar el resultado del ataque en la vista
            view.showStatus(attacker.getName() + " atacó al enemigo con " + damageAttacker + " de daño.");

            // Verificar si el defensor ha sido derrotado después del ataque del atacante
            if (defender.getCurHp() <= 0) {
                view.showStatus("El enemigo ha sido derrotado!");
                gameMap.removeCharacter(defender.getX(), defender.getY());
                break; // Romper el bucle si el defensor ha sido derrotado
            }

            // Obtener el daño del defensor y aplicar al atacante
            int damageDefender = defender.attack();
            attacker.setCurHp(attacker.getCurHp() - damageDefender);
            System.out.println("El ataque del Enemigo será de: " +  damageDefender);
            System.out.println("La vida del héroe es:" + attacker.getCurHp());
            // Mostrar el resultado del ataque en la vista
            view.showStatus(defender.getClass().getTypeName() + " atacó al héroe con " + damageDefender + " de daño.");

            // Verificar si el atacante ha sido derrotado después del ataque del defensor
            if (attacker.getCurHp() <= 0) {
                view.showStatus(attacker.getName() + " ha sido derrotado!");
                break; // Romper el bucle si el atacante ha sido derrotado
            }
        }
    }



    public void move(Player character, int x, int y) {
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
                gameMap.removeCharacter(currentX, currentY);
                gameMap.addCharacter(x, y, player);

                // Mostrar el mapa actualizado con los personajes
                view.showMapWithCharacters(gameMap, player, defender);
            } else {
                view.showStatus("Movimiento no válido. Las coordenadas están fuera de los límites del mapa.");
            }
        } else {
            view.showStatus("No se puede mover a este personaje.");
        }
    }

}

package main;

import controllers.GameController;
import entities.Enemy;
import entities.GameCharacter;
import entities.Map;
import entities.Player;
import entities.Weapon;
import views.Console;



public class Main {
    public static void main(String[] args) {
        // Crear armas
        Weapon sword = new Weapon("Sword", 7, 15);
        Weapon axe = new Weapon("Axe", 5, 10);
        Weapon bat = new Weapon("bat", 1, 5);
        Weapon bow = new Weapon("Bow", 0, 15);

        // Crear jugadores y enemigos
        Player player1 = new Player("Hero", sword);
        Enemy enemy1 = new Enemy(50, 50, 8);

        // Crear mapa
        Map gameMap = new Map(10, 10);
        gameMap.addCharacter(0, 0, player1);
        gameMap.addCharacter(1, 1, enemy1);

        // Crear vista
        Console console = new Console();

        // Crear controlador del juego
        GameCharacter[] characters = {player1, enemy1};
        GameController gameController = new GameController(characters, gameMap, console);

        // Iniciar juego
        boolean gameRunning = true;
        while (gameRunning) {
            console.showMap(gameMap);

            // Movimiento del jugador
            String move = console.askUserMove();
            // Aquí deberías parsear el movimiento y actualizar la posición del jugador en el mapa
            // Supongamos que movemos al jugador a una nueva posición (2, 2) como ejemplo
            gameController.move(player1, 2, 2);

            // Simular combate
            if (player1.isInRange(enemy1)) {
                gameController.combat(player1, enemy1);
            }

            // Comprobar estado del juego
            if (player1.getCurHp() <= 0 || enemy1.getCurHp() <= 0) {
                gameRunning = false;
                console.showStatus("Juego Terminado");
            }
        }
    }
}

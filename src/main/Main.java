package main;

import controllers.GameController;
import entities.Enemy;
import entities.Map;
import entities.Player;
import entities.Weapon;
import views.Console;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Array de armas predefinidas
        Weapon[] weapons = {
            new Weapon("Espada", 7, 15),
            new Weapon("Hacha", 5, 10),
            new Weapon("Bate", 3, 12),
            new Weapon("Lanza", 2, 8),
            new Weapon("Puñal", 4, 9)
        };

        // Crear vista
        Console console = new Console();
        Scanner scanner = new Scanner(System.in);

        // Interacción con el usuario para ingresar el nombre del héroe y elegir arma
        System.out.print("Ingrese el nombre del héroe: ");
        String heroName = scanner.nextLine();

        System.out.println("Seleccione un arma para " + heroName + ":");
        for (int i = 0; i < weapons.length; i++) {
            System.out.println((i + 1) + ". " + weapons[i].getName());
        }

        int weaponChoice;
        do {
            System.out.print("Elija el número correspondiente al arma: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            weaponChoice = scanner.nextInt();
        } while (weaponChoice < 1 || weaponChoice > weapons.length);

        Weapon chosenWeapon = weapons[weaponChoice - 1];

        // Crear jugador con el nombre y el arma elegida
        Player player1 = new Player(100, 100, heroName, chosenWeapon, 0, 0);  // Jugador empieza en (0, 0)
        Enemy enemy1 = new Enemy(50, 50, 50, 4, 4);                   // Enemigo empieza en (4, 4)

        // Crear mapa
        Map gameMap = new Map(10, 10);
        gameMap.addCharacter(player1.getX(), player1.getY(), player1);
        gameMap.addCharacter(enemy1.getX(), enemy1.getY(), enemy1);

        // Crear controlador del juego
        GameController gameController = new GameController(player1, enemy1, gameMap, console);

        // Iniciar juego
        boolean gameRunning = true;
        while (gameRunning) {
            console.showMapWithCharacters(gameMap, player1, enemy1); // Mostrar el mapa con los personajes

            // Movimiento del jugador
            String move = console.askUserMove();
            int newX = player1.getX();
            int newY = player1.getY();

            if (move.equalsIgnoreCase("a")) {
                newY--;
            } else if (move.equalsIgnoreCase("d")) {
                newY++;
            } else if (move.equalsIgnoreCase("w")) {
                newX--;
            } else if (move.equalsIgnoreCase("s")) {
                newX++;
            }

            // Verificar que las nuevas coordenadas estén dentro de los límites del mapa
            if (newX >= 0 && newX < gameMap.getWidth() && newY >= 0 && newY < gameMap.getHeight()) {
                gameController.move(player1, newX, newY);

                // Simular combate
                if (player1.isInRange(enemy1)) {
                    System.out.println("¡Entra en combate (está en rango)!");
                    gameController.combat(player1, enemy1);
                }

                // Comprobar estado del juego
                if (player1.getCurHp() <= 0) {
                    gameRunning = false;
                    console.showStatus("Juego Terminado - Has perdido!.");
                } else if (enemy1.getCurHp() <= 0) {
                    gameRunning = false; 
                    console.showStatus("Juego Terminado - Has ganado!.");
                }
            } else {
                console.showStatus("Movimiento no válido. Las coordenadas están fuera de los límites del mapa.");
            }
        }

        scanner.close();
    }
}

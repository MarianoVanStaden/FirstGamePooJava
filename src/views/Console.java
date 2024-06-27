package views;

import entities.Map;
import entities.GameCharacter;
import entities.Player;
import entities.Enemy;
import java.util.Scanner;

public class Console {
	private Scanner sc = new Scanner(System.in);
    public void showMap(Map gameMap) {
        for (int i = 0; i < gameMap.getHeight(); i++) {
            for (int j = 0; j < gameMap.getWidth(); j++) {
                System.out.print(gameMap.getTile(i, j));
            }
            System.out.println();
        }
    }

    public String askUserMove() {
        System.out.println("Enter your move: ");
        System.out.println("You have to use the normal commands of pc games (awsd)");
        System.out.println("(a = left , d = right, w = up & s = down)");
        return sc.nextLine();
    }

    public void showStatus(String status) {
        System.out.println(status);
    }

    public void showMapWithCharacters(Map gameMap, Player player, Enemy enemy) {
        for (int i = 0; i < gameMap.getHeight(); i++) {
            for (int j = 0; j < gameMap.getWidth(); j++) {
                GameCharacter character = gameMap.getCharacter(i, j);
                if (character == player) {
                    System.out.print("[H]");
                } else if (character == enemy) {
                    System.out.print("[X]");
                } else if (character == null) {
                    System.out.print("[.]");
                } else {
                    System.out.print("[ ]"); // Otros personajes o entidades
                }
            }
            System.out.println();
        }
    }
}

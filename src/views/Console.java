package views;

import entities.Map;
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
        return sc.nextLine();
    }

    public void showStatus(String status) {
        System.out.println(status);
    }
}
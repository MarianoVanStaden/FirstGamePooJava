package entities;
public class Map {
    private GameCharacter[][] map;

    public Map(int width, int height) {
        map = new GameCharacter[width][height];
    }

    public void addCharacter(int x, int y, GameCharacter character) {
        if (isValidPosition(x, y)) {
            map[x][y] = character;
        } else {
            System.out.println("Posición inválida");
        }
    }

    public GameCharacter getCharacter(int x, int y) {
        if (isValidPosition(x, y)) {
            return map[x][y];
        } else {
            System.out.println("Posición inválida");
            return null;
        }
    }

    public void removeCharacter(int x, int y) {
        if (isValidPosition(x, y)) {
            map[x][y] = null;
        } else {
            System.out.println("Posición inválida");
        }
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    public char[] getTile(int x, int y) {
        if (isValidPosition(x, y)) {
            return map[x][y] == null ? new char[] { ' ' } : new char[] { 'X' };
        } else {
            return new char[] { '?' }; // '?' para posiciones inválidas
        }
    }

    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[X]");
                }
            }
            System.out.println();
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[x].length;
    }
}

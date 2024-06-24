package entities;
public class Map {
    private GameCharacter[][] map;

    public Map(int width, int height) {
        map = new GameCharacter[width][height];
    }

    public void addCharacter(int x, int y, GameCharacter character) {
        map[x][y] = character;
    }

    public GameCharacter getCharacter(int x, int y) {
        return map[x][y];
    }

    public int getHeight() {
        return map[0].length;
    }

    public int getWidth() {
        return map[0].length;
    }

    public char[] getTile(int i, int j) {
        return new char[] { ' ' };
    }
}
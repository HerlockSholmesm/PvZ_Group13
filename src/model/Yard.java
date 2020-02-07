package model;

import in_game.Game;
import javafx.scene.image.Image;

public abstract class Yard {
    int width;
    int height;
    Image background;
    private Cell yard[][] = new Cell[6][19];
    private Game game;
    private boolean isItWater;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Yard(Image background, Cell[][] yard, Game game, boolean isItWater, int x1, int x2, int y1, int y2) {
        this.background = background;
        this.yard = yard;
        this.game = game;
        this.isItWater = isItWater;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        width = x2 - x1;
        height = y2 - y1;
    }

    public Game getGame() {
        return game;
    }

    public Cell[][] getYard() {
        return yard;
    }

    public boolean isItWater() {
        return isItWater;
    }

    public void setYard(Cell[][] yard) {
        this.yard = yard;
    }











}

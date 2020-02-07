package model;

import in_game.Game;
import javafx.scene.image.Image;

public abstract class Yard {
    int width;
    int height;
    Image background;
    private Cell cells[][] = new Cell[6][19];
    private Game game;
    private boolean isItWater;


    public Yard(Image background, Game game, boolean isItWater) {
        this.background = background;
        this.game = game;
        this.isItWater = isItWater;
    }

    public Game getGame() {
        return game;
    }

    public Cell[][] getYard() {
        return cells;
    }

    public boolean isItWater() {
        return isItWater;
    }









}

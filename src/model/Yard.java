package model;

import in_game.Game;
import javafx.scene.image.Image;

public abstract class Yard {
    double width;
    double height;
    protected Image background;
    protected Cell cells[][] = new Cell[6][19];
    private Game game;
    private boolean isItWater;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Yard(Game game, boolean isItWater) {
        this.game = game;
        this.isItWater = isItWater;
    }

    public Game getGame() {
        return game;
    }

    public Image getBackground() {
        return background;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean isItWater() {
        return isItWater;
    }









}

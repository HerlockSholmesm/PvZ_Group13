package model;

import in_game.DynamicDay;
import in_game.Game;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Chamanzan {
    public static final int SPEED = 3;
    boolean used;
    private int whichRow;
    private Cell whichCell;
    private Yard yard;
    private Image image;

    public Image getImage() {
        return image;
    }

    public Chamanzan(int x, int y, Yard yard) {
        this.whichCell = new Cell(false, x, x, y, y);
        this.yard = yard;
        used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getWhichRow() {
        return whichRow;
    }

    public void setWhichRow(int whichRow) {
        this.whichRow = whichRow;
    }

    public void setWhichCell(Cell whichCell) {
        this.whichCell = whichCell;
    }

    public Yard getYard() {
        return yard;
    }

    public void setYard(Yard yard) {
        this.yard = yard;
    }

    public int getWhichCell() {
        return whichRow;
    }

    public void setWhichCell(int whichCell) {
        this.whichRow = whichCell;
    }


    public void action(Game game){
        if (used) {
            whichCell.setX1(whichCell.getX1() + SPEED);
            whichCell.setY1(whichCell.getY1() + SPEED);
            for (Zombie zombie : game.getZombies()) {
                if ((whichCell.getX1() - 3 <= zombie.getX() || zombie.getX() <= whichCell.getX1()) && zombie.getY() == whichCell.getY1()) {
                    zombie.setX(-1);
                    zombie.setY(-1);
                }
            }
            if (whichCell.getX1() >= 19){
                whichCell.setX1(-1);
                whichCell.setY1(-1);
            }
        } else {
            for (Zombie zombie : game.getZombies()) {
                if (zombie.getX() == 0 && zombie.getY() == whichCell.getY1()) {
                    used = true;
                    game.getZombies().remove(zombie);
                    zombie.setLife(0);
                }
            }
            return;
        }

    }

}

package model;

import in_game.DynamicDay;
import in_game.Game;

import java.util.ArrayList;

public class Chamanzan {
    public static final int SPEED = 3;
    boolean used;
    private int whichRow;
    private Cell whichCell;
    private Yard yard;

    public Chamanzan(int x, int y, Yard yard) {
        this.whichCell = new Cell(x, y);
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
            whichCell.setX(whichCell.getX() + SPEED);
            whichCell.setY(whichCell.getY() + SPEED);
            for (Zombie zombie : game.getZombies()) {
                if ((whichCell.getX() - 3 <= zombie.getX() || zombie.getX() <= whichCell.getX()) && zombie.getY() == whichCell.getY()) {
                    zombie.setX(-1);
                    zombie.setY(-1);
                }
            }
            if (whichCell.getX() >= 19){
                whichCell.setX(-1);
                whichCell.setY(-1);
            }
        } else {
            for (Zombie zombie : game.getZombies()) {
                if (zombie.getX() == 0 && zombie.getY() == whichCell.getY()) {
                    used = true;
                    game.getZombies().remove(zombie);
                    zombie.setY(-1);
                    zombie.setX(-1);
                }
            }
            return;
        }

    }

}

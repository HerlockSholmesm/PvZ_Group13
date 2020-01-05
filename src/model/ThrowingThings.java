package model;

import in_game.Game;

public class ThrowingThings {
    private int x;
    private int y;
    Cell cell;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public ThrowingThings(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        cell = new Cell(x + 1, y);
    }
    public void action(Game game){
        if (this.getX() >= 19){
            game.removeBullet(this);
        }
        else {
            for (Zombie zombie : game.getZombies()) {
                if (zombie.getX() == x && zombie.getY() == y){
                    zombie.beAttacked();
                    game.removeBullet(this);
                    return;
                }
            }
        }
    }
}

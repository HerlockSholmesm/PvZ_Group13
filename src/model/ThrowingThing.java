package model;

import in_game.Game;

public class ThrowingThing {
    private int x;
    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    private int y;

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

    public ThrowingThing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        this.x+=1;
    }

    public void removeBullet() {
        this.setX(-1);
        this.setY(-1);
    }

    //todo
    //finding nearest
    public void action(Game game) {
        this.move();
        if (this.getX() >= 19) {
            this.removeBullet();
        } else {
            for (Zombie zombie : game.getZombies()) {
                if (zombie.getX() == x && zombie.getY() == y) {
                    zombie.setLife(zombie.getLife() - this.getPower());
                    this.removeBullet();
                    return;
                }
            }
        }
    }
}

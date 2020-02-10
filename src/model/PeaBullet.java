package model;

import in_game.Game;
import javafx.scene.image.Image;

public class PeaBullet {
    private int x;
    private int y;
    private int power=1;
    private Image image;

    public Image getImage() {
        return image;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

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

    public PeaBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        this.x=+1;
    }
    public void moveBack() {
        this.x=-1;
    }
    public void removeBullet() {
        this.setX(-1);
        this.setY(-1);
    }

    public void action(Game game) {
        this.move();
        if (this.getX() >= 19) {
            this.removeBullet();
        } else {
            for (Zombie zombie : game.getZombies()) {
                if (!(zombie instanceof ShieldZombie)) {
                    if (zombie.getX(game.getYard()) == x && zombie.getY(game.getYard()) == y) {
                        zombie.setLife(zombie.getLife() - this.getPower());
                        this.removeBullet();
                        return;
                    }
                }
            }
        }
    }
    public void actionNegetive(Game game) {
        this.moveBack();
        if (this.getX() <=0) {
            this.removeBullet();
        } else {
            for (Zombie zombie : game.getZombies()) {
                if (!(zombie instanceof ShieldZombie)) {
                    if (zombie.getX(game.getYard()) == x && zombie.getY(game.getYard()) == y) {
                        zombie.setLife(zombie.getLife() - this.getPower());
                        this.removeBullet();
                        return;
                    }
                }
            }
        }
    }
}

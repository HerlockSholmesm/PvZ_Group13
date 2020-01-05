package model;

public class ShieldZombie {
    int life;

    public ShieldZombie(int life) {
        this.life = life;
    }

    public void addLife(int addNumber) {
        this.life = +addNumber;
    }
}

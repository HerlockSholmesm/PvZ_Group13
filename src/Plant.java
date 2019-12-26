import Model.Card;
import Model.Cell;

import java.util.ArrayList;

public abstract class Plant extends Card {

    private int sun;
    private int rest;
    private int life;
    private int attackPower;
    private int speed;
    private Cell cell;
    protected Sun suni;
    private String name;


    public int getSun() {
        return sun;
    }

    public int getRest() {
        return rest;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }


    public int getSpeed() {
        return speed;
    }


    public Plant(String name, int sun, int rest, int life) {
        this.name = name;
        this.sun = sun;
        this.rest = rest;
        this.life = life;
        suni = new Sun();
    }

    public void attack(Card card) {
        card.setLife(card.getLife() - attackPower);

    }

    public void beAttacked(Card card) {
        card.setLife(card.getLife() - attackPower);
    }


}


class ProducerPlant extends Plant {

    public ProducerPlant(String name, int clock, int numberOfSun, int sun, int rest, int life) {

        super(name, sun, rest, life);
        addSun(sun);
    }

    public void produce(int addNumber) {
        suni.addsun(addNumber);
    }

    public void addSun(int sun1) {
        suni.addsun(sun1);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

}

class shootingPlant extends Plant {
    public shootingPlant(String name, int clock, int numberOfPea, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }

    public void shoot(int number,int x, int y) {
        ArrayList<PeaBullet> peaBullets = null;
        for (int i = 0; i <number ; i++) {
            peaBullets.add(new PeaBullet(x, y));
        }
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

}

class throwingPlant extends Plant {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }


    public throwingPlant(String name, int clock, int numberOfBullet, int power, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }
}

class MinePlant extends Plant {
    public MinePlant(String name, int cells, int sun, int rest, int life) {

        super(name, sun, rest, life);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }


}

class ToPlantOnPlant extends Plant {
    public ToPlantOnPlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }


}

class EatablePlant extends Plant {
    public EatablePlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

}

class PeaBullet {
    private int x;
    private int y;
    Cell cell;

    public PeaBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void shoot(int x, int y) {
        cell = new Cell(x, y);
    }

    public void move() {
        cell = new Cell(x + 1, y);
    }
}
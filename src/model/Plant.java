package model;

import java.util.ArrayList;
import in_game.*;

public abstract class Plant extends Card {
    private int x;
    private int y;
    private int sun;
    private int rest;
    private int price;



    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getPrice() {
        int sun = this.getSun(), coolDown = this.getRest(), health = this.getLife();
        return (sun * coolDown * health + 1);
    }
    private int life;
    private int attackPower;
    private int speed;
    private Cell cell;
    protected Sun suni;

    public int getClock() {
        return clock;
    }

    private int clock;

    public Cell getCell() {
        return cell;
    }

    private String name;

    public int getXCoordinate() {
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public Plant(String name,int clock, int sun, int rest, int life) {
        this.name = name;
        this.sun = sun;
        this.rest = rest;
        this.life = life;
        this.clock=clock;
        suni = new Sun();
    }

    public void attack(Card card) {
        card.setLife(card.getLife() - attackPower);
    }

    public void beAttacked(Card card) {
        card.setLife(card.getLife() - attackPower);
    }

<<<<<<< HEAD
    public void action(Game game){
    }
    public void attack() {
    }

  //  public abstract void action(Game game);
//>>>>>>> Stashed changes
=======

    public void attack() {
    }

    public abstract void action(Game game);
>>>>>>> origin/master
    @Override
    public String toString() {
        return   name  + ": " + sun ;
    }

    public String toStringPrime(){
        return name + ": " + life + ", " + "(" + x + "," + y + ")";
    }
}


class ProducerPlant extends Plant {

    public ProducerPlant(String name, int clock, int numberOfSun, int sun, int rest, int life) {

        super(name,clock, sun, rest, life);
        addSun(sun);
    }

    public void produce(int addNumber) {
        suni.addsun(addNumber);
    }

    public void addSun(int sun1) {
        suni.addsun(sun1);
    }

    @Override
    public void attack() {

    }

    @Override
    public void beAttacked() {
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        switch (name){
            case ("Sunflower"):
                    if (game.getTurn()>=this.getClock() ){ game.setSun(game.getSun().getSunStore()+1);}
            case ("Twin Sunflower"):
                if (game.getTurn()>=this.getClock()){ game.setSun(game.getSun().getSunStore()+2);}


        }
    }
}

class shootingPlant extends Plant {
    public shootingPlant(String name, int clock, int numberOfPea, int sun, int rest, int life) {
        super(name, clock, sun, rest, life);
    }

    public void shoot(int number, int x, int y) {
        ArrayList<PeaBullet> peaBullets = null;
        for (int i = 0; i < number; i++) {
            peaBullets.add(new PeaBullet(x, y));
        }
    }

    @Override
    public void attack(Card card) {

    }

    @Override
    public void beAttacked(Card card) {
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        for (Zombie zombie : game.getZombies()) {
            switch (name) {
                case ("Peashooter"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }
                case ("Snow Pea"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }

                case ("Repeater"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }
                case ("Threepeater"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }
                case ("Cactus"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }
                case ("Gatling Pea"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }
                case ("Scaredy-shroom"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }
                case ("Split Pea"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }

            }

        }
    }
}

    class throwingPlant extends Plant {
        @Override
        public void attack(Card card) {

        }

<<<<<<< HEAD
        @Override
        public void beAttacked() {

        }
=======
>>>>>>> origin/master


        public throwingPlant(String name, int clock, int numberOfBullet, int power, int sun, int rest, int life) {
            super(name, clock, sun, rest, life);
        }

        @Override
        public void action(Game game) {
            String name = this.getName();
            for (Zombie zombie : game.getZombies()) {
                switch (name) {
                    case ("Cabbage-pult"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                                peaBullet.move();
                            }
                        }
                    case ("Kernel-pult"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                                peaBullet.move();
                            }
                        }
                    case ("Melon-pult"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                                peaBullet.move();
                            }
                        }
                    case ("Winter Melon"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                                peaBullet.move();
                            }
                        }

                }
            }
        }
    }
    class MinePlant extends Plant {
        public MinePlant(String name, int cells, int sun, int rest, int life) {

            super(name, 0, sun, rest, life);
        }

        @Override
        public void attack(Card card) {

        }

        @Override
        public void beAttacked(Card card) {

        }


        @Override
        public void action(Game game) {
            String name = this.getName();
            switch (name) {
                case ("bobo"):
                    for (Zombie zombie : game.getZombies()) {
                        if (this.getXCoordinate() == zombie.getX()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }

            }
        }
    }
    class ToPlantOnPlant extends Plant {
        public ToPlantOnPlant(String name, int sun, int rest, int life) {
            super(name, 0, sun, rest, life);
        }

        @Override
        public void action(Game game) {
            String name = this.getName();
            switch (name) {
                case ("bobo"):
                    for (Zombie zombie : game.getZombies()) {
                        if (this.getXCoordinate() == zombie.getX()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                    }

            }
        }

        @Override
        public void attack(Card card) {

        }

        @Override
        public void beAttacked(Card card) {
        }


    }

    class EatablePlant extends Plant {
        public EatablePlant(String name, int sun, int rest, int life) {
            super(name, 0, sun, rest, life);
        }

        @Override
        public void action(Game game) {
            String name = this.getName();
            for (Zombie zombie : game.getZombies()) {
            switch (name) {
                case ("Explode-o-nut"):
                        if (this.getXCoordinate() == zombie.getX()) {
                            PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                            peaBullet.move();
                        }
                case ("Wall-nut"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                        peaBullet.move();
                    }
                case ("Tangle Kelp"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                        peaBullet.move();
                    }
                case ("Tall-nut"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                        peaBullet.move();
                    }
                case ("Cattail"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        PeaBullet peaBullet = new PeaBullet(this.getXCoordinate(), this.getYCoordinate());
                        peaBullet.move();
                    }
                    }

            }
        }

        @Override
        public void attack(Card card) {

        }

        @Override
        public void beAttacked(Card card) {

        }

    }


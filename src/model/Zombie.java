package model;

public abstract class Zombie extends Card {

    private static Shop shop;
    private int life;
    private int speed;
    private int attackPower;
    private int x;

    public static void setShop(Shop shop) {
        Zombie.shop = shop;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;
    Cell cell = new Cell();
    private int defense;
    private String name;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Zombie(int life, int speed, int defense, String name) {
        this.life = life;
        this.speed = speed;
        this.defense = defense;
        this.name = name;
        shop = new Shop();
    }

    public int getLife() {
        return life;
    }


    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setZombie(int x, int y) {
        this.x = x;
        this.y = y;
        cell = new Cell(x, y);
    }

    public void attack(Card card) {
        card.setLife(card.getLife() - attackPower);
    }

    public void move() {
        cell = new Cell(x + speed, y);
    }

    public abstract void action(Game game);


    static class separ {
        public int getAdditionLife() {
            return additionLife;
        }

        public void setAdditionLife(int additionLife) {
            this.additionLife = additionLife;
        }

        int additionLife;
    }


    @Override
    public String toString() {
        return   name  + ": " + life  ;
    }

    public String toStringPrime(){
        return name + ": " + life + ", " + "(" + x + "," + y + ")";
    }

}

class SwimmingZombie extends Zombie {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void action(Game game) {

    }

    public SwimmingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}

class ShieldZombie extends Zombie {

    int life;

    public ShieldZombie(int life, int speed, int defense, String name) {
        super(life, speed, defense, name);
    }

    public void addLife(int addNumber) {
        this.life = +addNumber;
    }

    @Override
    public void action(Game game) {

    }
}

class MovingZombie extends Zombie {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void action(Game game) {

    }

    public MovingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}

class GiantZombie extends Zombie {
    public GiantZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }


    @Override
    public void move() {
        super.move();
    }

    @Override
    public void action(Game game) {

    }
}


class FlyingZombie extends Zombie {
    public FlyingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void action(Game game) {

    }
}









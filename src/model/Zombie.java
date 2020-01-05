package model;

import in_game.Game;

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
    Cell cell;
    private int defense;
    private String name;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Shop getShop() {
        return shop;
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zombie(int life, int speed, int defense, String name) {
        this.life = life;
        this.speed = speed;
        this.defense = defense;
        this.name = name;
        shop = new Shop();
        this.cell = new Cell(x, y);
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
        return name + ": " + life;
    }

    public String toStringPrime() {
        return name + ": " + life + ", " + "(" + x + "," + y + ")";
    }


}








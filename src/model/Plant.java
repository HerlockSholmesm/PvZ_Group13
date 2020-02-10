package model;

import java.util.ArrayList;

import in_game.*;
import javafx.scene.image.Image;

public abstract class Plant extends Card {
    private int x;
    private int y;
    private int sun;
    private int rest;
    private int price;
    private Image image;

    public Image getImage() {
        return image;
    }

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

    public Plant(String name, int clock, int sun, int rest, int life,Image image) {
        this.name = name;
        this.sun = sun;
        this.rest = rest;
        this.life = life;
        this.clock = clock;
        suni = new Sun();
        this.image = image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    //<<<<<<< HEAD
    public void action(Game game) {
    }

    public void attack() {
    }

    @Override
    public String toString() {
        return name + ": " + sun;
    }

    public String toStringPrime() {
        return name + ": " + life + ", " + "(" + x + "," + y + ")";
    }

    abstract public Image getCardImage();
}

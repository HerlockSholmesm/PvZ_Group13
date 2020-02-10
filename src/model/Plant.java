package model;

import java.util.ArrayList;

import in_game.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public abstract class Plant extends Card {

    private int sun;
    private int rest;
    private int price;
    private Image image;
    private ImageView imageView;
    private StackPane stackPane = new StackPane();

    public StackPane getStackPane() {
        return stackPane ;
    }

    public Image getImage() {
        return image;
    }

    public void setX(int x,Yard yard) {
        double pace = x*yard.getDelta_x();
        stackPane.setTranslateX(pace);
    }
    public void setX(int x) {
        stackPane.setTranslateX(x);
    }

    public void setY(int y,Yard yard) {
        double pace = y*yard.getDelta_y();
        this.stackPane.setTranslateY(pace);
    }

    public void setY(int y) {
        this.stackPane.setTranslateY(y);
    }
    public double getXCoordinate(Yard yard) {
        double pixelX  = stackPane.getTranslateX();
        double pixelY = stackPane.getTranslateY();
        double x = yard.whichCoordinateAmI(yard, pixelX, pixelY)[0];
        return x;
    }

    public int getXCoordinate() {
        return 0;
    }
    public double getYCoordinate(Yard yard) { double pixelX  = stackPane.getTranslateX();
        double pixelY = stackPane.getTranslateY();
        double y = yard.whichCoordinateAmI(yard, pixelX, pixelY)[1];
        return y;
    }

    public int getYCoordinate() { double pixelX  = stackPane.getTranslateX();

        return 0;
    }

    public void setCoordinates(int x, int y) {
        stackPane.setTranslateX(x);
        stackPane.setTranslateY(y);
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
        super(name);
        this.name = name;
        this.sun = sun;
        this.rest = rest;
        this.life = life;
        this.clock = clock;
        suni = new Sun();
        this.image = image;
        this.imageView = new ImageView(image);
        stackPane.getChildren().add(imageView);

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
        return name + ": " + life + ", " + "(" + stackPane.getTranslateX() + "," + stackPane.getTranslateY() + ")";
    }

    abstract public Image getCardImage();
}

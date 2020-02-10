package model;

import in_game.Game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public abstract class Zombie extends Card {

    private static Shop shop;
    private int life;
    private int speed;
    private int attackPower;

    private Image image;
    private ImageView imageView;
    private StackPane stackPane = new StackPane();


    public StackPane getStackPane() {
        return stackPane ;
    }



    public void setCanmove(int canmove) {
        this.canmove = canmove;
    }

    //private int x;
    private int canmove;
    public static void setShop(Shop shop) {
        Zombie.shop = shop;
    }


    private int y;
    Cell cell;
    private int defense;
    private String name;

    public void setX(int x,DayYard yard) {
        double pace = x*yard.getDelta_x();
        stackPane.setTranslateX(pace);
    }

    public void setX(int x) {
        stackPane.setTranslateX(x);
    }
    public void setY(int y,DayYard yard) {
        double pace = y*yard.getDelta_y();
        this.stackPane.setTranslateY(pace);
    }

    public void setY(int y) {
        this.stackPane.setTranslateY(y);
    }
    public double getX(Yard yard) {
        double pixelX  = stackPane.getTranslateX();
        double pixelY = stackPane.getTranslateY();
        double x = yard.whichCoordinateAmI(yard, pixelX, pixelY)[0];
        return x;
    }

    public double getX() {

        return 0;
    }
    public double getY(Yard yard) { double pixelX  = stackPane.getTranslateX();
        double pixelY = stackPane.getTranslateY();
        double y = yard.whichCoordinateAmI(yard, pixelX, pixelY)[1];
        return y;
    }

    public double getY() {
        return 0;
    }


    public static Shop getShop() {
        return shop;
    }

    public Image getImage() {
        return image;
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

    public Zombie(int life, int speed, int defense, String name,Image image) {
        super(name);
        this.life = life;
        this.speed = speed;
        this.defense = defense;
        this.name = name;
        shop = new Shop();
      //  this.cell = new Cell(x, y);
        canmove=0;
        this.image = image;
        this.imageView = new ImageView(image);
        stackPane.getChildren().add(imageView);

    }

    public void setImage(Image image) {
        this.image = image;
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



    public void attack(Card card) {
        card.setLife(card.getLife() - attackPower);
    }

    public void move() {
        this.setX(speed);
    }
    public void move(DayYard dayYard){
        this.setX(speed, dayYard);
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
        return name + ": " + life + ", " + "(" + stackPane.getTranslateX() + "," + stackPane.getTranslateY() + ")";
    }


}








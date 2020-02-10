package model;

import in_game.DynamicDay;
import in_game.Game;
import in_game.GameDay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Chamanzan {
    public static final int SPEED = 3;
    boolean used;
    private int whichRow;
    private Yard yard;
    private Image image;
    private int x;
    private int y;
    private ImageView imageView;
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public Chamanzan( Yard yard) {
        this.yard = yard;
        used = false;
        this.image = new Image("png/lawn_mower.gif");
        this.imageView = new ImageView(image);
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean dead = false;

    public boolean isDead() {
        return dead;
    }

    public void setDead() {
        this.dead = true;
    }

    public int getWhichRow() {
        return whichRow;
    }

    public void setWhichRow(int whichRow) {
        this.whichRow = whichRow;
    }



    public Yard getYard() {
        return yard;
    }

    public void setYard(Yard yard) {
        this.yard = yard;
    }

    public int getWhichCell() {
        return whichRow;
    }

    public void setWhichCell(int whichCell) {
        this.whichRow = whichCell;
    }


    public void action(Game game){
        if (!used) {
            boolean toUse = true;
            for(Plant plant:game.getPlants()){
                if(plant.getYCoordinate(game.getYard()) == DayYard.whichCoordinateAmI(new DayYard((GameDay)game), this.getX(), this.getY())[1]){
                    toUse = false;
                    break;
                }
            }
            int flag = 0;
            if (toUse){
                for (Zombie zombie : game.getZombies()) {
                    if ((this.getX() >= zombie.getX(game.getYard()) - 15 && (zombie.getY(game.getYard()) - this.getY() <= 10 || this.getY() - zombie.getY(game.getYard())  <= 10))) {
                        flag++;
                        break;
                    }
                }
                if (flag > 0){
                    this.setUsed(true);
                    this.setX(this.getX() + DayYard.getDelta_x());
                }
            }
            if (this.getX() >= 19*DayYard.getDelta_x()){
                this.setDead();
            }
        }
        }

    }


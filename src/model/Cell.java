package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cell {
    private boolean dryness;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean hasImage = false;
    private Image starImage = new Image("/png/star.png");
    private ImageView starImageView = new ImageView(starImage);
    private StackPane stackPane = new StackPane();

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage() {
        stackPane.getChildren().add(starImageView);
        this.hasImage = true;
    }

    public void removeImage(){
        stackPane.getChildren().remove(starImageView);
        this.hasImage = false;
    }

    public Cell(boolean dry, int x1, int x2, int y1, int y2) {
        this.dryness = dry;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public boolean isDryness() {
        return dryness;
    }

    public void setDryness(boolean dryness) {
        this.dryness = dryness;
    }




}

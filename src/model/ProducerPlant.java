package model;

import in_game.Game;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProducerPlant extends Plant {

    private boolean hasStar = false;
    private Image starImage;
    private ImageView starImageView;



    public boolean isHasStar() {
        return hasStar;
    }

    public void setHasStar() {
        this.getStackPane().getChildren().add(starImageView);
        this.hasStar = true;

    }

    public void removeStar(){
        this.getStackPane().getChildren().remove(starImageView);
        this.hasStar = false;
    }

    public ProducerPlant(String name, int clock, int numberOfSun, int sun, int rest, int life, Image image) {

        super(name, clock, sun, rest, life,image);
        starImage = new Image("/png/star.png");
        starImageView = new ImageView(starImage);

    }


    public ProducerPlant(String name, int clock, int numberOfSun, int sun, int rest, int life, Image image, Group root) {

        super(name, clock, sun, rest, life,image);
        starImage = new Image("/png/star.png");
        starImageView = new ImageView(starImage);
        root.getChildren().add(this.getImageView());

    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        switch (name) {
            case ("Sunflower"):
                if (game.getTurn() >= this.getClock()) {
                    game.setSun(game.getSun().getSunStore() + 1);
                }
            case ("Twin Sunflower"):
                if (game.getTurn() >= this.getClock()) {
                    game.setSun(game.getSun().getSunStore() + 2);
                }


        }
    }

    @Override
    public Image getCardImage() {
        String name = this.getName();
        switch (name) {
            case ("Sunflower"):
                return new Image("Plants vs Zombies/Sunflower/Tallnut_cracked1.webp");
            case ("Twin Sunflower"):
                return new Image("Plants vs Zombies/Twin Sunflower/Twin_Sunfower_Seed.webp");
            default:
                return null;
        }
    }
}

package model;

import in_game.Game;
import javafx.scene.image.Image;

public class ToPlantOnPlant extends Plant {
    public ToPlantOnPlant(String name, int sun, int rest, int life, Image image) {
        super(name, 0, sun, rest, life, image);
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        switch (name) {
            case ("bobo"):
                //todo yoplantOnPlant
        }

    }

    @Override
    public Image getCardImage() {
        return null;
    }
}


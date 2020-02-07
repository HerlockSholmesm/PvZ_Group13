package model;

import in_game.Game;
import javafx.scene.image.Image;

public class ProducerPlant extends Plant {

    public ProducerPlant(String name, int clock, int numberOfSun, int sun, int rest, int life, Image image) {

        super(name, clock, sun, rest, life,image);
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
}

package model;

import in_game.Game;

public class ProducerPlant extends Plant {

    public ProducerPlant(String name, int clock, int sun, int rest, int life) {

        super(name, clock, sun, rest, life);
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

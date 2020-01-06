package model;

import in_game.Game;

public class ToPlantOnPlant extends Plant {
    public ToPlantOnPlant(String name, int sun, int rest, int life) {
        super(name, 0, sun, rest, life);
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        switch (name) {
            case ("bobo"):
                //todo
        }

    }
}


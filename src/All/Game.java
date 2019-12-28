package All;

import Model.Plant;
import Model.Yard;
import Model.Zombie;

import java.util.ArrayList;

public abstract class Game {
    boolean turn;
    Yard yard;
    ArrayList<Zombie> zombies;
    ArrayList<Plant> plants;

    void runGame() {
    }

    void hasGameEnded() {
    }

    void saveGame() {
    }

    void playerPlays() {
    }
}


class DayTypeGame extends Game {

    public PlayerDay player;



}

class WaterTypeGame extends DayTypeGame {

}

class RailTypeGame extends Game {
    public RailPlayer player;
    public void isGameFinished(){};

}

class ZombieTypeGame extends Game {
    public ZombiePlayer player = new ZombiePlayer();

}

class TwoAccountTypeGame extends Game {
    public Player player1;
    public Player player2;

}

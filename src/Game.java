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
    Account player;


}

class WaterTypeGame extends Game {

}

class RailTypeGame extends Game {


}

class ZombieTypeGame extends Game {

}

class TwoAccountTypeGame extends Game {
    Account firstPlayer;
    Account secondPlayer;
}

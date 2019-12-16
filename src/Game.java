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
    public DynamicDay dynamicDay = new DynamicDay();



}

class WaterTypeGame extends DayTypeGame {

}

class RailTypeGame extends Game {
    public RailPlayer player;
    public DynamicRail dynamicRail;
    public void isGameFinished(){};

}

class ZombieTypeGame extends Game {
    public ZombiePlayer player = new ZombiePlayer();
    public DynamicZombieMode dynamicZombieMode = new DynamicZombieMode();

}

class TwoAccountTypeGame extends Game {
    public Player player1;
    public Player player2;
    public DynamicPVP dynamicPVP;
}
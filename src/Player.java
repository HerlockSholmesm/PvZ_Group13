import java.util.ArrayList;

public abstract class Player {
    Account account;
    ArrayList<Coin> coin = new ArrayList<Coin>();
    ArrayList<Card> card = new ArrayList<Card>();

}


class PlayerDay extends Player{
    ArrayList<Plant> plants = new ArrayList<Plant>();

}

class RailPlayer extends Player{
    ArrayList<Plant> plants = new ArrayList<Plant>();
    int points;

}


class ZombiePlayer extends Player {
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();

}


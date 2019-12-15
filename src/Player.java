import java.util.ArrayList;

public abstract class Player {
    Account account;
    protected Coin coin;
    protected ArrayList<Card> cards ;

    public Coin getCoin() {
        return coin;
    }

    public ArrayList<Card> getCard() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
}


class PlayerDay extends Player{
    ArrayList<Plant> plants = new ArrayList<Plant>();
    private final int validNumOfPlants = 7;
    private final int validNumOfCards = 7;
    private Sun suns ;//must init with 2

    public PlayerDay(String name,String password,ArrayList<Card> cards, int numOfSuns) {
        this.plants.add(new shootingPlant(2,2 ,2,""));
        this.plants.add(new shootingPlant(3, 3, 2, ""));

        this.suns = new Sun(numOfSuns);
        this.cards = cards;
        coin.setCoinInTheGame(0);
        coin.setCoinOutOfTheGame(0);
        this.account = new Account(name, password);
    }

    public void addSuns(int s) {
        int currentSuns = this.suns.getSunStore();
        this.suns.setSunStore(s - currentSuns);
    }

    public int getSuns() {
        return suns.getSunStore();
    }
}

class RailPlayer extends Player{
    ArrayList<Plant> plants = new ArrayList<Plant>();
    int points;

}


class ZombiePlayer extends Player {
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();

}


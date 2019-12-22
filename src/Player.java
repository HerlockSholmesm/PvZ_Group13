import java.util.ArrayList;

public abstract class Player {
    Account account;
    protected Coin coin;
    protected ArrayList<Card> cards = new ArrayList<>();


    public Coin getCoin() {
        return coin;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
    public void removeCard(Card card){ this.cards.remove(card);}
}


class PlayerDay extends Player {
    ArrayList<Plant> plants = new ArrayList<Plant>();
    private final int validNumOfPlants = 7;
    private final int validNumOfCards = 7;
    private Sun suns;//must init with 2

    public int getValidNumOfPlants() {
        return validNumOfPlants;
    }

    public int getValidNumOfCards() {
        return validNumOfCards;
    }

    public int getNumOfPlants() {
        return plants.size();
    }

    public PlayerDay(String name, String password, ArrayList<Card> cards) {
        this.plants.add(new shootingPlant(2, 2, 2, "Peashooter"));
        this.plants.add(new shootingPlant(3, 3, 2, "Snow pea"));
        this.plants.add(new MinePlant(4, 5, 3, "Explode-o-nut"));
        this.plants.add(new shootingPlant(1, 2, 1, "Scaredy-shroom"));
        this.plants.add(new MinePlant(2, 4, 0, "Cherry Bomb"));
        this.plants.add(new shootingPlant(3, 3, 2, "Kernel-pult"));
        this.plants.add(new ProducerPlant(1, 2, 2, "Sunflower"));
        this.suns = new Sun(2);
        this.cards = cards;
        coin.setCoinInTheGame(0);
        coin.setCoinOutOfTheGame(0);
        this.account = new Account(name, password);
    }
    public void addPlant(Plant plant){
        this.plants.add(plant);
    }
    public void removePlant(Plant plant){
        this.plants.remove(plant);
    }
    public ArrayList<Plant> getPlants(){
        return this.plants;
    }

    public void addSuns(int s) {
        int currentSuns = this.suns.getSunStore();
        this.suns.setSunStore(s - currentSuns);
    }

    public int getSuns() {
        return suns.getSunStore();
    }
}

class RailPlayer extends Player {
    ArrayList<Plant> plants = new ArrayList<Plant>();
    int points;

}


class ZombiePlayer extends Player {
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();

}

/**
 * Commands:
 */





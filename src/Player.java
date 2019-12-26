import Model.Card;
import Model.Coin;

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
    private ArrayList<Plant> plants = new ArrayList<Plant>();
    private final int validNumOfPlants = 7;
    private final int validNumOfCards = 7;
    private Sun suns;//must init with 2
    private int wavesOfAttack;
    private int turn;
    private ArrayList<Zombie> zombies;

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public int getTurn() {
        return turn;
    }

    public void addTurn() {
        turn++;
    }

    public int getWavesOfAttack() {
        return wavesOfAttack;
    }

    public void decreaseWaveOfAttack(){
        wavesOfAttack--;
    }

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
        this.plants.add(new shootingPlant("Peashooter",2, 2, 2 ));
        this.plants.add(new shootingPlant("Snow pea",3, 3, 3 ));
        this.plants.add(new MinePlant("Explode-o-nut",4, 5, 3));
        this.plants.add(new shootingPlant("Scaredy-shroom",1, 2, 1 ));
        this.plants.add(new MinePlant("Cherry Bomb",2, 4, 0));
        this.plants.add(new throwingPlant("Kernel-pult",3, 3, 2 ));
        this.plants.add(new ProducerPlant("Sunflower",1, 2, 2 ));
        this.suns = new Sun(2);
        this.cards = cards;
        coin.setCoinInTheGame(0);
        coin.setCoinOutOfTheGame(0);
        this.account = new Account(name, password);
        wavesOfAttack = 3;
        turn = 0;
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





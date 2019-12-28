package All;

import Model.*;

import java.util.ArrayList;

public abstract class Player {
    protected int turn;
    protected ArrayList<Plant> plants = new ArrayList<Plant>();
    protected ArrayList<Zombie> zombies = new ArrayList<>();
    Account account;
    protected Coin coin = new Coin(0, 0);
    protected ArrayList<Card> cards = new ArrayList<>();
    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
    public int getTurn() {
        return turn;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public void addTurn() {
        turn++;
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
    private final int VALID_NUM_OF_PLANTS = 7;
    private final int VALID_NUM_OF_CARDS = 7;
    private Sun suns;//must init with 2
    private int wavesOfAttack;


    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }


    public int getWavesOfAttack() {
        return wavesOfAttack;
    }

    public void decreaseWaveOfAttack(){
        wavesOfAttack--;
    }

    public int getValidNumOfPlants() {
        return VALID_NUM_OF_PLANTS;
    }

    public int getValidNumOfCards() {
        return VALID_NUM_OF_CARDS;
    }

    public int getNumOfPlants() {
        return plants.size();
    }

    public PlayerDay(String name, String password) {
        this.cards.add(Shop.getAllPlants().get(0));
        this.cards.add(Shop.getAllPlants().get(1));
        this.cards.add(Shop.getAllPlants().get(10));
        this.cards.add(Shop.getAllPlants().get(7));
        this.cards.add(Shop.getAllPlants().get(19));
        this.cards.add(Shop.getAllPlants().get(8));
        this.cards.add(Shop.getAllPlants().get(21));
        this.suns = new Sun(2);
        this.account = new Account(name, password);
        wavesOfAttack = 3;
        turn = 0;
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
    private int points;
    private final int MAX_NUMBER_OF_CARDS = 10;

    public RailPlayer(ArrayList<Card> cards,String name,String password){
        this.plants.addAll(Shop.getCollectionPlant());
        this.cards = cards;
        this.account = new Account(name, password);
        turn = 0;
        points = 0;
    }

    public void pointAdder(){
        points++;
    }

    public void removeZombie(Zombie zombie){
        zombies.remove(zombie);
    }

    public int getPoints() {
        return points;
    }

    public int getMAX_NUMBER_OF_CARDS() {
        return MAX_NUMBER_OF_CARDS;
    }


}


class ZombiePlayer extends Player {
    public ZombiePlayer(){
        this.coin = new Coin(50, 0);
        this.cards.add(Shop.getZombies().get(0));
        this.cards.add(Shop.getZombies().get(1));
        this.cards.add(Shop.getZombies().get(10));
        this.cards.add(Shop.getZombies().get(4));
        this.cards.add(Shop.getZombies().get(7));
        this.cards.add(Shop.getZombies().get(6));
        this.cards.add(Shop.getZombies().get(3));
        ArrayList<Integer> Xcoordinates = new ArrayList<>();
        ArrayList<Integer> Ycoordinates = new ArrayList<>();
        for (int i = 0;i < 16;i++){
            Xcoordinates.add(MathFunctions.getRandomNumber(0, 2));
            Ycoordinates.add(MathFunctions.getRandomNumber(0,5));
        }
        this.plants.add(Shop.getAllPlants().get(10));
        plants.get(0).setCoordinates(Xcoordinates.get(0),Ycoordinates.get(0));
        this.plants.add(Shop.getAllPlants().get(10));
        plants.get(1).setCoordinates(Xcoordinates.get(1),Ycoordinates.get(1));
        this.plants.add(Shop.getAllPlants().get(10));
        plants.get(2).setCoordinates(Xcoordinates.get(2),Ycoordinates.get(2));
        this.plants.add(Shop.getAllPlants().get(7));
        plants.get(3).setCoordinates(Xcoordinates.get(3),Ycoordinates.get(3));
        this.plants.add(Shop.getAllPlants().get(7));
        plants.get(4).setCoordinates(Xcoordinates.get(4),Ycoordinates.get(4));
        this.plants.add(Shop.getAllPlants().get(7));
        plants.get(5).setCoordinates(Xcoordinates.get(5),Ycoordinates.get(5));
        this.plants.add(Shop.getAllPlants().get(7));
        plants.get(6).setCoordinates(Xcoordinates.get(6),Ycoordinates.get(6));
        this.plants.add(Shop.getAllPlants().get(7));
        plants.get(7).setCoordinates(Xcoordinates.get(7),Ycoordinates.get(7));
        this.plants.add(Shop.getAllPlants().get(7));
        plants.get(8).setCoordinates(Xcoordinates.get(8),Ycoordinates.get(8));
        this.plants.add(Shop.getAllPlants().get(1));
        plants.get(9).setCoordinates(Xcoordinates.get(9),Ycoordinates.get(9));
        this.plants.add(Shop.getAllPlants().get(1));
        plants.get(10).setCoordinates(Xcoordinates.get(10),Ycoordinates.get(10));
        this.plants.add(Shop.getAllPlants().get(2));
        plants.get(11).setCoordinates(Xcoordinates.get(11),Ycoordinates.get(11));
        this.plants.add(Shop.getAllPlants().get(2));
        plants.get(12).setCoordinates(Xcoordinates.get(12),Ycoordinates.get(12));
        this.plants.add(Shop.getAllPlants().get(4));
        plants.get(13).setCoordinates(Xcoordinates.get(13),Ycoordinates.get(13));
        this.plants.add(Shop.getAllPlants().get(6));
        plants.get(14).setCoordinates(Xcoordinates.get(14),Ycoordinates.get(14));
        this.plants.add(Shop.getAllPlants().get(18));
        plants.get(15).setCoordinates(Xcoordinates.get(15),Ycoordinates.get(15));

    }
    public void addZombie(Zombie zombie){
        zombies.add(zombie);
    }

}





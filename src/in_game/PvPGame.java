package in_game;

import model.Card;
import model.Coin;
import model.Shop;
import model.Sun;

import java.util.ArrayList;

public class PvPGame extends Game {
    /**
     * Constructor:
     *
     * @param name
     * @param password
     */
    public PvPGame(String name, String password,int totalWaves) {
        super(name, password);
        suns = new Sun(2);
        this.plantCads.add(Shop.getAllPlants().get(0));
        this.plantCads.add(Shop.getAllPlants().get(1));
        this.plantCads.add(Shop.getAllPlants().get(10));
        this.plantCads.add(Shop.getAllPlants().get(7));
        this.plantCads.add(Shop.getAllPlants().get(19));
        this.plantCads.add(Shop.getAllPlants().get(8));
        this.plantCads.add(Shop.getAllPlants().get(21));

        this.zombieCards.add(Shop.getZombies().get(0));
        this.zombieCards.add(Shop.getZombies().get(1));
        this.zombieCards.add(Shop.getZombies().get(10));
        this.zombieCards.add(Shop.getZombies().get(4));
        this.zombieCards.add(Shop.getZombies().get(7));
        this.zombieCards.add(Shop.getZombies().get(6));
        this.zombieCards.add(Shop.getZombies().get(3));
        this.coin = new Coin(50, 0);

        this.totalWaves = totalWaves;
    }


    private int totalWaves;
    private Sun suns;//must init with 2

    public int getSuns() {
        return suns.getSunStore();
    }

    public void addSuns(int s) {
        this.suns.setSunStore(s + suns.getSunStore());
    }

    public int getTotalWaves() {
        return totalWaves;
    }

    private ArrayList<Card> zombieCards = new ArrayList<>();
    private ArrayList<Card> plantCads = new ArrayList<>();

    public ArrayList<Card> getZombieCards() {
        return zombieCards;
    }

    public ArrayList<Card> getPlantCads() {
        return plantCads;
    }

    public void setZombieCards(ArrayList<Card> zombieCards) {
        this.zombieCards = zombieCards;
    }

    public void setPlantCads(ArrayList<Card> plantCads) {
        this.plantCads = plantCads;
    }
}

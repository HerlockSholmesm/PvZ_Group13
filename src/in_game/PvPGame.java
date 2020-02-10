package in_game;

import model.*;

import java.util.ArrayList;

public class PvPGame extends Game {
    private Coin coin;
    /**
     * Constructor:
     *
     * @param name
     * @param password
     */
    private GamePvPCondition gamePvPCondition = GamePvPCondition.PLAYING;

    public GamePvPCondition getGamePvPCondition() {
        return gamePvPCondition;
    }


    private ArrayList<Chamanzan> chamanzans = new ArrayList<>();

    public ArrayList<Chamanzan> getChamanzans() {
        return chamanzans;
    }

    public void setGamePvPCondition(GamePvPCondition gamePvPCondition) {
        this.gamePvPCondition = gamePvPCondition;
    }

    protected Coin zombieCoin = new Coin(50,0);
    protected Coin plantCoin = new Coin(0, 0);

    public Coin getZombieCoin() {
        return zombieCoin;
    }

    public Coin getPlantCoin() {
        return plantCoin;
    }
    public void addZombieCoin(int c){
        zombieCoin.setCoinInTheGame(zombieCoin.getCoinInTheGame() + c);
    }

    private int plantWins = 0;
    private int zombieWins = 0;

    public int getPlantWins() {
        return plantWins;
    }

    public int getZombieWins() {
        return zombieWins;
    }

    public void addPlantWins(){
        plantWins++;
    }

    public void addZombieWins(){
        zombieWins++;
    }

    private boolean start = false;

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    private boolean ready = false;

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public PvPGame(String name, String password, int totalWaves) {
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

        this.chamanzans.add(new Chamanzan(  this.yard));
        this.chamanzans.add(new Chamanzan(  this.yard));
        this.chamanzans.add(new Chamanzan(  this.yard));
        this.chamanzans.add(new Chamanzan( this.yard));
        this.chamanzans.add(new Chamanzan(  this.yard));
        this.chamanzans.add(new Chamanzan(  this.yard));


    }


    private GamePvPCondition waveCondition = GamePvPCondition.PLAYING;
    private int waveCounter = 0;
    private int totalWaves;
    private Sun suns;//must init with 2

    public GamePvPCondition getWaveCondition() {
        return waveCondition;
    }

    public void setWaveCondition(GamePvPCondition waveCondition) {
        this.waveCondition = waveCondition;
    }

    public int getWaveCounter() {
        return waveCounter;
    }

    public void waveAdder(){
        waveCounter++;
    }

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

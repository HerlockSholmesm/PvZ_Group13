package in_game;

import model.*;

import java.util.ArrayList;

public class Game {


    private ArrayList<ThrowingThing> ThrowingThings= new ArrayList<ThrowingThing>();

    private Sun sun;

    protected ArrayList<Plant> plants = new ArrayList<Plant>();

    ArrayList<Card> cards = new ArrayList<>();

    protected int turn;

    Account account;

    protected Coin coin = new Coin(0, 0);

    protected ArrayList<Zombie> zombies = new ArrayList<>();

    protected Yard yard;

    public ArrayList<PeaBullet> getPeaBullets() {
        ArrayList<PeaBullet> peaBullets = new ArrayList<>();
        for(int i = 0; i < plants.size(); i++){
            peaBullets.add(plants.get(i).getPea)
        }

        return peaBullets;
    }

    public void setPeaBullets(ArrayList<PeaBullet> peaBullets) {
        this.peaBullets = peaBullets;
    }


    public ArrayList<ThrowingThing> getThrowingThings() {
        return ThrowingThings;
    }

    public void setThrowingThings(int xCoordinate, int yCoordinate,int power,Game game) {
        ThrowingThing throwingThing= new ThrowingThing(xCoordinate,yCoordinate);
        this.getThrowingThings().add(new ThrowingThing(xCoordinate,yCoordinate));
        throwingThing.action(game,power);
    }

    public void setPeaBullets(int xCoordinate, int yCoordinate,Game game) {
        PeaBullet peaBullet= new PeaBullet(xCoordinate,yCoordinate);
        this.peaBullets.add(new PeaBullet(xCoordinate,yCoordinate));
        peaBullet.action(game);
    }
    public void setPeaBulletsNegetive(int xCoordinate, int yCoordinate,Game game) {
        PeaBullet peaBullet= new PeaBullet(xCoordinate,yCoordinate);
        this.peaBullets.add(new PeaBullet(xCoordinate,yCoordinate));
        peaBullet.actionNegetive(game);
    }

    public void removePlant(Plant plant) {
        this.plants.remove(plant);
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public ArrayList<Plant> getPlants() {
        return this.plants;
    }

    public Sun getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun.setSunStore(sun);
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public void addZombie(Zombie zombie){
        zombies.add(zombie);
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void addCoin(int C) {
        this.coin.setCoinInTheGame(this.coin.getCoinInTheGame() + C);
    }

    public Coin getCoin() {
        return coin;
    }

    public Game(String name, String password) {
        this.account = new Account(name, password);
        setTurn(0);
    }


    public int getTurn() {
        return turn;
    }

    public void addTurn() {
        turn++;
    }


    public Yard getYard() {
        return yard;
    }

    public void setYard(Yard yard) {
        this.yard = yard;
    }



}


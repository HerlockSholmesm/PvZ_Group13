package in_game;

import commands.print;
import model.*;

import javax.xml.namespace.QName;
import java.security.PublicKey;
import java.util.ArrayList;

public class Game {
    //<<<<<<< HEAD
    public ArrayList<PeaBullet> getPeaBullets() {
        return peaBullets;
    }

    public void setPeaBullets(ArrayList<PeaBullet> peaBullets) {
        this.peaBullets = peaBullets;
    }

    private ArrayList<PeaBullet> peaBullets = new ArrayList<PeaBullet>();
    private Sun sun;
    protected ArrayList<Plant> plants = new ArrayList<Plant>();
    protected ArrayList<Card> cards = new ArrayList<>();

    public void removePlant(Plant plant) {
        this.plants.remove(plant);
    }

    protected int turn;
    Account account;
    protected Coin coin = new Coin(0, 0);
    protected ArrayList<Zombie> zombies = new ArrayList<>();

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
//=======
//>>>>>>> origin/master


    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
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


    Yard yard;

    public Yard getYard() {
        return yard;
    }

    public void setYard(Yard yard) {
        this.yard = yard;
    }


    public void setPeaBullets(int xCoordinate, int yCoordinate) {
       PeaBullet peaBullet= new PeaBullet(xCoordinate,yCoordinate);
        this.peaBullets.add(new PeaBullet(xCoordinate,yCoordinate));
        peaBullet.move();
    }
}


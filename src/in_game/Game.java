package in_game;

import commands.print;
import model.*;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public abstract class Game {

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

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

    /**Plant related fields and functions:*/
    protected ArrayList<Plant> plants = new ArrayList<Plant>();

    Yard yard;

    public Yard getYard() {
        return yard;
    }

    public void setYard(Yard yard) {
        this.yard = yard;
    }

    public void removePlant(Plant plant){
        this.plants.remove(plant);
    }

    public void addPlant(Plant plant){
        this.plants.add(plant);
    }

    public ArrayList<Plant> getPlants(){
        return this.plants;
    }


    /**Card related fields and functions:*/
    protected ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
    public void removeCard(Card card){ this.cards.remove(card);}


    /**Zombie related fields and functions*/
    protected ArrayList<Zombie> zombies = new ArrayList<>();

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    /**Coin related fields and functions*/
    protected Coin coin = new Coin(0, 0);

    public void addCoin(int C) {
        this.coin.setCoinInTheGame(this.coin.getCoinInTheGame()+C);
    }

    public Coin getCoin() {
        return coin;
    }



    /**Constructor:*/
    public Game(String name, String password) {
        this.account = new Account(name, password);
    }


    protected int turn;
    Account account;

    public int getTurn() {
        return turn;
    }

    public void addTurn() {
        turn++;
    }


}


package in_game;

import model.Chamanzan;
import model.Shop;
import model.Sun;
import model.Zombie;

import java.util.ArrayList;

public class GameDay extends Game {
    public ArrayList<Chamanzan> chamanzans = new ArrayList<>(5);
    public static GameDay game;

    public static GameDay getGame() {
        return game;
    }

    private GameCondition gameCondition = GameCondition.PLAYING;

    public GameCondition getGameCondition() {
        return gameCondition;
    }

    private int turnLastZombieKilled = 0;

    private int wavesOfAttack;

    private int turnServed = 0;

    private Sun suns;//must init with 2

    public ArrayList<Chamanzan> getChamanzans() {
        return chamanzans;
    }

    public void setGameCondition(GameCondition gameCondition) {
        this.gameCondition = gameCondition;
    }


    public int getTurnLastZombieKilled() {
        return turnLastZombieKilled;
    }

    public void setTurnLastZombieKilled(int turnLastZombieKilled) {
        this.turnLastZombieKilled = turnLastZombieKilled;
    }
    /**Handling suns:*/

    public void addSuns(int s) {
        int currentSuns = this.suns.getSunStore();
        this.suns.setSunStore(s - currentSuns);
    }

    public int getSuns() {
        return suns.getSunStore();
    }

    public int getTurnServed() {
        return turnServed;
    }

    public void setTurnServed(int turnServed) {
        this.turnServed = turnServed;
    }

    /**Handling Zombies:*/
    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    /**Handling waves:*/

    public int getWavesOfAttack() {
        return wavesOfAttack;
    }


    public GameDay(String name, String password) {
        super(name, password);
        this.chamanzans.add(new Chamanzan( this.yard));
        this.chamanzans.add(new Chamanzan( this.yard));
        this.chamanzans.add(new Chamanzan( this.yard));
        this.chamanzans.add(new Chamanzan( this.yard));
        this.chamanzans.add(new Chamanzan(  this.yard));
        this.chamanzans.add(new Chamanzan(this.yard));

        this.cards.add(Shop.getAllPlants().get(0));
        this.cards.add(Shop.getAllPlants().get(1));
        this.cards.add(Shop.getAllPlants().get(10));
        this.cards.add(Shop.getAllPlants().get(7));
        this.cards.add(Shop.getAllPlants().get(19));
        this.cards.add(Shop.getAllPlants().get(8));
        this.cards.add(Shop.getAllPlants().get(21));
        this.suns = new Sun(2);
        wavesOfAttack = 3;
        turn = 0;
        game = this;
    }

}

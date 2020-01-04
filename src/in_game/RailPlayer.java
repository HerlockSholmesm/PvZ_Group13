package in_game;

import model.Card;
import model.Shop;
import model.Zombie;

import java.util.ArrayList;

public class RailPlayer extends Player {

    public RailPlayer(ArrayList<Card> cards, String name, String password){
        super(name,password);
        this.plants.addAll(Shop.getCollectionPlant());
        this.cards = cards;
        this.account = new Account(name, password);
        turn = 0;
        points = 0;
    }

    /**Handling points:*/
    private int points;

    public void pointAdder(){
        points++;
    }

    public int getPoints() {
        return points;
    }


    public void removeZombie(Zombie zombie){
        zombies.remove(zombie);
    }


    public int getMAX_NUMBER_OF_CARDS() {
        return 10;
    }


}



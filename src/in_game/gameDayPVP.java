package in_game;

import model.Card;
import model.Sun;

import java.util.ArrayList;

public class gameDayPVP extends Game {

    private Sun suns;//must init with 2

    private int numOfPlantsWins = 0;

    public int getNumOfWins() {
        return numOfPlantsWins;
    }

    public void addNumOfWins() {
        this.numOfPlantsWins++;
    }

    public gameDayPVP(ArrayList<Card> cards, String name, String password) {
        super(name, password);
        this.cards = cards;
        suns = new Sun(2);

    }

    public void addSuns(int s) {
        int currentSuns = this.suns.getSunStore();
        this.suns.setSunStore(s - currentSuns);
    }
    public int getSuns() {
        return suns.getSunStore();
    }



}

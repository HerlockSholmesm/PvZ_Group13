package in_game;

import model.Card;

import java.util.ArrayList;

public class ZombieGamePVP extends Game {

    public ZombieGamePVP(ArrayList<Card> cards, String name, String password) {
        super(name, password);
        this.cards = cards;
    }



}
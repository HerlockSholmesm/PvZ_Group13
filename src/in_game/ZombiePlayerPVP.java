package in_game;

import model.Card;

import java.util.ArrayList;

public class ZombiePlayerPVP extends Player{

    public ZombiePlayerPVP(ArrayList<Card> cards, String name, String password) {
        super(name, password);
        this.cards = cards;
    }



}
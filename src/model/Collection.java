package model;

import java.util.ArrayList;

public class Collection {
    private  ArrayList<Card> hand;
    private static ArrayList<Card> baughtCards;
    private static ArrayList<Card> notBaughtCards;

    public static ArrayList<Card> getBaughtCards() {
        return baughtCards;
    }

    public static void setBaughtCards(ArrayList<Card> baughtCards) {
        Collection.baughtCards = baughtCards;
    }

    public  ArrayList<Card> getNotBaughtCards() {
        return notBaughtCards;
    }

    public static void setNotBaughtCards(ArrayList<Card> notBaughtCards) {
        Collection.notBaughtCards = notBaughtCards;
    }

    public void setCollection(ArrayList<Card> collection) {
        this.collection = collection;
    }

    private ArrayList<Card> collection;
    private Shop shop;

    public Collection() {

    }

    public  ArrayList<Card> getHand() {
        return hand;
    }

    public void showHand() {
        for (Card card:hand) {
            System.out.println(card.getName());
        }
    }

    public void showCollection() {
        for (Card card:collection) {
            System.out.println(card.getName());
        }
    }
    public void addToHand(String name) {
        ArrayList<Card> cards=shop.getCards();
        for (Card card :shop.getCards()) {
            if(card.getName().equals(name)){
                hand.add(card);
            }
            else {
                System.out.println("invalid name");
            }
        }
    }

    public ArrayList<Card> getCollection() {
       return shop.getCollection();
    }

    public Collection(Shop shop) {
      this.shop=shop;
    }
}

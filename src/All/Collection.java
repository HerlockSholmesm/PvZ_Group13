package All;

import Model.Card;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> hand;
    private ArrayList<Card> collection;
    private Shop shop;

    public Collection() {

    }

    public ArrayList<Card> showHand() {
        return hand;
    }

    public void addToHand(String name) {
        ArrayList<Card> cards=shop.getCards();
        for (Card card :shop.getCards()) {
            if(card.getName().equals(name)){
                hand.add(card);
            }
        }
    }

    public ArrayList<Card> showCollection() {
       return shop.getCollection();
    }

    public Collection(Shop shop) {
      this.shop=shop;
    }
}

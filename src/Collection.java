import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> hand;
    private ArrayList<Card> collection;

    public ArrayList<Card> showHand() {
        return hand;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> showCollection() {
        return collection;
    }

    public void setCollection(ArrayList<Card> collection) {
        this.collection = collection;
    }

    public Collection() {
      //  collection.add( Plant Peashooter)
    }
}

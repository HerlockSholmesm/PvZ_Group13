
public abstract class Card {
    private String name;
    private int price;
    private boolean select;
    public Card() {
    }
    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isSelect() {
        return select;
    }

    public String getName() {
        return name;
    }
}

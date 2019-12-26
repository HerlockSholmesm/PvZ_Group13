package Model;

public abstract class Card {
    private String name;
    private int price;
    private boolean select;
    private int life;

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

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }
}

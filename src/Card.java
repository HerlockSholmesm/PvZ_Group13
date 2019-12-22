public class Card extends Plant {
    private String name;
    private boolean select;

    public Card(int sun, int rest, int life, String comment) {
        super(sun, rest, life, comment);
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

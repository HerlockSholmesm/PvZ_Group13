public class Zombie {

    private int life;
    private int speed;
    private String comment;
    private int x;
    private int y;
    Cell cell = new Cell();

    public Zombie(int life, int speed, String comment) {
        this.life = life;
        this.speed = speed;
        this.comment = comment;
    }
}

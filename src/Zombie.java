public class Zombie {

    private int life;
    private int speed;
    private String comment;
    private int x;
    private int y;
    Cell cell = new Cell();

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Zombie(int life, int speed, String comment) {
        this.life = life;
        this.speed = speed;
        this.comment = comment;
    }
}

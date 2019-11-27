public class Plant {

    private int sun;
    private int rest;
    private int life;
    private String comment;
    private int speed;

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Plant(int sun, int rest, int life, String comment) {
        this.sun = sun;
        this.rest = rest;
        this.life = life;
        this.comment = comment;
    }
}

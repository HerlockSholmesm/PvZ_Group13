public abstract class Zombie {

    private int life;
    private int speed;
    private String comment;
    private int x;
    private int y;
    Cell cell = new Cell();
    private int defense;


    public int getLife() {
        return life;
    }


    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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

    public Zombie(int life, int speed, String comment, int defense) {
        this.life = life;
        this.speed = speed;
        this.comment = comment;
        this.defense = defense;
    }

    public void attack() {

    }

    public void beAttacked() {

    }

    public void move() {

    }

}

class MovingZombie extends Zombie {
    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void beAttacked() {
        super.beAttacked();
    }

    @Override
    public void move() {
        super.move();
    }

    public MovingZombie(int life, int speed, String comment, int defense) {
        super(life, speed, comment, defense);
    }
}

class FlyingZombie extends Zombie {
    public FlyingZombie(int life, int speed, String comment, int defense) {
        super(life, speed, comment, defense);
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void beAttacked() {
        super.beAttacked();
    }

    @Override
    public void move() {
        super.move();
    }
}

class SwimmingZombie extends Zombie {
    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void beAttacked() {
        super.beAttacked();
    }

    @Override
    public void move() {
        super.move();
    }

    public SwimmingZombie(int life, int speed, String comment, int defense) {
        super(life, speed, comment, defense);
    }
}
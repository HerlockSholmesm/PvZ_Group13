public abstract class Zombie extends Card {

    private int life;
    private int speed;
    private String comment;
    private int x;
    private int y;
    Cell cell = new Cell();
    private int defense;
    private String name;

    public Zombie(int life, int speed, int defense, String name) {
        this.life = life;
        this.speed = speed;
        this.defense = defense;
        this.name = name;
    }

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

  /*  public Zombie(String name ,int life, int speed, String comment, int defense) {
        this.name=name;
        this.life = life;
        this.speed = speed;
        this.comment = comment;
        this.defense = defense;
    }*/

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

   public MovingZombie(String name ,int life, int speed, int defense) {
       super(life, speed, defense, name);
    }
}

class FlyingZombie extends Zombie {
    public FlyingZombie(String name ,int life, int speed, int defense) {
       super(life, speed, defense, name);
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

    public SwimmingZombie(String name ,int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}

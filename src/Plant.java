public abstract class Plant {

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

    public void attack() {

    }

    public void beAttacked() {

    }

    public void move() {

    }

}


class ProducerPlant extends Plant {

    public ProducerPlant(int sun, int rest, int life, String comment) {
        super(sun, rest, life, comment);
    }

    public void produce() {

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

class shootingPlant extends Plant {
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

    public shootingPlant(int sun, int rest, int life, String comment) {
        super(sun, rest, life, comment);
    }
}

class throwingPlant extends Plant {
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

    public throwingPlant(int sun, int rest, int life, String comment) {
        super(sun, rest, life, comment);
    }
}

class MinePlant extends Plant {
    public MinePlant(int sun, int rest, int life, String comment) {
        super(sun, rest, life, comment);
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

class ToPlantOnPlant extends Plant{
    public ToPlantOnPlant(int sun, int rest, int life, String comment) {
        super(sun, rest, life, comment);
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

class EatablePlant extends Plant {
    public EatablePlant(int sun, int rest, int life, String comment) {
        super(sun, rest, life, comment);
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
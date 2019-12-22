public abstract class Plant extends Card {

    private int sun;
    private int rest;
    private int life;
    private String comment;
    private int speed;
    private String name;

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

    public Plant(String name,int sun, int rest, int life) {
        this.name=name;
        this.sun = sun;
        this.rest = rest;
        this.life = life;
    }

    public void attack() {

    }

    public void beAttacked() {

    }

    public void move() {

    }

}


class ProducerPlant extends Plant {

    public ProducerPlant(String name,int sun, int rest, int life) {
        super(name,sun, rest, life);
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

    public shootingPlant(String name,int sun, int rest, int life) {
        super(name,sun, rest, life);
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

    public throwingPlant(String name,int sun, int rest, int life) {
        super(name,sun, rest, life);
    }
}

class MinePlant extends Plant {
    public MinePlant(String name,int sun, int rest, int life) {

        super(name ,sun, rest, life);
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
    public ToPlantOnPlant(String name ,int sun, int rest, int life)
    {
        super(name,sun, rest, life);
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
    public EatablePlant(String name,int sun, int rest, int life) {
        super(name ,sun, rest, life);
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
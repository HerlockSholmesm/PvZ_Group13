public abstract class Plant extends Card {

    private int sun;
    private int rest;
    private int life;
    private int attackPower;
    private int speed;
    private String name;
    private Cell cell;

    public int getSun() {
        return sun;
    }


    public int getRest() {
        return rest;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }


    public int getSpeed() {
        return speed;
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
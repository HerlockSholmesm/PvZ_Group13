import Model.Card;
import Model.Cell;

public abstract class Plant extends Card {

    private int sun;
    private int rest;
    private int life;
    private int attackPower;
    private int speed;
    private Cell cell;
    protected Sun suni;
    private String name;


    public int getSun() {
        return sun;
    }

    public int getRest() {
        return rest;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }


    public int getSpeed() {
        return speed;
    }


    public Plant(String name, int sun, int rest, int life) {
        this.name = name;
        this.sun = sun;
        this.rest = rest;
        this.life = life;
        suni =new Sun();
    }

    public void attack(Card card) {
        card.setLife(card.getLife()-attackPower);

    }

    public void beAttacked(Card card) {
        card.setLife(card.getLife()-attackPower);
    }


}


class ProducerPlant extends Plant {

    public ProducerPlant(String name,int clock,int numberOfSun, int sun, int rest, int life) {

        super(name, sun, rest, life);
    }

    public void produce(int addNumber) {
        suni.addsun(addNumber);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

}

class shootingPlant extends Plant {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }


    public shootingPlant(String name,int clock,int numberOfPea, int sun, int rest, int life)
    {
        super(name, sun, rest, life);
    }
}

class throwingPlant extends Plant {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }


    public throwingPlant(String name,int clock,int numberOfBullet,int power, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }
}

class MinePlant extends Plant {
    public MinePlant(String name,int cells, int sun, int rest, int life) {

        super(name, sun, rest, life);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }


}

class ToPlantOnPlant extends Plant {
    public ToPlantOnPlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }


}

class EatablePlant extends Plant {
    public EatablePlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

}
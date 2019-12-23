import java.util.ArrayList;

public abstract class Plant extends Card {

    private int sun;
    private int rest;
    private int life;
    private int speed;
    private String name;
    /**
     * Sorry ali I needed all plants together in an arrayList
     */

    private static final ArrayList<Plant> allPlants = new ArrayList<>();

    static {
        allPlants.add(new shootingPlant("Peashooter", 2, 2, 2));
        allPlants.add(new shootingPlant("snowPea", 3, 3, 3));
        allPlants.add(new shootingPlant("Cabbage-pult", 2, 3, 2));
        allPlants.add(new shootingPlant("Repeater", 3, 4, 4));
        allPlants.add(new shootingPlant("Threepeater", 4, 4, 5));
        allPlants.add(new shootingPlant("Cactus", 5, 4, 5));
        allPlants.add(new shootingPlant("Gatling Pea", 5, 4, 3));
        allPlants.add(new shootingPlant("Scaredy-shroom", 1, 2, 1));
        allPlants.add(new throwingPlant("Kernel-pult", 2, 3, 3));
        allPlants.add(new shootingPlant("Spilt Pea", 4, 4, 3));
        allPlants.add(new MinePlant("Explode-o-nut", 4, 5, 3));
        allPlants.add(new throwingPlant("Melon-pult", 3, 3, 3));
        allPlants.add(new ToPlantOnPlant("Lily Pad", 0, 1, 1));
        allPlants.add(new throwingPlant("Winter Melon", 4, 5, 3));
        allPlants.add(new EatablePlant("Wall-nut", 2, 4, 4));
        allPlants.add(new MinePlant("Tangle Kelp", 3, 3, 0));
        allPlants.add(new EatablePlant("Tall-nut", 4, 6, 6));
        allPlants.add(new shootingPlant("Cattail", 5, 5, 3));
        allPlants.add(new MinePlant("Potato Mine", 2, 3, 1));
        allPlants.add(new MinePlant("Cherry Bomb", 2, 4, 0));
        allPlants.add(new MinePlant("Magnet-shroom", 4, 4, 2));
        allPlants.add(new ProducerPlant("Sunflower", 1, 2, 2));
        allPlants.add(new ProducerPlant("Twin Sunflower", 3, 5, 2));
        allPlants.add(new MinePlant("Jalapeno", 4, 5, 0));
    }

    public static ArrayList<Plant> getAllPlants() {
        return allPlants;
    }

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


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Plant(String name, int sun, int rest, int life) {
        this.name = name;
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

    public ProducerPlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
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

    public shootingPlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
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

    public throwingPlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
    }
}

class MinePlant extends Plant {
    public MinePlant(String name, int sun, int rest, int life) {

        super(name, sun, rest, life);
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

class ToPlantOnPlant extends Plant {
    public ToPlantOnPlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
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
    public EatablePlant(String name, int sun, int rest, int life) {
        super(name, sun, rest, life);
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
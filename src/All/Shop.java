package All;

import Model.*;

import java.util.ArrayList;

public class Shop {
    private static ArrayList<Plant> collectionPlant;
    private static ArrayList<Zombie> collectionZombies;
    private static ArrayList<Plant> plants;
    private static ArrayList<Zombie> zombies;
    private static ArrayList<Card> collection;
    private ArrayList<Card> cards;

    public static ArrayList<Card> getCollection() {
        return collection;
    }

    public static ArrayList<Zombie> getCollectionZombies() {
        return collectionZombies;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public static ArrayList<Plant> getAllPlants() {
        return plants;
    }

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }


    public static ArrayList<Plant> getCollectionPlant() {
        return collectionPlant;
    }

    private void importPlant() {
        Plant plant = new shootingPlant("Peashooter", 2, 1, 2, 2, 2);
        plants.add(plant);
        collectionPlant.add(plant);
        plant = new shootingPlant("Snow Pea", 3, 1, 3, 3, 3);
        plants.add(plant);
        collectionPlant.add(plant);
        plant = new throwingPlant("Cabbage-pult", 2, 1, 2, 2, 3, 2);
        plants.add(plant);
        plant = new shootingPlant("Repeater", 3, 2, 3, 4, 4);
        plants.add(plant);
        plant = new shootingPlant("Threepeater", 4, 1, 4, 4, 5);
        plants.add(plant);
        plant = new shootingPlant("Cactus", 2, 1, 5, 4, 5);
        plants.add(plant);
        plant = new shootingPlant("Gatling Pea", 5, 4, 5, 4, 3);
        plants.add(plant);
        plant = new shootingPlant("Scaredy-shroom", 2, 1, 1, 2, 1);
        plants.add(plant);
        collectionPlant.add(plant);
        plant = new throwingPlant("Kernel-pult", 4, 1, 0, 3, 3, 2);
        plants.add(plant);
        collectionPlant.add(plant);
        plant = new shootingPlant("Split Pea", 1, 2, 4, 4, 3);
        plants.add(plant);
        plant = new EatablePlant("Explode-o-nut", 4, 5, 3);
        plants.add(plant);
        collectionPlant.add(plant);
        plant = new throwingPlant("Melon-pult", 4, 1, 3, 3, 3, 3);
        plants.add(plant);
        plant = new ToPlantOnPlant("Lily Pad", 0, 1, 1);
        plants.add(plant);
        plant = new throwingPlant("Winter Melon", 4, 1, 3, 4, 5, 3);
        plants.add(plant);
        plant = new EatablePlant("Wall-nut", 2, 4, 4);
        plants.add(plant);
        plant = new EatablePlant("Tangle Kelp", 3, 3, 0);
        plants.add(plant);
        plant = new EatablePlant("Tall-nut", 4, 6, 6);
        plants.add(plant);
        plant = new EatablePlant("Cattail", 5, 5, 3);
        plants.add(plant);
        plant = new MinePlant("Potato Mine", 1, 2, 3, 1);
        plants.add(plant);
        plant = new MinePlant("Cherry Bomb", 8, 2, 4, 2);
        plants.add(plant);
        collectionPlant.add(plant);
        plant = new MinePlant("Magnet-shroom", 8, 2, 4, 4);
        plants.add(plant);
        plant = new ProducerPlant("Sunflower", 2, 1, 1, 2, 2);
        plants.add(plant);
        collectionPlant.add(plant);
        plant = new ProducerPlant("Twin Sunflower", 2, 2, 3, 5, 2);
        plants.add(plant);
        plant = new MinePlant("Jalapeno", 19, 4, 5, 2);
        plants.add(plant);
        cards.addAll(plants);

    }

    private void importZombie() {
        Zombie zombie = new MovingZombie("zombie", 2, 2, 0);
        zombies.add(zombie);
        collectionZombies.add(zombie);
        zombie = new MovingZombie("Football Model.Zombie", 3, 4, 0);
        zombies.add(zombie);
        collectionZombies.add(zombie);
        zombie = new MovingZombie("Buckethead Model.Zombie", 2, 3, 0);
        zombies.add(zombie);
        zombie = new MovingZombie("Conehead Model.Zombie", 2, 3, 0);
        zombies.add(zombie);
        collectionZombies.add(zombie);
        zombie = new MovingZombie("Zomboni", 2, 3, 0);
        zombies.add(zombie);
        zombie = new MovingZombie("Catapult Model.Zombie", 2, 3, 0);
        zombies.add(zombie);
        zombie = new MovingZombie("Bungee Model.Zombie", 0, 3, 0);
        zombies.add(zombie);
        collectionZombies.add(zombie);
        zombie = new MovingZombie("Balloon Model.Zombie", 2, 2, 0);
        zombies.add(zombie);
        collectionZombies.add(zombie);
        zombie = new MovingZombie("Newspaper Model.Zombie", 2, 3, 2);
        zombies.add(zombie);
        zombie = new MovingZombie("Target Model.Zombie", 2, 3, 3);
        zombies.add(zombie);
        zombie = new MovingZombie("Screen Door Model.Zombie", 2, 2, 4);
        zombies.add(zombie);
        collectionZombies.add(zombie);
        zombie = new MovingZombie("Giga gargantuar", 1, 6, 0);
        zombies.add(zombie);
        zombie = new FlyingZombie("Pogo Model.Zombie", 2, 2, 0);
        zombies.add(zombie);
        zombie = new SwimmingZombie("Snorkel Model.Zombie", 2, 2, 0);
        zombies.add(zombie);
        zombie = new SwimmingZombie("Dolphin Rider Model.Zombie", 2, 2, 0);
        zombies.add(zombie);
        collection.addAll(collectionPlant);
        collection.addAll(collectionZombies);
        cards.addAll(zombies);
    }

    public int getPriceForPlant(int sun, int cooldown, int health) {
        return (sun * cooldown * health + 1);
    }

    public int getPriceForZombies(int speed, int health) {
        return ((1 + speed) * health * 10);
    }

}

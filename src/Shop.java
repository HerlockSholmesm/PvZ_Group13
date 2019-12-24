import java.util.ArrayList;

public class Shop {
    private ArrayList<Card> collection;
    private ArrayList<Card> cards;

    public ArrayList<Card> getCards() {
        return cards;
    }

    private static ArrayList<Plant> plants;
    private static ArrayList<Zombie> zombies;

    public static ArrayList<Plant> getAllPlants() {
        return plants;
    }

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }


    public ArrayList<Card> getCollection() {
        return collection;
    }

    private void importPlant(){
        Plant plant =new shootingPlant("Peashooter",2,2,2);
        plants.add(plant);
        cards.add(plant);
        collection.add(plant);
        plant =new shootingPlant("Snow Pea",3,3,3);
        plants.add(plant);
        cards.add(plant);
        collection.add(plant);
        plant =new throwingPlant("Cabbage-pult",2,3,2);
        plants.add(plant);
        cards.add(plant);
        plant  =new shootingPlant("Repeater",3,4,4);
        plants.add(plant);
        cards.add(plant);
        plant  =new shootingPlant("Threepeater",4,4,5);
        plants.add(plant);
        cards.add(plant);
        plant=new shootingPlant("Cactus",5,4,5);
        plants.add(plant);
        cards.add(plant);
        plant =new shootingPlant("Gatling Pea",5,4,3);
        plants.add(plant);
        cards.add(plant);
        plant =new shootingPlant("Scaredy-shroom",1,2,1);
        plants.add(plant);
        cards.add(plant);
        collection.add(plant);
        plant =new throwingPlant("Kernel-pult",3,3,2);
        plants.add(plant);
        cards.add(plant);
        collection.add(plant);
        plant=new shootingPlant("Split Pea",4,4,3);
        plants.add(plant);
        cards.add(plant);
        plant =new EatablePlant("Explode-o-nut",4,5,3);
        plants.add(plant);
        cards.add(plant);
        collection.add(plant);
        plant =new throwingPlant("Melon-pult",3,3,3);
        plants.add(plant);
        cards.add(plant);
        plant =new ProducerPlant("Lily Pad",0,1,1);
        plants.add(plant);
        cards.add(plant);
        plant =new throwingPlant("Winter Melon",4,5,3);
        plants.add(plant);
        cards.add(plant);
        plant =new ProducerPlant("Wall-nut",2,4,4);
        plants.add(plant);
        cards.add(plant);
        plant =new EatablePlant("Tangle Kelp",3,3,0);
        plants.add(plant);
        cards.add(plant);
        plant =new ProducerPlant("Tall-nut",4,6,6);
        plants.add(plant);
        cards.add(plant);
        plant=new EatablePlant("Cattail",5,5,3);
        plants.add(plant);
        cards.add(plant);
        plant =new EatablePlant("Potato Mine",2,3,1);
        plants.add(plant);
        cards.add(plant);
        plant =new EatablePlant("Cherry Bomb",2,4,2);
        plants.add(plant);
        cards.add(plant);
        collection.add(plant);
        plant =new EatablePlant("Magnet-shroom",2,4,4);
        plants.add(plant);
        cards.add(plant);
        plant =new ProducerPlant("Sunflower",1,2,2);
        plants.add(plant);
        cards.add(plant);
        collection.add(plant);
        plant =new ProducerPlant("Twin Sunflower",3,5,2);
        plants.add(plant);
        cards.add(plant);
        plant =new EatablePlant("Jalapeno",4,5,2);
        plants.add(plant);
        cards.add(plant);

    }
    private void importZombie(){
        Zombie zombie=new MovingZombie( "zombie",2,2,0);
        zombies.add(zombie);
        collection.add(zombie);
        cards.add(zombie);
        zombie =new MovingZombie("Football Zombie",3,4,0);
        zombies.add(zombie);
        collection.add(zombie);
        cards.add(zombie);
        zombie=new MovingZombie("Buckethead Zombie",2,3,0);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new MovingZombie("Conehead Zombie",2,3,0);
        zombies.add(zombie);
        collection.add(zombie);
        cards.add(zombie);
        zombie=new MovingZombie("Zomboni",2,3,0);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new MovingZombie("Catapult Zombie",2,3,0);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new MovingZombie("Bungee Zombie",0,3,0);
        zombies.add(zombie);
        cards.add(zombie);
        collection.add(zombie);
        zombie=new MovingZombie("Balloon Zombie",2,2,0);
        zombies.add(zombie);
        cards.add(zombie);
        collection.add(zombie);
        zombie=new MovingZombie("Newspaper Zombie",2,3,2);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new MovingZombie("Target Zombie",2,3,3);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new MovingZombie("Screen Door Zombie",2,2,4);
        zombies.add(zombie);
        cards.add(zombie);
        collection.add(zombie);
        zombie=new MovingZombie("Giga gargantuar",1,6,0);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new FlyingZombie("Pogo Zombie",2,2,0);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new SwimmingZombie("Snorkel Zombie",2,2,0);
        zombies.add(zombie);
        cards.add(zombie);
        zombie=new SwimmingZombie("Dolphin Rider Zombie",2,2,0);
        zombies.add(zombie);
        cards.add(zombie);
    }

}

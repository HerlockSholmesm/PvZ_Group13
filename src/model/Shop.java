package model;

import in_game.Account;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Shop implements Serializable {
    private static ArrayList<Card> collection;
    private static ArrayList<Plant> plants;
    private static ArrayList<Zombie> zombies;
    private static ArrayList<Card> cards;
    private static ArrayList<Card> boughtCards;
    private static ArrayList<Card> notBoughtCards;
    private static HashMap<String,String> WaterTypeOrDay = new HashMap<>();

    public static ArrayList<Card> getCollection() {
        return collection;
    }

    public static HashMap<String, String> getWaterTypeOrDay() {
        return WaterTypeOrDay;
    }

    public void showCollection(){
        for (Card card:collection) {
            System.out.println(card.getName());
        }
    }
    public void BuyCard(String name, Account account) {
        ArrayList<Card> toBeDeleted = new ArrayList<>();
        for (Card card : cards) {
            if (card.getName().equals(name)) {
                if (card instanceof Plant) {
                    if (card.getPrice() <= account.getMoney()) {
                        collection.add(card);
                        boughtCards.add(card);
                    } else System.out.println("Money is not enough");
                }
                if (card instanceof Zombie) {
                    if (card.getPrice() <= account.getMoney()) {
                        collection.add(card);
                        boughtCards.add(card);
                    } else System.out.println("Money is not enough");
                }

            } else System.out.println("the name is not valid");
        }
        notBoughtCards.removeAll(boughtCards);
    }

    public void showNotBaughtCard(Account account){
        for (Card card : account.getCollection().getNotBaughtCards()){
            System.out.println(card.toString());
        }
    }

    public void showMoney(Account account){
        System.out.println( account.getMoney());
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


    private void importPlant() {
        Plant plant = new shootingPlant("Peashooter", 2, 1, 2, 2, 2,
                new Image("Plants vs Zombies/Peashooter/Peashooter_transparent_gif.webp"));
        plants.add(plant);
        collection.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new shootingPlant("Snow Pea", 3, 1, 3, 3, 3
                , new Image("Plants vs Zombies/Snow Pea/Snow-Pea.webp"));
        plants.add(plant);
        collection.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new throwingPlant("Cabbage-pult", 2, 1, 2, 2, 3, 2
                , new Image("Plants vs Zombies/Cabbage-pult/Cabbagepult2009HD1.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new shootingPlant("Repeater", 3, 2, 3, 4, 4
        ,new Image("Plants vs Zombies/Repeater/1769829-plant_peashooter_thumb.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new shootingPlant("Threepeater", 4, 1, 4, 4, 5
        ,new Image("Plants vs Zombies/Threepeater/Threepeater2009HD.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new shootingPlant("Cactus", 2, 1, 5, 4, 5
        ,new Image("Plants vs Zombies/Cactus/Cactus.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new shootingPlant("Gatling Pea", 5, 4, 5, 4, 3
        ,new Image("Plants vs Zombies/Gatling Pea/GatlingPea2009HD.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new shootingPlant("Scaredy-shroom", 2, 1, 1, 2, 1
        ,new Image("Plants vs Zombies/Scared-shroom/Scaredy-shroom.webp"));
        plants.add(plant);
        collection.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new throwingPlant("Kernel-pult", 4, 1, 0, 3, 3, 2,
                new Image("Plants vs Zombies/Kernel-pult/Kernelpult2009HD.webp"));
        plants.add(plant);
        collection.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new shootingPlant("Split Pea", 1, 2, 4, 4, 3
        ,new Image("Plants vs Zombies/Split Pea/Splitpea2009HD.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new EatablePlant("Explode-o-nut", 4, 5, 3
                ,new Image("Plants vs ZombiesE/xplode-o-nut/HDExplode-o-nut.webp"));
        plants.add(plant);
        collection.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new throwingPlant("Melon-pult", 4, 1, 3, 3, 3, 3
                ,new Image("Plants vs Zombies/Melon-pult/Melonpult2009HD.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new ToPlantOnPlant("Lily Pad", 0, 1, 1
                ,new Image("Plants vs Zombies/Lily Pad/Lilypad.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "W");
        plant = new throwingPlant("Winter Melon", 4, 1, 3, 4, 5, 3
                ,new Image("Plants vs Zombies/Winter Melon/Winter_Melon.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new EatablePlant("Wall-nut", 2, 4, 4
                ,new Image("Plants vs Zombies/Wall-nut/2zfsax5_th.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new EatablePlant("Tangle Kelp", 3, 3, 0
                ,new Image("Plants vs Zombies/Tangle Kelp/Tangle-kelp.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "W");
        plant = new EatablePlant("Tall-nut", 4, 6, 6
                ,new Image("Plants vs Zombies/Tall-nut/Tallnut_body.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new EatablePlant("Cattail", 5, 5, 3
                ,new Image("Plants vs Zombies/Cattail/Cattail2009HD.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new MinePlant("Potato Mine", 1, 2, 3, 1
                ,new Image("Plants vs Zombies/Potato Mine/PotatoMineHD.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new MinePlant("Cherry Bomb", 8, 2, 4, 2
                ,new Image("Plants vs Zombies/Cherry Bomb/Catail.png"));
        plants.add(plant);
        collection.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new MinePlant("Magnet-shroom", 8, 2, 4, 4
                ,new Image("Plants vs Zombies/Magnet-shroom/HD_MAGNET.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new ProducerPlant("Sunflower", 2, 1, 1, 2, 2
                ,new Image("Plants vs Zombies/Sunflower/Sunflower_transparent.webp"));
        plants.add(plant);
        collection.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new ProducerPlant("Twin Sunflower", 2, 2, 3, 5, 2
                ,new Image("Plants vs Zombies/Sunflower/Sunflower_transparent.webp"));
        plants.add(plant);
        WaterTypeOrDay.put(plant.getName(), "D");
        plant = new MinePlant("Jalapeno", 19, 4, 5, 2
                ,new Image("Plants vs Zombies/Jalapeno/Jalapeno.webp"));
        plants.add(plant);
        cards.addAll(plants);
        WaterTypeOrDay.put(plant.getName(), "D");
        notBoughtCards.addAll(cards);

    }

    private void importZombie() {
        Zombie zombie = new MovingZombie("Zombie", 2, 2, 0
        ,new Image("Plants vs Zombies/Zombie/ZombieHD.webp"));
        zombies.add(zombie);
        collection.add(zombie);
        zombie = new MovingZombie("Football Zombie", 3, 4, 0
                ,new Image("Plants vs Zombies/Football Zombie/Cherry_Bomb_Seed.webp"));
        zombies.add(zombie);
        collection.add(zombie);
        zombie = new MovingZombie("BucketHead Zombie", 2, 3, 0
                ,new Image("Plants vs Zombies/Buckethead Zombie/Buckethead_Zombie.webp"));
        zombies.add(zombie);
        zombie = new MovingZombie("ConeHead Zombie", 2, 3, 0
                ,new Image("Plants vs Zombies/Conehead Zombie/Conehead_Zombie.png"));
        zombies.add(zombie);
        collection.add(zombie);
        zombie = new MovingZombie("Zomboni", 2, 3, 0
                ,new Image("Plants vs Zombies/Zomboni/HDplus_zamboni.webp"));
        zombies.add(zombie);
        zombie = new MovingZombie("Catapult Zombie", 2, 3, 0
                ,new Image("Plants vs Zombies/Snorkel Zombies/SnorkleZombie2009HD.webp"));
        zombies.add(zombie);
        zombie = new MovingZombie("Bungee Zombie", 0, 3, 0
                ,new Image("Plants vs Zombies/Bungee Zombie/Bungeed.webp"));
        zombies.add(zombie);
        collection.add(zombie);
        zombie = new MovingZombie("Balloon Zombie", 2, 2, 0
                ,new Image("Plants vs Zombies/Ballon Zombie/Zombie_balloon_.webp"));
        zombies.add(zombie);
        collection.add(zombie);
        zombie = new ShieldZombie("Newspaper Zombie", 2, 2, 2
                ,new Image("Plants vs Zombies/Newspaper Zombie/Newspaper_Zombie.webp"));
        zombies.add(zombie);
        zombie = new ShieldZombie("Target Zombie", 2, 3, 3
                ,new Image("Plants vs Zombies/Target Zombie/Zombie_Target1.gif"));
        zombies.add(zombie);
        zombie = new ShieldZombie("Screen Door Zombie", 2, 2, 4
                ,new Image("Plants vs Zombies/Screen Door Zombie/HDplus_screendoor.png"));
        zombies.add(zombie);
        collection.add(zombie);
        zombie = new GiantZombie("Giga-gargantuar", 6, 1, 0
                ,new Image("Plants vs Zombies/Giga-gargantaur/Gargantuar.webp"));
        zombies.add(zombie);
        zombie = new FlyingZombie("Pogo Zombie", 2, 2, 0
                ,new Image("Plants vs Zombies/Snorkel Zombies/SnorkleZombie2009HD.webp"));
        zombies.add(zombie);
        zombie = new SwimmingZombie("Snorkel Zombie", 2, 2, 0
                ,new Image("Plants vs Zombies/Snorkel Zombies/SnorkleZombie2009HD.webp"));
        zombies.add(zombie);
        zombie = new SwimmingZombie("Dolphin Rider Zombie", 2, 2, 2
                ,new Image("Plants vs Zombies/Dolphin Rider Zombie/DolphinRider2009HD.png"));
        zombies.add(zombie);
        collection.addAll(collection);
        collection.addAll(collection);
        cards.addAll(zombies);
        notBoughtCards.addAll(cards);
    }





}

package in_game;

import model.*;

import java.util.ArrayList;

public abstract class Dynamic {

    public void clock() {
    }

    /**
     * Show Hand Commands:
     */

    public static ArrayList<Card> getCards(Game game) {
        return game.getCards();
    }

    /**
     * Select Commands:
     */
    public static void SelectThisCard(Card card) {
        card.setSelect(true);
    }


    /**
     * Planting commands:
     */
    public static void setPlantPosition(int x, int y, Plant plant, Game game) {
        Graphic.plant(x, y, plant);
        plant.setSelect(false);
        game.addPlant(plant);
        Card card = findCard(plant, game);
        game.removeCard(card);
    }

    public static Card findCard(Plant plant, Game game) {
        for (Card card : game.getCards()) {
            if (card.getName().equals(plant.getName())) {
                return card;
            }
        }
        return null;
    }

    public static Plant findPlant(String name) {
        for (Plant plant : Shop.getAllPlants()) {
            if (plant.getName().equals(name)) {
                return plant;
            }
        }
        return null;
    }


    public static Plant findPlant(Card card) {
        for (Plant plant : Shop.getAllPlants()) {
            if (plant.getName().equals(card.getName())) {
                if (plant instanceof EatablePlant){
                    return new EatablePlant(plant.getName(), plant.getSun(), plant.getRest(), plant.getLife(), plant.getImage());
                }
                else if (plant instanceof MinePlant){
                    return new MinePlant(plant.getName(),plant.getClock(),plant.getSun(),plant.getRest(),plant.getLife(), plant.getImage());
                }
                else if (plant instanceof ProducerPlant){
                    return new ProducerPlant(plant.getName(),plant.getClock(),plant.getSun(),plant.getSun(),plant.getRest(),plant.getLife(), plant.getImage());
                }
                else if (plant instanceof shootingPlant){
                    return new shootingPlant(plant.getName(),plant.getClock(),0,plant.getSun(),plant.getRest(),plant.getLife(), plant.getImage());
                }
                else if (plant instanceof throwingPlant){
                    return new throwingPlant(plant.getName(),plant.getClock(),0,0,plant.getSun(),plant.getRest(),plant.getLife(), plant.getImage());
                }
                else {
                    return new ToPlantOnPlant(plant.getName(), plant.getSun(), plant.getRest(), plant.getLife(), plant.getImage());
                }

            }
        }
        return null;
    }

    public static Card findSelectedCard(Game game) {
        for (Card card : game.getCards()) {
            if (card.isSelect()) {
                return card;
            }
        }
        return null;
    }

    /**
     * Plant Removing:
     */
    public static void removePlant(int x, int y, Game game) {
        Plant plant = Graphic.findPlant(x, y);
        Graphic.remove(x, y);
        game.removePlant(plant);
    }


    /**
     * Show Lawn Commands:
     */
    public static ArrayList<Plant> getMeThePlants(Game game) {
        return game.getPlants();
    }

    public static ArrayList<Zombie> getMeTheZombies(Game game) {
        return game.getZombies();
    }

    /**
     * List Of All Cards:
     */
    public static ArrayList<Card> List(Game game) {
        return game.getCards();
    }

    /**
     * Turn Ending:
     */
    public static void goOn(Game game) {
        game.addTurn();
    }

    /**
     * Do I have enough coins?;
     */

    public static boolean doIHaveEnoughCoins(Game game, Card card) {
        return game.getCoin().getCoinInTheGame() - card.getPrice() >= 0;
    }


    public static void printer(ArrayList<Card> objects, String title1, String title2) {
        System.out.println(title1 + "\t\t" + title2);
        int n = objects.size();
        int i = 1;
        if (i <= n) {
            for (Object object : objects) {
                System.out.println(i + ". " + object);
                i++;
            }
        }

    }

    public static void ShowLawnPrinter(ArrayList<Plant> plants, ArrayList<Zombie> zombies, String title1P, String title2P) {
        System.out.println(title1P + "\t\t" + title2P);
        int i = 1;
        for (Plant plant : plants) {
            System.out.println(i + "." + plant.toStringPrime());
            i++;
        }
        i = 1;
        System.out.println(title1P + "\t\t" + title2P);
        for (Zombie zombie : zombies) {
            System.out.println(i + "." + zombie.toStringPrime());
            i++;
        }
    }
    /**Card printer*/
    public static void cardPrinter(ArrayList<Card> cards){
        int i = 0;
        for (Card card:cards){
            System.out.println(i + "." + card.getName());
        }
    }


    public static Plant findPlant(Plant plant, Game game) {
        for (Card cards : game.getCards()) {
            if (cards.getName().equals(plant.getName())) {
                return plant;
            }
        }
        return null;
    }


    public static int howManyZombiesAreThere(int row, Yard yard) {
        int numOfZombiesInRow = 0;
        for (Zombie zombie : yard.getGame().getZombies()) {
            if (row == zombie.getX()) {
                numOfZombiesInRow++;
            }
        }
        return numOfZombiesInRow;
    }



    public static Zombie findZombie(Card card) {
        for (Zombie zombie : Shop.getZombies()) {
            if (zombie.getName().equals(card.getName())) {
                if (zombie instanceof FlyingZombie) {
                    return new FlyingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense(), zombie.getImage());
                } else if (zombie instanceof GiantZombie) {
                    return new GiantZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense(), zombie.getImage());
                } else if (zombie instanceof MovingZombie) {
                    return new MovingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense(), zombie.getImage());
                } else {
                    return new SwimmingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense(), zombie.getImage());
                }

            }
        }
        return null;
    }

    public static int howManyZombiesInTheColumn(int X, int Y, Game game) {
        int numOfZombiesInCol = 0;
        for (Zombie zombie : game.getZombies()) {
            if (zombie.getX() == X && zombie.getY() == Y) {
                numOfZombiesInCol++;
            }
        }
        return numOfZombiesInCol;
    }


    public static void put(Game game, Zombie zombie, int x) {
        game.addZombie(zombie);
        zombie.setX(x);
        for (int y = 18; y >= 0; y--) {
            if (howManyZombiesInTheColumn(x, y, game) == 0) {
                zombie.setY(y);
            }
        }
        game.removeCard(findCard(game, zombie.getName()));
    }

    public static Card findCard(Game game, String name) {
        for (Card card : game.getCards()) {
            if (name.equals(card.getName())) {
                return card;
            }
        }
        return null;
    }



}

class MathFunctions {
    public static int getRandomNumber(int min, int max) {
        int n = (int) (Math.random() * (max - min + 1) + min);
        return n;
    }
}

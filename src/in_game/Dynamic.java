package in_game;

import model.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dynamic {

    public void clock() {
    }

    /**
     * Show Hand Commands:
     */

    public static ArrayList<Card> getCards(Player player) {
        return player.getCards();
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
    public static void setPlantPosition(int x, int y, Plant plant, Player player) {
        Graphic.plant(x, y, plant);
        plant.setSelect(false);
        player.addPlant(plant);
        Card card = findCard(plant, player);
        player.removeCard(card);
    }

    public static Card findCard(Plant plant, Player player) {
        for (Card card : player.getCards()) {
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
                return plant;
            }
        }
        return null;
    }

    public static Card findSelectedCard(Player player) {
        for (Card card : player.getCards()) {
            if (card.isSelect()) {
                return card;
            }
        }
        return null;
    }

    /**
     * Plant Removing:
     */
    public static void removePlant(int x, int y, Player player) {
        Plant plant = Graphic.findPlant(x, y);
        Graphic.remove(x, y);
        player.removePlant(plant);
    }


    /**
     * Show Lawn Commands:
     */
    public static ArrayList<Plant> getMeThePlants(Player player) {
        return player.getPlants();
    }

    public static ArrayList<Zombie> getMeTheZombies(Player player) {
        return player.getZombies();
    }

    /**
     * List Of All Cards:
     */
    public static ArrayList<Card> List(Player player) {
        return player.getCards();
    }

    /**
     * Turn Ending:
     */
    public static void goOn(Player player) {
        player.addTurn();
    }

    /**
     * Do I have enough coins?;
     */

    public static boolean doIHaveEnoughCoins(Player player, Card card) {
        return player.getCoin().getCoinInTheGame() - card.getPrice() >= 0;
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


    public static Plant findPlant(Plant plant,Player player) {
        for (Card cards : player.getCards()) {
            if (cards.getName().equals(plant.getName())) {
                return plant;
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

package in_game;

import model.*;
import commands.print;
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
    public static void setPlantPosition(int x, int y, Card card, Player player) {
        Plant plant = findPlant(card);
        graphic.plant(x, y, plant);
        plant.setSelect(false);
        player.addPlant(plant);
        player.removeCard(card);
    }

    public static Plant findPlant(Card card) {
        for (Plant plant : Shop.getAllPlants()) {
            if (card.getName().equals(plant.getName())) {
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
        Plant plant = graphic.findPlant(x, y);
        graphic.remove(x, y);
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


}
 class DynamicDay {
    PlayerDay playerDay;

    public DynamicDay(PlayerDay playerDay) {
        this.playerDay = playerDay;
    }

    /**
     * Show Hand Commands:
     */

    public int demandingSuns() {
        /**the output indicates the number of suns player needs,so
         * if the output < 0, it means that we need "output" suns.
         * if the output > 0, it means we have extra "output" suns.
         */
        int allSunsPlayerHas = playerDay.getSuns();
        int allSunsPlayerMustHave = 0;
        for (Plant plant : playerDay.getPlants()) {
            allSunsPlayerMustHave = allSunsPlayerMustHave + plant.getSun();
        }
        int allSunsPlayerNeeds = allSunsPlayerMustHave - allSunsPlayerHas;
        return allSunsPlayerNeeds;
    }



    /**
     * Select Commands:
     */
    public boolean canIChoose(PlayerDay playerDay, Card card) {
        Plant plant = Dynamic.findPlant(card);
        int numberOfExtraSuns = demandingSuns();
        return (numberOfExtraSuns >= plant.getSun());
    }

    /**
     * Adding Suns Randomly:
     */
    public void addSun() {
        int n = MathFunctions.getRandomNumber(2, 5);
        playerDay.addSuns(n);
    }

    /**
     * Set and choose Random Zombies:
     */
    public ArrayList<Zombie> chooseAndSetRandomZombies() {
        Random rand = new Random();
        ArrayList<Zombie> randomZombies = new ArrayList<>();
        int numberOfZombies = MathFunctions.getRandomNumber(4, 10);
        for (int i = 0; i < numberOfZombies; i++) {
            int randomIndex = rand.nextInt(Shop.getZombies().size());
            randomZombies.add((Zombie) Shop.getZombies().get(randomIndex));
        }
        playerDay.setZombies(randomZombies);
        return randomZombies;
    }

    /**
     * Set Cards Randomly:
     */

    public void addPlant() {
        int index = MathFunctions.getRandomNumber(0, Shop.getAllPlants().size() - 1);
        Plant plant = Shop.getAllPlants().get(index);
        playerDay.addCard(plant);
    }


}

class DynamicRail {
    RailPlayer railPlayer;

    public DynamicRail(RailPlayer railPlayer) {
        this.railPlayer = railPlayer;
    }

    public RailPlayer getRailPlayer() {
        return railPlayer;
    }

    public void setRailPlayer(RailPlayer railPlayer) {
        this.railPlayer = railPlayer;
    }

    /**
     * Random Zombie Adding:
     */
    public static void addZombie(RailPlayer railPlayer) {
        int index = MathFunctions.getRandomNumber(0, Shop.getZombies().size() - 1);
        Zombie zombie = Shop.getZombies().get(index);
        railPlayer.getZombies().add(zombie);
    }

    /**
     * Zombie killing:
     */
    public void killZombie(Zombie zombie) {
        railPlayer.removeZombie(zombie);
        railPlayer.pointAdder();
    }

    public Zombie findZombie(Zombie zombie) {
        for (Zombie z : railPlayer.getZombies()) {
            if (z.getName().equals(zombie.getName())) {
                return z;
            }
        }
        return null;
    }

    public int getNumOfDeadZombies() {
        return railPlayer.getPoints();
    }


}


class DynamicZombie extends Dynamic {

    ZombiePlayer zombiePlayer;

    public DynamicZombie(ZombiePlayer zombiePlayer) {
        this.zombiePlayer = zombiePlayer;
    }

    public ZombiePlayer getZombiePlayer() {
        return zombiePlayer;
    }

    public void setZombiePlayer(ZombiePlayer zombiePlayer) {
        this.zombiePlayer = zombiePlayer;
    }

    /**
     * Turn Ending for zombies
     */

    public void goOn() {
        zombiePlayer.addTurn();
        zombiePlayer.setKillPerTurn(0);
    }

    /**
     * find a zombie to buy
     */
    public static Zombie findZombie(String zombieName) {
        for (Zombie zombie : Shop.getZombies()) {
            if (zombie.getName().equals(zombieName)) {
                return zombie;
            }
        }
        return null;
    }

    /**
     * killing plants;
     */
    public void killPlant(int x, int y) {
        zombiePlayer.addKillPerTurn();
        Dynamic.removePlant(x, y, zombiePlayer);

    }

    /**
     * Rewarding Zombie
     */
    public void rewardZombie() {
        zombiePlayer.coin.setCoinInTheGame(zombiePlayer.coin.getCoinInTheGame() + 10 * zombiePlayer.getKillPerTurn());
    }

    /**
     * How to put Zombies?
     */
    public void put(String name, int n) {
        Card card = findCard(name);
        for (int i = 0; i < n; i++) {
            zombiePlayer.addZombie(findZombie(card));
            zombiePlayer.removeCard(card);
        }
    }

    public Card findCard(String name) {
        for (Card card : zombiePlayer.getCards()) {
            if (name.equals(card.getName())) {
                return card;
            }
        }
        return null;
    }

    public static Zombie findZombie(Card card) {
        for (Zombie zombie : Shop.getZombies()) {
            if (zombie.getName().equals(card.getName())) {
                return zombie;
            }
        }
        return null;
    }

    public static int howManyZombiesAreThere(int row, Yard yard) {
        int numOfZombiesInRow = 0;
        for (Zombie zombie : yard.getPlayer().getZombies()) {
            if (row == zombie.getX()) {
                numOfZombiesInRow++;
            }
        }
        return numOfZombiesInRow;
    }


}

class DynamicPVP {
    private PlayerDay playerDay;
    private ZombiePlayer zombiePlayer;
    private final int TOTAL_NUMBER_OF_WAVES;

    public void setPlayerDay(PlayerDay playerDay) {
        this.playerDay = playerDay;
    }

    public void setZombiePlayer(ZombiePlayer zombiePlayer) {
        this.zombiePlayer = zombiePlayer;
    }

    public PlayerDay getPlayerDay() {
        return playerDay;
    }

    public ZombiePlayer getZombiePlayer() {
        return zombiePlayer;
    }

    public int getTOTAL_NUMBER_OF_WAVES() {
        return TOTAL_NUMBER_OF_WAVES;
    }

    public DynamicPVP(PlayerDay playerDay, ZombiePlayer zombiePlayer, int TOTAL_NUMBER_OF_WAVES) {
        this.playerDay = playerDay;
        this.zombiePlayer = zombiePlayer;
        this.TOTAL_NUMBER_OF_WAVES = TOTAL_NUMBER_OF_WAVES;
    }

    /**
     * Turn ending
     */
    public void goOn() {
        playerDay.addSuns(1);
        zombiePlayer.addTurn();
        playerDay.addTurn();
    }


}

class graphic {

    public static void plant(int x, int y, Card plant) {
    }

    public static Plant findPlant(int x, int y) {
        return null;
    }

    public static void remove(int x, int y) {
    }

}

class MathFunctions {
    public static int getRandomNumber(int min, int max) {
        int n = (int) (Math.random() * (max - min + 1) + min);
        return n;
    }
}

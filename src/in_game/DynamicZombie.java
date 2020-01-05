package in_game;


import model.Card;
import model.Shop;
import model.Yard;
import model.Zombie;

public class DynamicZombie extends Dynamic {

    ZombieGame zombiePlayer;

    public DynamicZombie(ZombieGame zombiePlayer) {
        this.zombiePlayer = zombiePlayer;
    }

    public ZombieGame getZombiePlayer() {
        return zombiePlayer;
    }

    public void setZombiePlayer(ZombieGame zombiePlayer) {
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
        for (Zombie zombie : yard.getGame().getZombies()) {
            if (row == zombie.getX()) {
                numOfZombiesInRow++;
            }
        }
        return numOfZombiesInRow;
    }


    public void showLanePrinter(){
        int i = 0;
        System.out.println("Name" + "\t" + "row number:");
        for (Zombie zombie:zombiePlayer.getZombies()){
            System.out.println(i + ". " + zombie.getName() + " " + zombie.getY());
        }
    }



}


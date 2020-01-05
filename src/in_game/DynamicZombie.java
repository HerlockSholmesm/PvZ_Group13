package in_game;


import model.*;

public class DynamicZombie extends Dynamic {

    ZombieGame zombieGame;

    public DynamicZombie(ZombieGame zombieGame) {
        this.zombieGame = zombieGame;
    }

    public void setZombiePlayer(ZombieGame zombiePlayer) {
        this.zombieGame = zombiePlayer;
    }

    /**
     * Turn Ending for zombies
     */

    public void goOn() {
        zombieGame.addTurn();
        zombieGame.setKillPerTurn(0);
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
        zombieGame.addKillPerTurn();
        Dynamic.removePlant(x, y, zombieGame);
    }

    /**
     * Rewarding Zombie
     */
    public void rewardZombie() {
        zombieGame.coin.setCoinInTheGame(zombieGame.coin.getCoinInTheGame() + 10 * zombieGame.getKillPerTurn());
    }

    /**
     * How to put Zombies?
     */
    public static void put(ZombieGame zombieGame, Zombie zombie, int x) {
        zombieGame.addZombie(zombie);
        zombie.setX(x);
        for (int y = 18;y >= 0;y--){
            if (howManyZombiesInTheColumn(x,y,zombieGame) == 0){
                zombie.setY(y);
            }
        }
        zombieGame.removeCard(findCard(zombieGame, zombie.getName()));
    }

    public static int howManyZombiesInTheColumn(int X,int Y,ZombieGame zombieGame){
        int numOfZombiesInCol = 0;
        for (Zombie zombie:zombieGame.getZombies()){
            if (zombie.getX() == X && zombie.getY() == Y){
                numOfZombiesInCol++;
            }
        }
        return numOfZombiesInCol;
    }

    public static Card findCard(ZombieGame zombieGame, String name) {
        for (Card card : zombieGame.getCards()) {
            if (name.equals(card.getName())) {
                return card;
            }
        }
        return null;
    }

    public static Zombie findZombie(Card card) {
        for (Zombie zombie : Shop.getZombies()) {
            if (zombie.getName().equals(card.getName())) {
                if (zombie instanceof FlyingZombie) {
                    return new FlyingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
                } else if (zombie instanceof GiantZombie) {
                    return new GiantZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
                } else if (zombie instanceof MovingZombie) {
                    return new MovingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
                } else {
                    return new SwimmingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
                }

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


    public void showLanePrinter() {
        int i = 0;
        System.out.println("Name" + "\t" + "row number:");
        for (Zombie zombie : zombieGame.getZombies()) {
            System.out.println(i + ". " + zombie.getName() + " " + zombie.getY());
        }
    }
    public void endTurn(){
        for (Plant plant:zombieGame.getPlants()){
            if (plant.getLife() <= 0){
                killPlant(plant.getXCoordinate(),plant.getYCoordinate());
            }
        }
        rewardZombie();
        goOn();

    }
}


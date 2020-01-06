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

    public boolean hasWaveFinished(){
        return zombieGame.getZombies().size()==0;
    }

    public void showLanePrinter() {
        int i = 0;
        System.out.println("Name" + "\t" + "row number:");
        for (Zombie zombie : zombieGame.getZombies()) {
            System.out.println(i + ". " + zombie.getName() + " " + zombie.getY());
        }
    }

    public void endTurn() {
        for (Zombie zombie:zombieGame.getZombies()){
            if(zombie.getLife() <= 0 ){
                zombieGame.getZombies().remove(zombie);
            }
        }

        for (Plant plant : zombieGame.getPlants()) {
            if (plant.getLife() <= 0) {
                killPlant(plant.getXCoordinate(), plant.getYCoordinate());
            }
        }
        rewardZombie();
        goOn();

        for (Zombie zombie:zombieGame.getZombies()){
            zombie.action(zombieGame);
        }
        for (Plant plant:zombieGame.getPlants()){
            plant.action(zombieGame);
        }
        for (Chamanzan chamanzan:zombieGame.getChamanzans()){
            chamanzan.action(zombieGame);
        }
        for (PeaBullet peaBullet:zombieGame.getPeaBullets()){
            peaBullet.action(zombieGame);
        }

    }

    public boolean hasGameEnded(){
        if (zombieGame.getPlants().size() <= 0) {
            zombieGame.setGameCondition(GameCondition.WINNER);
            return  true;
        }
        else{
            int money = zombieGame.getCoin().getCoinInTheGame();
            int min = 0;
            for (Zombie zombie:Shop.getZombies()){
                if (min > zombie.getPrice()){
                    min = zombie.getPrice();
                }
            }
            if (money < min){
                zombieGame.setGameCondition(GameCondition.LOSER);
                return true;
            }
            else{
                return false;
            }
        }
    }
}


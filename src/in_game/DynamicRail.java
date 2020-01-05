package in_game;

import model.Card;
import model.Shop;
import model.Zombie;

public class DynamicRail extends Dynamic {

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

    /**Find a card with the number given to it:*/
    public Card findCard(int index){
        return railPlayer.getCards().get(index);
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


    public void endTurn() {

    }
}


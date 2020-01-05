package in_game;

import model.Card;
import model.Shop;
import model.Zombie;
import model.*;
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

    public Card getRandomCardSelect() {
        int min = 0;
        int max = Shop.getAllPlants().size() - 1;
        int rnd = MathFunctions.getRandomNumber(min, max);
        Card card = Shop.getAllPlants().get(rnd);
        return card;

    }

    public Zombie getRandomZombie(){
        int min = 0;
        int max = Shop.getZombies().size() - 1;
        int rnd = MathFunctions.getRandomNumber(min, max);
        Zombie zombie = Shop.getZombies().get(rnd);
        if (zombie instanceof FlyingZombie)
        {
            return new FlyingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
        }
        else if (zombie instanceof GiantZombie)
        {
            return new GiantZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
        }
        else if (zombie instanceof MovingZombie)
        {
            return new MovingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
        }
        else
        {
            return new SwimmingZombie(zombie.getName(), zombie.getLife(), zombie.getSpeed(), zombie.getDefense());
        }


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
        addCardRandomly();
        addZombieRandomly();
        railPlayer.addTurn();
    }

    public boolean hasGameEnded(){
        for (Zombie zombie:railPlayer.getZombies()){
            if (zombie.getX() <= 0){
                return true;
            }
        }
        return false;
    }

    public void addZombieRandomly(){
        int turn = railPlayer.getTurn();
        if (turn - railPlayer.getPreviousAddedZombieTurn() >= 3 && turn - railPlayer.getPreviousAddedZombieTurn() <= 4){
            int rnd = MathFunctions.getRandomNumber(0, 1);
            if (rnd == 1){
                railPlayer.zombies.add(getRandomZombie());
                railPlayer.setPreviousAddedZombieTurn(turn);
            }
        }
        else if (turn - railPlayer.getPreviousAddedZombieTurn() >= 5){
            railPlayer.zombies.add(getRandomZombie());
            railPlayer.setPreviousAddedZombieTurn(turn);
        }

    }
    public void addCardRandomly(){
        int turn = railPlayer.getTurn();
        if (turn - railPlayer.getPreviousGivenCard() >= 2 && turn - railPlayer.getPreviousGivenCard() <= 3){
            int rnd = MathFunctions.getRandomNumber(0, 1);
            if (rnd == 1){
                if (railPlayer.getCards().size() < 10){
                    railPlayer.addCard(getRandomCardSelect());
                    railPlayer.setPreviousGivenCard(turn);
                }
            }
        }
        else if (turn - railPlayer.getPreviousGivenCard() >= 4){
            if (railPlayer.getCards().size() < 10){
                railPlayer.addCard(getRandomCardSelect());
                railPlayer.setPreviousGivenCard(turn);
            }
        }

    }
}


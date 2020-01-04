package in_game;

import model.Card;
import model.Plant;
import model.Shop;
import model.Zombie;

import java.util.ArrayList;
import java.util.Random;

public class DynamicDay extends Dynamic {
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
        Plant plant = findPlant(card);
        int numberOfExtraSuns = demandingSuns();
        return (numberOfExtraSuns >= plant.getSun());
    }

    /**
     * Adding Suns Randomly:
     */
    public void addSunRandomly() {
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
        playerDay.addCard(new Plant(plant.getName(), plant.getSun(), plant.getRest(), plant.getLife()));
    }

    /**
     * Find a plant given its name:
     */
    public Plant findPlant(Plant plant) {
        for (Card cards : playerDay.getCards()) {
            if (cards.getName().equals(plant.getName())) {
                return plant;
            }
        }
        return null;
    }

    public void attack(){
        ArrayList<Zombie> zombies = chooseAndSetRandomZombies();
        playerDay.setZombies(zombies);
    }
    /**Do what is needed to do to end a turn:*/
    public boolean hasGameEnded(){
        if (playerDay.getWavesOfAttack() >= 3){
            playerDay.setPlayerCondition(playerCondition.WINNER);
            return true;
        }
        else if(playerDay.getPlants().size() == 0 && playerDay.getWavesOfAttack() < 3 && playerDay.getWavesOfAttack() != 0){
            playerDay.setPlayerCondition(playerCondition.LOSER);
            return true;
        }
        return false;
    }

    public boolean canIStartTheNextAttack(){
        if (playerDay.getTurn() - playerDay.getTurnLastZombieKilled() >= 7){
            return true;
        }
        else if(playerDay.getTurn() == 3){
            return true;
        }
        return false;

    }
    public void endTurn(){
        int turn = playerDay.getTurn();
        int lastTurnServed = playerDay.getTurnServed();
        if (turn - lastTurnServed > 1){
            addSunRandomly();
        }
        else if(turn - lastTurnServed == 1){
            int rnd = MathFunctions.getRandomNumber(0, 1);
            if (rnd == 1){
                addSunRandomly();
            }
        }
        if (playerDay.getZombies().size() == 0 && playerDay.getTurn() != 0){
            playerDay.setTurnLastZombieKilled(playerDay.getTurn());
        }

        if (canIStartTheNextAttack()){
            attack();
        }
        playerDay.addTurn();
    }

}


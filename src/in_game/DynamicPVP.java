package in_game;

import model.Card;
import model.Plant;
import model.Zombie;

public class DynamicPVP {


    private PvPGame pvpGame;

    public DynamicPVP(PvPGame pvpGame) {
        this.pvpGame = pvpGame;
    }


    public int demandingSuns() {
        /**the output indicates the number of suns player needs,so
         * if the output < 0, it means that we need "output" suns.
         * if the output > 0, it means we have extra "output" suns.
         */
        int allSunsPlayerHas = pvpGame.getSuns();
        int allSunsPlayerMustHave = 0;
        for (Plant plant : pvpGame.getPlants()) {
            allSunsPlayerMustHave = allSunsPlayerMustHave + plant.getSun();
        }
        int allSunsPlayerNeeds = allSunsPlayerMustHave - allSunsPlayerHas;
        return allSunsPlayerNeeds;
    }


    public boolean canIChoose(Card card) {
        Plant plant = Dynamic.findPlant(card);
        int numberOfExtraSuns = demandingSuns();
        return (numberOfExtraSuns >= plant.getSun());
    }


    public void showLanePrinter() {
        int i = 0;
        System.out.println("Name" + "\t" + "row number:");
        for (Zombie zombie : pvpGame.getZombies()) {
            System.out.println(i + ". " + zombie.getName() + " " + zombie.getY());
        }
    }



    public static Card findCard(PvPGame pvpGame, String name) {
        for (Card card : pvpGame.getCards()) {
            if (name.equals(card.getName())) {
                return card;
            }
        }
        return null;
    }

    /**
     * Turn ending
     */
    public void goOn() {
        pvpGame.addSuns(1);
        for (Plant plant : pvpGame.getPlants()) {
            if (plant.getLife() <= 0) {
                Dynamic.removePlant(plant.getXCoordinate(),plant.getYCoordinate(), pvpGame);
            }
        }
        pvpGame.addTurn();

    }

    public boolean isWaveFinished(){
        if (pvpGame.getZombies().size() == 0){
            pvpGame.addPlantWins();
            return true;
        }
        else{
            for(Zombie zombie:pvpGame.getZombies()){
                if (zombie.getX() == 0){
                    pvpGame.addZombieCoin(200);
                    pvpGame.addZombieWins();
                    return true;
                }
            }
            return false;
        }

    }

    public boolean hasGameEnded(){
        if (pvpGame.getPlantWins() >= pvpGame.getTotalWaves()/2){
            pvpGame.setGamePvPCondition(GamePvPCondition.PLANTWINNIG);
            return true;
        }
        else if (pvpGame.getZombieWins() >= pvpGame.getTotalWaves()/2){
            pvpGame.setGamePvPCondition(GamePvPCondition.ZOMBIEWINNING);
            return true;
        }
        return false;
    }

}

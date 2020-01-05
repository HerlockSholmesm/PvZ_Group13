package in_game;

import model.Card;
import model.Plant;

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


    /**
     * Turn ending
     */
    public void goOn() {
        pvpGame.addSuns(1);
        pvpGame.addTurn();
    }

}

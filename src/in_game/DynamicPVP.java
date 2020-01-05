package in_game;

import model.Zombie;

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

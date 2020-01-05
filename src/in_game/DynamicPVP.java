package in_game;

class DynamicPVP {
    private GameDay playerDay;
    private ZombieGame zombiePlayer;
    private final int TOTAL_NUMBER_OF_WAVES;

    public void setPlayerDay(GameDay playerDay) {
        this.playerDay = playerDay;
    }

    public void setZombiePlayer(ZombieGame zombiePlayer) {
        this.zombiePlayer = zombiePlayer;
    }

    public GameDay getPlayerDay() {
        return playerDay;
    }

    public ZombieGame getZombiePlayer() {
        return zombiePlayer;
    }

    public int getTOTAL_NUMBER_OF_WAVES() {
        return TOTAL_NUMBER_OF_WAVES;
    }

    public DynamicPVP(GameDay playerDay, ZombieGame zombiePlayer, int TOTAL_NUMBER_OF_WAVES) {
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

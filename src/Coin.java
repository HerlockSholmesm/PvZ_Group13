public class Coin {
    private int coinInTheGame;

    public int getCoinInTheGame() {
        return coinInTheGame;
    }

    public Coin(int coinInTheGame, int coinOutOfTheGame) {
        this.coinInTheGame = coinInTheGame;
        this.coinOutOfTheGame = coinOutOfTheGame;
    }

    public void setCoinInTheGame(int coinInTheGame) {
        this.coinInTheGame = coinInTheGame;
    }

    public int getCoinOutOfTheGame() {
        return coinOutOfTheGame;
    }

    public void setCoinOutOfTheGame(int coinOutOfTheGame) {
        this.coinOutOfTheGame = coinOutOfTheGame;
    }

    private int coinOutOfTheGame;
}

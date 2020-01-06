package in_game;

import model.*;

import java.util.ArrayList;

public class ZombieGame extends Game {

    private ArrayList<Chamanzan> chamanzans = new ArrayList<>();


    private boolean start = false;

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    private GameCondition gameCondition = GameCondition.PLAYING;

    public void setGameCondition(GameCondition gameCondition) {
        this.gameCondition = gameCondition;
    }

    public GameCondition getGameCondition() {
        return gameCondition;
    }

    private int killPerTurn = 0;

    public int getKillPerTurn() {
        return killPerTurn;
    }

    public void addKillPerTurn() {
        this.killPerTurn++;
    }

    public void setKillPerTurn(int killPerTurn) {
        this.killPerTurn = killPerTurn;
    }

    public ArrayList<Chamanzan> getChamanzans() {
        return chamanzans;
    }

    public ZombieGame(String name, String password){
        super(name,password);
        this.coin = new Coin(50, 0);
        this.cards.add(Shop.getZombies().get(0));
        this.cards.add(Shop.getZombies().get(1));
        this.cards.add(Shop.getZombies().get(10));
        this.cards.add(Shop.getZombies().get(4));
        this.cards.add(Shop.getZombies().get(7));
        this.cards.add(Shop.getZombies().get(6));
        this.cards.add(Shop.getZombies().get(3));
        ArrayList<Integer> Xcoordinates = new ArrayList<>();
        ArrayList<Integer> Ycoordinates = new ArrayList<>();
        for (int i = 0;i < 16;i++){
            Xcoordinates.add(MathFunctions.getRandomNumber(0, 2));
            Ycoordinates.add(MathFunctions.getRandomNumber(0,5));
        }
            this.plants.add(Shop.getAllPlants().get(10));
            plants.get(0).setCoordinates(Xcoordinates.get(0), Ycoordinates.get(0));
            this.plants.add(Shop.getAllPlants().get(10));
            plants.get(1).setCoordinates(Xcoordinates.get(1), Ycoordinates.get(1));
            this.plants.add(Shop.getAllPlants().get(10));
            plants.get(2).setCoordinates(Xcoordinates.get(2), Ycoordinates.get(2));
            this.plants.add(Shop.getAllPlants().get(7));
            plants.get(3).setCoordinates(Xcoordinates.get(3), Ycoordinates.get(3));
            this.plants.add(Shop.getAllPlants().get(7));
            plants.get(4).setCoordinates(Xcoordinates.get(4), Ycoordinates.get(4));
            this.plants.add(Shop.getAllPlants().get(7));
            plants.get(5).setCoordinates(Xcoordinates.get(5), Ycoordinates.get(5));
            this.plants.add(Shop.getAllPlants().get(7));
            plants.get(6).setCoordinates(Xcoordinates.get(6), Ycoordinates.get(6));
            this.plants.add(Shop.getAllPlants().get(7));
            plants.get(7).setCoordinates(Xcoordinates.get(7), Ycoordinates.get(7));
            this.plants.add(Shop.getAllPlants().get(7));
            plants.get(8).setCoordinates(Xcoordinates.get(8), Ycoordinates.get(8));
            this.plants.add(Shop.getAllPlants().get(1));
            plants.get(9).setCoordinates(Xcoordinates.get(9), Ycoordinates.get(9));
            this.plants.add(Shop.getAllPlants().get(1));
            plants.get(10).setCoordinates(Xcoordinates.get(10), Ycoordinates.get(10));
            this.plants.add(Shop.getAllPlants().get(2));
            plants.get(11).setCoordinates(Xcoordinates.get(11), Ycoordinates.get(11));
            this.plants.add(Shop.getAllPlants().get(2));
            plants.get(12).setCoordinates(Xcoordinates.get(12), Ycoordinates.get(12));
            this.plants.add(Shop.getAllPlants().get(4));
            plants.get(13).setCoordinates(Xcoordinates.get(13), Ycoordinates.get(13));
            this.plants.add(Shop.getAllPlants().get(6));
            plants.get(14).setCoordinates(Xcoordinates.get(14), Ycoordinates.get(14));
            this.plants.add(Shop.getAllPlants().get(18));
            plants.get(15).setCoordinates(Xcoordinates.get(15), Ycoordinates.get(15));


            this.chamanzans.add(new Chamanzan(0, 0, this.yard));
            this.chamanzans.add(new Chamanzan(0, 1, this.yard));
            this.chamanzans.add(new Chamanzan(0, 2, this.yard));
            this.chamanzans.add(new Chamanzan(0, 3, this.yard));
            this.chamanzans.add(new Chamanzan(0, 4, this.yard));
            this.chamanzans.add(new Chamanzan(0, 5, this.yard));



    }
    public void addZombie(Zombie zombie){
        zombies.add(zombie);
    }

    public void buy(Card zombie){
        this.cards.add(zombie);
        this.addCoin(-zombie.getPrice());
    }

}

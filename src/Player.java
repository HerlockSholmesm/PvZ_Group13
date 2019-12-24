import java.util.ArrayList;

public abstract class Player {
    protected int turn;
    protected ArrayList<Plant> plants = new ArrayList<Plant>();
    protected ArrayList<Zombie> zombies;
    Account account;
    protected Coin coin = new Coin(0, 0);
    protected ArrayList<Card> cards = new ArrayList<>();
    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
    public int getTurn() {
        return turn;
    }

    public void addTurn() {
        turn++;
    }
    public void addPlant(Plant plant){
        this.plants.add(plant);
    }

    public void removePlant(Plant plant){
        this.plants.remove(plant);
    }

    public ArrayList<Plant> getPlants(){
        return this.plants;
    }


    public Coin getCoin() {
        return coin;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
    public void removeCard(Card card){ this.cards.remove(card);}
}


class PlayerDay extends Player {
    private final int VALID_NUM_OF_PLANTS = 7;
    private final int   VALID_NUM_OF_CARDS = 7;
    private Sun suns;//must init with 2
    private int wavesOfAttack;


    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }


    public int getWavesOfAttack() {
        return wavesOfAttack;
    }

    public void decreaseWaveOfAttack(){
        wavesOfAttack--;
    }

    public int getValidNumOfPlants() {
        return VALID_NUM_OF_PLANTS;
    }

    public int getValidNumOfCards() {
        return VALID_NUM_OF_CARDS;
    }

    public int getNumOfPlants() {
        return plants.size();
    }

    public PlayerDay(String name, String password, ArrayList<Card> cards) {
        this.plants.add(new shootingPlant("Peashooter",2, 2, 2 ));
        this.plants.add(new shootingPlant("Snow pea",3, 3, 3 ));
        this.plants.add(new MinePlant("Explode-o-nut",4, 5, 3));
        this.plants.add(new shootingPlant("Scaredy-shroom",1, 2, 1 ));
        this.plants.add(new MinePlant("Cherry Bomb",2, 4, 0));
        this.plants.add(new throwingPlant("Kernel-pult",3, 3, 2 ));
        this.plants.add(new ProducerPlant("Sunflower",1, 2, 2 ));
        this.suns = new Sun(2);
        this.cards = cards;
        this.account = new Account(name, password);
        wavesOfAttack = 3;
        turn = 0;
    }


    public void addSuns(int s) {
        int currentSuns = this.suns.getSunStore();
        this.suns.setSunStore(s - currentSuns);
    }

    public int getSuns() {
        return suns.getSunStore();
    }
}

class RailPlayer extends Player {
    private int points;
    private final int MAX_NUMBER_OF_CARDS = 10;

    public RailPlayer(ArrayList<Card> cards,String name,String password){
        this.plants.add(new shootingPlant("Peashooter",2, 2, 2 ));
        this.plants.add(new shootingPlant("Snow pea",3, 3, 3 ));
        this.plants.add(new MinePlant("Explode-o-nut",4, 5, 3));
        this.plants.add(new shootingPlant("Scaredy-shroom",1, 2, 1 ));
        this.plants.add(new MinePlant("Cherry Bomb",2, 4, 0));
        this.plants.add(new throwingPlant("Kernel-pult",3, 3, 2 ));
        this.plants.add(new ProducerPlant("Sunflower",1, 2, 2 ));
        this.cards = cards;
        this.account = new Account(name, password);
        turn = 0;
        points = 0;
    }

    public void pointAdder(){
        points++;
    }

    public void removeZombie(Zombie zombie){
        zombies.remove(zombie);
    }

    public int getPoints() {
        return points;
    }

    public int getMAX_NUMBER_OF_CARDS() {
        return MAX_NUMBER_OF_CARDS;
    }


}


class ZombiePlayer extends Player {
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();

}





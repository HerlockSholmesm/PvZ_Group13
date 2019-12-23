import java.util.ArrayList;

public abstract class Zombie extends Card {

    private int life;
    private int speed;
    private int attackPower;
    private int x;
    private int y;
    Cell cell = new Cell();
    private int defense;
    private String name;

    /**
     * Sorry Dear Ali I needed all the zombies in an ArrayList
     */
    private static final ArrayList<Zombie> allZombies = new ArrayList<>();
    static {
        allZombies.add(new MovingZombie("Zombie",2,2,0));
        allZombies.add(new MovingZombie("Football Zombie",4,3,0));
        allZombies.add(new MovingZombie("Buckethead Zombie",3,2,0));
        allZombies.add(new MovingZombie("Conehead Zombie",3,2,0));
        allZombies.add(new MovingZombie("Zomboni",3,2,0));
        allZombies.add(new MovingZombie("Bungee Zombie",3,0,0));
        allZombies.add(new MovingZombie("BalloonZombie",3,2,0));
        allZombies.add(new MovingZombie("Newspaper Zombie",2,2,2));
        allZombies.add(new MovingZombie("Target Zombie",3,2,3));
        allZombies.add(new MovingZombie("Screen Door Zombie",2,2,4));
        allZombies.add(new MovingZombie("Giga-gargantuar",6,1,0));
        allZombies.add(new FlyingZombie("Pogo Zombie",2,2,0));
        allZombies.add(new SwimmingZombie("Snorkel Zombie",2,2,0));
        allZombies.add(new SwimmingZombie("Dolphin Rider Zombie",2,2,0));


    }

    public static ArrayList<Zombie> getAllZombies() {
        return allZombies;
    }

    public Zombie(int life, int speed, int defense, String name) {
        this.life = life;
        this.speed = speed;
        this.defense = defense;
        this.name = name;
    }

    public int getLife() {
        return life;
    }


    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setZombie(int x,int y) {
        this.x = x;
        this.y = y;
        cell=new Cell(x,y);
    }

    public void attack(Card card) {
        card.setLife(card.getLife()-attackPower);
    }

    public void beAttacked(Card card) {
        card.setLife(card.getLife()-attackPower);
    }

    public void move() {
        cell=new Cell(x+speed,y);
    }

}

class MovingZombie extends Zombie {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

    @Override
    public void move() {
        super.move();
    }

    public MovingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}

class FlyingZombie extends Zombie {
    public FlyingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

    @Override
    public void move() {
        super.move();
    }
}

class SwimmingZombie extends Zombie {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

    @Override
    public void move() {
        super.move();
    }

    public SwimmingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}

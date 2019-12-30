package in_game;

import model.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dynamic {
    public int attacks;

    public void clock() {
    }

    ;

    public void addCard() {
    }

    ;

    public void addPlant() {
    }

    ;

    public void plant() {
    }

    ;

    public void getInfo() {
    }

    ;

    public void addSuns() {
    }

    ;

    public void addCoins() {
    }

    ;

    public void kill() {
    }

    ;

    public void removePlant() {
    }

    ;

    public void attack() {
    }

    ;

    public void useShovel() {
    }

    ;

}

class DayAddSunRandomly {
    public static void addSun(PlayerDay playerDay) {
        int n = MathFunctions.getRandomNumber(2, 5);
        playerDay.addSuns(n);
    }
}

class DynamicShowHand {
    public static ArrayList<Card> getCards(Player player) {
        return player.getCards();
    }

}

class DayDynamicShowHand extends DynamicShowHand {

    public static int demandingSuns(PlayerDay playerDay) {
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
}


class DynamicSelect {
    public static void SelectThisCard(Card card) {
        card.setSelect(true);
    }

}

class DynamicDaySelect {
    public static boolean canIChoose(PlayerDay playerDay, Card card) {
        Plant plant = DynamicPlant.findPlant(card);
        int numberOfExtraSuns = DayDynamicShowHand.demandingSuns(playerDay);
        return (numberOfExtraSuns >= plant.getSun());
    }
}

class DynamicPlant {
    public static void plantMe(int x, int y, Card card, Player player) {
        Plant plant = findPlant(card);
        graphic.plant(x, y, plant);
        plant.setSelect(false);
        player.addPlant(plant);
        player.removeCard(card);
    }

    public static Plant findPlant(Card card) {
        for (Plant plant : Shop.getAllPlants()) {
            if (card.getName().equals(plant.getName())) {
                return plant;
            }
        }
        return null;
    }

    public static Card findSelectedCard(Player player) {
        for (Card card : player.getCards()) {
            if (card.isSelect()) {
                return card;
            }
        }
        return null;
    }


}

class DynamicRemovePlants {
    public static void removePlant(int x, int y, Player player) {
        Plant plant = graphic.findPlant(x, y);
        graphic.remove(x, y);
        player.removePlant(plant);
    }


}

class DynamicShowLawn {
    public static ArrayList<Plant> getMeThePlants(Player player) {
        return player.getPlants();
    }

    public static ArrayList<Zombie> getMeTheZombies(Player player) {
        return player.getZombies();
    }


}

class setAndChooseRandomZombies {
    public static ArrayList<Zombie> chooseAndSetRandomZombies(PlayerDay playerDay) {
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

}

class DynamicList {
    public static ArrayList<Card> List(Player player) {
        return player.getCards();
    }
}

class DynamicRailAddZombieRandomly {
    public static void addZombie(RailPlayer railPlayer) {
        int index = MathFunctions.getRandomNumber(0, Shop.getZombies().size() - 1);
        Zombie zombie = Shop.getZombies().get(index);
        railPlayer.getZombies().add(zombie);
    }
}

class DynamicDayAddCardRandomly {
    public static void addPlant(PlayerDay playerDay) {
        int index = MathFunctions.getRandomNumber(0, Shop.getAllPlants().size() - 1);
        Plant plant = Shop.getAllPlants().get(index);
        playerDay.addCard(plant);
    }
}

class DynamicRailKillZombie {
    public static void killZombie(RailPlayer railPlayer, Zombie zombie) {
        railPlayer.removeZombie(zombie);
        railPlayer.pointAdder();
    }

    public static Zombie findZombie(RailPlayer railPlayer, Zombie zombie) {
        for (Zombie z : railPlayer.getZombies()) {
            if (z.getName().equals(zombie.getName())) {
                return z;
            }
        }
        return null;
    }
}

class DynamicRailRecords {
    public static int getNumOfDeadZombies(RailPlayer railPlayer) {
        return railPlayer.getPoints();
    }
}
class EndTurn {
    public static void goOn(Player player) {
        player.addTurn();
    }
}
class DynamicZombieEndTurn extends EndTurn{
    public static void goOn(ZombiePlayer zombiePlayer){
        zombiePlayer.setKillPerTurn(0);
    }
}
class  DynamicZombieReward{
    public static void rewardZombie(ZombiePlayer zombiePlayer){
        zombiePlayer.coin.setCoinInTheGame(zombiePlayer.coin.getCoinInTheGame() + 10*zombiePlayer.getKillPerTurn());
    }
}
class DynamicZombiePut {
    public static void put(ZombiePlayer zombiePlayer, String name, int n) {
        Card card = findCard(name, zombiePlayer);
        for (int i = 0; i < n; i++) {
            zombiePlayer.addZombie(findZombie(card));
            zombiePlayer.removeCard(card);
        }
    }

    public static Card findCard(String name, ZombiePlayer zombiePlayer) {
        for (Card card : zombiePlayer.getCards()) {
            if (name.equals(card.getName())) {
                return card;
            }
        }
        return null;
    }

    public static Zombie findZombie(Card card) {
        for (Zombie zombie : Shop.getZombies()) {
            if (zombie.getName().equals(card.getName())) {
                return zombie;
            }
        }
        return null;
    }

    public static int howManyZombiesAreThere(int row, Yard yard) {
        int numOfZombiesInRow = 0;
        for (Zombie zombie : yard.getPlayer().getZombies()) {
            if (row == zombie.getX()) {
                numOfZombiesInRow++;
            }
        }
        return numOfZombiesInRow;
    }
}

class DynamicZombieKillPlant{
    public void killPlant(int x,int y,ZombiePlayer zombiePlayer){
        zombiePlayer.addKillPerTurn();
        DynamicRemovePlants.removePlant(x,y,zombiePlayer);

    }
}
class DynamicBuy{
    public static Zombie findZombie(String zombieName){
        for (Zombie zombie:Shop.getZombies()){
            if (zombie.getName().equals(zombieName)){
                return zombie;
            }
        }
        return null;
    }

    public static boolean doIHaveEnoughCoins(Player player,Card card){
        return player.getCoin().getCoinInTheGame() - card.getPrice() >= 0;
    }
}

class graphic {

    public static void plant(int x, int y, Card plant) {
    }

    public static Plant findPlant(int x, int y) {
        return null;
    }

    public static void remove(int x, int y) {
    }

}

class MathFunctions {
    public static int getRandomNumber(int min, int max) {
        int n = (int) (Math.random() * (max - min + 1) + min);
        return n;
    }
}

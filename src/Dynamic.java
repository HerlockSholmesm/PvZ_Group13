import java.util.ArrayList;
import java.util.List;
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


class DynamicDay extends Dynamic {
    public int attacks;

    public void getZombies() {
    }

    ;

    public void clock() {
    }

    ;//Control part must implement the time

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
    public static void SelectThisCard(Player player, int cardNumber) {
        player.getCards().get(cardNumber).setSelect(true);
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

class DynamicPVP {
    int wave;

    public void attack() {
    }

    ;

    public void socket() {
    }

    ;
    public DynamicZombieMode PZM;
    public DynamicDay PD;
}

class DynamicRail extends Dynamic {
    public void plant() {
    }

    ;

    public void addPlant() {
    }

    ;

    public void addCard() {
    }

    ;

    public void addCoins() {
    }

    ;

    public void addPoint() {
    }

    ;

    public void useShovel() {
    }

    ;
    public int kills;
    public int attacks;

    public void clock() {
    }

    ;

    public void getInfo() {
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

    public void getZombies() {
    }

    ;
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


class DynamicZombieMode extends Dynamic {
    public void put() {
    }

    ;

    public void addCard() {
    }

    ;

    public void addCoins() {
    }

    ;
    public int kills;

    public void clock() {
    }

    ;

    public void getInfo() {
    }

    ;

    public void kill() {
    }

    ;

    public void attack() {
    }

    ;

    public void getPlants() {
    }

    ;

    public void giveZombieThings() {
    }

    ;


}

class EndTurn {
    public static void goOn(Player player) {
        player.addTurn();
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Dynamic {
    public int attacks;
    public void clock(){};
    public void addCard(){};
    public void addPlant(){};
    public void plant(){};
    public void getInfo(){};
    public void addSuns(){};
    public void addCoins(){};
    public void kill(){};
    public void removePlant(){};
    public void attack(){};
    public void useShovel(){};

}


class DynamicDay extends Dynamic{
    public int attacks;
    public void getZombies(){};
    public void clock(){};//Control part must implement the time

    public void addCard(){};
    public void addPlant(){};
    public void plant(){};
    public void getInfo(){};
    public void addSuns(){};
    public void addCoins(){};
    public void kill(){};
    public void removePlant(){};
    public void attack(){};


}

class DynamicShowHand{
    public static ArrayList<Card> getCards(PlayerDay playerDay){
        return playerDay.getCards();
    }

    public static int demandingSuns(PlayerDay playerDay){
        /**the output indicates the number of suns player needs,so
         * if the output < 0, it means that we need "output" suns.
         * if the output > 0, it means we have extra "output" suns.
         */
        int allSunsPlayerHas = playerDay.getSuns();
        int allSunsPlayerMustHave = 0;
        for (Plant plant:playerDay.getPlants()){
            allSunsPlayerMustHave = allSunsPlayerMustHave + plant.getSun();
        }
        int allSunsPlayerNeeds = allSunsPlayerMustHave - allSunsPlayerHas;
        return allSunsPlayerNeeds;
    }
}

class DynamicSelect{
    public static void SelectThisCard(PlayerDay playerDay,Card card){
        card.setSelect(true);
    }

    public static Card findCard(PlayerDay playerDay,String name){
        for(Card card:playerDay.getCards()){
            if(card.getName() == name){
                return card;
            }
        }
        return null;
    }
}

class DynamicPlant{
    public static void plantMe(int x,int y,Card card,PlayerDay playerDay){
        Plant plant = findPlant(card);
        graphic.plant(x,y,plant);
        plant.setSelect(false);
        playerDay.addPlant(plant);
    }

    private static Plant findPlant(Card card){
        for (Plant plant:Shop.getAllPlants()){
            if (card.getName().equals(plant.getName())){
                return plant;
            }
        }
        return null;
    }

}

class DynamicRemovePlants{
    public static void removePlant(int x,int y,PlayerDay playerDay){
        Plant plant  = graphic.findPlant( x, y);
        graphic.remove(x,y);
        playerDay.removePlant(plant);
    }

    public static boolean isCommandValid(int x,int y){
        Plant plant  = graphic.findPlant( x, y);
        if (plant == null){
            return false;
        }
        else
            return true;
    }


}

class DynamicShowLawn{
    public static ArrayList<Plant> getMeThePlants(PlayerDay playerDay){
        return playerDay.getPlants();
    }

    public static ArrayList<Zombie> getMeTheZombies(PlayerDay playerDay){
        return playerDay.getZombies();
    }

    public static ArrayList<Zombie> chooseAndSetRandomZombies(PlayerDay playerDay){
        Random rand = new Random();
        ArrayList<Zombie> randomZombies = new ArrayList<>();
        int numberOfZombies = getRandomNumber(4,10);
        for (int i = 0; i <numberOfZombies;i++){
            int randomIndex = rand.nextInt(Shop.getZobbies().size());
            randomZombies.add((Zombie) Shop.getZobbies().get(randomIndex));
        }
        playerDay.setZombies(randomZombies);
        return randomZombies;
    }

    public static int getRandomNumber(int min,int max){
        int n = (int) (Math.random()*(max-min+1) + min);
        return n;
    }
}
class DynamicPVP {
    int wave;
    public void attack(){};
    public void socket(){};
    public DynamicZombieMode PZM;
    public DynamicDay PD;
}
class DynamicRail extends Dynamic {
    public void plant(){};
    public void addPlant(){};
    public void addCard(){};
    public void addCoins(){};
    public void addPoint(){};
    public void useShovel(){};
    public int kills;
    public int attacks;
    public void clock(){};
    public void getInfo(){};
    public void kill(){};
    public void removePlant(){};
    public void attack(){};
    public void getZombies(){};
}
class DynamicZombieMode extends Dynamic{
    public void put(){};
    public void addCard(){};
    public void addCoins(){};
    public int kills;
    public void clock(){};
    public void getInfo(){};
    public void kill(){};
    public void attack(){};
    public void getPlants(){};
    public void giveZombieThings(){};


}
class graphic{

    public static void plant(int x, int y, Card plant) {
    }

    public static Plant findPlant(int x, int y) {
        return null;
    }

    public static void remove(int x, int y) {
    }

    public static boolean canIPlant(int x, int y) {
        return true;
    }
}

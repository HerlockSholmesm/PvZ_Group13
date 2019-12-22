import java.util.ArrayList;

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
class ShowHands{
    public static ArrayList<Card> getCards(PlayerDay playerDay){
        return playerDay.getCards();
    }

    public static int demandingSuns(PlayerDay playerDay){
        int allSunsPlayerHas = playerDay.getSuns();
        int allSunsPlayerMustHave = 0;
        for (Plant plant:playerDay.getPlants()){
            allSunsPlayerMustHave = allSunsPlayerMustHave + plant.getSun();
        }
        int allSunsPlayerNeeds = allSunsPlayerMustHave - allSunsPlayerHas;
        return allSunsPlayerNeeds;
    }
}

class Select{
    public static void SelectThisCard(PlayerDay playerDay,Card card){
        /**to be implemented*/
        card.setSelect(true);
    }
    public static boolean isCommandValid(PlayerDay playerDay,Card card){
        return true;
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

class PlantMe{
    public static void plantMe(int x,int y,Card plant,PlayerDay playerDay){
        graphic.plant(x,y,plant);
        plant.setSelect(false);
        playerDay.addPlant(plant);

    }

    public static boolean isCommandValid(int x,int y,Card plant,PlayerDay playerDay){
        if (graphic.canIPlant(x,y) && (playerDay.getNumOfPlants() < playerDay.getValidNumOfPlants())){
            return true;
        }
        else
            return false;
    }
}

class RemovePlants{
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

    public static void plant(int x, int y, Plant plant) {
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

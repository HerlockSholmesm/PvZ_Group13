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


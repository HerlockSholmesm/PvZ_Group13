import java.util.ArrayList;

public class Shop {
    private ArrayList<Card> cardsBought;
    private ArrayList<Card> cardsNotBought;
    private void importPlant(){
        Plant Peashooter =new shootingPlant(2,2,2,"dfsfs");
        Plant SnowPea =new shootingPlant(3,3,3,"dfsfs");
        Plant Cabbage_pult =new throwingPlant(2,3,2,"dfsfs");
        Plant Repeater =new shootingPlant(3,4,4,"dfsfs");
        Plant Threepeater =new shootingPlant(4,4,5,"dfsfs");
        Plant Cactus=new shootingPlant(5,4,5,"dfsfs");
        Plant GatlingPea =new shootingPlant(5,4,3,"dfsfs");
        Plant Scaredy_shroom =new shootingPlant(1,2,1,"dfsfs");
        Plant Kernel_pult =new throwingPlant(3,3,2,"dfsfs");
        Plant Split_Pea =new shootingPlant(4,4,3,"dfsfs");
        Plant Explode_o_nut =new EatablePlant(4,5,3,"dfsfs");
        Plant Melon_pult =new throwingPlant(3,3,3,"dfsfs");
        Plant Lily_Pad =new ProducerPlant(0,1,1,"dfsfs");
        Plant Winter_Melon =new throwingPlant(4,5,3,"dfsfs");
        Plant Wall_nut =new ProducerPlant(2,4,4,"dfsfs");
        Plant Tangle_Kelp =new EatablePlant(3,3,0,"dfsfs");
        Plant Tall_nut =new ProducerPlant(4,6,6,"dfsfs");
        Plant Cattail=new EatablePlant(5,5,3,"dfsfs");
        Plant Potato_Mine =new EatablePlant(2,3,1,"dfsfs");
        Plant Cherry_Bomb =new EatablePlant(2,4,2,"dfsfs");
        Plant Magnet_shroom =new EatablePlant(2,4,4,"dfsfs");
        Plant Sunflower =new ProducerPlant(1,2,2,"dfsfs");
        Plant Twin_Sunflower =new ProducerPlant(3,5,2,"dfsfs");
        Plant Jalapeno =new EatablePlant(4,5,2,"dfsfs");



    }
    private void importZombie(){
        Zombie zombie=new MovingZombie(2,2,"sdfsd",0);
        Zombie Football_Zombie=new MovingZombie(3,4,"sdfsd",0);
        Zombie Buckethead_Zombie=new MovingZombie(2,3,"sdfsd",0);
        Zombie Conehead_Zombie=new MovingZombie(2,3,"sdfsd",0);
        Zombie Zomboni=new MovingZombie(2,3,"sdfsd",0);
        Zombie Catapult_Zombie=new MovingZombie(2,3,"sdfsd",0);
        Zombie Bungee_Zombie=new MovingZombie(0,3,"sdfsd",0);
        Zombie Balloon_Zombie=new MovingZombie(2,2,"sdfsd",0);
        Zombie Newspaper_Zombie=new MovingZombie(2,3,"sdfsd",2);
        Zombie Target_Zombie=new MovingZombie(2,3,"sdfsd",3);
        Zombie Screen_Door_Zombie=new MovingZombie(2,2,"sdfsd",4);
        Zombie Giga_gargantuar=new MovingZombie(1,6,"sdfsd",0);
        Zombie Pogo_Zombie=new FlyingZombie(2,2,"sdfsd",0);
        Zombie Snorkel_Zombie=new SwimmingZombie(2,2,"sdfsd",0);
        Zombie Dolphin_Rider_Zombie=new SwimmingZombie(2,2,"sdfsd",0);
    }

}

package model;

import in_game.Game;
import in_game.GameDay;
import javafx.scene.image.Image;

public class MinePlant extends Plant {
    public MinePlant(String name, int cells, int sun, int rest, int life, Image image) {

        super(name, 0, sun, rest, life,image );
    }

    @Override
    public void action(Game game) {
        for (Zombie zombie : game.getZombies()) {
            switch (this.getName()) {
                case ("Potato Mine"):
                    if (this.getClock() <= game.getTurn() && this.getXCoordinate(new DayYard((GameDay)game)) == zombie.getX(new DayYard((GameDay)game)) && this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game))) {
                        zombie.setLife(0);
                        this.setLife(0);
                    }
                    break;
                case ("Cherry Bomb"): {
                    if ((this.getClock() <= game.getTurn()) && ((this.getXCoordinate(new DayYard((GameDay)game)) == zombie.getX(new DayYard((GameDay)game))) && ((this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) + 1)
                            || (this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) - 1)))) {
                        zombie.setLife(0);
                        this.setLife(0);
                    }
                    if (this.getClock() <= game.getTurn() && ((this.getXCoordinate() == zombie.getX()+1) && ((this.getYCoordinate() == zombie.getY() + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1)))) {
                        zombie.setLife(0);
                        this.setLife(0);
                    }
                    if (this.getClock() <= game.getTurn() && ((this.getXCoordinate(new DayYard((GameDay)game)) == zombie.getX(new DayYard((GameDay)game))-1) && ((this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) + 1)
                            || (this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) - 1)))) {
                        zombie.setLife(0);
                        this.setLife(0);
                    }
                }
                break;
                case ("Magnet-shroom"):{
                    if (this.getClock() <= game.getTurn() && ((this.getXCoordinate(new DayYard((GameDay)game)) == zombie.getX(new DayYard((GameDay)game))) && ((this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1)||
                            (this.getYCoordinate() == zombie.getY() )))) {
                        zombie.setLife(0);
                    }
                    if (this.getClock() <= game.getTurn() && ((this.getXCoordinate(new DayYard((GameDay)game)) == zombie.getX(new DayYard((GameDay)game))+1) && ((this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) + 1)
                            || (this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) - 1)||
                            (this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) )))) {
                        zombie.setLife(0);
                    }
                    if (this.getClock() <= game.getTurn() && ((this.getXCoordinate(new DayYard((GameDay)game)) == zombie.getX(new DayYard((GameDay)game))-1) && ((this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) + 1)
                            || (this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) - 1)||
                            (this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) )))) {
                        zombie.setDefense(0);
                    }
                    }
                    break;
                case ("Jalapeno"):
                    if (this.getYCoordinate(new DayYard((GameDay)game)) == zombie.getY(new DayYard((GameDay)game)) ) {
                        zombie.setLife(0);
                    }
                    break;
            }
        }
    }

    @Override
    public Image getCardImage() {
        switch (this.getName()) {
            case ("Potato Mine"):
                return new Image("Plants vs Zombies/Potato Mine/Potato_Mine_Seed.webp");
            case ("Cherry Bomb"): {
                return new Image("Plants vs Zombies/Cherry Bomb/Cherryexplosion.PNG (2).png");
            }
            case ("Magnet-shroom"):{
                return new Image("Plants vs Zombies/Magnet-shroom/Melon-pult.webp");
            }
            case ("Jalapeno"):
                return new Image("Plants vs Zombies/Jalapeno/Magnetshroom_head4.webp");
            default:
                return null;
        }
    }
}

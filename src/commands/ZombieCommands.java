package commands;
import commands.Menu.Menu;
import commands.Menu.PlayMenu;
import commands.Menu.ShopMenu;
import in_game.Dynamic;
import in_game.DynamicZombie;
import in_game.ZombieGame;
import model.Card;
import model.Zombie;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ZombieCommands {
    //public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    ZombieCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {

        //allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr, ZombieGame zombiePlayer);


}
class Exit extends ZombieCommands {
    private Pattern pattern = Pattern.compile("exit (.)+", Pattern.CASE_INSENSITIVE);

    Exit(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new PlayMenu();
        }
    }
}

class Help extends ZombieCommands {
    private Pattern pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);

    Help(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr=new ShopMenu();
            //todo
            menuPtr.help();
        }
    }
}


class ShowHandZombie extends ZombieCommands {
    Pattern pattern = Pattern.compile("show hand", Pattern.CASE_INSENSITIVE);
    ShowHandZombie(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            Dynamic.printer(zombiePlayer.getCards(), "Names", "SunsTheyNeed");
        }
    }
}


class ShowLanes extends ZombieCommands {
    Pattern pattern = Pattern.compile("Show lanes", Pattern.CASE_INSENSITIVE);
    ShowLanes(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            DynamicZombie dynamicZombie = new DynamicZombie(zombiePlayer);
            dynamicZombie.showLanePrinter();
        }
    }
}


class Put extends ZombieCommands {
    Pattern pattern = Pattern.compile("Put ((.),(.))+", Pattern.CASE_INSENSITIVE);
    Put(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            String zombieName = matcher.group(2);
            String rowNumber = matcher.group(3);
            try{
                int row = Integer.parseInt(rowNumber);
                DynamicZombie dynamicZombie = new DynamicZombie(zombieGame);
                Card card = dynamicZombie.findCard(zombieGame,zombieName);
                if (card == null){
                    System.out.println("You don't have such a zombie or the zombie name is invalid");
                }
                else {
                    Zombie zombie = dynamicZombie.findZombie(card);
                    if (zombie == null){
                        System.out.println("Such a zombie doesn't exist on your list!");
                    }
                    else{
                        if (row >= 0 && row <= 5){
                            if (DynamicZombie.howManyZombiesAreThere(row, zombieGame.getYard()) <= 1)
                                DynamicZombie.put(zombieGame,zombie,row);
                            else
                                System.out.println("the row " + row + " is full.");
                        }
                        else{
                            System.out.println("Such a row doesn't exist!");
                        }
                    }

                }
            } catch (NumberFormatException e){
                System.out.println("PLEASE ENTER AN INTEGER AS THE LAST INPUT OF PUT COMMAND");
            }
        }
    }
}



class Start extends ZombieCommands {
    Pattern pattern = Pattern.compile("start", Pattern.CASE_INSENSITIVE);

    Start(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr,ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            zombieGame.setStart(true);
        }
    }
}

class EndTurn extends ZombieCommands {
    Pattern pattern = Pattern.compile("End turn", Pattern.CASE_INSENSITIVE);

    EndTurn(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr,ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            DynamicZombie dynamicZombie = new DynamicZombie(zombieGame);
            dynamicZombie.endTurn();
        }
    }
}

class ShowLawnZombie extends ZombieCommands {
    Pattern pattern = Pattern.compile("Showlawn", Pattern.CASE_INSENSITIVE);

    ShowLawnZombie(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr,ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            Dynamic.ShowLawnPrinter(zombieGame.getPlants(), zombieGame.getZombies(), "life", "Coordinate");
        }
    }
}
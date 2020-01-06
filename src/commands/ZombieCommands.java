package commands;

import commands.Menu.Menu;
import commands.Menu.PlayMenu;
import commands.Menu.ShopMenu;
import commands.Menu.ZombieMenu;
import in_game.Dynamic;
import in_game.DynamicZombie;
import in_game.GameCondition;
import in_game.ZombieGame;
import model.Card;
import model.Zombie;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ZombieCommands {
    public static ArrayList<ZombieCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    ZombieCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand = new ArrayList<>();
        allCommand.add(new EndTurn(input, menuPtr));
        allCommand.add(new Exit(input, menuPtr));
        allCommand.add(new Help(input, menuPtr));
        allCommand.add(new Put(input, menuPtr));
        allCommand.add(new ShowHandZombie(input, menuPtr));
        allCommand.add(new ShowLanes(input, menuPtr));
        allCommand.add(new ShowLawnZombie(input, menuPtr));
        allCommand.add(new Start(input, menuPtr));
    }

    abstract public Menu action(Menu menuPtr, ZombieGame zombiePlayer);


}

class Exit extends ZombieCommands {

    Exit(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("exit (.)+", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return menuPtr.exit(menuPtr);
        }
        return menuPtr;
    }
}

class Help extends ZombieCommands {
    Help(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr.help();
        }
        return menuPtr;
    }
}


class ShowHandZombie extends ZombieCommands {
    ShowHandZombie(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show hand", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Dynamic.printer(zombiePlayer.getCards(), "Names", "SunsTheyNeed");
        }
        return menuPtr;

    }
}


class ShowLanes extends ZombieCommands {
    ShowLanes(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Show lanes", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombiePlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            DynamicZombie dynamicZombie = new DynamicZombie(zombiePlayer);
            dynamicZombie.showLanePrinter();
        }
        return menuPtr;
    }
}


class Put extends ZombieCommands {
    Put(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Put ((.),(.))+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String zombieName = matcher.group(2);
            String rowNumber = matcher.group(3);
            try {
                int row = Integer.parseInt(rowNumber);
                DynamicZombie dynamicZombie = new DynamicZombie(zombieGame);
                Card card = Dynamic.findCard(zombieGame, zombieName);
                if (card == null) {
                    System.out.println("You don't have such a zombie or the zombie name is invalid");
                } else {
                    Zombie zombie = Dynamic.findZombie(card);
                    if (zombie == null) {
                        System.out.println("Such a zombie doesn't exist on your list!");
                    } else {
                        if (row >= 0 && row <= 5) {
                            if (DynamicZombie.howManyZombiesAreThere(row, zombieGame.getYard()) <= 1)
                                DynamicZombie.put(zombieGame, zombie, row);
                            else
                                System.out.println("the row " + row + " is full.");
                        } else {
                            System.out.println("Such a row doesn't exist!");
                        }
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("PLEASE ENTER AN INTEGER AS THE LAST INPUT OF PUT COMMAND");
            }

        }
        return menuPtr;
    }
}


class Start extends ZombieCommands {
    Start(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("start", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            zombieGame.setStart(true);
        }
        return menuPtr;

    }
}

class EndTurn extends ZombieCommands {
    EndTurn(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("End turn", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            DynamicZombie dynamicZombie = new DynamicZombie(zombieGame);
            if (dynamicZombie.hasGameEnded()) {
                System.out.println("Game has ended");
                menuPtr = new PlayMenu();
                if (zombieGame.getGameCondition() == GameCondition.WINNER)
                    System.out.println("YOU WON!!");
                else {
                    System.out.println("YOU LOST!!!");
                }
            }
            else if(dynamicZombie.hasWaveFinished()){
                menuPtr = new ZombieMenu();
                System.out.println("Wave Has Finished");
            }
            else if (zombieGame.isStart()) {
                dynamicZombie.endTurn();
            } else {
                System.out.println("You haven't started the game yet");
            }

        }
        return menuPtr;

    }
}

class ShowLawnZombie extends ZombieCommands {
    ShowLawnZombie(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Showlawn", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, ZombieGame zombieGame) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            Dynamic.ShowLawnPrinter(zombieGame.getPlants(), zombieGame.getZombies(), "life", "Coordinate");
        }
        return menuPtr;
    }
}
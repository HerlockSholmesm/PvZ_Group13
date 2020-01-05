package commands;
import commands.Menu.Menu;
import commands.Menu.RailMenu;
import commands.Menu.CollectionMenu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PlayMenuCommands {
    public static ArrayList<PlayMenuCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    PlayMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new DayCommand(input, menuPtr));
        allCommand.add(new PvPCommand(input, menuPtr));
        allCommand.add(new RailCommand(input, menuPtr));
        allCommand.add(new WaterCommand(input, menuPtr));
        allCommand.add(new ZombieCommand(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);

}


class DayCommand extends PlayMenuCommands {
    Pattern pattern = Pattern.compile("day", Pattern.CASE_INSENSITIVE);
    DayCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            new CollectionMenu();
            // TODO: 12/29/2019
        }
    }
}



class WaterCommand extends PlayMenuCommands {
    Pattern pattern = Pattern.compile("water", Pattern.CASE_INSENSITIVE);
    WaterCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            new CollectionMenu();
            // TODO: 12/29/2019
        }
    }
}


class RailCommand extends PlayMenuCommands {
    Pattern pattern = Pattern.compile("rail", Pattern.CASE_INSENSITIVE);
    RailCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            menuPtr = new RailMenu();
        }
    }
}


class ZombieCommand extends PlayMenuCommands {
    Pattern pattern = Pattern.compile("zombie", Pattern.CASE_INSENSITIVE);
    ZombieCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            menuPtr = new CollectionMenu();
        }
    }
}

class PvPCommand extends PlayMenuCommands {
    Pattern pattern = Pattern.compile("pvp  (\\d)+", Pattern.CASE_INSENSITIVE);
    PvPCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}



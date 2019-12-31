package commands;
import in_game.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PlantCollectionMenuCommands {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    PlantCollectionMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {

        allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr, Account account);
}


class ShowHandCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show hand",Pattern.CASE_INSENSITIVE);
    ShowHandCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            account.getCollection().showHand();
        }
    }
}


class ShowCollectionPlantCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show collection",Pattern.CASE_INSENSITIVE);
    ShowCollectionPlantCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            account.getCollection().showCollection();
        }
    }
}


class SelectPlantCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("select (.)+",Pattern.CASE_INSENSITIVE);
    SelectPlantCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
           account.getCollection().addToHand(matcher.group(1));
        }
    }
}



class PlayCommandPlantCollectionCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("play",Pattern.CASE_INSENSITIVE);
    PlayCommandPlantCollectionCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            // TODO: 12/29/2019 : how to understand from which type we
            // we've got here
        }
    }
}
package commands;

import commands.Menu.Menu;
import in_game.Account;
import in_game.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CollectionMenuCommands {
    public static ArrayList<CollectionMenuCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    CollectionMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand = new ArrayList<>();
        allCommand.add(new ExitCollection(input, menuPtr));
        allCommand.add(new HelpCollection(input, menuPtr));
        allCommand.add(new SelectCommand(input, menuPtr));
        allCommand.add(new ShowCollectionCommand(input, menuPtr));
        allCommand.add(new ShowHandCommand(input, menuPtr));
    }

    abstract public Menu action(Menu menuPtr, Account account);

}

class ExitCollection extends CollectionMenuCommands {

    ExitCollection(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return menuPtr.exit(menuPtr);
        }
        return menuPtr;
    }

}

class HelpCollection extends CollectionMenuCommands {

    HelpCollection(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr.help();
        }
        return menuPtr;
    }
}


class ShowHandCommand extends CollectionMenuCommands {
    ShowHandCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show hand", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.getCollection().showHand();
        }
        return menuPtr;
    }
}


class ShowCollectionCommand extends CollectionMenuCommands {

    ShowCollectionCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show collection", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.getCollection().showCollection();
        }
        return menuPtr;
    }
}


class SelectCommand extends CollectionMenuCommands {

    SelectCommand(String input, Menu menuPtr) {
        super(input, menuPtr);pattern = Pattern.compile("select (.)+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.getCollection().addToHand(matcher.group(1));
        }
        return menuPtr;
    }
}

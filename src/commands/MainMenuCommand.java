package commands;

import commands.Menu.*;
import in_game.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MainMenuCommand {

    public static ArrayList<MainMenuCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    MainMenuCommand(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand = new ArrayList<>();
        allCommand.add(new HelpMain(input, menuPtr));
        allCommand.add(new ExitMain(input, menuPtr));
        allCommand.add(new PlayCommand(input, menuPtr));
        allCommand.add(new ProfileCommand(input, menuPtr));
        allCommand.add(new ShopCommand(input, menuPtr));
    }

    abstract public Menu action(Menu menuPtr, Account account);

}


class PlayCommand extends MainMenuCommand {

    PlayCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("play", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Menu action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return new PlayMenu();
        }
        return menu;
    }
}


class ProfileCommand extends MainMenuCommand {

    ProfileCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Profile", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return new ProfileMenu();
        }
        return menu;
    }
}

class ShopCommand extends MainMenuCommand {

    ShopCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Shop", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return new ShopMenu();
        }
        return menu;
    }
}

class HelpMain extends MainMenuCommand {

    HelpMain(String input, Menu menuPtr) {
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

class ExitMain extends MainMenuCommand {

    ExitMain(String input, Menu menuPtr) {
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


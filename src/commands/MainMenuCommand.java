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
    private Pattern pattern = Pattern.compile("Play", Pattern.CASE_INSENSITIVE);

    PlayCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public Menu action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Menu newMenu = new PlayMenu();
            ((MainMenu) newMenu).parentMenu = menu;
            return newMenu;
        }
        return menu;
    }
}


class ProfileCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Profile", Pattern.CASE_INSENSITIVE);

    ProfileCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public Menu action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Menu newMenu = new ProfileMenu();
            ((MainMenu) newMenu).parentMenu = menu;
            return newMenu;
        }
        return menu;
    }
}

class ShopCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Shop", Pattern.CASE_INSENSITIVE);

    ShopCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public Menu action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Menu newMenu = new ShopMenu();
            ((MainMenu) newMenu).parentMenu = menu;
            return newMenu;
        }
        return menu;
    }
}

class HelpMain extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);

    HelpMain(String input, Menu menuPtr) {
        super(input, menuPtr);
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
    private Pattern pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    ExitMain(String input, Menu menuPtr) {
        super(input, menuPtr);
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


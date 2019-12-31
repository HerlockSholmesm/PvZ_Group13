package commands;

import in_game.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MainMenuCommand {

    public static ArrayList<commands.LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    MainMenuCommand(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new commands.CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr, Account account);

}


class PlayCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Play", Pattern.CASE_INSENSITIVE);

    PlayCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menu = new PlayMenu();

        }

    }
}


class ProfileCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Profile", Pattern.CASE_INSENSITIVE);

    ProfileCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menu = new ProfileMenu();
        }

    }
}

class ShopCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Shop", Pattern.CASE_INSENSITIVE);

    ShopCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menu = new ShopMenu();
        }

    }
}

class HelpMain extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);

    HelpMain(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new MainMenu();
            menuPtr.help();
        }
    }

}

class ExitMain extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    ExitMain(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new LoginMenu();
        }
    }
}


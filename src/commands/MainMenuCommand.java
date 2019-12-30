package commands;

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

    abstract public void action(Menu menuPtr);

}


class PlayCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Play");

    PlayCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menu = new PlayMenu();

        }

    }
}


class ProfileCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Profile");

    ProfileCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menu = new ProfileMenu();
        }

    }
}

class ShopCommand extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("Shop");

    ShopCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menu = new ShopMenu();
        }

    }
}


class ExitMain extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("exit");

    ExitMain(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new LoginMenu();
        }
    }
}

class HelpMain extends MainMenuCommand {
    private Pattern pattern = Pattern.compile("help");

    HelpMain(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("Please Enter Play Or Shop Or exit");
        }
    }

}
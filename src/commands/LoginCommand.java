package commands;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class LoginCommand {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    LoginCommand(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new CreateAccount(input, menuPtr));

    }

    abstract public void action(Menu menuPtr);
}

class CreateAccount extends LoginCommand {
    private Pattern pattern = Pattern.compile("create account (.+) (.+)");

    CreateAccount(String string, Menu menu) {
        super(string, menu);
        super.pattern = this.pattern;
    }

    @Override
    public void action(Menu menu) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            // TODO: 12/24/2019
        }
    }
}

class Login extends LoginCommand {
    private Pattern pattern = Pattern.compile("login (.+) (.+)");

    Login(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            // TODO: 12/24/2019
        }

    }
}

class LeaderBoardCommand extends LoginCommand {
    private Pattern pattern = Pattern.compile("Leaderboard");

    LeaderBoardCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new LeaderBoard();
        }
    }
}
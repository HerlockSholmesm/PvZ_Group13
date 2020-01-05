package commands;


import commands.Menu.LeaderBoardMenu;
import commands.Menu.Menu;
import in_game.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class LoginCommand {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    commands.Menu.Menu menu;
    public Account account = null;

    LoginCommand(String input, commands.Menu.Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, commands.Menu.Menu menuPtr) {
        LoginCommand.allCommand = new ArrayList<>();
        allCommand.add(new CreateAccount(input, menuPtr));
        allCommand.add(new ExitLogin(input, menuPtr));
        allCommand.add(new HelpLogin(input, menuPtr));
        allCommand.add(new LeaderBoardCommand(input, menuPtr));
        allCommand.add(new Login(input, menuPtr));
    }

    abstract public void action(commands.Menu.Menu menuPtr, Account account);
}

class CreateAccount extends LoginCommand {

    CreateAccount(String input, commands.Menu.Menu menu) {
        super(input, menu);
        super.pattern = this.pattern;
    }

    @Override
    public void action(commands.Menu.Menu menu, Account account) {

    }
}

class Login extends LoginCommand {
    private


    Login(String input, commands.Menu.Menu menuPtr) {
        super(input, menuPtr);
        super.pattern = this.pattern;

    }

    @Override
    public void action(commands.Menu.Menu menu, Account account) {
    }
}

class LeaderBoardCommand extends LoginCommand {
    private Pattern pattern = Pattern.compile("Leaderboard", Pattern.CASE_INSENSITIVE);

    LeaderBoardCommand(String input, commands.Menu.Menu menuPtr) {
        super(input, menuPtr);
        super.pattern = this.pattern;

    }

    @Override
    public void action(commands.Menu.Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Menu newMenu = new LeaderBoardMenu();
            ((LeaderBoardMenu) newMenu).parentMenu = menuPtr;
            menuPtr = newMenu;
        }
    }
}

class HelpLogin extends LoginCommand {
    private Pattern pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);

    HelpLogin(String input, commands.Menu.Menu menuPtr) {
        super(input, menuPtr);
        super.pattern = this.pattern;

    }

    @Override
    public void action(commands.Menu.Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr.help();
        }
    }
}

class ExitLogin extends LoginCommand {
    private Pattern pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    ExitLogin(String input, commands.Menu.Menu menuPtr) {
        super(input, menuPtr);
        super.pattern = this.pattern;

    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            this.menu = menuPtr.exit(menuPtr);
        }
    }
}



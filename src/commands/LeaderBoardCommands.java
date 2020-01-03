package commands;

import commands.Menu.Menu;
import in_game.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LeaderBoardCommands {
    public static ArrayList<LeaderBoardCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    LeaderBoardCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new ShowLeaderBoard(input, menuPtr));
        allCommand.add(new ExitLeaderBoard(input, menuPtr));
        allCommand.add(new HelpLeaderBoard(input, menuPtr));
    }

    abstract public void action(Menu menuPtr, Account account);
}

class ShowLeaderBoard extends LeaderBoardCommands {
    Pattern pattern = Pattern.compile("show", Pattern.CASE_INSENSITIVE);

    ShowLeaderBoard(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.showLeaderBoard();
        }

    }
}

class HelpLeaderBoard extends LeaderBoardCommands {
    Pattern pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);

    HelpLeaderBoard(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new LeaderBoard();
            menuPtr.help();
        }
    }
}

class ExitLeaderBoard extends LeaderBoardCommands {
    Pattern pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    ExitLeaderBoard(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = menuPtr.parentMenu;
        }
    }
}



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
        allCommand = new ArrayList<>();
        allCommand.add(new ShowLeaderBoard(input, menuPtr));
        allCommand.add(new ExitLeaderBoard(input, menuPtr));
        allCommand.add(new HelpLeaderBoard(input, menuPtr));
    }

    abstract public Menu action(Menu menuPtr, Account account);
}

class ShowLeaderBoard extends LeaderBoardCommands {

    ShowLeaderBoard(String input, Menu menuPtr) {
        super(input, menuPtr);pattern = Pattern.compile("show", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.showLeaderBoard();
        }
        return menuPtr;
    }
}

class HelpLeaderBoard extends LeaderBoardCommands {

    HelpLeaderBoard(String input, Menu menuPtr) {
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

class ExitLeaderBoard extends LeaderBoardCommands {

    ExitLeaderBoard(String input, Menu menuPtr) {
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



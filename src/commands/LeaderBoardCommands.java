package commands;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LeaderBoardCommands {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    LeaderBoardCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);
}

class ShowLeaderBoard extends LeaderBoardCommands {
    Pattern pattern = Pattern.compile("show");

    ShowLeaderBoard(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            // TODO: 12/29/2019
        }

    }
}

class ExitLeaderBoard extends LeaderBoardCommands {
    Pattern pattern = Pattern.compile("exit");
    ExitLeaderBoard(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            menuPtr = new LoginMenu();
        }
    }
}

class HelpLeaderBoard extends LeaderBoardCommands {
    Pattern pattern = Pattern.compile("help");
    HelpLeaderBoard(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            System.out.println("Please Enter Show Or Exit");
        }
    }
}

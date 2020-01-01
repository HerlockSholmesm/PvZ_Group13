package commands;
import model.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ZombieCommands {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    ZombieCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {

        allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);


}
class Exit extends ZombieCommands {
    private Pattern pattern = Pattern.compile("exit (.)+", Pattern.CASE_INSENSITIVE);

    Exit(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new MainMenu();
        }
    }
}

class Help extends ZombieCommands {
    private Pattern pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);

    Help(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr=new ShopMenu();
            //todo
            menuPtr.help();
        }
    }
}


class ShowHand extends ZombieCommands {
    Pattern pattern = Pattern.compile("show hand", Pattern.CASE_INSENSITIVE);
    ShowHand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}


class ShowLanes extends ZombieCommands {
    Pattern pattern = Pattern.compile("showlanes", Pattern.CASE_INSENSITIVE);
    ShowLanes(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}


class Put extends ZombieCommands {
    Pattern pattern = Pattern.compile("Put (.)+", Pattern.CASE_INSENSITIVE);
    Put(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}



class Start extends ZombieCommands {
    Pattern pattern = Pattern.compile("start (.)+", Pattern.CASE_INSENSITIVE);

    Start(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {

        }
    }
}

class EndTurn extends ZombieCommands {
    Pattern pattern = Pattern.compile("End turn (.)+", Pattern.CASE_INSENSITIVE);

    EndTurn(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {

        }
    }
}

class ShowLawn extends ZombieCommands {
    Pattern     pattern = Pattern.compile("Showlawn (.)+", Pattern.CASE_INSENSITIVE);

    ShowLawn(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {

        }
    }
}
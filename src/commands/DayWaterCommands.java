package commands;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DayWaterCommands {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    DayWaterCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {

        allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);
}

class ShowHandDay extends DayWaterCommands {
    Pattern pattern = Pattern.compile("show hand");

    ShowHandDay(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
//todo
        }
    }
}


class select extends DayWaterCommands {
    Pattern pattern = Pattern.compile("select");

    select(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {

        }
    }
}


class Plant extends DayWaterCommands {
    Pattern pattern = Pattern.compile("Plant (.)+");

    Plant(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {

        }
    }
}


class Remove extends DayWaterCommands {
    Pattern pattern = Pattern.compile("remove (.)+");

    Remove(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {

        }
    }

    class EndTurn extends DayWaterCommands {
        private Pattern pattern = Pattern.compile("end turn (.)+");

        EndTurn(String input, Menu menuPtr) {
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

    class ShowLawn extends DayWaterCommands {
        private Pattern pattern = Pattern.compile("show lawn (.)+");

        ShowLawn(String input, Menu menuPtr) {
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
    class Exit extends DayWaterCommands {
        private Pattern pattern = Pattern.compile("exit (.)+");

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

    class Help extends DayWaterCommands {
        private Pattern pattern = Pattern.compile("help");

        Help(String input, Menu menuPtr) {
            super(input, menuPtr);
        }

        @Override
        public void action(Menu menuPtr) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                menuPtr = new ShopMenu();
                menuPtr.help();
            }
        }
    }
}
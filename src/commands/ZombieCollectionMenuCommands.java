package commands;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ZombieCollectionMenuCommands {
        public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
        public Pattern pattern;
        String input;
        Menu menu;

        ZombieCollectionMenuCommands(String input, Menu menuPtr) {
            this.input = input;
            this.menu = menuPtr;
        }

        public static void createCommands(String input, Menu menuPtr) {
            allCommand.add(new CreateAccount(input, menuPtr));
        }

        abstract public void action(Menu menuPtr);

}


class ShowHandZombieCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show hand");
    ShowHandZombieCommand(String input, Menu menuPtr) {
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


class ShowCollectionZombieCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show collection");
    ShowCollectionZombieCommand(String input, Menu menuPtr) {
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


class SelectZombieCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("select (.)+");
    SelectZombieCommand(String input, Menu menuPtr) {
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



class PlayCommandZombieCollectionCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("play");
    PlayCommandZombieCollectionCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            // TODO: 12/29/2019 : how to understand from which type we
            // we've got here
        }
    }
}

package commands;
import commands.Menu.Menu;
import in_game.Account;
import in_game.*;
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

        abstract public void action(Menu menuPtr, Account account);

}


class ShowHandZombieCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show hand",Pattern.CASE_INSENSITIVE);
    ShowHandZombieCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            account.getCollection().showHand();
        }
    }
}


class ShowCollectionZombieCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show collection",Pattern.CASE_INSENSITIVE);
    ShowCollectionZombieCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            account.getCollection().showCollection();
        }
    }
}


class SelectZombieCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("select (.)+",Pattern.CASE_INSENSITIVE);
    SelectZombieCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            account.getCollection().addToHand(matcher.group(1));
        }
    }
}               



class PlayCommandZombieCollectionCommand extends ZombieCollectionMenuCommands {
    Pattern pattern = Pattern.compile("play",Pattern.CASE_INSENSITIVE);
    PlayCommandZombieCollectionCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            // TODO: 12/29/2019 : how to understand from which type we
            // we've got here
        }
    }
}

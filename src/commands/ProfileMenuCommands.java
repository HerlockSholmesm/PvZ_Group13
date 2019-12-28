package commands;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ProfileMenuCommands {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    ProfileMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new commands.CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);
}

class ChangeUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("change (.)+ (.)+");
    ChangeUserName(String input, Menu menuPtr) {
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


class DeleteUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("delete (.)+ (.)+");
    DeleteUserName(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}

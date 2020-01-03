package commands;
import model.*;
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
    Pattern pattern = Pattern.compile("change (.)+ (.)+", Pattern.CASE_INSENSITIVE);
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

class RenameUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("rename (.)+", Pattern.CASE_INSENSITIVE);
    RenameUserName(String input, Menu menuPtr) {
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

class CreateUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("change (.)+ (.)+", Pattern.CASE_INSENSITIVE);
    CreateUserName(String input, Menu menuPtr) {
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
    Pattern pattern = Pattern.compile("delete (.)+ (.)+", Pattern.CASE_INSENSITIVE);
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


class ShowUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("show", Pattern.CASE_INSENSITIVE);
    ShowUserName(String input, Menu menuPtr) {
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
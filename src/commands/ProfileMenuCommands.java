package commands;

import commands.Menu.LoginMenu;
import commands.Menu.Menu;
import in_game.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ProfileMenuCommands {
    public static ArrayList<ProfileMenuCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    ProfileMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new ChangeUserName(input, menuPtr));
        allCommand.add(new CreateUserName(input, menuPtr));
        allCommand.add(new DeleteUserName(input, menuPtr));
        allCommand.add(new RenameUserName(input, menuPtr));
        allCommand.add(new ShowUserName(input, menuPtr));
    }

    abstract public void action(Menu menuPtr, Account account);
}

class ChangeUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("change (.)+ (.)+", Pattern.CASE_INSENSITIVE);

    ChangeUserName(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.setName(matcher.group(1));
            account.setPassword(matcher.group(2));
        }
    }
}

class RenameUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("rename (.)+", Pattern.CASE_INSENSITIVE);

    RenameUserName(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            if (account.getName().equals(matcher.group(1))) {
                account.setName(matcher.group(1));
            }
        }
    }
}

class CreateUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("change (.)+ (.)+", Pattern.CASE_INSENSITIVE);

    CreateUserName(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
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
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            if (account.getName().equals(matcher.group(1))) {
                if (matcher.group(2).equals(account.getPassword())) {
                    Account.deleteAccount(account);
                    menuPtr = new LoginMenu();
                } else {
                    InvalidPrompt invalidPassword = () -> System.out.println("invalid Password");
                }
            }
        }
    }
}


class ShowUserName extends ProfileMenuCommands {
    Pattern pattern = Pattern.compile("show", Pattern.CASE_INSENSITIVE);

    ShowUserName(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println(account.getName());
        }
    }
}
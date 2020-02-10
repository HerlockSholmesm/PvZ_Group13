package commands;

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
        allCommand = new ArrayList<>();
        allCommand.add(new ChangeUserName(input, menuPtr));
        allCommand.add(new CreateUserName(input, menuPtr));
        allCommand.add(new DeleteUserName(input, menuPtr));
        allCommand.add(new RenameUserName(input, menuPtr));
        allCommand.add(new ShowUserName(input, menuPtr));
        allCommand.add(new ExitProfileMenu(input, menuPtr));
        allCommand.add(new HelpProfileMenu(input, menuPtr));
    }

    abstract public Menu action(Menu menuPtr, Account account);
}

class ChangeUserName extends ProfileMenuCommands {

    ChangeUserName(String input, Menu menuPtr) {
        super(input, menuPtr);pattern = Pattern.compile("change (.)+ (.)+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.setName(matcher.group(1));
            account.setPassword(matcher.group(2));
        }
        return menuPtr;
    }
}

class RenameUserName extends ProfileMenuCommands {

    RenameUserName(String input, Menu menuPtr) {
        super(input, menuPtr);pattern = Pattern.compile("rename (.)+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            if (account.getName().equals(matcher.group(1))) {
                account.setName(matcher.group(1));
            }
        }
        return menuPtr;
    }
}

class CreateUserName extends ProfileMenuCommands {

    CreateUserName(String input, Menu menuPtr) {
        super(input, menuPtr);pattern = Pattern.compile("change (.)+ (.)+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            // TODO: 12/29/2019
        }
        return menuPtr;
    }
}

class DeleteUserName extends ProfileMenuCommands {

    DeleteUserName(String input, Menu menuPtr) {
        super(input, menuPtr); pattern = Pattern.compile("delete (.)+ (.)+", Pattern.CASE_INSENSITIVE);


    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            if (account.getName().equals(matcher.group(1))) {
                if (matcher.group(2).equals(account.getPassword())) {
                    Account.deleteAccount(account);
                    return menuPtr.exit(menuPtr);
                } else {
                    InvalidPrompt invalidPassword = () -> System.out.println("invalid Password");
                    invalidPassword.action();
                }
            }
        }
        return menuPtr;
    }
}

class ShowUserName extends ProfileMenuCommands {

    ShowUserName(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println(account.getName());
        }
        return menuPtr;
    }
}

class HelpProfileMenu extends ProfileMenuCommands {

    HelpProfileMenu(String input, Menu menuPtr) {
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

class ExitProfileMenu extends ProfileMenuCommands{
    ExitProfileMenu(String input, Menu menuPtr) {
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
package commands;

import commands.Menu.MainMenu;
import commands.Menu.Menu;
import commands.Menu.ShopMenu;
import in_game.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ShopMenuCommands {
    public static ArrayList<ShopMenuCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    ShopMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand = new ArrayList<>();
        allCommand.add(new Buy(input, menuPtr));
        allCommand.add(new Money(input, menuPtr));
        allCommand.add(new ShowCollection(input, menuPtr));
        allCommand.add(new ShowShop(input, menuPtr));
        allCommand.add(new ExitShop(input, menuPtr));
        allCommand.add(new HelpShop(input, menuPtr));
    }

    public abstract Menu action(Menu menuPtr, Account account);

}

class ExitShop extends ShopMenuCommands {
    ExitShop(String input, Menu menuPtr) {
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

class HelpShop extends ShopMenuCommands {
    HelpShop(String input, Menu menuPtr) {
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

class ShowShop extends ShopMenuCommands {
    ShowShop(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show shop", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.getShop().showNotBaughtCard(account);

        }
        return menuPtr;
    }
}


class ShowCollection extends ShopMenuCommands {
    ShowCollection(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show collection", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.getShop().showCollection();
        }
        return menuPtr;
    }
}


class Buy extends ShopMenuCommands {
    Buy(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Buy (.)+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.getShop().BuyCard(matcher.group(1),account);
        }
        return menuPtr;
    }
}


class Money extends ShopMenuCommands {
    Money(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("money (.)+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            account.getShop().showMoney(account);
        }
        return menuPtr;
    }
}



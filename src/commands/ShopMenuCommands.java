package commands;

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

    public static void createCommands(String input, Menu menuPtr)
    {
        allCommand.add(new Buy(input, menuPtr));
        allCommand.add(new ExitShopMenu(input, menuPtr)) ;
        allCommand.add(new HelpShopMenu(input, menuPtr));
        allCommand.add(new Money(input, menuPtr));
        allCommand.add(new ShowCollection(input, menuPtr));
        allCommand.add(new ShowShop(input, menuPtr));
    }

    abstract public void action(Menu menuPtr, Account account);

}

class ShowShop extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("show shop", Pattern.CASE_INSENSITIVE);

    ShowShop(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            // TODO: 1/2/2020  : how to show shop of one account
        }
    }
}


class ShowCollection extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("show collection", Pattern.CASE_INSENSITIVE);

    ShowCollection(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            account.getCollection().showCollection();
        }
    }
}


class Buy extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("buy (.)+");

    Buy(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String name = matcher.group(1);

        }
    }
}


class Money extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("money (.)+");

    Money(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            System.out.println(account.getMoney());
        }
    }
}

class ExitShopMenu extends ShopMenuCommands {
    private Pattern pattern = Pattern.compile("exit (.)+");

    ExitShopMenu(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new MainMenu();
        }
    }
}

class HelpShopMenu extends ShopMenuCommands {
    private Pattern pattern = Pattern.compile("help");

    HelpShopMenu(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, Account account) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new ShopMenu();
            menuPtr.help();
        }
    }
}




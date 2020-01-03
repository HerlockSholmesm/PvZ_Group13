package commands;
import commands.Menu.MainMenu;
import commands.Menu.Menu;
import commands.Menu.ShopMenu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ShopMenuCommands {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    ShopMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);

}

class ShowShop extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("show shop", Pattern.CASE_INSENSITIVE);
    ShowShop(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}


class ShowCollection extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("show collection", Pattern.CASE_INSENSITIVE);
    ShowCollection(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}


class Buy extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("Buy (.)+", Pattern.CASE_INSENSITIVE);
    Buy(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){

        }
    }
}



class Money extends ShopMenuCommands {
    Pattern pattern = Pattern.compile("money (.)+", Pattern.CASE_INSENSITIVE);

    Money(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {

        }
    }

    class Exit extends ShopMenuCommands {
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

    class Help extends ShopMenuCommands {
        private Pattern pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);

        Help(String input, Menu menuPtr) {
            super(input, menuPtr);
        }

        @Override
        public void action(Menu menuPtr) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                menuPtr=new ShopMenu();
                menuPtr.help();
            }
        }
    }
}



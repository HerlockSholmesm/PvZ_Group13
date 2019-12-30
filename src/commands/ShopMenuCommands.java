package commands;
import model.*;
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
    Pattern pattern = Pattern.compile("show shop");
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
    Pattern pattern = Pattern.compile("show collection");
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
    Pattern pattern = Pattern.compile("Buy (.)+");
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
    Pattern pattern = Pattern.compile("money");
    Money(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()){

        }
    }
}



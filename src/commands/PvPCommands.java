package commands;

import commands.Menu.Menu;
import in_game.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PvPCommands {
    //public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    PvPCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {

        //allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr, PvPGame pvpGame);

}

class ShowHandPvP extends PvPCommands {
    Pattern pattern = Pattern.compile("show hand", Pattern.CASE_INSENSITIVE);

    ShowHandPvP(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, PvPGame pvpGame ) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            DynamicPVP dynamicPVP = new DynamicPVP(pvpGame);
            Dynamic.printer(pvpGame.getCards(), "Names", "SunsTheyNeed");
            System.out.println("all the suns you need for current plants: " + dynamicPVP.demandingSuns());
        }
    }
}



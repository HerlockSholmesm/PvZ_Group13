package commands;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PlantCollectionMenuCommands {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    PlantCollectionMenuCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);
}


class ShowHandCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show hand");
    ShowHandCommand(String input, Menu menuPtr) {
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


class ShowCollectionPlantCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("show collection");
    ShowCollectionPlantCommand(String input, Menu menuPtr) {
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


class SelectPlantCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("select (.)+");
    SelectPlantCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
           // System.out.println(Collection.sho);
        }
    }
}



class PlayCommandPlantCollectionCommand extends PlantCollectionMenuCommands {
    Pattern pattern = Pattern.compile("play");
    PlayCommandPlantCollectionCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            // TODO: 12/29/2019 : how to understand from which type we
            // we've got here
        }
    }
}
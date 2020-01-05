package commands;

import commands.Menu.Menu;
import in_game.*;
import model.Card;
import model.Plant;

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

class ShowHandPvPDay extends PvPCommands {
    Pattern pattern = Pattern.compile("show hand", Pattern.CASE_INSENSITIVE);

    ShowHandPvPDay(String input, Menu menuPtr) {
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


class SelectPvPDay extends PvPCommands {
    Pattern pattern = Pattern.compile("select (.)+", Pattern.CASE_INSENSITIVE);

    SelectPvPDay(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, PvPGame pvpGame) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String cardName = matcher.group(1);
            //does the player has this card?
            Plant wantedPlant = Dynamic.findPlant(cardName);
            if (wantedPlant == null) {
                InvalidPrompt invalidPrompt = () -> {
                    System.out.println("INVALID CARD NAME!");
                };
                invalidPrompt.action();
            } else {
                DynamicPVP dynamicPVP = new DynamicPVP(pvpGame);
                Card wantedCard = Dynamic.findPlant(wantedPlant);
                if (wantedCard == null) {
                    InvalidPrompt invalidPrompt = () -> {
                        System.out.println("CARD NOT ON YOUR LIST!");
                    };
                    invalidPrompt.action();
                    return;
                }
                if (dynamicPVP.canIChoose(wantedCard))
                    wantedCard.setSelect(true);
                else {
                    InvalidPrompt invalidPrompt = () -> {
                        System.out.println("YOU DON'T HAVE ENOUGH SUNS!");
                    };
                    invalidPrompt.action();
                }
            }
        }
    }
}


class PlantPvPDay extends PvPCommands {
    Pattern pattern = Pattern.compile("Plant ((.),(.))+");

    PlantPvPDay(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, PvPGame pvpGame) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Card card = Dynamic.findSelectedCard(pvpGame);
            if (card == null) {
                InvalidPrompt invalidPrompt = () -> {
                    System.out.println("NO CARD IS SELECTED!");
                };
                invalidPrompt.action();
            } else {
                String num1 = matcher.group(2);
                String num2 = matcher.group(3);
                try {
                    int x = Integer.parseInt(num1);
                    int y = Integer.parseInt(num2);
                    Plant plant = Dynamic.findPlant(Dynamic.findPlant(card));
                    if ((x >= 0) && (x <= 2) && (y >= 0) && (y <= 5)) {
                        Dynamic.setPlantPosition(x, y, plant, pvpGame);
                    } else {
                        InvalidPrompt invalidPrompt = () -> {
                            System.out.println("FIRST INTEGER MUST SATISFY:");
                            System.out.println("0 <= x <= 2");
                            System.out.println("SECOND INTEGER MUST SATISFY:");
                            System.out.println("0 <= Y <= 5.");
                        };
                        invalidPrompt.action();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("PLEASE ENTER TWO INTEGERS ALIKE:");
                    System.out.println("INT,INT AFTER Plant. THE FIRST INTEGER");
                    System.out.println("MUST BE A NUMBER BETWEEN 0 AND 18 AND");
                    System.out.println("THE SECOND INTEGER IS A NUMBER BETWEEN 0 AND 5!");
                }


            }
        }

    }
}


class RemovePvPDay extends PvPCommands {
    Pattern pattern = Pattern.compile("remove ((.),(.))+", Pattern.CASE_INSENSITIVE);

    RemovePvPDay(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, PvPGame pvpGame) {
        Matcher matcher = pattern.matcher(input.toLowerCase());
        if (matcher.matches()) {
            String num1 = matcher.group(2);
            String num2 = matcher.group(3);
            try {
                int x = Integer.parseInt(num1);
                int y = Integer.parseInt(num2);
                if ((x >= 0) && (x <= 18) && (y >= 0) && (y <= 5)) {
                    Plant plant = Graphic.findPlant(x, y);
                    if (plant == null) {
                        InvalidPrompt invalidPrompt = () -> {
                            System.out.println("THERE IS NO PLANT THERE!");
                        };
                        invalidPrompt.action();
                    } else {
                        Graphic.remove(x, y);
                        pvpGame.removePlant(plant);
                    }
                } else {
                    InvalidPrompt invalidPrompt = () -> {
                        System.out.println("PLEASE ENTER TWO INTEGERS ALIKE:");
                        System.out.println("INT,INT AFTER Plant. THE FIRST INTEGER");
                        System.out.println("MUST BE A NUMBER BETWEEN 0 AND 18 AND");
                        System.out.println("THE SECOND INTEGER IS A NUMBER BETWEEN 0 AND 5!");
                    };
                    invalidPrompt.action();
                }

            } catch (NumberFormatException e) {
                System.out.println("PLEASE ENTER TWO INTEGERS ALIKE:");
                System.out.println("INT,INT AFTER Plant. THE FIRST INTEGER");
                System.out.println("MUST BE A NUMBER BETWEEN 0 AND 18 AND");
                System.out.println("THE SECOND INTEGER IS A NUMBER BETWEEN 0 AND 5!");
            }

        }
    }
}


class ShowLawnPvP extends PvPCommands {
    private Pattern pattern = Pattern.compile("show lawn", Pattern.CASE_INSENSITIVE);

    ShowLawnPvP(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr, PvPGame pvpGame) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            //menuPtr = new MainMenu();
            Dynamic.ShowLawnPrinter(pvpGame.getPlants(), pvpGame.getZombies(), "life", "Coordinate");
        }
    }
}


class Ready extends PvPCommands {
    private Pattern pattern = Pattern.compile("Ready");

    Ready(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr,PvPGame pvpGame) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            //menuPtr = new MainMenu();
            pvpGame.setReady(true);
        }
    }
}





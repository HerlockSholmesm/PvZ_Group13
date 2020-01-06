package commands;

import commands.Menu.Menu;
import commands.Menu.PlayMenu;
import in_game.*;
import model.Card;
import model.Plant;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RailCommands {
    public static ArrayList<RailCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    RailCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand = new ArrayList<>();
        allCommand.add(new EndTurnRail(input, menuPtr));
        allCommand.add(new List(input, menuPtr));
        allCommand.add(new PlantRail(input, menuPtr));
        allCommand.add(new RailRemove(input, menuPtr));
        allCommand.add(new RailSelect(input, menuPtr));
        allCommand.add(new RailShowLawn(input, menuPtr));
        allCommand.add(new Record(input, menuPtr));
    }

    abstract public Menu action(Menu menuPtr, RailGame railPlayer);

}

class List extends RailCommands {
    List(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("List", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, RailGame railPlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Dynamic.cardPrinter(railPlayer.getCards());
        }
        return menuPtr;
    }
}

class RailSelect extends RailCommands {
    RailSelect(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("select (.)+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, RailGame railPlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String indexNum = matcher.group(1);
            //does the player has this card?
            try {
                int index = Integer.parseInt(indexNum);
                DynamicRail dynamicRail = new DynamicRail(railPlayer);
                if (index >= 0 && index <= railPlayer.getCards().size()) {
                    Card foundCard = dynamicRail.findCard(index);
                    foundCard.setSelect(true);
                    System.out.println("Card " + foundCard.getName() + " is selected.");
                } else {
                    System.out.println("Please enter an integer in the card number boundary!");
                }
            } catch (NumberFormatException e) {
                System.out.println("PLEASE ENTER AN INTEGER AFTER SELECT!");
            }


        }
        return menuPtr;
    }
}

class Record extends RailCommands {
    Record(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Record", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, RailGame railPlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            DynamicRail dynamicRail = new DynamicRail(railPlayer);
            System.out.println("The number of killed zombies is " + dynamicRail.getNumOfDeadZombies());
        }
        return menuPtr;
    }
}


class PlantRail extends RailCommands {
    PlantRail(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Plant ((.),(.))+");

    }

    @Override
    public Menu action(Menu menuPtr, RailGame railPlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Card card = Dynamic.findSelectedCard(railPlayer);
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
                    if ((x >= 0) && (x <= 18) && (y >= 0) && (y <= 5)) {
                        Dynamic.setPlantPosition(x, y, plant, railPlayer);
                    } else {
                        InvalidPrompt invalidPrompt = () -> {
                            System.out.println("FIRST INTEGER MUST SATISFY:");
                            System.out.println("0 <= x <= 18");
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
        return menuPtr;

    }
}


class RailRemove extends RailCommands {
    RailRemove(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("remove ((.),(.))+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, RailGame railPlayer) {
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
                        railPlayer.removePlant(plant);
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
        return menuPtr;
    }
}


class EndTurnRail extends RailCommands {
    EndTurnRail(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("end turn (.)+");

    }

    @Override
    public Menu action(Menu menuPtr, RailGame railPlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            DynamicRail dynamicRail = new DynamicRail(railPlayer);
            dynamicRail.endTurn();
        }
        return menuPtr;

    }
}

class RailShowLawn extends RailCommands {
    RailShowLawn(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show lawn", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, RailGame railPlayer) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Dynamic.ShowLawnPrinter(railPlayer.getPlants(), railPlayer.getZombies(), "life", "Coordinate");
        }
        return menuPtr;
    }

}



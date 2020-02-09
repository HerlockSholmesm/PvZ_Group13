package commands;

import commands.Menu.*;
import in_game.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DayWaterCommands {
    public static ArrayList<DayWaterCommands> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    DayWaterCommands(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {
        allCommand = new ArrayList<>();
        allCommand.add(new EndTurnDay(input, menuPtr));
        allCommand.add(new ExitDay(input, menuPtr));
        allCommand.add(new HelpDay(input, menuPtr));
        allCommand.add(new PlantDay(input, menuPtr));
        allCommand.add(new RemoveDay(input, menuPtr));
        allCommand.add(new SelectDay(input, menuPtr));
        allCommand.add(new ShowHandDay(input, menuPtr));
        allCommand.add(new ShowLawnDay(input, menuPtr));
    }

    abstract public Menu action(Menu menuPtr, GameDay playerDay);
}

class ShowHandDay extends DayWaterCommands {

    ShowHandDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show hand", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            DynamicDay dynamicDay = new DynamicDay(playerDay);
            Dynamic.printer(playerDay.getCards(), "Names", "SunsTheyNeed");
            System.out.println("all the suns you need for current plants: " + dynamicDay.demandingSuns());
        }
        return menuPtr;
    }
}


class SelectDay extends DayWaterCommands {
    SelectDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("select (.)+", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
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
                return menuPtr;
            } else {
                DynamicDay dynamicDay = new DynamicDay(playerDay);
                Card wantedCard = dynamicDay.findPlant(wantedPlant);
                if (wantedCard == null) {
                    InvalidPrompt invalidPrompt = () -> {
                        System.out.println("CARD NOT ON YOUR LIST!");
                    };
                    invalidPrompt.action();
                    return menuPtr;
                }
                if (dynamicDay.canIChoose(playerDay, wantedCard))
                    wantedCard.setSelect(true);
                else {
                    InvalidPrompt invalidPrompt = () -> {
                        System.out.println("YOU DON'T HAVE ENOUGH SUNS!");
                    };
                    invalidPrompt.action();
                }
            }
        }
        return menuPtr;
    }
}


class PlantDay extends DayWaterCommands {
    PlantDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("Plant ((.),(.))+");


    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            DynamicDay dynamicDay = new DynamicDay(playerDay);
            Card card = Dynamic.findSelectedCard(playerDay);
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
                        if (Shop.getWaterTypeOrDay().get(plant.getName()).equals("D") && (x <= 1 || x >= 4)){
                            Dynamic.setPlantPosition(x, y, plant, playerDay);
                        }
                        else if(Shop.getWaterTypeOrDay().get(plant.getName()).equals("W") && (x <= 3 && x >=2)){
                            Dynamic.setPlantPosition(x, y, plant, playerDay);
                        }
                        else{
                            InvalidPrompt invalidPrompt = () -> {
                                System.out.println("PLANT DAY-WATER MISMATCH!");
                            };
                            invalidPrompt.action();
                        }
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


class RemoveDay extends DayWaterCommands {
    RemoveDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("remove ((.),(.))+", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
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
                        playerDay.removePlant(plant);
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

class EndTurnDay extends DayWaterCommands {
    EndTurnDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("end turn",Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            //menuPtr = new MainMenu();
            DynamicDay dynamicDay = new DynamicDay(playerDay);
            if (dynamicDay.hasGameEnded()){
                System.out.println("Game has ended!");
                menuPtr = new PlayMenu();
            }
            else if (dynamicDay.hasWaveEnded()){
                System.out.println("Wave has ended!");
                menuPtr = new DayAndWater();
            }
            else{
                dynamicDay.endTurn();
            }

        }
        return menuPtr;
    }
}

class ShowLawnDay extends DayWaterCommands {
    ShowLawnDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("show lawn", Pattern.CASE_INSENSITIVE);

    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            //menuPtr = new MainMenu();
            Dynamic.ShowLawnPrinter(playerDay.getPlants(), playerDay.getZombies(), "life", "Coordinate");
        }
        return menuPtr;
    }
}

class ExitDay extends DayWaterCommands {
    ExitDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("exit (.)+");

    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return menuPtr.exit(menuPtr);
        }
        return menuPtr;
    }
}

class HelpDay extends DayWaterCommands {
    HelpDay(String input, Menu menuPtr) {
        super(input, menuPtr);
        pattern = Pattern.compile("help");

    }

    @Override
    public Menu action(Menu menuPtr, GameDay playerDay) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new ShopMenu();
            menuPtr.help();
        }
        return menuPtr;
    }
}

class PlayDay extends Application{
    private Group root;
    private Yard dayYard;

    public void setDayYard(DayYard dayYard) {
        this.dayYard = dayYard;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Plants VS Zombies");
        this.root = new Group();
        Scene scene = new Scene(root,1116, 602);
        Image background = new Image("/png/wallp.png");
        ImageView backgroundView = new ImageView(background);
        root.getChildren().add(backgroundView);
        GameDay gameDay = GameDay.getGame();
        DayYard dayYard = new DayYard(gameDay);


        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
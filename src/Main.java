import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commands.*;
import commands.Menu.*;
import commands.Menu.Menu;
import in_game.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menuPointer = new LoginMenu();
        Account mainAccount = null;
        int number = 0;
        mainWhile:
        while (true) {

            while (menuPointer instanceof LeaderBoardMenu) {
                String string = scanner.nextLine();
                LeaderBoardCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (LeaderBoardCommands commands1 : LeaderBoardCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof MainMenu) {
                String string = scanner.nextLine();
                MainMenuCommand.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (MainMenuCommand commands1 : MainMenuCommand.allCommand) {
                    Pattern pattern = (commands1.pattern);
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }
            }

            while (menuPointer instanceof ProfileMenu) {
                String string = scanner.nextLine();
                ProfileMenuCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (ProfileMenuCommands commands1 : ProfileMenuCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof ShopMenu) {
                String string = scanner.nextLine();
                ShopMenuCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (ShopMenuCommands commands1 : ShopMenuCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof CollectionMenu) {
                String string = scanner.nextLine();
                CollectionMenuCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (CollectionMenuCommands commands1 : CollectionMenuCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (string.equalsIgnoreCase("play")) {
                    menuPointer = new PlayMenu();
                    break;
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof DayAndWater) {
                assert mainAccount != null;
                GameDay gameDay = new GameDay(mainAccount.getName(), mainAccount.getPassword());
                String string = scanner.nextLine();
                DayWaterCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (DayWaterCommands commands1 : DayWaterCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, gameDay);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof PlayMenu) {
                String string = scanner.nextLine();
                switch (string) {
                    case "Day":
                        menuPointer = new CollectionMenu();
                        while (menuPointer instanceof CollectionMenu) {
                            string = scanner.nextLine();
                            CollectionMenuCommands.createCommands(string, menuPointer);
                            boolean isValidCommand = false;
                            for (CollectionMenuCommands commands1 : CollectionMenuCommands.allCommand) {
                                Pattern pattern = commands1.pattern;
                                Matcher matcher = pattern.matcher(string);
                                if (matcher.matches()) {
                                    menuPointer = commands1.action(menuPointer, mainAccount);
                                    isValidCommand = true;
                                    break;
                                }
                            }
                            if (string.equalsIgnoreCase("play")) {
                                menuPointer = new PlayMenu();
                                break;
                            }
                            else if (!isValidCommand) {
                                InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                                invalidCommand.action();
                            }

                        }
                        menuPointer = new DayAndWater();
                        break;
                    case "Water":
                        menuPointer = new CollectionMenu();
                        while (menuPointer instanceof CollectionMenu) {
                            string = scanner.nextLine();
                            CollectionMenuCommands.createCommands(string, menuPointer);
                            boolean isValidCommand = false;
                            for (CollectionMenuCommands commands1 : CollectionMenuCommands.allCommand) {
                                Pattern pattern = commands1.pattern;
                                Matcher matcher = pattern.matcher(string);
                                if (matcher.matches()) {
                                    menuPointer = commands1.action(menuPointer, mainAccount);
                                    isValidCommand = true;
                                    break;
                                }
                            }
                            if (string.equalsIgnoreCase("play")) {
                                menuPointer = new PlayMenu();
                                break;
                            }
                            if (!isValidCommand) {
                                InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                                invalidCommand.action();
                            }

                        }
                        menuPointer = new DayAndWater();
                        break;
                    case "Rail":
                        menuPointer = new RailMenu();
                        break;
                    case "zombie":
                        menuPointer = new ZombieMenu();
                        break;
                }
                Pattern pattern = Pattern.compile("pvp (\\d)+", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(string);
                if (matcher.matches()) {
                    number = Integer.parseInt(matcher.group(1));
                    menuPointer = new CollectionMenu();
                    while (menuPointer instanceof CollectionMenu) {
                        string = scanner.nextLine();
                        CollectionMenuCommands.createCommands(string, menuPointer);
                        boolean isValidCommand = false;
                        for (CollectionMenuCommands commands1 : CollectionMenuCommands.allCommand) {
                            Pattern pattern1 = commands1.pattern;
                            Matcher matcher1 = pattern1.matcher(string);
                            if (matcher1.matches()) {
                                menuPointer = commands1.action(menuPointer, mainAccount);
                                isValidCommand = true;
                                break;
                            }
                        }
                        if (string.equalsIgnoreCase("play")) {
                            menuPointer = new PlayMenu();
                            break;
                        }
                        if (!isValidCommand) {
                            InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                            invalidCommand.action();
                        }

                    }
                    menuPointer = new PvPMenu();
                }
            }

            while (menuPointer instanceof PvPMenu) {
                String string = scanner.nextLine();
                PvPCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                PvPGame pvPGame = new PvPGame(mainAccount.getName(), mainAccount.getPassword(), number);
                for (PvPCommands commands1 : PvPCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, pvPGame);
                        isValidCommand = true;
                        break;
                    }
                }
                if (string.equalsIgnoreCase("play")) {
                    menuPointer = new PlayMenu();
                    break;
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof RailMenu) {
                RailGame gameDay = new RailGame(mainAccount.getName(), mainAccount.getPassword());
                String string = scanner.nextLine();
                RailCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (RailCommands commands1 : RailCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, gameDay);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof ZombieMenu) {
                ZombieGame zombieGame = new ZombieGame(mainAccount.getName(), mainAccount.getPassword());
                String string = scanner.nextLine();
                ZombieCommands.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (ZombieCommands commands1 : ZombieCommands.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        menuPointer = commands1.action(menuPointer, zombieGame);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof LoginMenu) {
                String string = scanner.nextLine();
                if (string.equalsIgnoreCase("exit")) {
                    break mainWhile;
                } else if (string.equalsIgnoreCase("help")) {
                    menuPointer.help();
                } else if (string.equalsIgnoreCase("leaderboard")) {
                    menuPointer = new LeaderBoardMenu();
                } else if (string.contains("create account")) {
                    Pattern pattern = Pattern.compile(
                            "create account (.+) (.+)", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        mainAccount = new Account(matcher.group(1), matcher.group(2));
                        System.out.println("account created : " + mainAccount.getName());
                    }
                } else if (string.contains("login")) {
                    Pattern pattern = Pattern.compile(
                            "login (.+) (.+)", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        mainAccount = Account.findAccount(matcher.group(1), matcher.group(2));
                        menuPointer = new MainMenu();
                    }
                } else {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }
        }

    }
}


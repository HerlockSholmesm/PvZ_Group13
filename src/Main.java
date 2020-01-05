import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commands.*;
import commands.Menu.*;
import commands.Menu.Menu;
import in_game.Account;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menuPointer = new LoginMenu();
        Account mainAccount = null;
        mainWhile:
        while (true) {
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

            while (menuPointer instanceof CollectionMenu){
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
                if (string.equalsIgnoreCase("play")){
                    menuPointer = new PlayMenu();
                    break;
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                    invalidCommand.action();
                }

            }

            while (menuPointer instanceof PlayMenu) {

            }
            while (menuPointer instanceof CollectionMenu) {

            }
        }


    }
}


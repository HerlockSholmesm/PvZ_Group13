import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commands.*;
import commands.Menu.*;
import commands.Menu.Menu;
import in_game.Account;

public class Main {

    public static <LeaderBoard> void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        Menu menuPointer = new LoginMenu();
        Account mainAccount = null;
        mainWhile:
        while (true) {
            while (menuPointer instanceof LoginMenu) {
                String string = scanner.nextLine();
                LoginCommand.createCommands(string, menuPointer);
                boolean isValidCommand = false;
                for (LoginCommand commands1 : LoginCommand.allCommand) {
                    Pattern pattern = commands1.pattern;
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.matches()) {
                        commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
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
                        commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
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
                        commands1.action(menuPointer, mainAccount);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    InvalidPrompt invalidCommand = () -> System.out.println("invalid command");
                }

            }

            while (menuPointer instanceof ProfileMenu) {

            }
            while (menuPointer instanceof ShopMenu) {

            }
            while (menuPointer instanceof PlayMenu) {

            }
            while (menuPointer instanceof ZombieCollectionMenu) {

            }
            while (menuPointer instanceof PlantCollectionMenu) {

            }
            while (menuPointer instanceof MainMenu) {

            }
        }


    }
}


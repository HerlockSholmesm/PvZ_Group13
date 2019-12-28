package All;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commands.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        Menu menuPointer = new LoginMenu();
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
                        commands1.action(menuPointer);
                        isValidCommand = true;
                        break;
                    }
                }
                if (!isValidCommand) {
                    new InvalidCommand().action();
                }
            }
       /*     while (menuPointer instanceof MainMenu) {

            }

            while (menuPointer instanceof LeaderBoardMenu) {

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
            while (menuPointer instanceof) {

            }
            while (menuPointer instanceof MainMenu) {

            }
        }*/


        }
    }
}

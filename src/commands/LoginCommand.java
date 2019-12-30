package commands;

//import com.sun.xml.internal.bind.v2.TODO;
import in_game.Account;
import model.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class LoginCommand {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;
    Menu menu;

    LoginCommand(String input, Menu menuPtr) {
        this.input = input;
        this.menu = menuPtr;
    }

    public static void createCommands(String input, Menu menuPtr) {

        allCommand.add(new CreateAccount(input, menuPtr));
    }

    abstract public void action(Menu menuPtr);
}

class CreateAccount extends LoginCommand {
    private Pattern pattern = Pattern.compile("create account (.+) (.+)");

    CreateAccount(String string, Menu menu) {
        super(string, menu);
        super.pattern = this.pattern;
    }

    @Override
    public void action(Menu menu) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("Please Enter your username");
            Scanner scanner=new Scanner(System.in);
            String name =scanner.nextLine();
            System.out.println("Please Enter your password");
            String password=scanner.nextLine();
            int pass=Integer.parseInt(password);
            Account account=new Account(name,password);
        }
    }
}

class Login extends LoginCommand {
    private Pattern pattern = Pattern.compile("login (.+) (.+)");

    Login(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menu) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("Please Enter your username");
            Scanner scanner=new Scanner(System.in);
            String name =scanner.nextLine();
            System.out.println("Please Enter your password");
            String password=scanner.nextLine();
            Account.findAccount(name,password);
        }

    }
}

class LeaderBoardCommand extends LoginCommand {
    private Pattern pattern = Pattern.compile("Leaderboard");

    LeaderBoardCommand(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            menuPtr = new LeaderBoard();
        }
    }
}

class ExitLogin extends LoginCommand {
    private Pattern pattern = Pattern.compile("exit");
    ExitLogin(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            menuPtr = null;
        }
    }
}

class HelpLogin extends LoginCommand{
    private Pattern pattern = Pattern.compile("help");
    HelpLogin(String input, Menu menuPtr) {
        super(input, menuPtr);
    }

    @Override
    public void action(Menu menuPtr) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
           menuPtr=new LoginMenu();
           menuPtr.help();
        }
    }
}

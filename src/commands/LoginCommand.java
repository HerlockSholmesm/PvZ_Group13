package commands;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LoginCommand {
    public static ArrayList<LoginCommand> allCommand = new ArrayList<>();
    public Pattern pattern;
    String input;

    LoginCommand(String input) {
        this.input = input;
    }

    public static void createCommands(String input) {
        allCommand.add(new JoinGroup(input));

    }

    abstract public void action();
}

class JoinGroup extends LoginCommand {
    private Pattern pattern = Pattern.compile("(\\d+) join group (\\d+)");

    JoinGroup(String string) {
        super(string);
        super.pattern = this.pattern;

    }

    @Override
    public void action() {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {

        }
    }
}

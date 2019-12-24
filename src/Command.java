import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Command {
    static ArrayList<Command> allCommand = new ArrayList<>();
    String input;
    Pattern pattern;

    Command(String input) {
        this.input = input;
    }

    static void createCommands(String input) {
        allCommand.add(new JoinGroup(input));

    }

    abstract public void action();


}

class JoinGroup extends Command {
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

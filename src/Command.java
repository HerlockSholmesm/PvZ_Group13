import java.util.ArrayList;
import java.util.regex.Pattern;

abstract class Command {
    static ArrayList<Command> allCommand = new ArrayList<>();
    String input;
    Pattern pattern;

    Command(String input) {
        this.input = input;
    }

    static void createCommands(String input) {
        allCommand.add(new AddMember(input));
        allCommand.add(new AllUsers(input));
        allCommand.add(new Block(input));
        allCommand.add(new ChangeGroupName(input));
        allCommand.add(new CreateAccount(input));
        allCommand.add(new CreateGroup(input));
        allCommand.add(new DeleteAccount(input));
        allCommand.add(new GetAllGroupMessages(input));
        allCommand.add(new GetAllGroupsAccount(input));
        allCommand.add(new GetAllMessagesAccount(input));
        allCommand.add(new GetGroupAdmin(input));
        allCommand.add(new GetGroupMembers(input));
        allCommand.add(new GetGroupName(input));
        allCommand.add(new GetMessageContent(input));
        allCommand.add(new GetMessageSender(input));
        allCommand.add(new GetUserName(input));
        allCommand.add(new JoinGroup(input));
        allCommand.add(new LeaveGroup(input));
        allCommand.add(new RemoveMessage(input));
        allCommand.add(new SendMessage(input));
        allCommand.add(new SendMessageToGroup(input));
        allCommand.add(new SetName(input));
    }

    abstract public void action();


}

class JoinGroup extends Commands {
    private Pattern pattern = Pattern.compile("(\\d+) join group (\\d+)");

    JoinGroup(String string) {
        super(string);
        super.pattern = this.pattern;

    }

    @Override
    public void action() {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            int user_id = Integer.parseInt(matcher.group(1));
            int group_id = Integer.parseInt(matcher.group(2));
            Account account = Account.findAccount(user_id);
            Group group = Group.findGroup(group_id);
            if (account == null) {
                new InvalidUserId().action();
            } else if (group == null) {
                new InvalidGroupId().action();
            } else {
                for (Account account1 : group.getAccounts_in_group()) {
                    if (account1.getId() == user_id) {
                        new AlreadyInGroup().action();
                        return;
                    }
                }
                if (group.getN_ozv() == group.getCapacity()) {
                    new NotEnoughSpace().action();
                } else {
                    account.joinGroup(group);
                    group.addAccount((account));
                }
            }
        }
    }
}

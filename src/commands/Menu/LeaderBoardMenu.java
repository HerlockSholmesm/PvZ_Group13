package commands.Menu;

public class LeaderBoardMenu implements Menu {
    public Menu parentMenu;

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "show : showing all acounts with number of zomies that killed" +
                "exit : exit");

    }

    @Override
    public Menu exit(Menu menu) {
        return this.parentMenu;
    }

}

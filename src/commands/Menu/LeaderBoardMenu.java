package commands.Menu;

public class LeaderBoardMenu implements Menu {
    public Menu parentMenu = new LoginMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "show : showing all acounts with number of zomies that killed\n" +
                "exit : exit\n");

    }

    @Override
    public Menu exit(Menu menu) {
        return this.parentMenu;
    }

}

package commands.Menu;

public class ZombieMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "show hand : showing your hand\n" +
                "show lanes : showing lanes for zombie and plant\n" +
                "put : puting zombie\n" +
                "start : starting wave\n" +
                "end turn : next turn\n" +
                "showlawn : showing lawns\n");
    }

    @Override
    public Menu exit(Menu menu) {
        return this.parentMenu;
    }
}

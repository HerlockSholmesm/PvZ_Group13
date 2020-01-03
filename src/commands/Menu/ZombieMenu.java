package commands.Menu;

public class ZombieMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "show hand : showing your hand" +
                "show lanes : showing lanes for zombie and plant" +
                "put : puting zombie" +
                "start : starting wave" +
                "end turn : next turn" +
                "showlawn : showing lawns");
    }

    @Override
    public void exit(Menu menu) {
        menu=this.parentMenu;
    }
}

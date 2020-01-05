package commands.Menu;

public class PvPMenu implements Menu {
    Menu parent = new MainMenu();
    @Override
    public void help() {

    }

    @Override
    public Menu exit(Menu menu) {
        return parent;
    }
}

package commands.Menu;

public class ZombieCollectionMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "shoe hand : shoe cards that you select" +
                "shoe collection : show cards in your collection" +
                "select : go to shop menu" +
                "play : go to shop menu" +
                "exit : go to pvp"
        );
    }

    @Override
    public Menu exit(Menu menu) {
        return this.parentMenu;
    }
}

package commands.Menu;

public class PlantCollectionMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "shoe hand : shoe cards that you select\n" +
                "shoe collection : show cards in your collection\n" +
                "select : go to shop menu\n" +
                "play : go to shop menu\n" +
                "exit : go to pvp\n"
        );
    }

    @Override
    public Menu exit(Menu menu) {
        return parentMenu;
    }
}

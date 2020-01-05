package commands.Menu;

public class RailMenu implements Menu {

    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "List : show list of accounts \n" +
                "select : select your card \n" +
                "Record : Show kiled Zombie \n" +
                "Plant : \n" +
                "Remove : \n" +
                "End turn : \n" +
                "show lawn  : showing all of lawns of zombies and plants\n" );
    }

    @Override
    public Menu exit(Menu menu) {return this.parentMenu;
    }
}

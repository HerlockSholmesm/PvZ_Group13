package commands.Menu;

public class RailMenu implements Menu {

    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "List : show list of accounts " +
                "select : select your card " +
                "Record : Show kiled Zombie " +
                "Plant : " +
                "Remove : " +
                "End turn : " +
                "show lawn  : showing all of lawns of zombies and plants" );
    }

    @Override
    public void exit(Menu menu) {menu=this.parentMenu;
    }
}

package commands.Menu;

public class ShopMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("show shop : showing market" +
                "show collection : showing collection" +
                "Buy : Buying card" +
                "Money : Showing your ceredit");
    }

    @Override
    public void exit(Menu menu) {
        menu = this.parentMenu;
    }
}

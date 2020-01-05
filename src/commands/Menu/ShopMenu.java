package commands.Menu;

public class ShopMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("show shop : showing market\n" +
                "show collection : showing collection\n" +
                "Buy : Buying card\n" +
                "Money : Showing your ceredit\n");
    }

    @Override
    public Menu exit(Menu menu) {
        return this.parentMenu;
    }
}

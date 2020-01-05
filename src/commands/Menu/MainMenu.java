package commands.Menu;

public class MainMenu implements Menu {
    public Menu parentMenu = new LoginMenu();

    public void goToPlayMenu(Menu menuPtr) {
        menuPtr = this.childMenus.get(0);
    }

    public void goToProfileMenu(Menu menuPtr) {
        menuPtr = this.childMenus.get(1);
    }

    public void goToShopMenu(Menu menuPtr) {
        menuPtr = this.childMenus.get(2);
    }

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "play : go to play menu\n" +
                "profile : go to profile menu\n" +
                "shop : go to shop menu\n");
    }

    @Override
    public Menu exit(Menu menuPtr) {
        return this.parentMenu;
    }
}

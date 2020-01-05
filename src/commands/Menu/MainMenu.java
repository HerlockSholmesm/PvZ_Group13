package commands.Menu;

public class MainMenu implements Menu {
    public Menu parentMenu;

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
        System.out.println("help : showing commands" +
                "play : go to play menu" +
                "profile : go to profile menu" +
                "shop : go to shop menu");
    }

    @Override
    public Menu exit(Menu menuPtr) {
        return this.parentMenu;
    }
}

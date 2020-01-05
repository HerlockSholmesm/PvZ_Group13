package commands.Menu;

public class PlayMenu implements Menu {

    Menu parentMenu = new MainMenu();

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
                "day : go to plant collection\n" +
                "water : go to plant collection\n" +
                "rail : go to shop menu\n"+
                "zombie : go to shop menu\n"+
                "pvp : go to shop menu\n");
    }

    @Override
    public Menu exit(Menu menuPtr) {
        return  this.parentMenu;
    }
}

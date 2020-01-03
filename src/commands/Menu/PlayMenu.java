package commands.Menu;

public class PlayMenu implements Menu {

    Menu parentMenu = new MainMenu();

    public PlayMenu() {
        this.childMenus.add(new ZombieCollectionMenu());
        this.childMenus.add(new PlantCollectionMenu());
        this.childMenus.add(new RailMenu());
        this.childMenus.add(new DayAndWater());
    }

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
                "day : go to plant collection" +
                "water : go to plant collection" +
                "rail : go to shop menu"+
                "zombie : go to shop menu"+
                "pvp : go to shop menu");
    }

    @Override
    public void exit(Menu menuPtr) {
        menuPtr = this.parentMenu;
    }
}

package commands;

import model.Shop;
import model.Zombie;

import java.util.ArrayList;

public interface Menu {
    ArrayList<Menu> childMenus = new ArrayList<>();

    void help();

    void exit(Menu menu);

}

class ShopMenu implements Menu {
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

class MainMenu implements Menu {
    Menu parentMenu = new LoginMenu();

    public MainMenu() {
        parentMenu = new LoginMenu();
        this.childMenus.add(new PlayMenu());
        this.childMenus.add(new ProfileMenu());
        this.childMenus.add(new ShopMenu());
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
                "play : go to play menu" +
                "profile : go to profile menu" +
                "shop : go to shop menu");
    }

    @Override
    public void exit(Menu menuPtr) {
        menuPtr = this.parentMenu;
    }
}

class LoginMenu implements Menu {

    Menu parentMenu = null;

    public LoginMenu() {
        parentMenu = null;
        this.childMenus.add(new MainMenu());
        this.childMenus.add(new LeaderBoard());
    }

    public void goToMainMenu(Menu menuPtr) {
        menuPtr = this.childMenus.get(0);
    }

    public void goToLeaderBoardMenu(Menu menuPtr) {
        menuPtr = this.childMenus.get(1);
    }

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "Create account : to create an account" +
                "Login : to login" +
                "Leader board : to show leader Board" +
                "exit : to exit game");

    }

    @Override
    public void exit(Menu menuPtr) {
        try {
            menuPtr = this.parentMenu;
            menuPtr.exit(menuPtr);
        } catch (Exception e) {
            e.getMessage();
            // TODO: 12/24/2019
        }
    }
}

class PlayMenu implements Menu {

    Menu parentMenu = new MainMenu();

    public PlayMenu() {
        this.childMenus.add(new ZombieCollectionMenu());
        this.childMenus.add(new PlantCollectionMenu());
        this.childMenus.add(new RailMenu());
      //  this.childMenus.add(new WaterMenu());
        //  this.childMenus.add(new DayMenu());
        //todo
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

class PlantCollectionMenu implements Menu {
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
    public void exit(Menu menu) {
        menu = this.parentMenu;
    }
}

class ZombieCollectionMenu implements Menu {
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
    public void exit(Menu menu) {
        menu = this.parentMenu;
    }
}

class RailMenu implements Menu {

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
    public void exit(Menu menu) {

    }
}

class ShopCollection implements Menu {
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
    public void exit(Menu menu) {

    }
}


class LeaderBoard implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "show : showing all acounts with number of zomies that killed" +
                "exit : exit");

    }

    @Override
    public void exit(Menu menu) {

    }

    public void show(Menu menu) {

    }

}

class ProfileMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "change : chanding your profile" +
                "delete : delete your profile" +
                "rename : rename your profile" +
                "create : create your profile" +
                "show : show your profile");
    }

    @Override
    public void exit(Menu menu) {

    }

}

class DayAndWater implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands" +
                "show hand : chanding your profile" +
                "select : delete your profile" +
                "plant : rename your profile" +
                "remove : create your profile" +
                "end turn : create your profile" +
                "showlawn : show your profile");
    }

    @Override
    public void exit(Menu menu) {

    }
}

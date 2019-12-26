package commands;

import java.util.ArrayList;

public interface Menu {
    ArrayList<Menu> childMenus = new ArrayList<>();

    void help();
    void exit(Menu menu);

}

class ShopMenu implements Menu{

    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

    }
}

class MainMenu implements Menu{
    Menu parentMenu = new LoginMenu();
    public MainMenu(){
        parentMenu = new LoginMenu();
        this.childMenus.add(new PlayMenu());
        this.childMenus.add(new ProfileMenu());
        this.childMenus.add(new ShopMenu());
    }

    public void goToPlayMenu(Menu menuPtr){
        menuPtr = this.childMenus.get(0);
    }
    public void goToProfileMenu(Menu menuPtr){
        menuPtr = this.childMenus.get(1);
    }
    public void goToShopMenu(Menu menuPtr){
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

public class LoginMenu implements Menu{

    Menu parentMenu = null;
    public LoginMenu(){
        parentMenu = null;
        this.childMenus.add(new MainMenu());
        this.childMenus.add(new LeaderBoard());
    }

    public void goToMainMenu(Menu menuPtr){
        menuPtr = this.childMenus.get(0);
    }

    public void goToLeaderBoardMenu(Menu menuPtr){
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
        } catch (Exception e){
            e.getMessage();
            // TODO: 12/24/2019
        }
    }
}

class PlayMenu implements Menu{

    Menu parentMenu = new MainMenu();
    public PlayMenu(){
        this.childMenus.add(new CollectionMenu());
        this.childMenus.add(new RailMenu());
    }

    public void goToPlayMenu(Menu menuPtr){
        menuPtr = this.childMenus.get(0);
    }

    public void goToProfileMenu(Menu menuPtr){
        menuPtr = this.childMenus.get(1);
    }
    public void goToShopMenu(Menu menuPtr){
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

class CollectionMenu implements Menu{

    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

    }
}

class RailMenu implements Menu{

    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

    }
}

class ShopCollection implements Menu{


    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

    }
}



class LeaderBoard implements Menu{

    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

    }

}

class ProfileMenu implements Menu{


    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

    }

}



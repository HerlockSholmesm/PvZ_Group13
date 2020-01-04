package commands.Menu;

public class LoginMenu implements Menu {

    Menu parentMenu = null;

    public void goToMainMenu(Menu menuPtr) {
        menuPtr = this.childMenus.get(0);
    }

    public void goToLeaderBoardMenu(Menu menuPtr) {
        menuPtr = this.childMenus.get(1);
    }

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "Create account : to create an account\n" +
                "Login : to logi\n" +
                "Leader board : to show leader Board\n" +
                "exit : to exit game");

    }

    @Override
    public Menu exit(Menu menuPtr) {
        return parentMenu;
    }
}

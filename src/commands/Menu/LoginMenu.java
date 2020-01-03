package commands.Menu;

public class LoginMenu implements Menu {

    Menu parentMenu = null;

    public LoginMenu() {
        parentMenu = null;
        this.childMenus.add(new MainMenu());
        this.childMenus.add(new LeaderBoardMenu());
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
            menuPtr=this.parentMenu;
        }
    }
}

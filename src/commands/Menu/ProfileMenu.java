package commands.Menu;

public class ProfileMenu implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "change : chanding your profile\n" +
                "delete : delete your profile\n" +
                "rename : rename your profile\n" +
                "create : create your profile\n" +
                "show : show your profile\n");
    }

    @Override
    public Menu exit(Menu menu) {
        return this.parentMenu;
    }

}

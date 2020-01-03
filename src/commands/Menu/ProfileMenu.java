package commands.Menu;

public class ProfileMenu implements Menu {
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
        menu=this.parentMenu;
    }

}

package commands.Menu;

public class DayAndWater implements Menu {
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
        menu=this.parentMenu;
    }
}

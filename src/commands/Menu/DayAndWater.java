package commands.Menu;

public class DayAndWater implements Menu {
    Menu parentMenu = new MainMenu();

    @Override
    public void help() {
        System.out.println("help : showing commands\n" +
                "show hand : chanding your profile\n" +
                "select : delete your profile\n" +
                "plant : rename your profile\n" +
                "remove : create your profile\n" +
                "end turn : create your profile\n" +
                "showlawn : show your profile\n");
    }

    @Override
    public Menu exit(Menu menu) {
        return parentMenu;
    }
}

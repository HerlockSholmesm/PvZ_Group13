import java.util.ArrayList;

public interface Menu {
    Menu parentMenu = null;
    ArrayList<Menu> childMenus = null;

    void help();
    void exit(Menu menu);

}


class MainMenu implements Menu{


    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {
        menu = this.parentMenu;

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



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

class LoginMenu implements Menu{

    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

    }
}

class PlayMenu implements Menu{

    //todo
    @Override
    public void help() {

    }

    @Override
    public void exit(Menu menu) {

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



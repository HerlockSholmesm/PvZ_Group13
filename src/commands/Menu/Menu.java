package commands.Menu;

import java.util.ArrayList;

public interface Menu {
    ArrayList<Menu> childMenus = new ArrayList<>();

    void help();

    Menu exit(Menu menu);

}



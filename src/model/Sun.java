package model;

import javafx.scene.image.Image;

public class Sun {
    private static int sunStore;
    private Image image;

    public Image getImage() {
        return image;
    }

    public Sun(int sunStore) {
        this.sunStore = sunStore;
    }

    public Sun() {
    }

    public int getSunStore() {
        return sunStore;
    }

    public void setSunStore(int sunStore) {
        this.sunStore = sunStore;
    }

    public static void addsun(int addNumber){sunStore=+addNumber;}
}

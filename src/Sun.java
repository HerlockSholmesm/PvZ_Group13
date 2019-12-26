public class Sun {
    private int sunStore;

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

    public void addsun(int addNumber){this.sunStore=+addNumber;}
}

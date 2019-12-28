package All;

public class Account {
    private String name;
    private String password;
    private int score;
    private int money;
    private Collection collection;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.money = 0;
        this.score = 0;
        this.collection = new Collection();
    }

    public void saveAccount(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Account account1 = new Account(this.getName(), this.getPassword());
        return account1;
    }
}

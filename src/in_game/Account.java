package in_game;

import model.Collection;
import commands.*;

import java.io.*;
import java.util.ArrayList;

public class Account {
    public static ArrayList<Account> allAccounts = new ArrayList<>();

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


    public static void restoreAccounts() throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(new File("Accounts.txt"));
        ObjectInputStream o = new ObjectInputStream(f);
        while (o.available() > 0) { //todo : checked
            allAccounts.add((Account) o.readObject());
        }
        o.close();
        f.close();
    }

    public void saveAccount() throws IOException {
        FileOutputStream f = new FileOutputStream("Accounts.txt");
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public static Account findAccount(String name, String password) {
        for (Account account : allAccounts) {
            if (account.getName().equals(name)) {
                if (account.getPassword().equals(password)) {
                    return account;
                } else {
                    new InvalidPassword().action();
                }
            }
        }
        new InvalidAccount().action();
        return null;
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

package in_game;

import model.Card;
import model.Collection;
import commands.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account implements Serializable{
    public static ArrayList<Account> allAccounts = new ArrayList<>();
    public static int NumberOfKilledZombie;
    private static HashMap<Object, Object> LeaderBoard;


    private ArrayList<Player> players = new ArrayList<>();
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
        NumberOfKilledZombie = 0;
        allAccounts.add(this);
    }

    public void setLeaderBoard(int number, String name) {
        LeaderBoard.put(number, name);
    }

    public void showLeaderBoard() {
        for (Map.Entry m : LeaderBoard.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
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

    public static Account addAccount(String name, String password) {
        for (Account account : allAccounts) {
            if (account.getName().equals(name)) {
                Invalid.existedAccountAction();
                return null;
            }
        }
        Account account = new Account(name, password);
        allAccounts.add(account);
        return account;
    }

    public static void deleteAccount(Account account){
        allAccounts.remove(account);
    }


    public static Account findAccount(String name, String password) {
        for (Account account : allAccounts) {
            if (account.getName().equals(name)) {
                if (account.getPassword().equals(password)) {
                    return account;
                } else {
                    Invalid.invalidPasswordAction();
                    return null;
                }
            }
        }
        System.out.println("no account found!");
        return null;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
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

    public void setCollection(ArrayList<Card> collection) {
        this.collection = collection;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Account account1 = new Account(this.getName(), this.getPassword());
        return account1;
    }
}

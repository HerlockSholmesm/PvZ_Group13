package in_game;

import model.Collection;
import commands.*;
import model.Shop;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account implements Serializable{
    public static ArrayList<Account> allAccounts = new ArrayList<>();
    public static int NumberOfKilledZombie;
    private static transient HashMap<Object, Object> LeaderBoard = new HashMap<>();
    private Shop shop;

    private transient ArrayList<Game> games = new ArrayList<>();
    private String name;
    private String password;
    private int score;
    private int money;

    public Shop getShop() {
        return shop;
    }


    private Collection collection;



    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.money = 100;
        this.score = 0;
        this.collection = new Collection();
        this.shop = new Shop();
        NumberOfKilledZombie = 0;
        allAccounts.add(this);
    }

    public void setLeaderBoard(int number, String name) {
        LeaderBoard.put(number, name);
    }

    public static void showLeaderBoard() {
        for (Account m : allAccounts) {
            System.out.println(m.getName() + " is account name " + " With this score : " + m.getScore());
        }
    }

    public static String showLeaderBoard1() {
        String s = new String();
        for (Account m : allAccounts) {
            s.concat(m.getName() + " is account name " + " With this score : " + m.getScore() +"\n");
        }
        return s;
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
        return null;
    }

    public static String findAccount2(String name, String password) {
        for (Account account : allAccounts) {
            if (account.getName().equals(name)) {
                if (account.getPassword().equals(password)) {
                    return "find";
                } else {
                    Invalid.invalidPasswordAction();
                    return "invalid password";
                }
            }
        }
        return "no account found!";
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void addPlayer(Game game) {
        this.games.add(game);
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

    public void saveGame(Game game){
        this.money = game.getCoin().getCoinOutOfTheGame();
    }
}

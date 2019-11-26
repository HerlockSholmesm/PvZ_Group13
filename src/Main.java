public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
	// write your code here
        Account account = new Account("abolfazl", "123456");
        System.out.println(account.hashCode());
        Account account1 = (Account) account.clone();
        System.out.println(account.getClass());
        System.out.println(account1.getName());

    }
}

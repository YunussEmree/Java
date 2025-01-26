public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        System.out.println("Hesap = " + manager.getBalance());
        manager.deposit(100);
        System.out.println("Hesap = " + manager.getBalance());

        try {
            manager.withdraw(90);
            System.out.println("Hesap = " + manager.getBalance());
            manager.withdraw(20);
            System.out.println("Hesap = " + manager.getBalance());
        }catch (BalanceInsufficentException e) {
            System.out.println(e);
        }


    }
}
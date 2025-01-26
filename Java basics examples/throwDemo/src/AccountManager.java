public class AccountManager {
    private double balance;

    public void deposit(int amount) {
        setBalance(getBalance() + amount);
    }

    public void withdraw(int amount) throws BalanceInsufficentException {
        if(balance-amount>=0){
            setBalance(getBalance() - amount);
        } else {
            //System.out.println("Para çekilemedi. Bakiye yetersiz.");
            throw new BalanceInsufficentException("Bakiye yetersiz");
        }

    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

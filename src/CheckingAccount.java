public class CheckingAccount {
    private long balance;
    private long amountWithdrawn;

    public long getBalance() {
        return this.balance;
    }
    
    public long getAmountWithdrawn() {
        return this.amountWithdrawn;
    }

    public void setBalance(long bal) {
        this.balance = bal;
    }
    
    public void setAmountWithdrawn(long amount) {
        this.amountWithdrawn = amount;
    }
}

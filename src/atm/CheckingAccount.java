package atm;
public class CheckingAccount {
    private long balance;
    private long amountWithdrawn;
    private long amountDepo;

    public long getBalance() {
        return this.balance;
    }
    
    public long getAmountWithdrawn() {
        return this.amountWithdrawn;
    }

    public long getAmountDepo() {
        return this.amountDepo;
    }

    public void setBalance(long bal) {
        this.balance = bal;
    }
    
    public void setAmountWithdrawn(long amount) {
        this.amountWithdrawn = amount;
    }

    public void setAmountDepo(long amount) {
        this.amountDepo = amount;
    }
}

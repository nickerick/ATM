package atm;
public class SavingsAccount {
    private long balance;
    private long amountWithdrawn;
    private long amountDepo;
    private long amountTransferred;

    public long getBalance() {
        return this.balance;
    }
    
    public long getAmountWithdrawn() {
        return this.amountWithdrawn;
    }

    public long getAmountDepo() {
        return this.amountDepo;
    }

    public long getAmountTransferred() {
        return this.amountTransferred;
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

    public void setAmountTransferred(long amount) {
        this.amountTransferred = amount;
    }
}

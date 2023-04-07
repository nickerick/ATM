public class User {
    public SavingsAccount savingsAccount;
    public CheckingAccount checkingAccount;
    public UtilityAccount utilityAccount;

    public User(){
        this.savingsAccount = DataAccess.getSavingsAccount();
        this.checkingAccount = DataAccess.getCheckingAccount();
        this.utilityAccount = DataAccess.getUtilityAccount();
    }
}

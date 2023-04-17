package test;
import static org.junit.Assert.*;

import org.junit.Test;

import atm.*;


public class ATMTest {

    @Test
    public void checkingAccountStoresValuesCorrectly() {
        CheckingAccount checkAcc = new CheckingAccount();
        checkAcc.setAmountDepo(300);
        checkAcc.setAmountWithdrawn(500);
        checkAcc.setBalance(400);

        assertTrue(checkAcc.getAmountDepo() == 300);
        assertTrue(checkAcc.getAmountWithdrawn() == 500);
        assertTrue(checkAcc.getBalance() == 400);
    }

    @Test
    public void savingAccountStoresValuesCorrectly() {
        SavingsAccount saveAcc = new SavingsAccount();
        saveAcc.setAmountDepo(300);
        saveAcc.setAmountWithdrawn(500);
        saveAcc.setBalance(400);

        assertTrue(saveAcc.getAmountDepo() == 300);
        assertTrue(saveAcc.getAmountWithdrawn() == 500);
        assertTrue(saveAcc.getBalance() == 400);
    }

    @Test
    public void billStoresValuesCorrectly() {
        Bill bill = new Bill();
        bill.setPayAmount(1000);
        bill.setPayDate(34);
        bill.setPayStatus(false);

        assertTrue(bill.getPayAmount() == 1000);
        assertTrue(bill.getPayDate() == 34);
        assertTrue(bill.getPayStatus() == false  );
    }

    // @Test
    // public void checkingAccountStoringAndRetrievalTest() {
    //     CheckingAccount checkAcc = new CheckingAccount();
    //     checkAcc.setAmountDepo(300);
    //     checkAcc.setAmountWithdrawn(500);
    //     checkAcc.setBalance(400);
    //     DataAccess.setCheckingAccount(checkAcc);

    //     CheckingAccount checkAccNew = DataAccess.getCheckingAccount();

    //     assertTrue(checkAccNew.getAmountDepo() == 300);
    //     assertTrue(checkAccNew.getAmountWithdrawn() == 500);
    //     assertTrue(checkAccNew.getBalance() == 400);
    // }

    // Checks that none of the DataAccess objects are null. Null objects should not be able to be stored in data nor retrieved from it.
    // @Test
    // public void DataAccessContainsNoNulLValues() {
    //     CheckingAccount checkAcc = DataAccess.getCheckingAccount();
    //     SavingsAccount saveAcc = DataAccess.getSavingsAccount();
    //     Bill[] bills = DataAccess.getBills();
    //     long day = -1;
    //     day = DataAccess.getDayNum();

    //     assertTrue(!checkAcc.equals(null));
    //     assertTrue(!saveAcc.equals(null));
    //     assertTrue(!bills.equals(null));
    //     assertTrue(day != -1);
    // }

    @Test
    public void cantExceedDeposit() {
        SavingsAccount saveAcc = new SavingsAccount();
        int[] userDepositRequests = new int[] {400, 500, 4500};
        
        for (int i = 0; i < 3; i++) {
            if (saveAcc.getAmountDepo() + userDepositRequests[i] < 5000) {
                saveAcc.setAmountDepo(saveAcc.getAmountDepo() + userDepositRequests[i]);
            }
        }

        assertTrue(saveAcc.getAmountDepo() == 900);
    }

    @Test
    public void cantExceedMaxWithdraw() {
        CheckingAccount checkAcc = new CheckingAccount();
        int[] userWithdrawRequest = new int[] {400, 50, 100};
        
        for (int i = 0; i < 3; i++) {
            if (checkAcc.getAmountWithdrawn() + userWithdrawRequest[i] < 500) {
                checkAcc.setAmountWithdrawn(checkAcc.getAmountWithdrawn() + userWithdrawRequest[i]);
            }
        }

        assertTrue(checkAcc.getAmountWithdrawn() == 450);
    }

    @Test
    public void cantExceedSavingsTransfer() {
        SavingsAccount saveAcc = new SavingsAccount();
        saveAcc.setBalance(1000);
        CheckingAccount checkAcc = new CheckingAccount();
        checkAcc.setBalance(1000);
    
        int[] userTransferRequests = new int[] {90, 20};
        
        for (int i = 0; i < 2; i++) {
            if (saveAcc.getAmountTransferred() + userTransferRequests[i] < 100) {
                saveAcc.setAmountTransferred(saveAcc.getAmountTransferred() + userTransferRequests[i]);
                saveAcc.setBalance(saveAcc.getBalance() - userTransferRequests[i]);
                checkAcc.setBalance(checkAcc.getBalance() + userTransferRequests[i]);
            }
        }
        
        assertTrue(saveAcc.getAmountTransferred() == 90);
        assertTrue(saveAcc.getBalance() == 910);
        assertTrue(checkAcc.getBalance() == 1090);
    }    

}

import java.util.*;

public class ATMDriver {
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int menuSelect = 0;
        int subMenuSelect = 0;
        User user = new User();

        System.out.println("Starting Application");
        CheckingAccount checkAcc = DataAccess.getCheckingAccount();
        SavingsAccount saveAcc = DataAccess.getSavingsAccount();
        long dayNum = DataAccess.getDayNum();

        // TESTS TO CHECK VALUES
        // System.out.println(checkAcc.getBalance() + " " + checkAcc.getAmountWithdrawn());
        // System.out.println(saveAcc.getBalance() + " " + saveAcc.getAmountWithdrawn());
        
        checkAcc.setAmountWithdrawn(443);
        DataAccess.setCheckingAccount(checkAcc);
        saveAcc.setAmountWithdrawn(8080);
        DataAccess.setSavingsAccount(saveAcc);
        DataAccess.setDayNum(123);

        while(true){
            System.out.println("Day: " + dayNum);
            System.out.println("Please Select A Action Below:");
            System.out.println("1: Access ATM");
            System.out.println("2: Access Utility Account");
            System.out.println("3: Advance To Next Day");
            System.out.println("4: Quit");

            // Scan Menu Select Input
            while(true) {
                System.out.print("Input: ");
                menuSelect = scan.nextInt();
                System.out.println();
                if (menuSelect < 1 || menuSelect > 4) {
                    System.out.println("Invalid Input");
                } else {
                    break;
                }
            }

            if (menuSelect == 1) {
                while(true){
                    System.out.println("Please Select ATM Action Below:");
                    System.out.println("1: Check Balance");
                    System.out.println("2: Deposit");
                    System.out.println("3: Withdraw");
                    System.out.println("4: Transfer");
                    System.out.println("5: Exit");

                    while(true) {
                        System.out.print("Input: ");
                        subMenuSelect = scan.nextInt();
                        System.out.println();
                        if (menuSelect < 1 || menuSelect > 5) {
                            System.out.println("Invalid Input");
                        } else {
                            break;
                        }
                    } 

                    if (subMenuSelect == 1) {
                        System.out.println("Which account? \n (1) Checking (2) Savings");
                        System.out.print("Input: ");
                        subMenuSelect = scan.nextInt();

                        if (subMenuSelect == 1) {
                            System.out.println("Balance: $" + checkAcc.getBalance());
                        } else {
                            System.out.println("Savings: $" + saveAcc.getBalance());
                        }
                    } else if (subMenuSelect == 2) {
                        System.out.println("Which account? \n (1) Checking (2) Savings");
                        System.out.print("Input: ");
                        subMenuSelect = scan.nextInt();

                        System.out.println("How much?");
                        System.out.print("Input: ");
                        int deposit = scan.nextInt();

                        if (subMenuSelect == 1) {
                            if ((checkAcc.getAmountDepo() + deposit) > 5000) {
                                System.out.println("Can only deposit " + (5000 - checkAcc.getAmountDepo()) + " more today into Checking.");    
                            } else {
                                System.out.println(deposit + " successfully deposited into Checking.\n");
                                checkAcc.setBalance(checkAcc.getBalance() + deposit);
                                checkAcc.setAmountDepo(checkAcc.getAmountDepo() + deposit);
                            }
                        } else {
                            if ((saveAcc.getAmountDepo() + deposit) > 5000) {
                                System.out.println("Can only deposit " + (5000 - saveAcc.getAmountDepo()) + " more today into Savings.");    
                            } else {
                                System.out.println(deposit + " successfully deposited into Savings.\n");
                                saveAcc.setBalance(saveAcc.getBalance() + deposit);
                                saveAcc.setAmountDepo(saveAcc.getAmountDepo() + deposit);
                            }
                        }
                    } else if (subMenuSelect == 3) {
                        System.out.println("How much would you like to withdraw from Checking?");
                        System.out.print("Input: ");
                        int withdraw = scan.nextInt();

                        if ((checkAcc.getAmountWithdrawn() + withdraw) > 500) {
                            System.out.println("Can only withdraw " + (500 - checkAcc.getAmountWithdrawn()) + " more today into Checking.");    
                        } else {
                            System.out.println(withdraw + " successfully withdrawn from Checking.\n");
                            checkAcc.setBalance(checkAcc.getBalance() - withdraw);
                            checkAcc.setAmountDepo(checkAcc.getAmountWithdrawn() + withdraw);
                        }                        
                    } else if (subMenuSelect == 4) {
                        System.out.println("Which account would you like to transfer FROM? \n (1) Checking (2) Savings");
                        System.out.print("Input: ");
                        subMenuSelect = scan.nextInt();

                        System.out.println("How much?");
                        System.out.print("Input: ");
                        int transfer = scan.nextInt();
                        
                        if (subMenuSelect == 1) {
                            if (checkAcc.getBalance() < transfer) {
                                System.out.println("Cannot transfer more than you have! Checking Balance: " + checkAcc.getBalance());    
                            } else {
                                System.out.println(transfer + " successfully transferred into Savings.\n");
                                checkAcc.setBalance(checkAcc.getBalance() - transfer);
                                saveAcc.setBalance(saveAcc.getBalance() + transfer);
                            }
                        } else {
                            if (saveAcc.getBalance() < transfer) {
                                System.out.println("Cannot transfer more than you have! Checking Balance: " + checkAcc.getBalance());    
                            } else if (saveAcc.getAmountTransferred() + transfer > 100) {
                                System.out.println("You can only transfer " + (100 - saveAcc.getAmountTransferred()) + " more today.");    
                            } else {
                                System.out.println(transfer + " successfully transferred into Checkings.\n");
                                checkAcc.setBalance(checkAcc.getBalance() + transfer);
                                saveAcc.setBalance(saveAcc.getBalance() - transfer);
                                saveAcc.setAmountTransferred(saveAcc.getAmountTransferred() + transfer);
                            }
                        }
                    } else {
                        break;
                    }
                    System.out.println();
                }
            } else if (menuSelect == 2) {

            } else if (menuSelect == 3) {
                dayNum++;
                checkAcc.setAmountDepo(0);
                checkAcc.setAmountWithdrawn(dayNum);
                saveAcc.setAmountDepo(0);
                saveAcc.setAmountWithdrawn(0);
                saveAcc.setAmountTransferred(0);
            } else {
                break;
            }
        }
        System.out.println("Exiting Application");

        DataAccess.setCheckingAccount(checkAcc);
        DataAccess.setSavingsAccount(saveAcc);
        DataAccess.setDayNum(dayNum);
        scan.close();
    }

}

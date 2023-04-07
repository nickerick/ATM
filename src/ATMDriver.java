import java.util.*;

public class ATMDriver {
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int menuSelect = 0;
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
                
            } else if (menuSelect == 2) {

            } else if (menuSelect == 3) {
                
            } else {
                break;
            }
        }
        System.out.println("Exiting Application");

        scan.close();
    }

}

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;

  //    JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
        //    Iterator iterator = subjects.iterator();
        //    while (iterator.hasNext()) {
        //       System.out.println(iterator.next());
        //    }

public class DataAccess {
    
    public static CheckingAccount getCheckingAccount() {
        CheckingAccount acc = new CheckingAccount();
        JSONParser parser = new JSONParser();
        
        try {
           String filePath = new File("").getAbsolutePath();
           Object obj = parser.parse(new FileReader(filePath + "/src/database.json"));
           JSONObject jsonObject = (JSONObject)obj;
           
           JSONObject holder = (JSONObject) jsonObject.get("checkingAccount");
           acc.setBalance((long)holder.get("balance"));
           acc.setAmountWithdrawn(((long)holder.get("amountWithdrawn")));
        } catch(Exception e) {
           e.printStackTrace();
        }

        return acc;
    }

    public static SavingsAccount getSavingsAccount() {
        SavingsAccount acc = new SavingsAccount();
        JSONParser parser = new JSONParser();
        
        try {
           String filePath = new File("").getAbsolutePath();
           Object obj = parser.parse(new FileReader(filePath + "/src/database.json"));
           JSONObject jsonObject = (JSONObject)obj;
           
           JSONObject holder = (JSONObject) jsonObject.get("savingsAccount");
           acc.setBalance((long)holder.get("balance"));
           acc.setAmountWithdrawn(((long)holder.get("amountWithdrawn")));
        } catch(Exception e) {
           e.printStackTrace();
        }

        return acc;
    }

    public static UtilityAccount getUtilityAccount() {
        UtilityAccount acc = new UtilityAccount();
        return acc;
    }

    public static long getDayNum() {
        long dayNum = 0;
        JSONParser parser = new JSONParser();
        
        try {
           String filePath = new File("").getAbsolutePath();
           Object obj = parser.parse(new FileReader(filePath + "/src/database.json"));
           JSONObject jsonObject = (JSONObject)obj;
           dayNum = (long)jsonObject.get("dayNum");
        } catch(Exception e) {
           e.printStackTrace();
        }

        return dayNum;
    }


}

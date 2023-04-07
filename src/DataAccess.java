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

    public static void setCheckingAccount(CheckingAccount acc) {
        JSONParser parser = new JSONParser();
        
        try {
           String filePath = new File("").getAbsolutePath();
           Object obj = parser.parse(new FileReader(filePath + "/src/database.json"));
           JSONObject database = (JSONObject)obj;

           JSONObject writeData = new JSONObject();
           writeData.put("balance", acc.getBalance());
           writeData.put("amountWithdrawn", acc.getAmountWithdrawn());

           database.put("checkingAccount", writeData);

           try (FileWriter file = new FileWriter("./src/database.json")) {
                file.write(database.toJSONString());
                file.flush();
           } catch(Exception e) {
            e.printStackTrace();
           }

        } catch(Exception e) {
           e.printStackTrace();
        }
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

    public static void setSavingsAccount(SavingsAccount acc) {
        JSONParser parser = new JSONParser();
        
        try {
           String filePath = new File("").getAbsolutePath();
           Object obj = parser.parse(new FileReader(filePath + "/src/database.json"));
           JSONObject database = (JSONObject)obj;

           JSONObject writeData = new JSONObject();
           writeData.put("balance", acc.getBalance());
           writeData.put("amountWithdrawn", acc.getAmountWithdrawn());

           database.put("savingsAccount", writeData);

           try (FileWriter file = new FileWriter("./src/database.json")) {
                file.write(database.toJSONString());
                file.flush();
           } catch(Exception e) {
            e.printStackTrace();
           }

        } catch(Exception e) {
           e.printStackTrace();
        }
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

    public static void setDayNum(long newDay) {
        JSONParser parser = new JSONParser();
        
        try {
           String filePath = new File("").getAbsolutePath();
           Object obj = parser.parse(new FileReader(filePath + "/src/database.json"));
           JSONObject database = (JSONObject)obj;

           JSONObject writeData = new JSONObject();
           database.put("dayNum", newDay);

           try (FileWriter file = new FileWriter("./src/database.json")) {
                file.write(database.toJSONString());
                file.flush();
           } catch(Exception e) {
            e.printStackTrace();
           }

        } catch(Exception e) {
           e.printStackTrace();
        }
    }


}

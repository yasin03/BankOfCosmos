import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CustomerServices {

    static Map<String, ExtractOfAccount> extAcc = new HashMap<>();


    public static void addCustomer(){

    }

    public static void deleteCustomer(){

    }

    public static void swapAccount(){

    }

    public static void updateCustomer(){

    }

    public static void extractAccount(String action, double amount, String id){
        ExtractOfAccount obj = new ExtractOfAccount();
        obj.setDt(LocalDate.now());
        obj.setTm(LocalTime.now());
        obj.setAction(action);
        obj.setAmount(amount);
        extAcc.put(id, obj);

    }
    public static void exit(){

        String date ="Date";
        String action ="Action";
        String amount ="Amount";


        LocalDate date2 = LocalDate.now();
        LocalTime time2 = LocalTime.now();


        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm");
        String date3 = date2.format(dateFormat);
        String time3 = time2.format(timeFormat);



        System.out.println("\nCOSMOS BANK \nEXTRACT OF ACCOUNT______________________");
        System.out.printf("%40s",date3);
        System.out.println();

        System.out.printf("\n%-10s %-22s %-10s",date,action,amount);
        System.out.println("\n----------------------------------------");
        System.out.printf("%-10s %-22s %-10s",time3,action,1250.00);
        System.out.println("\n\n\n\n\n----------------------------------------");
        System.out.println("HAVE A GOOD DAY - WE WISH YOU AGAIN");

        Collection<ExtractOfAccount> asd = extAcc.values();





    }










}

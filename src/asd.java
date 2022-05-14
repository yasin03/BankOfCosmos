import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class asd {
    public static void main(String[] args) {

        Map<String, ExtractOfAccount> extAcc = new HashMap<>();




        String date ="Date";
        String action ="Action";
        String amount ="Amount";


        LocalDate date2 = LocalDate.now();
        LocalTime time2 = LocalTime.now();


        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm");
        String dat = date2.format(dateFormat);
        String tim = time2.format(timeFormat);



        System.out.println("\nCOSMOS BANK \nEXTRACT OF ACCOUNT______________________");
        System.out.printf("%40s",dat);
        System.out.println();

        System.out.printf("\n%-10s %-22s %-10s",date,action,amount);
        System.out.println("\n----------------------------------------");
        System.out.printf("%-10s %-22s %-10s",tim,action,1250.00);
        System.out.println("\n\n\n\n\n----------------------------------------");
        System.out.println("HAVE A GOOD DAY - WE WISH YOU AGAIN");

        Collection<ExtractOfAccount> asd = extAcc.values();
        System.out.println(asd);



    }
}

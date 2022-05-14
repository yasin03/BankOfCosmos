import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menus extends OperationsTRY {   //Ana menu
    public static final String W = "\u001B[37m";
    public static final String R = "\u001B[31m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";
    static Scanner scanner = new Scanner(System.in);

    static Customers currentCustomer; // hangi müşteri işlem yapıyor onu takip etmek için variable

    static Map<String, Customers> customersMap = new HashMap<>();//customerID string olduğu için, map'in key'lerini String olarak yazdım


    public static void registerMenu() {

        System.out.println("========================== WELCOME COSMOS BANK =======================\r\n"

                + "   ____________________             ____________________    \n"
                + "   | 1-LOGIN          |             | 2-REGISTER        |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   " + B);

        System.out.print("Please make your choice: ");


        if (TryCatch.intGirisi() == 1) {
            login();
        } else {
            register();
        }
    }

    private static void register() {

        Customers customer1 = new Customers();

        System.out.println("Register screen. Please enter customer's; ");
        System.out.print("Name: ");
        customer1.setName(scanner.nextLine());
        System.out.print("Surname: ");
        customer1.setSurname(scanner.nextLine());
        System.out.print("ID Number: ");
        customer1.setIdNumber(scanner.nextLine());
        System.out.print("Password: ");// 1 büyük,1küçük harf,1 rakam kontrolü eklenecek
        customer1.setPassword(scanner.nextLine());
        System.out.print("Previously used credit? Y/N ");//pojoClass'taki setDebit methodunu sadece Y/N girecek şekilde değiştirdim
        customer1.setDebit(scanner.nextLine());
        System.out.print("Phone Number: ");
        customer1.setTelephone(scanner.nextLine());
        System.out.print("Your Monthly Income: ");
        customer1.setMonthlyInCome(TryCatch.intGirisi());

        currentCustomer = customer1; // we now know that this particular customer is using our app


        customersMap.put(customer1.getIdNumber(), customer1);
        System.out.println("New customer has been registered to our system. You are being redirected to the main menu...");
        TryCatch.threadSleep(1000);
        System.out.println(customersMap);
        mainMenu();


    }

    private static void login() {

        System.out.println("Please enter your ID number: ");
        String loginId = scanner.nextLine();
        if (!customersMap.containsKey(loginId)) {
            System.out.println("No such customer exists in our system by the ID you provided.\nPress 1 to register new customer,\n" +
                    "Press 2 to try to login again,\nPress 0 to exit login screen: ");

            while (true) { // kullanıcı 1,2 veya 0'dan başka giriş yapmaması için while döngüsüne aldım
                int loginSelect = TryCatch.intGirisi();
                if (loginSelect == 1) {
                    register();
                    break;
                } else if (loginSelect == 2) {
                    login();
                    break;
                } else if (loginSelect == 0) {
                    registerMenu();
                    break;
                } else {
                    System.out.println("Invalid selection, please pres 1, 2 or 0 to proceed: ");

                }
            }
        } else {
            System.out.println("Welcome to Cosmos Bank Mr/Mrs " + customersMap.get(loginId).getName() + "! redirecting to the main menu...");
            TryCatch.threadSleep(1000);
            mainMenu();
        }


    }

    public static void mainMenu() { // Kullanıcı login/register olduktan sonraki ekran

        System.out.println("========================== CUSTOMER OPERATION =======================\r\n"

                + "   ____________________             ____________________    \n"
                + "   | 1-CHECK BALANCE |               | 2-WITHDRAWAL     |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   _____________________             ____________________    \n"
                + "   | 3-DEPOSIT|                      | 4-UPDATE COSTUMER |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   _____________________            _____________________   \n"
                + "   | 5-FOREIGN CURRENCY|            |6- LOAN TRANSACTION|   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯            ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   \n"
                + "   _____________________            _____________________   \n"
                + "   | 7-EXIT            |            | 8- -----          |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯            ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯  " + B);

        System.out.print("Please make your selection: ");
        switch (TryCatch.intGirisi()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                creditRatingCheck();
                break;
            case 7:
                CustomerServices.exit();
                break;
            case 8:
                break;
        }


    }//main menu

    static void defCustomer() {
        Customers customer2 = new Customers("Marcia", "Rubra", "2785", "Aa123",12.550,2780.00,"n", "+27 (772) 269-4929",12000);
        customersMap.put("2785",customer2);
    }
/*
    insert into MOCK_DATA (name, surname, id, password, phone) values ('Darelle', 'Fantin', 2572, 'mK6fr9', '+57 (881) 873-6567');
    insert into MOCK_DATA (name, surname, id, password, phone) values ('Marcia', 'Rubra', 2785, 'IRAcgxlilS', '+27 (772) 269-4929');
    insert into MOCK_DATA (name, surname, id, password, phone) values ('Cly', 'Allchin', 5325, '1LQB15GZWd8', '+255 (989) 688-6877');

 */
}//class

public class OperationsTRY implements Operations{


    public static void payments(){

    }

    public static void creditsTransaction(){//Sadece TL için kredi, bunu diğer döviz
                                           // cinsleri için de ayırabiliriz.
        System.out.println("========================== CREDIT TRANSACTIONS =======================\r\n"

                + "   ____________________             ____________________    \n"
                + "   | 1-MORTGAGE       |             | 2-AUTO LOAN      |    \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   _____________________            ____________________    \n"
                + "   | 3-CONSUMER LOAN   |            | 4-LOAN REPAYMENT  |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯            ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n" + Menus.B);

        switch(TryCatch.intGirisi()){
            case 1:
                Credits obj0 = new Mortgage();
                obj0.kredi();
                break;
            case 2:
                Credits obj = new AutoLoan();
                 obj.kredi();
                break;
            case 3:
                Credits obj1 = new ConsumerLoan();
                obj1.kredi();
                break;
            case 4:
                Credits obj2 = new LoanRepayment();
                obj2.kredi();
                break;
            default:
                System.out.println("Invalid credit selection please try again");
                TryCatch.threadSleep(1000);
                creditsTransaction();

        }


    }//creditsTransaction();


    public static void creditRatingCheck() {//checks if the customer, who applied for new credit, have previously unpaid loans
        if(Menus.currentCustomer.isDebit()){
            System.out.println("You are not suitable to use credit since it seems you currently have unpaid loan: \n" +
                    Menus.currentCustomer.getPreviousDebit()+
                    ". If you wish to proceed, you must close your previous loan with your 'CURRENT BALANCE'\n" +
                    "Press 1 to proceed\nPress 0 to exit");
            int selection = TryCatch.intGirisi();
            if(selection==1){

                double currBalanceTRY = Menus.currentCustomer.getBalaceTRY();
                double prevDebit = Menus.currentCustomer.getPreviousDebit();

                if(currBalanceTRY >= prevDebit){
                    Menus.currentCustomer.setBalaceTRY(currBalanceTRY-prevDebit);
                } else {
                    System.out.println("You have insufficient funds to pay your previous credit loan. Redirecting to the main menu...");
                    TryCatch.threadSleep(1000);
                    Menus.mainMenu();
                }

            } else {
                Menus.mainMenu();
            }
        }
        else {// müşterinin ödenmemiş kredi borcu YOKSA
            creditsTransaction();
        }
    }










    @Override
    public void balanceInquiry() {

    }

    @Override
    public void withdrawal() {

    }

    @Override
    public void deposit() {

    }

    @Override
    public void moneyTransfer() {

    }

}

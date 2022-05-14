

public class Mortgage implements Credits {

    @Override
    public void kredi() {
        System.out.println("Mortgage prerequisite is;\nYour monthly income must be " +
                "10000.0 TRY or higher. Our mortgage packages are as follows: \n"+
                "1- 20.000 TRY mortgage with monthly 2.9% interest rate\n" +
                "2- 35.000 TRY mortgage with monthly 2.1% interest rate\n"+
                "3- 50.000 TRY mortgage with monthly 1.9% interest rate");
        if(Menus.currentCustomer.getMonthlyInCome()<10000){
            System.out.println("You are not suitable for Mortgage credit since " +
                    "you dont have enough monthly income for the mortgage prerequisite. Your " +
                    "monthly income is: "+ Menus.currentCustomer.getMonthlyInCome()+" TRY");
        } else {
            System.out.println("Please select one of our mortgage packages: ");
            switch (TryCatch.intGirisi()){
                case 1:
                    Menus.currentCustomer.setBalaceTRY(Menus.currentCustomer.getBalaceTRY()+20000);
                    System.out.println("Success! 20.000 TRY Mortgage Credit has been transferred to your account. Your curren account balance is "+ Menus.currentCustomer.getBalaceTRY());
                    Menus.currentCustomer.setPreviousDebit(Menus.currentCustomer.getPreviousDebit()+20000*2.9);// ödenmemiş kredi borçlarına eklendi
                    CustomerServices.extractAccount("Kredi çekildi",20000,Menus.currentCustomer.getIdNumber());
                    break;
                case 2:
                    Menus.currentCustomer.setBalaceTRY(Menus.currentCustomer.getBalaceTRY()+35000);
                    System.out.println("Success! 35.000 TRY Mortgage Credit has been transferred to your account. Your curren account balance is "+ Menus.currentCustomer.getBalaceTRY());
                    Menus.currentCustomer.setPreviousDebit(Menus.currentCustomer.getPreviousDebit()+35000*2.1);// ödenmemiş kredi borçlarına eklendi
                    break;
                case 3:
                    Menus.currentCustomer.setBalaceTRY(Menus.currentCustomer.getBalaceTRY()+50000);
                    System.out.println("Success! 50.000 TRY Mortgage Credit has been transferred to your account. Your curren account balance is "+ Menus.currentCustomer.getBalaceTRY());
                    Menus.currentCustomer.setPreviousDebit(Menus.currentCustomer.getPreviousDebit()+50000*1.9);// ödenmemiş kredi borçlarına eklendi
                    break;
                default:
                    System.out.println("Invalid mortgage package. Please try again:");
                    kredi();
            }
        }
    }
}

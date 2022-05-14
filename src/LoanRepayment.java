import java.time.LocalDateTime;



public class LoanRepayment implements Credits {
    @Override
    public void kredi() {
        boolean hasDebit = Menus.currentCustomer.isDebit();

        if(!hasDebit){
            System.out.println("You dont have any previous unpaid loans on your account. Redirecting to credit transactions...");
            TryCatch.threadSleep(1000);
            OperationsTRY.creditsTransaction();
        }else {
            System.out.println("Press 1 to pay the amount you decide\nPress 2 to create automatic monthly payment order ");//ayın her 1.inde çekicek hesaptan
            int selection =TryCatch.intGirisi();
            if(selection == 1){
                System.out.println("Please enter the amount you want to pay");
                int amountPayable = TryCatch.intGirisi();
                if(amountPayable<=0){
                    System.out.println("You must enter an amount greater than zero. Redirecting you to Loan Repayment");
                    kredi();
                } else {
                    if(Menus.currentCustomer.getBalaceTRY()<amountPayable){
                        System.out.println("You have insufficient balance on your TRY account. Redirecting you to Loan Repayment");
                        kredi();
                    } else {
                        Menus.currentCustomer.setPreviousDebit(Menus.currentCustomer.getPreviousDebit()-amountPayable);
                        //TRY balance  - amountPayable
                        System.out.println("Payment successful. Your current value of previous unpaid credits is: "+ Menus.currentCustomer.getPreviousDebit()+" TRY");}
                }

            } else if ( selection == 2){// her ayın 1'inde TRYbalance hesabında bakiye varsa previousDebit'ten düşecek 1/4

                LocalDateTime tarihSaat= LocalDateTime.now();
                System.out.println("Your previous debit amount will be divived into 4 installments.");

                while(Menus.currentCustomer.getPreviousDebit()>0){ //borcu sıfırdan büyükse
                    if(Menus.currentCustomer.getBalaceTRY()> Menus.currentCustomer.getPreviousDebit()/4 ) {//hesabında taksidin 1/4'ünü ödeyecek kadar para varsa alsın
                        if (tarihSaat.getDayOfMonth() == 1) {
                            Menus.currentCustomer.setPreviousDebit(Menus.currentCustomer.getPreviousDebit() - (Menus.currentCustomer.getPreviousDebit() / 4));//double olduğu için *0.75 yapmadım
                        }
                    } else {
                        System.out.println("You have insufficient funds in your TRY account to pay your monthly installment");
                    }
                }



            } else {
                System.out.println("Invalid selection. Redirecting you to Loan Repayment...");
                TryCatch.threadSleep(1000);
                kredi();
            }
        }
    }
}

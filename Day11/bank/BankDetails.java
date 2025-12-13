package bank;
import loan.*;

public class BankDetails {
    LoanAccount a = new LoanAccount();
     public  void access(){
        System.out.println("No access for loanAccount attributes due to different package");
        a.applyForLoan();
    }
}

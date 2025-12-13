package bank;
import loan.LoanAccount;

public class ApplyLoan extends LoanAccount{
   public void access(){
        System.out.println("No access for loan Account attributes due to different package ");
        super.applyForLoan();
        super.calculateEMI();
    }
}

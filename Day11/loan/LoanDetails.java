package loan;

public class LoanDetails extends LoanAccount{
  public  void access(){
       System.out.println(" Tenure "+super.tenure);
       super.applyForLoan();
       super.calculateEMI();
    }
}

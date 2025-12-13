package loan;

public class LoanAccount{
    private int interestRate;
    int tenure;

    protected void calculateEMI(){
        System.out.println("This function calculates emi");
    }

    public void applyForLoan(){
        System.out.println("This function use to apply for loan");
    }

   public class LoanValidator{
       public void access(){
            System.out.println(" Intrest Rate "+interestRate);
            System.out.println("Tenure "+tenure);
            calculateEMI();
            applyForLoan();
        }
    }
}
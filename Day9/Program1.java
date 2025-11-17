class Bank{
    private double balance;

    Bank(int amount){
        System.out.println("Welcome to Apna Bank");
      this.balance = amount;
    }

    double getBalance(){
        System.out.println(balance);
        return this.balance;
    }

    double deposit(double amount){
        this.balance += amount;
        return this.balance; 
    }

    void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
        }else{
            System.out.println("You have insufficient amount to withdraw");
        }
    }
}

public class Program1 {
     public static void print(){
            System.out.println("hello");
        }

        public static int add(){
            return 3+4;
        }
        
    public static void main(){   
    Bank raj = new Bank(500);
    Bank ritka = new Bank(1000);
       Bank nandini = new Bank(2000);
         Bank piyush = new Bank(3000);
            Bank sanjay = new Bank(8000); 
             sanjay.deposit(10000);
             raj.deposit(100);
             nandini.deposit(3000);
             ritka.deposit(5000);
             piyush.deposit(9000);
             sanjay.withdraw(499);
             ritka.withdraw(1000);
             raj.withdraw(500);
             piyush.withdraw(3000);
             nandini.withdraw(40000);
             double res = raj.getBalance();
             double res1 = ritka.getBalance();
             double res2 = piyush.getBalance();
             double res3 = nandini.getBalance();
             double res4 = sanjay.getBalance();
        
    }
}

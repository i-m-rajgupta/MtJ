import hospital.patients.*;
import shop.*;
import shopping.*;
import company.manager.Manager;

class BankAccount{
    String name;
    private double balance ;
    private int pin;

     BankAccount(String name){
        this.name = name;
    }

    double getbalance(){
        return this.balance;
    }

   protected  void addAmount(int amount){
          balance += amount;
    }

    protected void withdrawAmount(int amount){
        balance-= amount;
    }

    int getPin(){
        return pin;
    }

    void setPin(int pin){
        this.pin = pin;
    }

    void setBalance(double amount){
        this.balance = amount;
    }
}

class Transaction extends BankAccount{
     Transaction(String name){
        super(name);
    }
    void withdraw(int amount){
       if(amount<super.getbalance()){
           super.withdrawAmount(amount);
       }
    }

    void deposit(int amount){
         super.addAmount(amount);
    }
}

class MobileOS{
   private void securityPatch(){
        System.out.println("This is security patch");
    }
  protected void bootLoader(){
        System.out.println("This is boot loader ");
    }
}
class AndroidOS extends MobileOS{
    // logically securityPatch() is  not override as it is not visible in this class from the MobileOS 
    void securityPatch(){
        System.out.println("This is security patch of Android");
    }

    @Override
    protected void bootLoader(){
        System.out.println("Boot loader in Android");
    }
}
public class Nov24 {
    //  Create a BankAccount class: balance and pin are private. 
// A Transaction class tries to access them directly. Show what happens and how to fix it. 
public static void main(String[] args) {
   Transaction t = new Transaction("Balwinder");
   t.setBalance(500);   
   t.setPin(455);
   t.withdraw(100);
  System.out.println("Balance : "+t.getbalance());  
   t.deposit(500);
     System.out.println(t.getPin());
   t.setPin(522);
   System.out.println(t.getPin());

//    Create two packages: hospital.staff and hospital.patients 
// Inside: A parent class Person in staff package contains protected fields. 
// A subclass Patient in another package tries to access them. Observe which variables can or can't be accessed. 
     Patient p = new Patient("Murli",42,"Male");
     p.display();
     p.access();

//       Create classes: Product and Cart 
// Both in the same package, then move Cart to a different package. 
// Check:Which default (no modifier) variables/methods become inaccessible? 

    Cart c = new Cart();
    c.showCart();
    Cart1 c1 = new Cart1();

    // Create a base class MobileOS: 
// Private method securityPatch() and Protected method bootLoader() 
// A subclass AndroidOS tries to override both. Check which one is allowed. 
     AndroidOS a = new AndroidOS();
     a.bootLoader();
     a.securityPatch();
 
    //  Create a Employee class with: 
// Private variable salary. Default method calculateBonus(). 
// Create another class in a different package trying to call calculateBonus(). 

   Manager m =  new Manager();
   m.display();
   m.access();
}
}

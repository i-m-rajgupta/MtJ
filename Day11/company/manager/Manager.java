package company.manager;
import company.employee.*;

public class Manager {
    String name = "Manoj";
    String dept = "HR";

   public void display(){
        System.out.println("Manager info : "+name+" working in department : "+dept);
    }

    Employee e = new Employee();
  public  void access(){
        System.out.println("This method create error while accessing calculateBonus method");
//  e.calculateBonus();
    }
   
}

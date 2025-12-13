import user.User;

class Patient{
    private String name;
    private int age = 0;
    private String disease;
    
    public String getName(){
        return name;
    }

      public String getDisease(){
        return disease;
    }

    public int getAge(){
        return age;
    }
    
    public void set(String name,int age,String disease){
        this.name = name;
        this.disease = disease;
        if(age<0 && age<130){
            System.out.println("Enter valid age. Age cannot be negative and should less than 130");
        }else{
            this.age = age;
        }
    }

    public void setAge(int age){
        if(age<0 && age<130){
            System.out.println("Enter valid age. Age cannot be negative and should less than 130");
        }else{
            this.age = age;
        } 
    }
}

class Print{
    Patient p;
    Print(Patient p){
     this.p = p;
    }
    public void details(){
        System.out.println("--- Patient Details ---");
        System.out.println("Name : "+p.getName());
        System.out.println("Age : "+p.getAge());
        System.out.println("Disease : "+p.getDisease());
    }
}

class Employee{
    private String name;
    private int salary;
    private int age;

    Employee(String name,int age,int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

      public int getSalary(){
        return salary;
    }

    public int getAge(){
        return age;
    }
}

class UserAccount{
    private int pin = 55886;

    public void validate(int pin){
        if(pin == this.pin){
            System.out.println("Entered pin is valid ");
        }else{
            System.out.println("Please enter valid pin");
        }
    }
}

class Tries{
    UserAccount u = new UserAccount();
    void access(){
    // System.out.println(u.pin);  this is cause error because pin is private 
    System.out.println("No access to pin attribute of UserAccount");
    }
}

class Ticket{
    private int seatNumber = 25;
    private String passengerName;
    private boolean status = false;

    Ticket(String passengerName){
        this.passengerName = passengerName;
    }

    public void assignSeat(int seatNumber){
       if(status){
        System.out.println("Ticket is Booked . No seat can assigned now .");
       }else{
        if(seatNumber>1 && seatNumber <= 50){
         this.seatNumber = seatNumber;   
        }else{
            System.out.println("Please provide valid seat number between 1 to 50");
        }
       }
    }

    public void bookTicket(){
        status = true;
    }

    public void details(){
        if(status){
           System.out.println("Passenger  Name : "+passengerName);
           System.out.println("Seat Number : "+seatNumber);
        }else{
        System.out.println("Ticket is not booked yet");
        }
    }
}

class Login{
    private String userName = "op";
    private int password = 3663;
    private static int attempts =1;

    void login(String userName,int password){
        if(userName == this.userName && password == this.password) {
            System.out.println("You have successfully login to your account ");
            attempts = 1;
        }else if(attempts >3){
            System.out.println("Your account is locked due to multiple wrong attempts ");
        }else{
            System.out.println("Enter valid username and password ");
            attempts++;
        }
    }

}
public class Nov26 {
  public static void main(String[] args) {
    // Create a Patient class where: 
// name, age, disease are private. 
// Access only via getters/setters. 
// Setters should restrict invalid age (e.g., negative). 
// Create a class that prints details without directly accessing fields. 
  Patient p1 = new Patient();
  p1.set("Mohan", 45, "Sugar");
  Print p2 = new Print(p1);
  p2.details();

  Patient p3 = new Patient();
  p3.set("Vijay", -5, "Headache");
  Print p4 = new Print(p3);
  p4.details();

//    Create an “immutable” Employee class: 
// All fields private. 
// No setters. 
// Only getters. 
// Parameterized constructor initializes everything. 
// Try modifying values after object creation (should not be possible). 
   Employee e1 = new Employee("Ramesh", 52, 5200);
   System.out.println("Name : "+e1.getName());
   System.out.println("Age : "+e1.getAge());
      System.out.println("Salary : "+e1.getSalary());

    //   Create a UserAccount class: Private pin. 
// Create a method to validate the pin andAnother class tries to read pin directly → should fail. 
  UserAccount u1 = new UserAccount();
  u1.validate(55886);
  u1.validate(63366);
  Tries t = new Tries();
  t.access();

//    Create a Ticket class: Private seatNumber, passengerName. 
// Public methods to assign seat. 
// Prevent seat change once booked. 
   Ticket t1 = new Ticket("Aditya");
   t1.bookTicket(); 
   t1.details();

   Ticket t2 = new Ticket("Shivank");
   t2.assignSeat(54);
   t2.assignSeat(28);
   t2.bookTicket();
   t2.details();
   t2.assignSeat(38);

//     Create a Login class: Private username, password. 
// Validate login using a method. 
// Track number of failed attempts in a private variable. 
// Lock account if attempts > 3. 

  Login l1 = new Login();
  l1.login("op", 3663);
   l1.login("op", 5885);
    l1.login("op", 5885);
     l1.login("op", 5885);
     
      l1.login("op", 5885);
  }
}

class Laptop{
    String company;
    int ram;
    int rom;

    class Processor{
        String company;
        int series;

        Processor(String company,int series){
            this.company = company;
            this.series = series;
        }

        void display(){
           System.out.println("This laptop has "+company+" processor has "+series+" series ");
        }
    }

    Laptop(String company,int ram ,int rom){
        this.company = company;
        this.ram = ram;
        this.rom = rom;
    }

    void display(){
        System.out.println("This laptop is "+company+" company has "+ram+"GB RAM "+rom+" GB ROM ");
    }
}

class University{
    String name;

    class Department{
        String name;

        Department(String name){
            this.name = name;
        }

         void details(){
        System.out.println(University.this.name+" University has "+name+" department.");
         }
    }

    University(String name){
        this.name = name;
    }
}

class Car{
    String company;
    String color;

    Car(String company,String color){
        this.color = color;
        this.company = company;
    }

    class Engine{
        String engine;
        int horsepower;
        Engine(String engine,int horsepower){
           this.engine = engine;
           this.horsepower = horsepower;
        }
        void details(){
            System.out.println(engine+" Engine has "+horsepower+" horsepower ");
        }
    }

    void showDetails(){
       Engine e = new Engine("4- Stroke",56);
        System.out.println("This is "+color+" "+ company+" car and its engine details ");
        e.details();
    }
}

class School{
    String name;
    int established;

    School(String name,int established){
        this.name = name;
        this.established = established;
    }
    class Student{
        String name;
        static int count=101;
        int roll;
        Student(String name){
            this.name = name;
            this.roll = count++;
        }

       void details(){
             System.out.println(name+" has "+roll+" roll number");
        }
    }
}

class Bank{
    String name;

    Bank(String name){
        this.name = name;
    }
    class Account{
        String name;
        static int count=20015001;
        int accountNo;
        int balance;

        Account(String name,int balance){
        this.balance = balance;
        this.name = name;
        this.accountNo = count++;
        }

        void withdraw(int amount){
            if(amount<balance){
                balance -= amount;
                System.out.println("You have successfully withdraw "+amount+" from your account and now you have "+balance+" Balance in your account");
            }else{
                System.out.println("You dont have enough balance to withdraw this amount ");
            }
        }

        void deposit(int amount){
           this.balance += amount;
           System.out.println("You have sucessfully deposit amount in your account ");
        }

        void details(){
            System.out.println("This account belongs to "+name+" with account number "+accountNo);
        }
    }
}
public class Nov16 {
    public static void main(String[] args) {
        // Create an outer class Laptop with an inner class Processor. 
       // Print processor details using an object of inner class. 

       Laptop lap = new Laptop("Acer", 5, 16);
       Laptop.Processor p1 = lap.new Processor("AMD Ryzen", 700);
       lap.display();
       p1.display(); 

    //    Create a class University with inner class Department.  Print “Department of CSE inside University”.
       University uni = new University("RMTU");
       University.Department dept1 = uni.new Department("Cse");
       dept1.details();
       University.Department dept2 = uni.new Department("EC");
       dept2.details();
       
    //     Write a program with class Car and inner class Engine.  Engine has horsepower, Car prints engine details. 
      Car c = new Car("Alto", "red");
      c.showDetails();

    //   Create a class School with an inner class Student. Student prints roll number and name.
      School s = new School("Horizon school",2008);
      School.Student st1 = s.new Student("Raunak");
      School.Student st2 = s.new Student("Joginder");
      st1.details();
      st2.details();

    //   Define a class Bank with an inner class Account. Deposit + Withdraw methods inside inner class. 
     Bank b = new Bank("HDFC");
     Bank.Account ac = b.new Account("Mohan", 500);
     ac.deposit(4500);
     ac.withdraw(4900);
     ac.deposit(4000);
     ac.details();
    }
}

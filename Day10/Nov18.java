import java.util.*;


interface Greetings{
    void sayHello();
}

abstract class Animal{
    String sound = "Meow";
    abstract void sound();
}

interface OnClick{
 void clicked();
}
  
class Button{
    OnClick listener;

    public void setListener(OnClick listener) {
        this.listener = listener;
    }

    public void press(){
        if(listener != null){
            listener.clicked();
        }else{
            System.out.println("No listener attached ");
        }
    }
}

class Company{
    
    String name;

    Company(String name){
        this.name = name;
    }
    
    static class Department{
        String name;
        Company company;
        List<Employee> employees = new ArrayList<>();
     
        Department(String name,Company company){
            this.name = name;
            this.company = company;
        }
     
        class Employee{
            String name;
            int salary;

            Employee(String name,int salary){
            this.name = name;
            this.salary = salary;
            }

            void details(){
                System.out.println(name+" has "+salary+" salary");
            }
     
        }

        void addEmployee(Employee e){
           employees.add(e);
        }
     
        void details(){
     
            System.out.println("Welcome to the "+name+" Department of "+company.name);
     
            if(employees.size() == 0){
            System.out.println("No employee available ");
            return;
           }
        
           for(Employee e : employees){
            e.details();
          }
        }
    }
}

class Hospital{
    String name;
    String owner;
    List<Doctor> doctors = new ArrayList<>();
    List<Record> records = new ArrayList<>();
    Hospital(String name,String owner){
    this.name = name;
    this.owner = owner;
    }
  
    class Doctor{
      String name;
      String quali;
      int salary;

      Doctor(String name,String quali,int salary){
        this.name = name;
        this.quali = quali;
        this.salary = salary;
      }

      void details(){
        System.out.println("Doctor details : ");
        System.out.println("Name -> "+name);
        System.out.println("Qualifications -> "+quali);
        System.out.println("Salary -> "+salary);
      }
    }

    static class Record{
    String name;
    int age;
    String add;

    Record(int age,String name,String add){
        this.age = age;
        this.name = name;
        this.add = add;
    }
    void details(){
        System.out.println("Patient details : ");
        System.out.println("Name -> "+name);
        System.out.println("Age -> "+age);
        System.out.println("Address -> "+add);
    }
    }


    void addDoctors(Doctor d){
        doctors.add(d);
    }
    void addRecords(Record r){
        records.add(r);
    }
 
    void getDoctorDetails(){
        if(doctors.size() == 0){
            System.out.println("No Information  available");
            return;
        }
       for(Doctor d : doctors){
            d.details();
        }
    }

    void getRecord(){
        if(records.size() == 0){
            System.out.println("No information available ");
            return;
        }
        for(Record r : records){
            r.details();
        }
    }
      void details(){
        System.out.println(name+" Hospital is owned by "+owner);
        getDoctorDetails();
        getRecord();
    }

     interface Emergency{
    void emergency(String msg);
    }
    
    }


public class Nov18 {
    public static void main(String[] args) {
        // Create an interface Greetings with method sayHello(). Use anonymous inner class to print “Hello Java!”.
        Greetings g = new Greetings() {
            @Override
            public void sayHello(){
                System.out.println("Hello Java!");
            }
        };
        g.sayHello();

        // Create an abstract class Animal with abstract method sound(). Use anonymous class to implement sound = “Meow”. 
        Animal a = new Animal() {
            public void sound(){
                System.out.println("Sound : "+sound);
            }
        };

        a.sound();

        // Create a button click simulation using anonymous inner class: interface OnClick { void clicked(); } 
        Button button = new Button();
        button.setListener(new  OnClick(){
            public void clicked(){
                System.out.println("Button is clicked");
            }
        });

        button.press();

        // Create static nested class + inner class combination: Company → static nested class Department → inner class Employee. 
        Company c = new Company("Raj Technology");
        Company.Department hr = new Company.Department("HR", c);
        Company.Department.Employee e1 =  hr.new Employee("Mohak", 10000);
        Company.Department.Employee e2 = hr.new Employee("Raju",50000);
        hr.addEmployee(e1);
        hr.addEmployee(e2); 
        hr.details();

        Company.Department it = new Company.Department("IT", c);
        Company.Department.Employee e3 = it.new Employee("ayu", 80000);
        Company.Department.Employee e4 = it.new Employee("nancy", 65000);
        it.addEmployee(e4);
        it.addEmployee(e3);
        it.details();

        // Create a real-world example: Hospital class with: Inner class: Doctor Static nested class: Record Anonymous inner class: for emergency alert 
        Hospital h = new Hospital("Nirogaya ","Mukesh ");
        Hospital.Doctor d1 = h.new Doctor("Sachin", "MBBS", 80000);
        Hospital.Doctor d2 = h.new Doctor("Munni", "Nursing ", 50000);
        Hospital.Record r1 = new Hospital.Record(25,"Ruchi","MAlipura Ujjain");
        Hospital.Record r2 = new Hospital.Record(45, "Savita", "Sehore");
        h.addDoctors(d1);
        h.addDoctors(d2);
        h.addRecords(r2);
        h.addRecords(r1);
        h.details();
       
        Hospital.Emergency e = new Hospital.Emergency() {
           public void emergency(String msg){
                System.out.println("Emergency alert : "+msg);
            }
        };
        e.emergency("Fire occured in f-bolck Building ");

    }
}

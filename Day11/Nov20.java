class Counter{
    static int count =0;
    Counter(){
      count++;
      System.out.println(count);
    }
}

class Demo{
    static void display(){
        System.out.println("New updates");
    }
}

class MathUtil{
    static void square(int n ){
        System.out.println("Sqaure of "+n+" is : "+n*n);
    }
}

class IDGenerator{
    static int count = 2000;

   static void idGenerator(){
      count++;
      System.out.println("ID : "+count);
    }
}

class Employee{
    String empName;
    static String companyName;

    Employee(String empName,String companyName){
        this.empName = empName;
        Employee.companyName = companyName;
    }

    void display(){
        System.out.println(empName+" is working in "+companyName+" company ");
    }
}
public class Nov20 {
    public static void main(String[] args) {
        // Create a class Counter having a static variable count. Increment count in constructor and print the value. 
        Counter c = new Counter();

        // Create a static method display() inside class Demo. Call it without creating object of class. 
        Demo.display();

        // Create a class MathUtil with static method square(int). Call it from main. 
        MathUtil.square(5);

        // Create a class IDGenerator that generates unique IDs using static variable + static method.
       IDGenerator.idGenerator();
        IDGenerator.idGenerator();

        //  Create a class Employee with: static companyName non-static empName 
        Employee e = new Employee("Rakesh", "Tata");
        Employee e2 = new Employee("Ranu", "Naviotech");
        e.display();
        e2.display();
        System.out.println(Employee.companyName);

    }
}

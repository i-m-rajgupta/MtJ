class Circle{
    public static double pi = Math.PI;
    
    public static double area(double radius){
        return pi*radius*radius;
    } 
}

class Animal{
    void show(){
        System.out.println("I am Animal ");
    }
}

class Dog extends Animal{
    void show(){
        System.out.println("I am Dog");
    }
}
class Cat extends Animal{
    void show(){
        System.out.println("I am Cat");
    }
}

interface Shape{
    double area();
}

class Triangle implements Shape{
    double height;
    double breadth;
     Triangle(double h,double b){
        height = h;
        breadth = b;
     }

    public double area(){
        return (height*breadth)/2;
     }

}

class Rectangle implements Shape{
    double height;
    double breadth;
    Rectangle(double h,double b){
        height =h;
        breadth = b;
    }

   public double area(){
        return height*breadth;
    }
}

class Square implements Shape{
    double side;
    Square(double s){
        side = s;
    }

    public double area(){
        return side*side;
    }

}

abstract class Vehicle{
    int wheels;

    Vehicle(){
        System.out.println("This is vehicle ");
    }
    abstract void show();
    abstract void start();
}

class Car extends Vehicle{
    Car(int w){
        System.out.println("This is car ");
      super.wheels = w;
    }

    void show(){
        System.out.println("This car has "+super.wheels+" wheels .");
    }

    void start(){
        System.out.println("Car is starting..");
    }
}

class Bike extends Vehicle{
    Bike(int w){
        System.out.println("This is Bike ");
      super.wheels = w;
    }

    void show(){
        System.out.println("This bike has "+super.wheels+" wheels .");
    }

    void start(){
        System.out.println("Bike is starting..");
    }
}

abstract class Employee {
    String name;
    int id;

    Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
    abstract double calculateSalary();   
}

class FullTimeEmployee extends Employee{
    int salary;
    FullTimeEmployee(String name,int id,int salary){
        super(name, id);
        this.salary = salary;
    }
    
    double calculateSalary() {
           System.out.println("Yearly salary : ");
      return 12*salary;
    }
}

class PartTimeEmployee extends Employee{
    int workingHour ;
    int salaryPerHour ;

    PartTimeEmployee(String name,int id ,int workingHour,int salaryPerHour){
        super(name, id);
        this.workingHour = workingHour;
        this.salaryPerHour = salaryPerHour;
    }

    double calculateSalary(){
        System.out.println("Yearly salary : ");
        return 365*workingHour*salaryPerHour;
    }
}



public class Nov5 {
    public static void main(String[] args) {
        // Create a class Circle with a static variable pi and static method to calculate area.
        // We can use static variable and method withot creating the object 
        System.out.println(Circle.pi);
        System.out.println("Area "+Circle.area(90));

        //  Create a parent class Animal and child classes Dog, Cat (inheritance) and demonstrate method overriding using above classes.
       Animal a = new Dog();
       a.show();
       a = new Cat();
       a.show();

    //    Create an interface Shape with method area(). Implement it in Triangle,Square and  Rectangle.
       Shape s = new Triangle(23, 70);
       System.out.println("Area of Triangle : "+s.area());
       s = new Rectangle(80, 90);
       System.out.println("Area of Rectangle : "+s.area());
       s = new Square(50);
       System.out.println("Area of Square : "+s.area());

    //    Create an abstract class Vehicle with abstract method start(). Extend it in Car, Bike.
     Vehicle v = new Car(4);
     v.show();
     v.start();

     v = new Bike(2);
     v.show();
     v.start();
    //  Create an abstract class Employee with an abstract method calculateSalary(). Extend it in FullTimeEmployee and PartTimeEmployee.
    Employee e = new FullTimeEmployee("Ram", 12, 80000);
    System.out.println(e.calculateSalary());
    e = new PartTimeEmployee("Shyam", 15, 4, 120);
      System.out.println(e.calculateSalary());
}
}

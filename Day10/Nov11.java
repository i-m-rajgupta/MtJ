class Animal{
    void eat(){
        System.out.println("Animal is eating ");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("Dog is barking ");
    }
}

class Person{
    String name;
    int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("Person is called ");
    }
}

class Student extends Person{
    String college;
    Student(String name,int age,String college){
        super(name,age);
        this.college = college;
    }

    void details(){
      System.out.println(name+" is studying in "+college+" college who is "+age+" years old .");
    }
}

class A{
    void grandparent(){
        System.out.println("I am grandparent");
    }
}

class B extends A{
    void parent(){
        System.out.println("I am parent");
    }
}

class C extends B{
    void child(){
        System.out.println("I am child");
    }
}

class Vehicle{
    void start(){
        System.out.println("Vehicle is starting...");
    }
}

class Bike extends Vehicle{
    void bike(){
        System.out.println("I am bike");
    }
}
class Car extends Vehicle{
    void car(){
        System.out.println("I am Car");
    }
}

class Employee{
    String name;
    double salary;
}

class Manager extends Employee{
    double bonus;
  
    Manager(String name,double salary,double bonus){
        super.name = name;
        super.salary = salary;
        this.bonus = bonus;
    }
    void getTotalSalary(){
        System.out.println("Manager salary is "+(salary+bonus));
    }
}
public class Nov11 {
    public static void main(String[] args) {
        //  Create a class Animal with method eat() and a class Dog extending it with method bark().
        Dog d = new Dog();
        d.eat();
        d.bark();

        // Create parent class Person with a constructor, and child class Student.
        //  Show how parent constructor is called from child class.
      Student s = new Student("Komal", 25, "MIT");
      s.details();

    //    Create classes A → B → C. 
// Each should have a different method, and object of class C should call all methods.
     C c = new C();
     c.grandparent();
     c.parent();
     c.child();

    //   Class Vehicle has method start().  Classes Car and Bike inherit from it.  Show usage in main.
    Bike b = new Bike();
    Car c1 = new Car();
    b.start();
    b.bike();
    c1.start();
    c1.car();

    // Create class Employee having name, salary.  Create child class Manager adding bonus. 
// Write function to display total salary. 
    Manager m = new Manager("shyam", 50000, 500);
    m.getTotalSalary();

    
    }
}

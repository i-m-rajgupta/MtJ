class Parent{
    String name = "Prachi";
}

class Child extends Parent{
    String name ;
    Child(String name){
        this.name = name;
    }
    void details(){
        System.out.println("Parent name : "+super.name);
        System.out.println("Child name  : "+name);
    }
}

class Shape{
    Shape(){
        System.out.println("Shape created");
    }
    void display(){
        System.out.println("This is shape ");
    }
}

class Rectangle extends Shape{
    void display(){
        super.display();
        System.out.println("This is Rectangle");
    }
}

class Fruit{
    Fruit(){
        System.out.println("Eating fruits keep you healthy ");
    }
}

class Apple extends Fruit{
    Apple(){
        super();
        System.out.println("Apple is good for health");
    }
}

class Person{
    String name;
    int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}

class Student extends Person{
    int roll;
   Student(String name,int age,int roll){
    super(name,age);
    this.roll = roll;
   }

   void display(){
    System.out.println(super.name+" is "+super.age+" years old and roll number is  "+roll);
   }
}

class Circle extends Shape{
    Circle(){
        super();
        System.out.println("Circle Created");
    }
}
public class Nov19 {
    public static void main(String[] args) {
        // Create a Parent class with variable name. Child class also has variable name. Print parent’s name using super.name. 
        Child c = new Child("Ruchi");
        c.details();

        // Parent has a method display(). Child overrides it and also calls parent’s method using super.display(). 
        Shape s = new Rectangle();
        s.display();

        // Call parent class constructor from child using super() and print messages.
        Apple a = new Apple();

        //  Parent class Person with constructor (name, age). Child class Student with constructor (name, age, roll). 
// Use super(name, age) inside Student. 
       Student s1 = new Student("Neelesh", 18, 25);
       s1.display();

    //    Parent class Shape has constructor printing "Shape Created". Child class Circle calls super() and prints "Circle Created". 
     Circle c1 = new Circle();   
}
}

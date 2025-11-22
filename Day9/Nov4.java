class Student{
    String name ;
    int age ;
    int rollNo ;
}
class Rectangle{
    int length ;
    int breadth ;

    int area(){
        return length*breadth;
    }

    int perimeter(){
        return 2*(length+breadth);
    }
}

class Car{
    String model ;
    int price;
    String color ;

    void start(){
        System.out.println("Car is starting ");
    }
}

class Calculator{
    double a;
    double b;

    int add(int a,int b){
        this.a = a;
        this.b = b;
        return (int) a+b;
    }
    double add(double a,double b){
        this.a= a;
        this.b =b;
        return a+b;
    }
}

class Employee{
    private int salary = 20000;
    String name;

    Employee(String name){
        this.name = name;
    }

    int getters(){
        return salary;
    }
    void setters(int a){
        salary = a;
    }
}
public class Nov4 {
    public static void main(String[] args) {
        // Create a class Student with name, age, rollNo. Create objects and print details.
        Student s1 = new Student();
        s1.name = "vijay";
        s1.age = 19;
        s1.rollNo = 66;
        Student s2 = new Student();
        s2.name = "harshit";
        s2.age = 20;
        s2.rollNo = 45;
        System.out.println("Student 1 details : "+s1.name+" "+s1.age+" "+s1.rollNo);
          System.out.println("Student 2 details : "+s2.name+" "+s2.age+" "+s2.rollNo);

        //    Create a class Rectangle with length, breadth and a method to calculate area and perimeter.
       Rectangle r1 = new Rectangle();
       r1.length = 34;
       r1.breadth = 10;
       System.out.println("Area of r1 "+r1.area());
       System.out.println("Perimeter of r1 "+r1.perimeter());
       Rectangle r2 = new Rectangle();
       r2.length = 50;
       r2.breadth = 20;
       System.out.println("Area of r2 "+r2.area());
       System.out.println("Perimeter of r2 "+r2.perimeter());

    //    Create a class Car with attributes model, color, price. Add a method start().
 
    Car c1 = new Car();
    c1.model = "XUV";
    c1.color = "black";
    c1.price = 800000;
    System.out.println("Car 1 details : "+c1.model+" "+c1.color+" "+c1.price);
    c1.start();

    // Create a Calculator class with method overloading for add(int,int), add(double,double).
     Calculator cl1 = new Calculator();
     System.out.println("Integer add "+cl1.add(2, 3));
     System.out.println("Double add "+cl1.add(2.4, 4.5));

    //   Create a class Employee with private fields. Use getters and setters (encapsulation).
    Employee e1 = new Employee("ram");
    System.out.println("Default salary : "+e1.getters());
    e1.setters(12000);
    System.out.println("After setting salary : "+e1.getters());
    }
}

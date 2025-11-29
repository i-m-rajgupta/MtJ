class Student{
    String name;
    String branch;
    Student(){
        System.out.println("Student object created");
    }
}

class Car{
    String company;
    String model;

    Car(String company,String model){
        this.company = company;
        this.model =model;
    }

    void display(){
        System.out.println(company+" "+model);
    }
}

class Laptop{
    String company;
    int ram;
    String processor;

    Laptop(String c,int r,String p){
        company = c;
        ram = r;
        processor = p;
    }

    Laptop(Laptop l){
        this.company = l.company;
        this.processor = l.processor;
        this.ram = l.ram;
    }

    void info(){
        System.out.println("Laptop details : "+company+"  "+ram+" GB RAM and "+processor+" processor ");
    }
}

class Book{
    String title;
    double price;
    String author;
    Book(String title,double price,String author){
     this.title = title;
     this.author = author;
     this.price = price;
    }

    void details(){
        System.out.println("Book details : "+title+" is written by "+author);
    }
    double discount(){
        return price - 0.18*price;
    }
}

class Product{
    String productName;
    double price;

    Product(String productName ,double price){
        this.productName = productName;
        this.price = (price > 0) ? price : 0;
    }

    void details(){
        System.out.println("Product details : "+productName+" costs "+price+" rupees");
    }
}
public class Nov9 {
    public static void main(String[] args) {
        // Create a class Student with  No argument constructor that prints "Student object created".
        Student s = new Student();
        s.name = "Dhanush";
        s.branch = "Cse";

        System.out.println(s.name+" is studying in "+s.branch+" branch .");

        // Create a class Car with a parameterized constructor (company, model) and print details.
       Car c = new Car("Mahindra", "Bolero");
       c.display();

    //  Create a Laptop class with copy constructor.
     Laptop l1 = new Laptop("Acer",8,"intel");
     Laptop l2 = new Laptop(l1);
     l2.ram = 16;
     l1.info();
     l2.info();

    //  Create a class Book with:	title, author, price and constructor to initialize and method to apply discount
    Book b = new Book("Mahabharat ", 500, "Ved vyas ");
    b.details();
    System.out.println("After discount the price of book is "+b.discount());

    // Create a class Product with constructor validation: price must not be negative and if negative, set price = 0
    Product p1 = new Product("Ball", 50);
    Product p2 = new Product("Bat", -85);
     p1.details();
     p2.details();
    }
}

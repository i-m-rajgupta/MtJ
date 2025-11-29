import java.util.ArrayList;
import java.util.List;

class Animal{
    int legs ;
    String color;

    Animal(String color,int legs){
        this.legs = legs;
        this.color = color;
    }
    void  show(){
     System.out.println("This is an animal ");
    }
}
class Dog extends Animal{
    String name;
    String sound;
    Dog(String name,int legs,String sound,String color){
      super(color, legs);
      this.sound = sound;
      this.name = name;
    }

    @Override
    void show(){
        System.out.println("This is a dog ");
        System.out.println(name+" has "+legs+" legs making "+sound+" sound and "+color+" in color");
    }
}

class Author{
    String name ;
    String email ;

    Author(String name ,String email){
        this.name = name;
        this.email = email;
    }

    void displayAuthor(){
        System.out.println(name+" "+email);
    }
}

class Book{

    String title;
    int price;
    Author author;

    Book(String title,int price,Author author){
        this.title = title;
        this.price = price;
        this.author = author;
    }

    void displayBook(){
        System.out.println("Title : "+title);
        System.out.println("Price : "+price);
        System.out.println("Author details : ");
        author.displayAuthor();
    }
}

class Library{
    String name;
    String location;
    List<Book> books ;

    Library(String name,String location,List<Book> books){
        this.name = name;
        this.location = location;
        this.books = books;
    }

    void showLibrary(){
        System.out.println("Library details : ");
        System.out.println(name+" and location is  "+location);
    }
    void showBooks(){
        showLibrary();
        for(Book b:books){
            b.displayBook();
        }
    }
}

class Fruit{
    String taste ;
    String color;
    
    Fruit(String taste,String color){
        this.taste = taste;
        this.color = color;
    }
    void show(){
        System.out.println("This fruit has "+color+" color and "+taste+" in taste. ");
    }
}

class Apple extends Fruit{
    Apple(String taste,String color){
     super(taste, color);
    }
    void display(){
    super.show();
    }
}

class Student{
    String name ;
    String branch;
    static String college = "Ujjain Engineering College";

    Student(String name,String branch){
        this.name = name;
        this.branch = branch;
    }

    void info(){
        System.out.println(name+" study in branch "+branch+" in "+college);
    }
}
public class Nov6 {
public static void main(String[] args) {
    //  Demonstrate runtime polymorphism using Animal a = new Dog();.
    Animal a = new Dog("Dollar", 4, "Bark", "brown");
    a.show();

    // Create a class Book that has an Author object inside it (composition).
    Author vijay = new Author("Vijay", "vijay123@gmail.com");
    Book b1 = new Book("Good vibes", 150, vijay);
    Author hemu = new Author("hemu", "hemu@gmail.com");
    Book b2 = new Book("M1", 500, hemu);

 
    // Create a class Library containing list of Book objects (aggregation).
   List<Book> books = new ArrayList<>();
    books.add(b1);
    books.add(b2);
    Library library = new Library("Ujjain college library","Engineering square,Ujjain", books);
    library.showBooks();

    //  Demonstrate use of super keyword (super constructor call + super method).
    Fruit f = new Apple("sweet", "red");
    f.show();

    // Create a class Student with a unique attributes using static variable.
      System.out.println(Student.college);
    Student s = new Student("Harshit", "CSE");
    s.info();
}
}
import java.util.ArrayList;
import java.util.List;

class Room{
    String name;
    int area;

    Room(String name,int area){
        this.name = name;
        this.area = area;
    }

    void display(){
    System.out.println(name+" has "+area+" Area. ");
    }
}

class House{
    String owner;
    Room r1;
    Room r2;
    Room r3;
    List<Room> rooms = new ArrayList<>();
   
    House(String owner){
        this.owner = owner;
        r1 = new Room("Living room", 500);
        r2 = new Room("Kitchen", 200);
        r3 = new Room("Bedroom", 600);
        addRoom();
    }
     void addRoom(){
     rooms.add(r1);
     rooms.add(r2);
     rooms.add(r3);
     }
  
     void display(){
        System.out.println("This house is owned by "+owner);
        for(Room r : rooms){
            r.display();
        }
     }
}

class Processor{
    String company;
    int series;

    Processor(String company,int series){
        this.company = company;
        this.series = series;
    }

    void info(){
        System.out.println("This is processor  of "+company+" with "+series+" series ");
    }
}

class Computer{
   String company;
   int ram;
   int rom;
   Processor p1;

   Computer(String company ,int ram,int rom){
    this.company = company;
    this.ram = ram;
    this.rom = rom;
    p1 = new Processor("AMD RYZEN", 700);
   }

   void display(){
   System.out.println("This computer is made by "+company);
   System.out.println("It has "+p1.company+" processor of "+p1.series+" and "+ram+" RAM "+rom+" ROM");
   }
}

class Chapter{
    int no;
    String title;
    String author;
    static int count=1;

    Chapter(String title,String author){
       this.title = title;
       this.author = author;
       addNo();
    }

    void addNo(){
        this.no = count++;
    }

    void display(){
      System.out.println("Chapter "+no+" : "+title+" and is written by "+author);
    }
}
class Book{
    String title;
    String author;
    int price;
    Chapter c1 = new Chapter( "The Road to heaven ", "James ");
    Chapter c2 = new Chapter( "Deep Meditation ", "Shri");
    Book(String title,String author,int price){
        this.price = price;
        this.author = author;
        this.title = title;
    }

    void display(){
        System.out.println(title+" is written by "+author+" and available in "+price+" rupees .");
        c1.display();
        c2.display();
    }
}

class Heart{
    int heartRate;
    Heart(int heartRate){
        this.heartRate = heartRate;
    }
}

class Human{
    String name;
    int age;
    String gender;
    Heart h = new Heart(72);

    Human(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void display(){
        System.out.println("Details : ");
        System.out.println("Name : "+name+" Age : "+age+" Gender : "+gender);
        System.out.println("Heart is beat at "+h.heartRate+" rate ");
    }
}

class Engine{
    String engine;
    
    Engine(String engine){
        this.engine = engine;
    }
}

class Car{
    String name;
    int wheels;
    String color;
    Engine eng = new Engine("4-Stroke ");
    Car(String name,int wheels,String color){
     this.color = color;
     this.name = name;
     this.wheels = wheels;
    }

    void display(){
      System.out.println(name+"  has "+wheels+" with "+color+" color ");
      System.out.println("It has "+eng.engine+" engine ");
    }
}

public class Nov15 {
    public static void main(String[] args) {
        // Create a class House and class Room. If House is destroyed, Rooms are destroyed too (Composition). 
        House h = new House("Ramesh");
        h.display();

        // Create a class Computer and class Processor. Computer contains Processor — strong association.
       Computer c = new Computer("Acer", 8, 512);
       c.display();

    //     Create class Book and class Chapter. Chapter cannot exist without Book.
      Book b = new Book("Honeydew", "Williams Bond", 70);
      b.display();
      
    // Create class Human and class Heart. Heart cannot exist without Human (Composition). 
    Human  human = new Human("Ash", 21, "Male");
    human.display();

    // Create class Car and class Engine. Engine cannot exist outside Car.
   Car c1 = new Car("Alto", 4, "red");
   c1.display();
    }
}

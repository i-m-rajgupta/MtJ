interface Printable{
    void print();
}

interface Showable{
    void show();
}

class A implements Printable,Showable{
    public void print(){
        System.out.println("This can print ");
    }
    public void show(){
        System.out.println("This can show");
    }
}

class Shape{
    void area(){
        System.out.println("Area of shape is calculated ");
    }
}

class Rectangle extends Shape{
    double length;
    double breadth;

    Rectangle(double length,double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    void area(){
        System.out.println("Area of Rectangle is : "+length*breadth);
    }
}

class Circle extends Shape{
    double pi = Math.PI;
    double radius ;
    Circle(double radius){
        this.radius = radius;
    }
    void area(){
        System.out.println("Area of Circle is :"+pi*radius*radius);
    }
}

class Triangle extends Shape{
    double length;
    double breadth;

    Triangle(double length,double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    void area(){
        System.out.println("Area of triangle is "+0.5*length*breadth);
    }
}

class Student{
    String name;
    String branch;
    int year;
    int marks;

    Student(String name,int year,String branch){
        this.name = name;
        this.branch = branch;
        this.year = year;
    }

    void display(){
        System.out.println("Student details : Name - "+name+" Year - "+year+" Branch - "+branch );
    }
}

class Marks extends Student{
    double maths;
    double science;
    double hindi;
    int totalSubject = 3;
     double totalMarks;

    Marks(String name,int year,String branch,double maths,double science,double hindi){
        super(name,year,branch);
        this.maths = maths;
        this.science = science;
        this.hindi = hindi;
        getTotal();
    }

    void getTotal(){
        totalMarks = maths+science+hindi;
    }
    @Override
    void display() {
        super.display();
        System.out.println("Total marks obtained is : "+totalMarks);
    }
}

class Result extends Marks{

    Result(String name,int year,String branch,double maths,double hindi,double science){
      super(name,year,branch,maths,science,hindi);
    }

      char grade;
    double avg = totalMarks / totalSubject;

    void calculateGrade(){
      if(avg>90){
        grade = 'A';
      }else if(avg <= 90 && avg >80){
        grade = 'B';
      }else if(avg <= 80 && avg > 70){
        grade = 'C';
      }else{
        grade= 'D';
      }
    }

    @Override
    void display() {
        super.display();
       calculateGrade();
       System.out.println("Average is "+avg);
       System.out.println("Grade Obtained is : "+grade);
    }
}

class LibraryItem{
    int itemNo ;

    LibraryItem(int itemNo){
        this.itemNo = itemNo;
    }

    void display(){
     System.out.println("Library Item : "+itemNo);
    }
}

class Book extends LibraryItem{
    String name ;
    int price;
    String author ;

    Book(String name,int price,String author ,int itemNo){
        super(itemNo);
        this.name = name;
        this.price = price;
        this.author = author;
    }
 
    @Override
    void display(){
        super.display();
        System.out.println("Book details : Title "+name+" Price : "+price+" Author : "+author);
    }
}

class Magazine extends LibraryItem{
    String date;
    String title;
    int issueNo;
    
    Magazine(String title,String date,int itemNo,int issueNo){
        super(itemNo);
        this.date = date;
        this.title = title;
        this.issueNo = issueNo;
    }

    @Override
    void display(){
       super.display();
       System.out.println("Magazine details  Title : "+title+" Date "+date+" Issue : "+issueNo);
    }
}

class Newspaper extends LibraryItem{
    String date;
    String title;
    
    Newspaper(String title,String date,int itemNo){
        super(itemNo);
        this.date = date;
        this.title = title;
    }

    @Override
    void display(){
       super.display();
       System.out.println("Newspaper details  Title : "+title+" Date "+date);
    }
}

interface Smartfeatures{
    void usingInternet();
}

interface Camera{
    void photo();
}

class Device{
    Device(){
        System.out.println("Device is power on");
    }
}

class Mobile extends Device{
    Mobile(){
        System.out.println("Phone is using call feature.");
    }
}

class Smartphone extends Mobile implements Smartfeatures,Camera{
    Smartphone(){
        System.out.println("Smartphone having all the latest features .");
    }
    public void photo(){
        System.out.println("It is capturing the memorable moments with best quality camera");
    }
    public void usingInternet(){
        System.out.println("This device is connected to the world");
    }

    void display(){
        photo();
        usingInternet();
    }
}
public class Nov12 {
    public static void main(String[] args) {
        // Create two interfaces: Printable and  Showable Implement both in one class and call methods. 
        A a = new A();
        a.show();
        a.print();

        // Parent class: Shape Child classes: Rectangle, Triangle, Circle Each should calculate area. 
        Shape s = new Shape();
        s.area();
        s = new Circle(45);
        s.area();
        s = new Rectangle(12, 35);
        s.area();
        s = new Triangle(45, 44);
        s.area();

        // Class Student → stores basic details Class Marks → stores marks Class Result → calculates grade
        //  Override method display(). 
        Student result = new Result("Mahesh", 2, "CSE", 89, 78, 78);
        result.display();

        // Parent: LibraryItem Children: Book, Magazine, Newspaper 
        // Each should have their own display function.

        LibraryItem b = new Book("Java Programming ", 500, "James bond", 5677);
        LibraryItem m = new Magazine("New Vibes", "18-Oct-2025", 5966, 89);
        LibraryItem n = new Newspaper("Indian Times", "12-Nov-2025", 5899);
        b.display();
        m.display();
        n.display();

        // Two interface smartfeatures and camera class Smartphone implements both interface and also extends
        //  class Mobile and Mobile extend class Device. 
         Smartphone s1 = new Smartphone();
         s1.display();
        
    }
}

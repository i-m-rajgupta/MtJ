
import java.util.ArrayList;
import java.util.List;

class Course{
    String name;
    int price;
    boolean status;

      Course(String name,int price,boolean status){
        this.name = name;
        this.price = price;
        this.status = status;
    }

    void details(){
         System.out.println("This course is "+name+" with "+price+" price");
         System.out.println("Your current confirmation to the course : "+status);
    }
}

class Student{
    String name ;
    String college;
    String branch;
    int year;
    List<Course> courses;

    Student(String name,String college,String branch,int year){
        this.name = name;
        this.college = college;
        this.branch = branch;
        this.year = year;
    }

    void studentDetails(){
            System.out.println("Welcome to Master skills classes ");
        System.out.println("Student details : Name -> "+name+" College -> "+college+" Branch -> "+branch+" Year -> "+year);
    }

    void setCourse(List<Course> courses){
            this.courses = courses;
    }

    void courseDetails(){
        if(courses == null){
           System.out.println("You are not enrolled in any course . Please first enrolled in our courses ");
           return;
        }
        for(Course course : courses ){
            course.details();
        }
    }
}

class Subject{
    String name;
    int experience;

    Subject(String name,int experience){
        this.name = name;
        this.experience = experience;
    }

    protected void details(){
        System.out.println("Subject details : Name -> "+name+" Experience in teaching subject is "+experience+" years");
    }
}
class Teacher{
    String name;
    String quali;
    int age;
    double salary;
    String department;
    Subject sub;
    String college;
    Teacher(String name,String quali,int age,double salary,String department,Subject sub,String college){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.quali = quali;
        this.sub = sub;
        this.college = college;
    }

    void subjectDetails(){
        sub.details();
    }

    void teacherDetails(){
        System.out.println(name+" teaches "+sub.name+" in the "+department+" of "+college+" college");
        System.out.println(name+" has "+sub.experience+" years experience in teaching this subject ");
        System.out.println(name+"'s qualification is "+quali+" with salary "+salary);
        System.out.println("Additional Info Age : "+age);
    }
}

class Car{
    String name;
    int model_no ;
    String color;

    Car(String name,int model_no,String color){
        this.name = name;
        this.model_no = model_no;
        this.color = color;
    }
    void details(){
        System.out.println("Car details : "+name+" has model no "+model_no+" with "+color+" color");
    }
}
class Driver{
    String name;
    int experience;
    int license_no ;

    Car car;

    Driver(String name,int experience,int license_no,Car car){
       this.name = name;
       this.car = car;
       this.experience = experience;
       this.license_no = license_no;
    }

    void details(){
       System.out.println("Driver details : ");
       System.out.println(name+" has "+experience+" years experience in driving "+car.name+" of "+car.model_no+" model ");
       System.out.println(name+"'s license no is : "+license_no);
    }
}

class Book{
    String title;
    int price;
    String author;

    Book(String title,int price,String author){
        this.author = author;
        this.price = price;
        this.title = title;
    }

    void display(){
        System.out.println(title+" is written by "+author+" and is available in only "+price+" rupees");
    }

}
class Library{
    String name;
    String location;
    int totalBooks;

    List<Book> books;

    Library(String name,String location){
       this.name = name;
       this.location = location;
    }

    void setBooks(List<Book> books){
       this.books = books;
       this.totalBooks = books.size();
    }

    void getBookDetails(){
        if(books == null){
            System.out.println("No books available ");
            return;
        }

        for(Book book : books){
            book.display();
        }
    }

    void details(){
        System.out.println(name+" is located at "+location+" and contains "+totalBooks+" books");
    }
}

class Address{
    String city;
    String state;
    String country;
    int zip_code;

    Address(String city,String state,String country,int zip_code){
        this.city = city;
        this.country = country;
        this.state = state;
        this.zip_code = zip_code;
    }

    void display(){
        System.out.println("Address : "+city+" , "+state+" , "+country+" and zip code is "+zip_code);
    }
}
class Person{
    String name ;
    int age;
    String gender;
    int height;

    Address add;

    Person(String name,int age,String gender,int height,Address add){
        this.name = name;
        this.add = add;
        this.age =age;
        this.gender = gender;
        this.height = height;
    }

    void details(){
        System.out.println("Personal details :");
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Gender : "+gender);
        System.out.println("Height : "+height);
        System.out.print("Address : ");
        add.display();
    }
}
public class Nov13 {
    public static void main(String[] args) {
        // Create a class Student and a class Course. A Student can take multiple Courses. Show this using association.
        Course c1 = new Course("Java Programming ",5000,true);
        Course c2 = new Course("Web development", 8900, true);
        Course c3 = new Course("Computer Networking", 5000, false);

        List<Course> courses = new ArrayList<Course>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        Student s = new Student("Bulbul", "UEC", "EE", 3);
        s.setCourse(courses);
        s.studentDetails();
        s.courseDetails();

        //  Create a class Teacher and a class Subject. A Teacher teaches a Subject. Use association to link them.
            Subject sub = new Subject("DS", 15);
            Teacher teacher = new Teacher("Vinay", "M Tech", 45, 150000, "CSE", sub, "UEC");
            teacher.subjectDetails();
            teacher.teacherDetails();

            // Create a class Driver and class Car. A Driver drives a Car. Demonstrate association. 
         Car car = new Car("Alto", 3434, "red");
         car.details();

         Driver driver = new Driver("Mukesh", 15, 96688557, car);
         driver.details();

        //   Create a class Library and class Book. A Library contains multiple Books. Show association.
         Library lib = new Library("Akagra Library", "Mahananda Ujjain");
         Book b1 = new Book("Python", 566, "Murli prasad");
         Book b2 = new Book("Higher MAthematics", 900, "Harshit Gangwani");
         Book b3 = new Book("Java Programing ", 500, "Nitin Vajpayee");
         List<Book> books = new ArrayList<Book>();
         books.add(b1);
         books.add(b2);
         books.add(b3);

         lib.setBooks(books);
         lib.details();
         lib.getBookDetails();

         Library lib1 = new Library("UPS", "Sehore");
         lib1.details();
         lib1.getBookDetails();

        //  Create a class Person and class Address. A Person "has-a" Address.
        Address add = new Address("Ujjjain", "MP", "India", 456010);
        Person per = new Person("Mahesh", 56, "Male", 162, add);
        per.details();
    }
}


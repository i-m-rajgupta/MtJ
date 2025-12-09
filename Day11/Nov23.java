import student.Student;
import myutils.Calculator;
import ecommerce.product.Product;
import ecommerce.cart.*;
import library.books.Book;
import library.members.*;
import university.student.Students;
import university.teacher.Teacher;


public class Nov23 {
    public static void main(String[] args) {
        // first create package folder and then put the file of your code inside it like Student.java inside the student
        //javac -d . student/Student.java - for package compilation here is -d is for destination and . is current diectory

        // Create a package named student and inside it create a class StudentInfo that prints student details.
        //  Import it into another class and call its method.
         
        Student s = new Student();
        s.StudentInfo();

        // Create a package myutils with a class Calculator containing add() and subtract() methods. Use this class from a 
        // different file. 
        
        Calculator c= new Calculator();
        c.add(5,2);
        c.subtract(5, 2);
         
        //  Create packages: 
    // ecommerce.product → class Product with name, price AND ecommerce.cart → class Cart with addProduct() and showCart() 
    // Task: Use the classes in a main program to simulate adding products to a cart. 

    
     Product p1 = new Product("paint",55);
    Product p2= new Product("Bread", 20);
    Cart c1 = new Cart();
    c1.addProduct(p1);
    c1.addProduct(p2);
    c1.showCart();

    // Create packages: 
// library.books → class Book with title, author and library.members → class Member with name, memberId 
// Task: Import classes and display books issued to a member in a main class. 
    
    Member m1 = new Member("Jyoti");
    Member m2 = new Member("Pushpa");
    Book b1 = new Book("M1", "Tejas", m1);
    Book b2 = new Book("M2", "Jullie", m2);
    m1.display();
    m2.display();
    b2.display();
    b1.displayAllBooks();

    //  Create packages: 
// university.student → class Student with name, roll number university.teacher → class Teacher with name, subject 
// Task: Import both classes into a Main class and display student and teacher info. 
    Students s1 = new Students("Sanchay");
    Teacher t1 = new Teacher("Shailendra","ACD");

    s1.display();
    t1.info();
    
    }
}

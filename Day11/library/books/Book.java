package library.books;
import java.util.ArrayList;
import java.util.List;

import library.members.Member;

public class Book {
    String name;
    String author;
    Member m;
   static List<Book> books = new ArrayList<>();
    public Book(String name,String author,Member m ){
        this.name = name;
        this.author = author;
        this.m = m;
        addBook();
    }

    public void addBook(){
        books.add(this);
    }

    public void display(){
        System.out.println(name+" Book whose author is "+author+" and issued to : ");
        this.m.display();
    }

    public void  displayAllBooks(){
           System.out.println(" --- All Books Details ---");
        for(Book b : books){
            b.display();
        }
    }

    // Create packages: 
// university.student → class Student with name, roll number university.teacher → class Teacher with name, subject 
// Task: Import both classes into a Main class and display student and teacher info. 

   
}

class Person{
    String name;
    int age;
    String gender;

    class Address{
        String city;
        String state;
        String country;

        Address(String city,String country,String state){
              this.city = city;
              this.country = country;
              this.state = state;
              System.out.println("Address is created ");
        }
        void display(){
            System.out.println(name+" Address is "+city+" , "+state+" , "+country);
        }
    }

    Person(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
        System.out.println("Person is created ");
    }

    void display(){
        System.out.println(name+" is "+gender+" with age "+age+" years.");
    }
}

abstract class Account{
    String name ;
    int age;
    String address;
    int salary;
    double balance;
    static String bankName = "Union Bank ";

    abstract void info();

       void getbalance(){
        System.out.println("Balance is "+balance);
    }
}

class CurrentAccount extends Account{
    String purpose ;

    CurrentAccount(String name,int age,String address,int salary,double balance,String purpose){
        super.address = address;
        super.age = age;
        super.balance = balance;
        super.name = name;
        super.salary = salary;
        this.purpose = purpose;
    }

    @Override
    void info(){
        System.out.println("This Current account is created in" +bankName+" for "+purpose+" by "+name);
        System.out.println(name+" is "+age+" years living in "+address);
    }

}

class SavingsAccount extends Account{


        SavingsAccount(String name,int age,String address,int salary,double balance){
        super.address = address;
        super.age = age;
        super.balance = balance;
        super.name = name;
        super.salary = salary;
    }

        @Override
    void info() {
         System.out.println("This Saving account is created in" +bankName+" by "+name);
        System.out.println(name+" is "+age+" years living in "+address);   
    }

}

interface Playable{
    void play();
    void pause();
    void stop();
}

class MusicPlayer implements Playable{
    String title;
    String artist;
     MusicPlayer(String title,String artist){
       this.title = title;
       this.artist = artist;
     }

     void info(){
        System.out.println("Song name : "+title+" and Artist name : "+artist);
     }
    public void play(){
        System.out.println("Song is playing ");
     }

    public void pause(){
        System.out.println("Song is paused ");
    }
    public void stop(){
        System.out.println("Song is stopped ");
    }
}

class VideoPlayer implements Playable{
     String title;
    int quality;
     VideoPlayer(String title,int quality){
       this.title = title;
       this.quality = quality;
     }
      void info(){
        System.out.println("Video title : "+title+" and Video quality : "+quality);
     }
      public void play(){
        System.out.println("Video is playing ");
     }

    public void pause(){
        System.out.println("Video is paused ");
    }
    public void stop(){
        System.out.println("Video is stopped ");
    }
}

final class A {
    int marks ;
    String name;

    A(String name ,int marks){
    this.name = name;
    this.marks = marks;
    }
    void info(){
        System.out.println(name+" got "+marks+" marks");
    }
}

class Student{
    String name;
    String id = "0701CS";
    static int count = 231000;

    Student(String name){
        this.name = name;
        count++;
        this.id = id+count;
    }

    void details(){
        System.out.println(name+" having id is "+id);
    }
}

public class Nov7 {
    
    public static void main(String[] args) {
        // Create a class Person and nested class Address (inner class).
        Person p1 = new Person("Vijay", 56, "male");
        Person.Address a1 = p1.new Address("ujjain", "India", "MP");
        p1.display();
        a1.display();

           Person p2 = new Person("Mamta", 45, "female");
        Person.Address a2 = p2.new Address("sehore", "India", "MP");
        p2.display();
        a2.display();

        // Create an abstract class Account with implemented + abstract methods. Extend SavingsAccount & CurrentAccount.
        CurrentAccount c = new CurrentAccount("Shyam", 25, "ujjain", 80000, 5000, "business");
        c.info();
        c.getbalance();
        SavingsAccount s = new SavingsAccount("Ram", 56, "shajapur", 50000, 500);
       s.info();
       s.getbalance();

    //     Create an interface Playable with play(), pause(), stop(). Implement in MusicPlayer, VideoPlayer.
     MusicPlayer m = new MusicPlayer("Banjara", "Arjit Singh");
     VideoPlayer v = new VideoPlayer("Practice video ", 144);
     m.info();
     v.info();
     m.pause();
     m.play();
     m.stop();
     v.stop();
     v.play();

    //  Create final class A and try extending it.
     A f = new A("Mahesh", 89);
     f.info();
    // We cannot extehd the final class 

    // Create a class Student with a unique ID generated using static variable.
     Student s1 = new Student("Neha");
     Student s2 = new Student("Priya");
     Student s3 = new Student("Mahesh");
     s1.details();
     s2.details();
     s3.details();
    }
}

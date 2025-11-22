class Student{
    // default constructor 
    String enroll;
    String name;
    int age;

    void show(){
        System.out.println(this.name+" "+this.age+" "+this.enroll);
    }
}

class Vehicle{
    // No argument
    int wheels;
    String color;
    int model_no ;
    String model_name;

    Vehicle(){
        System.out.println("Constuctor is called ");
    }

    void show(){
     System.out.println(this.model_name+" "+this.color);
    }
}

class Bank{
    // Paramaterized constructor 
    int balance;
    String name;
    
    Bank(int balance,String name){
     this.balance = balance;
     this.name = name; 
    }

    void show(){
        System.out.println(this.name+" "+this.balance);
    }
}
class Teacher {
    String name;
    int salary;
    String quali;
    String college_name;
    String college_address;
    
    
    Teacher(String n,int s,String q){
        name = n;
        salary = s;
        quali = q;
        college_name = "UEC";
        college_address = "Sanwer road";
    }
    
    // Copy consturctor 
    Teacher(Teacher t){
        this.name = t.name;
        this.salary = t.salary;
        this.quali = t.quali; 
        this.college_name = t.college_name;
        this.college_address = t.college_address;
    }
}
public class Program2 {
        public static void main(String[] args) { 
    // Student s1 = new Student();
    // Student s2 = new Student();
    // Student s3 = new Student();
    // s1.name = "Raj";
    // s1.age = 20;
    // s1.enroll = "0701cs231053";
    // s2.name = "Piyush";
    // s2.age =19;
    // s2.enroll = "0701cs241053";
    // s3.name = "Ritika";
    // s3.enroll = "0701cs241060";
    // s3.age =19;
    // s1.show();
    // s2.show();
    // s3.show();
    // s3.enroll = "0701ec421060";
    // s3.show();

    // Constructor - default copy paramaterzied no argument 
    
    // Vehicle v1 = new Vehicle();
    // Vehicle v2 = new Vehicle();
    // v1.model_name = "hero honda";
    // v1.model_no=123;
    // v1.color = "pink";
    // v1.wheels = 2;
    // v2.model_name ="Creta";
    // v2.color="white";
    // v2.wheels =4;
    // v2.model_no = 966;
    // v1.show();
    // v2.show();
    
    // Bank b1 = new Bank(500, "raj");
    // Bank b2 = new Bank(1000, "piyush");
    // Bank b3 = new Bank(1500, "Ritika");
    // b1.show();
    // b2.show();
    // b3.show();

    
    Teacher t1 = new Teacher("Rahul Paldiya",80000,"M tech");
    Teacher t2 = new Teacher(t1);   //Copy constructor 
     Teacher t3 = new Teacher(t1);
     Teacher t4 = new Teacher(t1);

     t2.name = "Rahul sharma";
     t3.name = "Ashok sir";
     t4.name = "Vaishali mam";
   t3.salary = 200000;
         System.out.println(t3.name+" "+t3.salary+" "+t3.college_name);
}
}
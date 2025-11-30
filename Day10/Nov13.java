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
    }
}


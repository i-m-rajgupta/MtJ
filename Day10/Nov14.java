import java.util.ArrayList;
import java.util.List;
class Employee{
    String name;
    String quali;
    int experience;
    int salary;

    Employee(String name,String quali,int experience,int salary){
        this.name = name;
        this.quali = quali;
        this.experience = experience;
        this.salary = salary;
    }

    void details(){
        System.out.println("Employee Details : ");
        System.out.println("Name : "+name);
        System.out.println("Qualification : "+quali);
        System.out.println("Salary : "+salary);
        System.out.println("Experience : "+experience);
    }
}

class Department{
    String name;
    int totalEmployess;
    List<Employee> employees;

    Department(String name){
        System.out.println("Welcome to the "+name+" Departmenet ");
        this.name = name;
    }

    void addEmployee(List<Employee> employees){
        this.employees = employees;
        this.totalEmployess = employees.size();
    }

    void getEmployees(){
        if(employees == null){
            System.out.println("No employee available ");
            return;
        }

        System.out.println("Details of employees of "+name+" Department ");
        for(Employee e : employees){
            e.details();
        }
    }
}

class Player{
    String name;
    int experience;
    int age;

    Player(String name,int experience, int age){
        this.name = name;
        this.experience = experience;
        this.age = age;
    }

    void display(){
        System.out.println("Player info : ");
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Experience : "+experience);
    }
}
class Team{
    String name;
    int totalMembers;
    Player leader;

    List<Player> players;
    Team(String name,Player leader,List<Player> players){
        this.name = name;
        this.leader = leader;
        this.players = players;
        this.totalMembers = players.size();
    }

    void details(){
        System.out.println("Team "+name+"  with leader "+leader.name+" : ");
        for(Player p : players){
            p.display();
        }
    }
    
}

class Project{
    String name;
    String leader;
    int day;

    Project(String name,String leader,int day){
        this.name = name;
        this.day = day;
        this.leader = leader;
    }

    void display(){
        System.out.println(name+" project is under "+leader+" and should complete in "+day+" days");
    }
}
class Company{
    String name;
    int reveueGenerated;
    List<Project> projects = new ArrayList<>() ;

    Company(String name,int reveueGenerated){
        this.name = name;
        this.reveueGenerated = reveueGenerated;
    }

    void addProject(Project p){
        projects.add(p);
    }

    void display(){
        System.out.println(name+" company has generated "+reveueGenerated+" revenue in last year and it is currently working on this projects : ");
        if(projects.size() == 0){
            System.out.println("No Project has added .Add some using addProject()");
            return;
        }
        for(Project p : projects){
            p.display();
        }
    }
}

class Student{
    String name;
    int id;

    Student(String name,int id){
        this.name = name;
        this.id = id;
    }

    void display(){
        System.out.println(name+" is enrolled with Student ID : "+id);
    }
}

class University{
    String name ;

    List<Student> students;
    University(String name,List<Student> students){
        this.name = name;
        this.students = students;
    }

    void display(){
        System.out.println("Student enrolled in "+name+" University ");
        if(students.size() == 0){
            System.out.println("No student has enrolled ");
            return;
        }
       for(Student s  : students){
            s.display();
        }
    }

}

class Account{
    String name;
    static int count=200014400;
    int accountNo ;

    Account(String name){
        this.name = name;
        addAccount();
    }

    void addAccount(){
        count++;
       accountNo = count;
    }
   
   void display(){
        System.out.println(name+" has account with "+accountNo+" Account Number.");
    }
}

class Bank{
    String name;
    List<Account> accounts = new ArrayList<>();
    Bank(String name){
        this.name = name;
    }

    void addAccount(Account a){
        accounts.add(a);
    }

    void display(){
            if(accounts.size() == 0){
            System.out.println("No Information available right now.");
            return;
        }
        System.out.println(name+" Bank has these account ");
    
        for(Account a : accounts){
            a.display();
        }
    }
}
public class Nov14 {
    public static void main(String[] args) {
        // Create class Department and class Employee. A Department has multiple Employees (but Employees can exist even without
        //  the Department).
        
        Department d = new Department("Sales");
        Employee e1 = new Employee("Chutki", "MBA", 15, 70000);
        Employee e2 = new Employee("Jaggu", "BBA", 5, 30000);
        Employee e3 = new Employee("Raju","Btech",15,80000);
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        d.addEmployee(employees);
        d.getEmployees();

        // Create class Team and class Player. A Player can exist without the Team
        Player p1 = new Player("Himanshu", 5, 22);
            Player p2 = new Player("Sangharsh", 5, 25);
                Player p3 = new Player("LAkshya", 5, 28);

                List<Player> players = new ArrayList<>();
                players.add(p1);
                players.add(p2);
                players.add(p3);

                Team t = new Team("Noobers", p1, players);
                t.details();

                // Create class Company and class Project. A Company works on many Projects (Project can exist independently). 
              Project pro1 = new Project("Apna", "Satyam", 45);
              Project pro2 = new Project("Fired", "Nitin", 70);
              Company apna = new Company("Apna Sapna money money", 520000);
              apna.addProject(pro2);
              apna.addProject(pro1);
              apna.display();
               
            //    Create class University and class Student. A Student can exist without the University (Aggregation).

            Student s = new Student("Shailu", 1);
            List<Student> students = new ArrayList<>();
            students.add(s);
            University u = new University("RGPV",students);
            u.display();

            // Create class Bank and class Account. An Account exists independent of Bank object. 
            Account a1 = new Account("Rohan");
            Account a2 = new Account("Chandu");
            Bank b = new Bank("IOB");
            b.addAccount(a1);
            b.addAccount(a2);
            b.display();
    }
}

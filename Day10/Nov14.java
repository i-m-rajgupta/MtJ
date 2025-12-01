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
    }
}

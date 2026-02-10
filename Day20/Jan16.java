import java.util.*;

class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private double salary;
     String department;
    
    Employee(int id,String name,Double salary,String department){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public int compareTo(Employee other){
     return Double.compare(this.salary, other.salary);
    }
     
    @Override
    public String toString(){
        return "Employee ("+id+","+name+","+salary+")";
    }
}

class Student{
    int marks;
    String name;
    Student(int marks,String name){
     this.marks = marks;
     this.name = name;
    }

   public String toString(){
    return "Student - (marks : "+marks+", name : "+name+")";
   }
}

class MarksComparator implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return Integer.compare(s1.marks, s2.marks);
    }
}

class Employee2 {
    String name,department;
    Employee2(String name,String department){
        this.name = name;
        this.department = department;
    }

    public String toString(){
        return "Employee : "+name+" "+department;
    }
}
public class Jan16 {
    public static void main(String[] args) {
        // Write a class Employee that implements Comparable and sort objects by salary.
         Employee e1 = new Employee(1, "Ash", 60000.0,"Sales");
         Employee e2 = new Employee(2, "Bin", 45000.0,"HR");
          Employee e3 = new Employee(3, "Charlie", 80000.0,"Market");
  Employee e4 = new Employee(4, "Duggo", 90000.0,"Market");
          List<Employee> employees = new ArrayList<>();
          employees.add(e1);
          employees.add(e2);
          employees.add(e3);
          employees.add(e4);

          for(Employee e : employees){
            System.out.println(e);
          }

          Collections.sort(employees);
        employees.forEach(System.out::println);

        //Write a program demonstrating compareTo returning positive negative and zero.
        System.out.println("a".compareTo("b"));
        System.out.println("b".compareTo("a"));
        System.out.println("a".compareTo("a"));

        System.out.println(e1.compareTo(e3));
        System.out.println(e1.compareTo(e2));
        System.out.println(e1.compareTo(e1));

        // Write a Java program to sort a list of strings using Comparator.
        List<String> lists = Arrays.asList("Banana","grape","Orange","apple","kiwi");
        System.out.println("Original list ");
        System.out.println(lists);
        Collections.sort(lists,new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                return s1.compareToIgnoreCase(s2);
            }
        });

        System.out.println("Lists after sorting ignoring case : ");
        System.out.println(lists);

        lists.sort((s1,s2) -> s1.compareTo(s2));
        System.out.println("Lists after sorting with case sensitive ");
        System.out.println(lists);
        
        lists.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(lists);

    //    Write a custom Comparator to sort students by marks.
    List<Student> students = new ArrayList<>();
    students.add(new Student(78, "putin"));
    students.add(new Student(45, "usha"));
    students.add(new Student(66, "williams"));

    System.out.println(students);
    students.sort(new MarksComparator());
    System.out.println("In Ascending order ");
    System.out.println(students);
    System.out.println("In Descending order");
     students.sort((s1,s2)->Integer.compare(s2.marks,s1.marks));
System.out.println(students);

    //  Write a program to sort employees first by department and then by name using thenComparing().
     List<Employee2> employee2 = new ArrayList<>();
     employee2.add(new Employee2("Jyoti", "Sales"));
     employee2.add(new Employee2("Osho", "HR"));
          employee2.add(new Employee2("Dhroova", "It"));
 employee2.add(new Employee2("Alice", "It"));
        employee2.sort(Comparator.comparing((Employee2 e) -> e.department).thenComparing(e -> e.name) );
        employee2.forEach(System.out::println);

    //  
    }
}

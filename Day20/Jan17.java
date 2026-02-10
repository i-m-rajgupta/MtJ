import java.util.*;

class Employee{
     int age;
     String name;
     Employee(String name,int age){
        this.name = name;
        this.age = age;
     }

     @Override
     public String toString(){
       return "Employee ( "+name+" , "+age+")";
     }
}
public class Jan17 {
    public static void main(String[] args) {
        // Write a program using Comparator.comparing() to sort objects by age.
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Robert", 25));
        employees.add(new Employee("Mahesh", 45));
        employees.add(new Employee("Neelu", 65));
        employees.add(new Employee("Jagan", 35));

        employees.sort(Comparator.comparing((Employee e)->e.age));
        System.out.println(employees);

    //   Write a Java program to reverse sort a list using Comparator.reverseOrder().
      
       List<String> list2 = Arrays.asList("Ram","mahesh","Jitendra","Rahul");
        System.out.println("Original order");
      System.out.println(list2);
       list2.sort(Comparator.reverseOrder());
       System.out.println("After sorting : ");
       System.out.println(list2);

    //    Write a program to sort integers using Comparator.naturalOrder().
        List<Integer> list1 = new ArrayList<>();
        list1.add(8);
        list1.add(7);
        list1.add(6);
       System.out.println("Original order");
      System.out.println(list1);
       list1.sort(Comparator.naturalOrder());
       System.out.println("After sorting : ");
       System.out.println(list1);

    //    Write a program to sort a list containing null values using nullsFirst().
      employees.add(null);
      list1.add(null);
      Collections.sort(list1,Comparator.nullsFirst(Comparator.naturalOrder()));
      System.out.println(list1);
      Collections.sort(employees,Comparator.nullsFirst(Comparator.comparing((Employee e)->e.name)));
      System.out.println(employees);

    //   Write a program to sort a list containing null values using nullsLast().
      Collections.sort(list1,Comparator.nullsLast(Comparator.reverseOrder()));
      Collections.sort(employees,Comparator.nullsLast(Comparator.comparing((Employee e)->e.name)));
      System.out.println(list1);
      System.out.println(employees);
    }
}

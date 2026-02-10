import java.util.HashSet;
import java.util.Objects;

class Student{
     String name ;
     int rank;
     Student(String name,int rank){
       this.name = name;
       this.rank = rank;
     }
      @Override
    public String toString(){
        return "Student ( rank "+rank+",name "+name+")";
    }
}

class Person{
    private int id;
    private String name;
    Person(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
       if(this == obj){
        return true;
       }
       if(obj == null || obj.getClass() != getClass()){
        return false;
       }

       Person p = (Person) obj;
       return (id == p.id) && name.equals(p.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    } 

    @Override
    public String toString(){
        return "Person ( id "+id+",name "+name+")";
    }
}
public class Jan15 {
    public static void main(String[] args) {
        // Write a class Student and compare two objects using equals().
         Student s1 = new Student("Raj", 1);
             Student s2 = new Student("Raj", 1);
         Student s3 = new Student("yash",2);
         Student s4 = null;
         System.out.println(s1.equals(s2));
         System.out.println(s2.equals(s3));

        //  Write a program using Objects.equals() to safely compare two objects that may be null.
        Object o1 = new Object();
        Object o2 = null;
        System.out.println(o1.equals(o2));
         
        // Override equals() and hashCode() in a class and test object equality using HashSet.
        HashSet<Student> set1 = new HashSet<>();
        set1.add(s1);
        set1.add(s2);
        set1.add(s3);

        System.out.println("Hashset contains : ");
        for(Student s : set1){
          System.out.println(s);
        }
         Person p1 = new Person(1, "Ram");
            Person p2 = new Person(1, "Ram");
            Person p3 = new Person(2, "Mohan");

            HashSet<Person> set2 = new HashSet<>();
            set2.add(p1);
            set2.add(p2);
            set2.add(p3);
            for(Person p : set2){
            System.out.println(p);
            }

            // Even though p1 and p2 are different objects, equals() returns true and hashCode() is the same.
           // HashSet uses hashCode() to check for duplicates, so p2 is not added.
           // p3 is different, so it is added.

        //    Write a program to print hashCode() and System.identityHashCode() of two equal objects.
           System.out.println(s1.hashCode());
            System.out.println(s2.hashCode());
           System.out.println(p1.hashCode());
           System.out.println(p2.hashCode());

           System.out.println(System.identityHashCode(s1));
           System.out.println(System.identityHashCode(s2));
            System.out.println(System.identityHashCode(p1));
             System.out.println(System.identityHashCode(p2));      
             
            //  Write a program to show how identityHashCode() behaves for two different objects with same content.
            System.out.println(System.identityHashCode(s1));
            System.out.println(System.identityHashCode(s2));

            
    }
}

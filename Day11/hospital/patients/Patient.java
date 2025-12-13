package hospital.patients;
import hospital.staff.*;

public class Patient extends Person {
    String name;
    int age;
    String gender;

public Patient(String name,int age,String gender){
        this.age =age;
        this.name = name;
        this.gender = gender;
    }

   public void display(){
        System.out.println("---- Patient Details ---");
        System.out.println("Name "+name);
        System.out.println("Age : "+age+" Gender : "+gender);
    }

   public void access(){
        System.out.println("--- Staff details -----");
        System.out.println(super.name);
        System.out.println("Age "+super.age);
        super.details();
    }
}

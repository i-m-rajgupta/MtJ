package hospital.staff;

public class Person{
     protected  String name = "Mohan";
     String qualifi = "Nursing";
     String email = "mohan@fasd";
     int mobile = 6336598 ;
    protected int age = 45;
    private int id = 522;

     public void details(){
      System.out.println("Email "+email);
      System.out.println("Mobile : "+mobile);
      System.out.println("ID "+id);
    }
}


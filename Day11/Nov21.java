class Demo{
    final void demo(){
        System.out.println("This is for demo");
    }
}

class Harry extends Demo{
    // This demo will show and error as final method cannot be override
    // void demo(){
    //     System.out.println("This is demo");
    // }
    void display(){
        System.out.println("This is Harry class");
    }
}

final class Fruit{
    final static String king = "Mango";
    Fruit(){
        System.out.println("This is final class ");
    }
}

final class Vehicle{
    private final String name = "Bike";
     final void getname(){
      System.out.println("Vehicle name : "+name);
     }
}
// class Apple extends Fruit -> This will throw an error as we cannot extend final class 
public class Nov21 {
    public static void main(String[] args) {
        // Write a program where a final variable cannot be changed.
        final int demo = 5;
        // demo =6; It will throw an error 

        // Create a class with a final method. Try overriding it in a child class.
         Harry d = new Harry();
         d.display();

        //  Create a final class and try to extend it. 

        // Show use of final static constant.
        // Fruit.king = "Banana"; This will throw an error as final variable cannot be change after its declaration 
        System.out.println(Fruit.king);

        // Create immutable class using final keyword.     Final Class with final private attribute name and method getname(). 
        Vehicle v = new Vehicle();
        v.getname();
    }
}

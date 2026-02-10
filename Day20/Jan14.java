
public class Jan14{
   public static boolean isBetween(int num){
        return (num>=10 && num <= 50);
    }
  public static void main(String[] args) {
    // Write a Java program to compare two integers using == and print whether they are equal.
    int a = 4,b= 5;
    if(a == b){
        System.out.println(a+" is equal to "+b);
    }else{
        System.out.println(a+" is not equal to "+b);
    }

    // Write a program to check if two floating-point numbers are not equal using !=.
    float c = 8.57f,d = 7.96f;
    
    if(c != d){
        System.out.println(c+" is not equal to "+d);
    }else{
        System.out.println(c+" is equal to "+d);
    }

    // Write a program that finds the greater of two numbers using >.
     if(a>b){
        System.out.println(a+" is greater than "+b);
     }else if(b>a){
        System.out.println(a+" is greater than "+b);
     }else{
        System.out.println(a+" is equal to "+b);
     }

    //  Write a Java program to check whether a number lies between 10 and 50 using  <=, >=.
    System.out.println(b+" is betweeen "+isBetween(b));

    // Write a program to compare two Integer objects using relational operators and observe the output.
    Integer obj1 = new Integer(5);
    Integer obj2 = new Integer(5);
  
    System.out.println("5 is greater than 6 "+(obj1<obj2));
    System.out.println("5 is equal to 5 "+(obj1 == obj2));
    System.out.println("5 is equal to 5 "+obj1.equals(obj2));


  }
}
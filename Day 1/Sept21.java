
public class Sept21 {
    public static void main(String [] args){
        // Use different data types in variables and print their values.  
        int a = 23;  //4 bytes  Very large integer
        float b = 34.3f; //4 bytes Single-precision decimal
        String c =  "Ram"; 
        char d = 'c';  //2 bytes Single character
        boolean e = true;  //1 bit  True or False
        double f = 3.223; //8 bytes  Double-precision decimal

        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f);
                
       short g = 129;   //2  bytes   Stores larger integers (-32,768 to 32,767)
       long h =1122333333;  //8bytes   Very large integer
       byte i = 127;  //1 bytes  Stores small integers (-128 to 127)

       System.out.println(g+" "+h+" "+i);

    //   Declare multiple variables in one line and initialize them.
      
    //   int a=4, float b = 3.13f , char c = 'z',boolean g;
    // When you declare multiple variables in one line, they must all be of the same type.

    int  a1 = 3,a2= 5,a3 ;
    float a4 = 4.1f , a5 = 3.22f , a6 = 5.44f ;
    char a7 = 'o',a8 = 'r',a9 = '$';

    a3 = 4;
      
   System.out.println(a1+" "+a2+" "+a3+" "+a4+" "+a5+" "+a6);
    System.out.println(a7+" "+a8+" "+a9);

    // Use variables to calculate the area of a rectangle.  

    double length = 33;
    double breadth = 56;
    double Area = length * breadth;
    System.out.println("Area of Rectangle : "+Area);

    double num1 = 34;
       double num2 = 84;
    double num3 = 45;
   double avg = (num1+num2+num3)/3;
       System.out.println("Average  : "+avg);

    //    Declare a variable without initializing and assign value later.  

    double b1 ;
    b1 = 542345.34234;
    System.out.println(b1);

    // Write a program to print your name, age, and city using variables. 
    
    String name = "Raj";
    int age = 20;
    String city = "Maihar";

    System.out.println(name+" "+age+" "+city);
 
    }
}

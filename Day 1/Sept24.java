public class Sept24 {
    public static void main(String[] args) {
        
// Write a program to calculate compound interest given principal, rate, and time.
   double principle = 800000;
   double intrest = 16;
   int time = 7;
   int n = 1;

   double amount = principle * Math.pow(1+intrest/(100*n), n*time);
   double compoundIntrest = amount-principle;
   System.out.println(compoundIntrest);

//    Write a program to find the square and cube of a number.
   double num1 = 45;
   double square = num1*num1;
   double cube = square*num1;
   System.out.println("Square "+square+",Cube "+cube);

//    Write a program to convert days into years, weeks, and days. 370
int totalDays = 5300;
int year = totalDays/365;
int  days = totalDays%365;
int weeks = days/7;
days = days%7;
System.out.println(days+"in ywd is "+year+" Years "+weeks+" Weeks "+days+" Days ");

// Write a program to convert hours into minutes and seconds.
 
double hours = 5.6;
double minutes = hours*60;
double seconds = minutes*60;
System.out.println(hours+" "+minutes+" "+seconds);

// Write a program to calculate the area of a triangle given base and height.
double height = 23.5;
double base = 15;
double Area = 1.0/2*height*base;
System.out.println(Area);

// Write a program to convert rupees into dollars (assume 1 USD = 83 INR).
double dollar = 23;
double rupees = dollar*83;
System.out.println(rupees);

// Write a program to calculate the electricity bill given units consumed (assume 1 unit = ₹5).
double unit = 273.6;
double Amount = unit*5;
System.out.println(Amount);

// Write a program to calculate the volume of a cube and a cuboid.
double length = 45,breadth = 55,h = 52;
//   double cub = length*length*length;
double cub = Math.pow(length, 3);
double cuboid = length*breadth*h;
System.out.println(cub+" "+cuboid);
System.out.println(Math.pow(5,2));
    }
}

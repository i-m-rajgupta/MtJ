import java.util.Scanner;

public class Sept29 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        // Write a program to evaluate the expression a + b * c and (a + b) * c
        //  for given values of a, b, and c. Compare both results using if conditions. 
        int a = num1;
        int b = num2;
        int c = num3;

        int res1 = a + b * c;
        int res2 = (a + b) * c;
        if(res1>res2){
            System.out.println("a + b * c is greater than (a + b) * c");
        }else if(res1 < res2){
            System.out.println("a + b * c is less than (a + b) * c");
        }else {
            System.out.println("Both are equal");
        }

        // Take an integer input n. Check using an if statement whether n / 2 * 2 == n.
        //  (This checks if a number is even without using %). 

        int n = num1;
        if(n / 2 * 2 == n){
            System.out.println(n+" is an even number");
        }else {
            System.out.println(n+"is a odd no.");
        }

        // For three numbers x, y, z, evaluate (x > y && x > z) and (x > y || x > z)
        //  inside an if statement to decide the largest number. 

        int x = num1;
        int y = num2;
        int z = num3;

        if(x > y || x > z){
           System.out.println(x+"might be greatest than "+y+" and "+z);
        } 
         if(x > y && x > z){
               System.out.println(x+"is greatest than "+y+" and "+z);
           }

        //    Write a program to demonstrate the difference between && and & operators using if. 
        if(x>10 && ++y>5){
              System.out.println("Value of x and y "+x +" "+y);
        }
        System.out.println("Value of y after short-circuit: " + y);

        if(x>10 & ++y>5){
              System.out.println("Value of x and y "+x +" "+y);
        }
        System.out.println("Value of y after short-circuit: " + y);

        // Write a program where you calculate a = b++ + ++b and c = --b + b--. Print a and c and
        //  decide which one is greater using if-else. 
       a = b++ + ++b ; //5  5++ + ++5    5 + 7 =12
       System.out.println(b);
       c = --b + b--;    // --7 + 7--   5 + 7 = 12
        System.out.println(b);
       System.out.println("Value of a and c :"+a+" "+c);
       if(a>c){
        System.out.println(a +" is greater than "+c);
       }else if(a<c){
          System.out.println(a +" is less than "+c);
       }else {
         System.out.println(a +" is equal to "+c);
       }

  sc.close();
    }
}

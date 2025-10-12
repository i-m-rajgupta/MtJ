import java.util.Scanner;

public class Oct11 {
    public static void main(String[] args) {
        // Print a fibonacci series until n  using the while loop
        Scanner  sc = new Scanner(System.in); 
        System.out.println("Enter any number to find the fibonacci series");
        int n = sc.nextInt();
       int num1 = 0;
       int num2 = 1;
        while(num2<=n){
        System.out.print(num1+" ");
        System.out.print(num2+" ");
        num1 = num1+num2;
        num2 = num1+num2; 
        }
        System.out.println();
        //  Without using + or – operator, add two numbers.    
        System.out.println("Enter any two numbers :");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        int sum = 0;
        while(num2!=0){
         sum = num1^num2;
         num2 = (num1&num2)<<1;
         num1 = sum;
        }
        System.out.println("The sum of two number is "+num1);
       
        // Find the cube of first n natural numbers.
        System.out.println("Enter any number "); 
        n = sc.nextInt();
        while(n>0){
            int cube =(int) Math.pow(n,3);
            System.out.print(cube+" ");
            n--;
        }
        // Find power of a number (a^b) using loop. 
        System.out.println("");
        System.out.println("Enter any a and b for finding the power : ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        int res =num1;
        while(num2>1){
            res = res*num1;
            num2--;
        }
        System.out.println("The power of a and b is "+res);

        // Check if a number is within a specific range.

        System.out.println("Enter max and min numbers ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        System.out.println("Enter a number to check");
        int num = sc.nextInt();
        if(num1<= num && num <= num2){
            System.out.println(num+" is within the specified range  ");
        }else{
                System.out.println(num+" is not within the specified range  ");
        }
        sc.close();
    }
}

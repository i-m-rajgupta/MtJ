import java.util.Scanner;

public class Oct1{
    public static void main(String [] args){
        // Write a program to print the factorial of a number entered by the user.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number");
        int n = sc.nextInt();
        long res = 0;
        for(int i = 0;  i <= n;i++){
            if(i == 0){
                res = 1;
            }else{
                res = i * res;
            }
        }
        System.out.println("Factorial of "+n+" is "+res);

        //  Write a program to print the squares of numbers from 1 to 10.
        for(int i = 1;i<=10;i++){
            // System.out.println((int) Math.pow(i, 2));
            System.out.println(i*i);
        }

        // Write a program to print all factors of a number using a for loop.
        System.out.println("Factor of "+n+" :");
        for(int i = 1;i<=n;i++){
           if( n % i == 0){
            System.out.println(i);
           }
        }

        // Write a program to print the multiplication table of a given number using a for loop.
        System.out.println("Mutiplication table :");
        for(int i = 1;i<=10;i++){
            System.out.println(n+" X "+i+" = "+n*i);
        }

        //  Write a program to find HCF or GCD (Greatest Common Divisor) of two numbers using a for loop. 
        System.out.println("Enter two numbers");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
       int min = (num1>num2)?num2:num1;
       int HCF=1;
       for(int i =2 ;i<=min;i++){
        if(num1 % i == 0 && num2 % i == 0){
             HCF =  i;
        }
       }
    System.out.println("HCF of "+num1+" and "+num2+" is "+HCF);
     sc.close();
    }
}
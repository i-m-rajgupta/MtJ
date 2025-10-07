package Day4;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) { 
    //while loop
    System.out.println("Enter any  number");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while(n<5){
        System.out.println("Hello world");
        n++;
    }
       System.out.println("Enter any  number");
    int i = 1;
    while(i<=10){
    System.out.println(n+"X"+i+"="+n*i);
        i++;
    }

     int factorial = 1;   //1  5  20 60  120

    while(n>1){
     factorial = factorial*n;
     n--;
    }

    System.out.println(factorial);
    int count = 0;  // 0 1 2 3
      

      while(n>0){
        count++;
        n = n/10;
      }
      System.out.println(count);

      sc.close();
    }
}

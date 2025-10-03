import java.util.Scanner;

 public class Oct2{
    public static void main(String [] args){
        // Print numbers from 1 to n in zig-zag form:
        // Example n=10 → 1 10 2 9 3 8 4 7 5 6. n=7 -> 1 7 2 6 3 5 4
        //  1 = 0+1 10 = 10 -0 2 = 1+1 9 = 10-2  3 = 2 + 1 8 = 10-3 4 = 3+1  7=10-3 5 = 4+1 6 = 10-4
        //  1 = 0 + 1  7 = 7-0  2= 1+1  6 = 7-1 3=2+1 5=7-2 4=3+1
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any no.");
        int num = sc.nextInt();
        int end = (num % 2 == 0)?num/2:num/2+1;

        for(int i = 0;i<end ;i++){
            if(i == end-1){
                 System.out.print(num-i+" ");
            }else{
               System.out.print(i+1+" ");
               System.out.print(num-i+" ");
            }
        }
        System.out.println("");

        // Check if a number is perfect (sum of divisors/factors excluding the number itself = number). 
// Example : 6 → divisors are 1, 2, 3 → sum = 6 → Perfect 
// 6, 28, 496, 8128
        long sum = 0;
        for(int i = 1;i<=num/2;i++){
            if(num % i == 0){
                sum = sum + i;
            }
        }
        if(sum == num){
            System.out.println(num+" is a Perfect Number ");
        }else{
             System.out.println(num+" is not a Perfect Number ");
        }

        // Check if a number is a Strong Number (sum of factorial of digits = number).Number is only upto 10 digit . 
        // Example: 145 → 1! + 4! + 5! = 145. 
        // 1, 2, 145, 40585

        System.out.println("Enter any number :");
        int num1 = sc.nextInt();
        int sum2 = 0;
          int digit = 0;
        int num2 = num1;
         int factorial = 1;
        
        for(int i = 0;i<10;i++){
            if(num2>0){
             digit = num2 % 10;
             num2 = num2/10;
             factorial = 1;
            for(int j =1;j<=digit;j++){
              factorial = factorial*j;
            }
            sum2 += factorial;
            }else{
                break;
            }
        }

        if(sum2 == num1){
            System.out.println(num1+" is a Strong number");
        }else {
            System.out.println(num1+" is not a Strong number");
        }
// Print numbers divisible by 3 but not by 5 between 1 and n.

      System.out.println("Numbers divisible by 3 but not by 5 between 1 and "+num);
        for(int i = 1;i<=num;i++){
            if(i % 3 == 0 && i % 5 != 0){
                System.out.print(i+" ");
            }
        }
        System.out.println("");
        //   Find the product of first n natural numbers.
        long product = 1;
        for(int i =1;i<num;i++){
            product = product*i;
        }
        System.out.println(product);
  sc.close();
    }
}

import java.util.Scanner;

public class Oct10 {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number ");
        int n = sc.nextInt();

          // Print a reverse of any number using the loop and conditional statements .
          int num = n;
          int reverse =0;

          int count = 0;
          while(num>0){
            num = num/10;
            count++;
          }

          int divider = (int) Math.pow(10, count-1);
          num = n;
          for(int i=0;i<count;i++){
            int lastDigit = num%10;
            num = num/10;
            reverse = lastDigit*divider + reverse;
            divider = divider/10;
          }
          System.out.println("The Reverse of "+n+" is "+reverse);
        //   Find Sum of Digits Until Single Digit.

        int sum =n;
        while(sum>9){
            int res = sum;
            sum = 0;
            while(res>0){
             int lastDigit = res%10;
           sum = sum+lastDigit;
           res = res/10;
            }
            System.out.println(sum);
        }
        System.out.println("Sum of digit until single digit of "+n+" is "+sum);

        // Check Spy Number
        num = n;
        sum =0;
        int product = 1;
        while (num>0) {
            int lastDigit = num%10;
            num = num/10;
            sum = sum+lastDigit;
            product = product*lastDigit;
        }
        if(sum == product){
            System.out.println(n+" is spy number");
        }else{
              System.out.println(n+" is not a spy number");
        }

        // Toggle Case of Each Character
        System.out.println("Enter any alphabet : ");
        char ch = sc.next().charAt(0);
        char newCh = ' ';
        int charInt = (int) ch;
        if(charInt>= 65 && charInt <= 90){
            newCh = (char) (charInt+32);
            System.out.println("Toggle of "+ch+" is "+newCh);
        }else if(charInt >= 97 && charInt <= 122){
            newCh = (char) (charInt-32);
            System.out.println("Toggle of "+ch+" is "+newCh);
        }else{
            System.out.println("Invalid input");
        }

        // Print the log of any number n using the while loop concept

        double d = 1;
        System.out.println("Enter a n to find ln(n) :");
        double n2 = sc.nextDouble();
        double x = n2-1;
        double res =x;
         count = 1;
        while (d >0.00001) {
            count++;
            double temp = res;
            if(count%2 != 0){
            res = res + Math.pow(x, count)/count;
            }else{
                  res = res - Math.pow(x, count)/count;
            }
            d = Math.abs(res - temp);
        }
        if(n == 1){
            System.out.println(res);
        }
        System.out.println("ln("+n2+") is "+res);
        sc.close();   
    }
}

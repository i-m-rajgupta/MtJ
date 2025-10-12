import java.util.Scanner;

public class Oct7 {
    public static void main(String[] args) {
        // Check if Number is Binary
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any binary number ");
        int temp = sc.nextInt();
        int n = temp;
        boolean isBinary = true;
        while(n>0){
            int lastDigit = n %10;
          if(lastDigit != 0 && lastDigit != 1){
            isBinary = false;
            break;
          }
          n = n/10;
        }
        System.out.println(temp+" is binary : "+isBinary);

        // Convert Binary to decimal  
        int decimal = 0;
        n = temp;
        int count = 0;
        while(isBinary && n>0){
            int lastDigit = n%10;
            if(lastDigit == 1){
                decimal = (int) Math.pow(2,count) + decimal;
            }
            count ++;
            n = n/10;
        }
        if(isBinary){
        System.out.println(temp + " in decimal is : "+decimal);
        }

        // Convert Decimal to Binary 
        System.out.println(" Enter decimal number ");
        long temp3 = sc.nextLong();
        int temp2 = (int) temp3;
        long binary = 0;
        long n1 = temp3;
        long place = 1;
        while(n1>0){
            long lastDigit = (long) n1%2;
           binary = binary + lastDigit*place;
           place = place*10;
             n1 = n1/2;
        }
        System.out.println(binary);

        // Count Number of Zeros in a Number
        n = temp;
        count = 0;
        while(n>0){
        int lastDigit = n%10;
        if(lastDigit == 0){
            count++;
        }
        n = n/10;
        }
        if(temp == 0){
            count++;
        }
        System.out.println("No. of zeroes in "+temp+" is "+count);

        // Check if a Number is a Power of 2
        n = temp2;
        boolean isPower = true;
        while( n>0){
            int lastDigit = n%2;
            if(lastDigit == 1 && n != 1){
            isPower = false;
            }
            //  System.out.println(lastDigit+" "+n);
            n =n /2;
                }
                System.out.println(temp2+" is power of 2 : "+isPower);
    
                sc.close();
    }
}

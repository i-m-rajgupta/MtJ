import java.util.Scanner;

public class Oct6 {
   public static void main(String[] args) {
    //  Find the sum of digits at odd positions and even positions separately, then print the difference.
    int oddSum = 0;
    int evenSum = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter any number");
    int n = sc.nextInt();
    int temp = n;
    while(temp > 0){
       int even = temp % 10;
       temp = temp/10;
       int odd = temp%10;
       temp = temp/10;
       oddSum += odd;
       evenSum += even;
    }
    int diff = Math.abs(evenSum-oddSum);
    System.out.println("Difference "+diff);

    //  Print all prime factors of a number using a loop and conditional statements.
    int n1 = n;
    temp = n-1;
    int lastFactor;
    System.out.print("Prime factors are : ");
    while(temp>1){
        if(n %temp == 0){
            System.out.print(n/temp+" ");
            n = temp;
        }
        temp--;
    }
     if(n>1){
    System.out.print(n);
   }
System.out.println("");
//    Print diamond of stars for n
   for(int i = 0;i<2*n-1;i++){
    for(int j=0;j<2*n-1;j++){
        if(i<n){
        if(j<n-i-1 || j>n+i-1){
            System.out.print(" ");
        }else{
 System.out.print('*');
        }
    }else{
        if(j<=i-n || j>2*n-i+2){
            System.out.print(" ");
        }else{
 System.out.print('*');
        }
       
    }
    }
    System.out.println("");
   }
//    Print Hollow Right angled triangle for n:
   for(int i =0;i<n1;i++){
    for(int j =0;j<2*n1-1;j++){
        if(j==0 || j== 2*i || i == n-1){
       System.out.print("*");
        }else{
            System.out.print(" ");
        }
    }
    System.out.println();
   }
//    Print Hollow Inverted triangle for n: 
for(int i =0;i<n1;i++){
    for(int j =0;j<2*n1-1;j++){
       if(i==0 || j==i || j == 2*n1-2-i){
        System.out.print('*');
       }else{
        System.out.print(' ');
       }
    }
    System.out.println("");
}
   }   
}

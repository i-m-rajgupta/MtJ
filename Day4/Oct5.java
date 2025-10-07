
import java.util.Scanner;

public class Oct5 {
    public static void main(String[] args) {

        // Check whether a number is prime or not using the while loop . 
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter any number :");
       int n =  sc.nextInt();
       boolean isPrime = true;
       int temp = n;
       while (temp>2) {
          if(n%(temp-1) == 0){
            isPrime = false;
          }
          temp--;
       }
       System.out.println(n+" is prime : "+isPrime);

    //    Check whether the digits of a number are in ascending order using while loop . 
    temp = n;
    boolean isAsc = true;
    while(temp > 9){
        int last = temp%10 ;
        temp = temp/10;
        int secLast = temp%10;
        if(secLast>last){
            isAsc = false;
        }
    } 
     System.out.println(n+"is in Ascending Order "+isAsc);

    //  Check if a number is a palindrome using a while loop.
    temp = n;
    int count = 0;
    while(temp > 0){
        count++;
        temp /= 10;
    }
    int mid = count/2;
    boolean isPalindrome = true;
    temp = n;
    int divider =(int) Math.pow(10,count-1);
    while (mid > 0) {
        int last = temp %10;
        int firstNum =  temp/divider;
        int first = firstNum % 10;
        if(first != last){
            isPalindrome = false;
          break;
        }
        temp = temp/10;
        divider = divider/100;
       mid--;
    }
    System.out.println(n+" is palindrome : "+isPalindrome);

    // Find the largest digit in the number using a while loop.

     temp =n;
     int largest = temp%10;
     temp = temp/10;
     while (temp>0) {
        int last = temp%10;
        if(last > largest){
            largest = last;
        }
        temp /= 10;
     }
  System.out.println(largest+" is the largest digit in the "+n);

//   Check whether the no. Is kaprekar or not 
count = 0;
temp = n;
while(temp>0){
    count++;
    temp /= 10;
}   
int sq = n*n;
   temp = n;
    divider = (int) Math.pow(10, count);
    int left = sq/divider;
   int right = sq%divider;
   boolean isKaprekar = false;
   if(left+right == n){
    isKaprekar = true;
   }
   System.out.println(n+" is Kaprekar "+isKaprekar);

    }
}

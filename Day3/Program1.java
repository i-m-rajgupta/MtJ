import java.util.Scanner;

public class Program1 {
   public static void main(String [] args){
    //     for(int i = 0;i<5;i++){
    //         System.out.println("Hello World");
    //     }
    //     // print 10 even no.
    //     for(int i = 0;i<20;i=i+2){
    //    System.out.println(i);
    //     }

    //     //print 10 to 0
    //     for(int i =10;i>=0;i--){
    //         System.out.println(i);
    //     }

   //sum natural no.  
   long sum = 0;
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter any number");
   int n = sc.nextInt(); //n=8
   for(int i =0 ; i<2*n;i=i+2){  // i =0 to 15   
         sum = sum + i;
   }
   System.out.println("Sum of "+n+" even no. is "+ sum);

//    calculate the sum of n even no.
   
   }    
}

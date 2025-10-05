import java.util.Scanner;

public class Oct4 {
    public static void main(String [] args){
        // Write a program to print a hollow square of size n × n using *. 
        System.out.println("Enter any number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
           for(int j =0;j<n;j++){
            if(i == 0 || i == n-1){
               System.out.print("a ");
            }else{
            if(j == 0 || j==n-1){
                System.out.print("a ");
            }else{
                System.out.print("  ");
            }
            }
           }
           System.out.println();
        }

        // Print a sandglass-shaped number pattern of size n.
        int digit = 0;
        int temp = n;

        //   for(int i = 0;i<n;i++){
    //    for(int j = 0;j<n;j++){
    //     if(j<i){
    //         System.out.print("  ");
    //     }else{
    //     System.out.print(" a");
    //     }
    //    }
    //    System.out.println("");
    // }
    //  for(int i = 0;i<n;i++){
    //    for(int j = 0;j<2*n-1;j++){
    //     if(j<i || j>=2*n-i-1){
    //         System.out.print("  ");
    //     }else{
    //     System.out.print(" a");
    //     }
    //    }
    //    System.out.println("");
    // }
        for(int i = 0;i<2*n-1;i++){
            digit =0;
            for(int j =0;j<2*n-1;j++){
                if(i<n){
                 if(j<i || j>=2*n-i-1 ){
                     System.out.print("  ");
                }else {
                if(j < n ){
                 digit++;
                }else{
                    digit--;
                }
                System.out.print(digit+" ");        
                }
                }else{
                    if(j<2*n-i-2 || j>i){
                        System.out.print("  ");
                    }else{
                         if(j < n ){
                 digit++;
                }else{
                    digit--;
                }
                 System.out.print(digit+" ");
                    }
                }
              
            }
            System.out.println();
        }
    }
}

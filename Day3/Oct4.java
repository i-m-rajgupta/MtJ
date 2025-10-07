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

        //  Print alphabet pyramid pattern of size n. 

        int charInt  = 65;
        int count ;

        for(int i =0;i<n;i++){
            count = 0;
            charInt = 65;
            for(int j =0;j<2*n-1;j++){
                if(j<n-i-1 || j>=n+i){
                  System.out.print(" ");
                }else if(i+j==n+count){
                  System.out.print(' ');
                  count = count+2;
                }else{
                    char ch = (char) charInt;
                   System.out.print(ch);
                   charInt++;
                }
                }
                System.out.println();
            }

            // Print pascal pyramid pattern of size n. 
            int val;
            int update ;
            for(int i = 0;i<n;i++){
                count = 0;
                val = 1;
                update = 0;
                for(int j =0;j<2*n-1;j++){
                    if(j<n-i-1 || j>=n+i){
                        System.out.print(" ");
                    }else if(i+j == n+count){
                       System.out.print(" ");
                       count = count +2;
                    }else{
                               System.out.print(val);
                           val = val * (i - update) / (update + 1);      
                           update++;     
                    }
                }
                System.out.println("");
            }
            
            // Print plus pattern of size n. 

            for(int i =0;i<2*n-1;i++){
                for(int j =0;j<2*n-1;j++){
                    if(i+1 == n || j+1 ==n ){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
            sc.close();
        }

    }


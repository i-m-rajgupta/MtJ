import java.util.Scanner;

public class Oct9 {
    public static void main(String[] args) {
        // Print rohmbus with 3 extra width 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number for making the rohmbus");
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
           for(int  j = 0;j<2*n-i-1;j++){
            if(j>=  n-i-1){
            System.out.print('*');
            }else{
                System.out.print(' ');
            }
           }
           System.out.println();
        }

        // Print right angled triangle of prime numbers n 
         int num = 2; 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {  
                int k = 2;
                boolean isPrime = true;
                while (k * k <= num) {
                    if (num % k == 0) {
                        isPrime = false;
                        break;
                    }
                    k++;
                }

                if (isPrime) {
                    System.out.print(num + " ");
                    j++; 
                }

                num++; 
                j--;   
            }
            System.out.println();
        }

        // Print Inverted Right-Aligned Triangle
        for(int i =0;i<n;i++){
            for(int j= 0;j<n;j++){
                if(j < i){
                    System.out.print(" ");
                }else{
                    System.out.print('*');
                }
            }
            System.out.println();
        }
        // Print checkboard for n 
        for(int i =0;i<n;i++){
            for(int j =0;j<5;j++){
                if(j == 0 && i%2 == 0){
                    System.out.print(" *");
                }else{
                 System.out.print("*");
                }
            }
            System.out.println();
        }
        // Print X for n
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                    if(j == i || j == n-i-1){
                        System.out.print('*');
                    }else{
                        System.out.print(' ');
                    }
            }
            System.out.println();
        }        
        sc.close();
    }
}

import java.util.Scanner;

public class Oct8 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter any number ");
        int temp = sc.nextInt();
        int n = temp;
            // Count the digits that are even and odd in a number.
        int evenCount = 0;
        int oddCount = 0;
        n = temp;
        while(n>0){
             if(n%2 == 0){
                evenCount++;
             }else{
                oddCount++;
             }
             n = n/10;
        }
        System.out.println("Even count and Odd Count in "+temp+" is : "+evenCount+" "+oddCount);



        // Print numbers from 1 to 30 but skip numbers that contain digit 3.
        boolean isPrint = true;
        for(int i =1 ;i<= 50;i++){
            int temp2 = i;
            isPrint = true;
            while (temp2>0) {
                int lastDigit = temp2%10;
                 if(lastDigit == 3){
                    isPrint = false;
                 }
                 temp2 = temp2 /10;
            }

            if(isPrint){
             System.out.print(i+" ");
            }
        }
        System.out.println();

        // Print a butterfly pattern
        System.out.println("Enter number for making butterfly : ");
        int n2 = sc.nextInt();
        for(int i = 0;i<2*n2-1;i++){
            for(int j =0;j<2*n2-1;j++){
                if(i<n2){
                    if(j <= i || j>=2*n2-2-i){
                    System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }else{
                      if(j <2*n2- i-1 || j>=i){
                    System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
        // Print a binary triangle . Here n = 5 
        for(int i =1;i<=n2;i++){
            int count = (i%2);
            for(int j =1;j<=n2;j++){
                if(j<=i){
                System.out.print(count+" ");
                }
                if(count == 0){
                    count =1;
                }else{
                    count = 0;
                }
            }
             System.out.println();
        }
        // Print a hollow pyramid  of n .
        for(int i =0;i<n2;i++){
            int count = 1;
            for(int j =0;j<2*n2-1;j++){
                if(i == n2-1|| j == n2+i-1 || j == n2-i-1 ){
                 if(i == n2-1){
                         if(j%2 == 0){
                        System.out.print(count+" ");
                        count++;
                    }
                 }else if(j == n2+i-1){
                    System.out.print(i+1);
                 }else{
                    System.out.print('1'); 
                 }
                }else{
                    System.out.print(' ');
                }

            }
            System.out.println();
        }
        sc.close();
    }
}

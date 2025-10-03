import java.util.Scanner;

public class Oct3{
    public static void main(String[] args) {
        // 1.Print all numbers between 1 and n whose square ends with the number itself. 
// Example: 25 → 25² = 625 (ends with 25) 

       Scanner sc = new Scanner(System.in);
       System.out.println("Enter any no.");
       int num = sc.nextInt();
       for(int n = 1;n<=num;n++){
        int temp = n;
        int count = 0;
        while(temp>0){
            temp = temp/10;
            count++;
        }
        int divider = 1;
        int digit = 0;
        while(digit<count){
            divider *= 10;
            digit++;
        }
           int sq = n*n;
        int last_sq = sq%divider;
        if(last_sq == n){
            System.out.print(n+" ");
        }
       }
      
    //    Write a program to print a square of size n × n using the character a.
    System.out.println("");
    System.out.println("Enter any num");
    int num2 = sc.nextInt();
    for(int i = 0;i<num2;i++){
       for(int j = 0;j<num2;j++){
        System.out.print("a ");
       }
       System.out.println("");
    }
    System.out.println();

    // Print a right-angled triangle where each row has the same character.
    //  The first row starts with a, second with b, and so on. 

            int charInt = 97;
    for(int i = 0;i<num2;i++){
        char ch = (char)charInt++;
        for(int j = 0;j<=i;j++){
            System.out.print(ch+" ");
        }
        System.out.println("");
    }
  System.out.println();
    // Print a triangle where each row starts from a and continues alphabetically. 
    for(int i =0;i<num2;i++){
        charInt = 97;
        for(int j=0;j<=i;j++){
            char ch = (char)charInt++;
            System.out.print(ch+" ");
        }
        System.out.println();
    }
    System.out.println();
    // Print an inverted triangle where the first row goes from a to the nth letter.  
    for(int i = num2;i>0;i--){
         charInt = 97;
        for(int j=0;j<i;j++){
            char ch = (char)charInt++;
            System.out.print(ch+" ");
        }
        System.out.println();
    }
       sc.close();
    }
}
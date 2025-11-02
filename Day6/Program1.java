package Day6;

import java.util.Scanner;

public class Program1 {
    public static void main(String [] args){
      Scanner sc = new Scanner(System.in);
    System.out.println("Enter any number ");
    int n = sc.nextInt();

    // Pattern Question 

     // Write a program to print a square of size n × n using the *.
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         System.out.print('*');
    //     }
    //     System.out.println();
    // }

   // ***   =3     =3-0
   // **      =2    =3-1
    // *        =1   =3-2

    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n-i;j++){
    //         System.out.print('*');
    //     }
    //     System.out.println();
    // }

    // hollow square 
    //***
    //* *
    //***  n = 3 i =0 j =0
    //  for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         if(i == 0 || i == n-1 || j == 0 || j == n-1){
    //         System.out.print('*');
    //         }else{
    //             System.out.print(' ');
    //         }
    //     }
    //     System.out.println();
    // }

    // pyramid 
    //    *j=3 = 3+0      i = 0 j=0 to 4
      // *** j= 4 = 3+1   i=1 j=0 to 4
      //*****   i =2 j=0 to 4
      
    //   for(int i=0;i<n;i++){
    //     for(int j=0;j<2*n-1;j++){
    //         if(j >= n-i-1 && j<n+i){
    //         System.out.print('*');
    //         }else{
    //             System.out.print(" ");
    //         }
    //     }
    //     System.out.println();
    //   }
    
      for(int i=0;i<n;i++){
          int charnum = 97;
        for(int j=0;j<=i;j++){
              char ch = (char) charnum;
            System.out.print(ch);
             charnum++;
        }
        System.out.println();
    }
     //  *
    //   *
    // *****
  //     *
  //     *
    sc.close();
    }
}

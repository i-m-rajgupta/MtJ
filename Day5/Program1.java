import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        // do while
        Scanner sc = new Scanner(System.in); 
    //    int pass;
    //     do{
    //         System.out.println("Enter your password");
    //           pass = sc.nextInt();
    //     }while(pass != 1234);
    //     System.out.println("Access granted");

    //     int a = 9;
    //     int b = 10;
    //     int val;
    //     do{
    //         System.out.println("Enter 1 for add ,2 for subtract and 3 for exit");
    //          val = sc.nextInt();
    //         switch (val) {
    //             case 1:
    //                 System.out.println(a+b);
    //                 break;
    //             case 2 :
    //                 System.out.println(a-b);
    //                 break;
    //                 case 3:
    //                 System.out.println("You are exited ");
    //                 break;
    //             default:
    //             System.out.println("Invalid Input");
    //                 break;
    //         }
    //     }while(val != 3);

    //  System.out.println("Enter a number ");
    //     int n = sc.nextInt();  //3

    //     int i = 1;  //1 2 3 4
    //     int fact = 1 ; //1 1 2 6
    //     do{
    //         fact = fact * i;
    //         i++;
    //     }while(i<=n);
    //     System.out.println(fact);
     

        // int[] arr; //declaration
        // arr = new int[5]; //Creation

        // System.out.println(arr);
        // for(int j =0;j<6;j++){
        //     System.out.print(arr[j]+" ");
        // }
     
    //    int[] arr1 = new int[3]; 
    //    arr1[0] = 23;
    //    for(int j =0;j<3;j++){
    //         System.out.print(arr1[j]+" ");
    //     }

        // int[] arr ={34,23,78,90};
        //     for(int j =0;j<arr.length;j++){
        //     System.out.print(arr[j]+" ");
        // }

        int[] arr = new int[7];
        for(int i = 0;i<arr.length;i++){
            arr[i] = (i+1) *10;
        }
//         int sum = 0;
//         for(int i = 0;i<arr.length;i++){
//            sum = sum+arr[i];
//         }
//         System.out.println(arr.length);
// System.out.println(sum);

    //  int[] arr1 = new int[arr.length];
    //  for(int i =0;i<arr1.length;i++){
    //     arr1[i] = arr[arr.length-1-i];
    //  }

    //      for(int i = 0;i<arr1.length;i++){
    //         System.out.println(arr1[i]);
    //      }
     for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);  //10 20 30 40 50 60 70
         }

    for(int i=0;i<arr.length/2;i++){  // i =0 to 6
        int temp = arr[i];                // 70 20 30 40 50 60 10   i =0
        arr[i] = arr[arr.length-1-i];      //70 60 30 40 50 20 10   i =1
        arr[arr.length-1-i] =temp; //70 60 50 40 30 20 10   i=2
    }                             //70 60 50 40 30 20 10     i=3
      for(int i = 0;i<arr.length;i++){    
            System.out.println(arr[i]);
         }
         sc.close();
    }
}

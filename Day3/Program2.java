import java.util.Scanner;

class demo {
    public static void main(String[] args) {
        //Kaprekar -> 45 -> 2025 -> 4 1 -> 1  0 1
        // 9 -> 81  8 1 99 -> 9801 -> 98  01  45 -> 20 25 999  ->  998001  998 001  10 -> 1  00 65 ->  42 25
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number "); 
        int n = sc.nextInt();  
        int temp = n;
        int count = 0;
        while(n>0){
          n = n/10; 
          count++;
        }
        System.out.println(count);
      
        int digit =0;
        long divider = 1;
        while(digit<count){
            divider = divider *10;
            digit++;
        }
        long sq = temp*temp;
        long left = sq/divider;
        long right = sq%divider;
       
        if(left+right == temp){
            System.out.println(temp+" is a Kaprekar");
        }else{
            System.out.println("This is not a Kaprekar");
        }
        sc.close();
    }
}


import java.util.ArrayList;

public class Nov29 {
    public static int sum(int[] arr,int idx,int sum){
         if(idx == arr.length){
           return sum;
         }
         sum += arr[idx];
         return sum(arr,idx+1,sum);
    }

    public static int sum(int [] arr,int idx){
        if (idx == arr.length) {
            return 0;
        }
        return arr[idx]+sum(arr, idx+1);
    }
    private static void permutations(String per,String word){
        if(word.isEmpty()){
            System.out.println(per);
        }else{
            for(int i =0;i<word.length();i++){
                permutations(per+word.charAt(i), word.substring(0, i)+word.substring(i+1, word.length()));
            }
        }
    }

    public static void towerofHanoi(int n,char source,char destination,char auxiallary){
        if(n == 1){
            System.out.println("Move 1 from rod "+source+" to rod "+destination);
            return;
        }
        towerofHanoi(n-1, source, auxiallary, destination);
        System.out.println("Move "+n+" from rod "+source+" to rod "+destination);
        towerofHanoi(n-1, auxiallary, destination, source);
    }
   
    public static void subset(int arr[],int idx,ArrayList<Integer> newArr){
         if(idx == arr.length){
            System.out.println(newArr);
            return;
         }
         
         subset(arr, 1+idx, newArr);

         newArr.add(arr[idx]);
         subset(arr, idx+1, newArr);
         newArr.remove(newArr.size()-1);
    }

    
    public static int climb(int stairs,int n){
         if(n == stairs){
            return 1;
         }
         if(n > stairs){
            return 0;
         }
         return climb(stairs, n+1)+climb(stairs, n+2);
    }

    public static int climb(int n){
        if(n == 0|| n==1){
            return 1;
        }
        return climb(n-1)+climb(n-2);
    }
    public static void main(String[] args) {
        // Compute the sum of elements in an array using  recurssion.
        int arr[] = {5,8,6};
        System.out.println("Sum : "+sum(arr, 0, 0));
           System.out.println("Sum : "+sum(arr, 0));

        // Print all permutations of a string.
        permutations("","hey");

       //    Tower of Hanoi problem.
         towerofHanoi(3, 'A', 'C', 'B');

        //  Print all subsets of a set.
        ArrayList<Integer> newArr = new ArrayList<>();
          subset(arr,0,newArr);

    //    Count the number of ways to climb stairs (1 or 2 steps at a time).
      System.out.println( "No of ways "+climb(7, 0));
      System.out.println("No of ways "+climb(5));
        
    }
}

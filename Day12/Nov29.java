public class Nov29 {
    public static int sum(int[] arr,int idx,int sum){
         if(idx == arr.length){
           return sum;
         }
         sum += arr[idx];
         return sum(arr,idx+1,sum);
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
   
    public static void main(String[] args) {
        // Compute the sum of elements in an array using  recurssion.
        int arr[] = {5,8,6,9,7};
        System.out.println("Sum : "+sum(arr, 0, 0));

        // Print all permutations of a string.
        permutations("","hey");

       //    Tower of Hanoi problem.
         

    }
}

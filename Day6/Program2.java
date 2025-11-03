import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        //Prefix sum 
        // int  arr[] = {10,5,6,7,4,8,89,56,75,86,35,72,85};
        // int prefix[] = new int[arr.length];
        // prefix[0] = arr[0];
        // for(int i=1;i<prefix.length;i++){
        //     prefix[i] += prefix[i-1] + arr[i];
        // }
        // for(int i : prefix){
        //     System.out.println(i);
        // }

        // int sum =0;
        // sum = prefix[9]-prefix[3];
        // System.out.println(sum);

        //Find Subarray with Given Sum     [4,6,7,5,5]
         int arr[] = new int[5];
         System.out.println("Enter array elements");
         Scanner sc = new Scanner(System.in);
         for(int i=0;i< arr.length;i++){
            arr[i] = sc.nextInt();
         }
       System.out.println("Enter the target sum : ");
       int k = sc.nextInt();
       int start[] =new int[arr.length];
       int end[] = new int[arr.length];
       int sum=0;
       int count =0;
        //  for(int i=0;i<arr.length;i++){//0(n2)
        //     sum=0;
        //     for(int j=i;j<arr.length;j++){
        //       sum += arr[j];
        //       if(sum == k){
        //         start[count] = i;
        //         end[count] = j;
        //         count++;
        //       }
        //     }
        //  }

       int prefix[] = new int[arr.length];
       prefix[0] = arr[0];
       for(int i=1;i<arr.length;i++){
          prefix[i] += prefix[i-1]+arr[i];
       }

       for(int i=0;i<arr.length;i++){
        for(int j=i;j<arr.length;j++){
            if(i != 0){
            sum = prefix[j] - prefix[i-1];
            }else{
           sum = prefix[j];
            }
           if(sum == k){
            start[count] = i;
            end[count] =j;
            count++;
           }
        }
       }
        for(int i=0;i<count;i++){
            System.out.println("Subarray with target sum : "+start[i]+" and end "+end[i]);
        } 
    }
}

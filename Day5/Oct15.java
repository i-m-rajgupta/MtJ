import java.util.Scanner;

public class Oct15 {
    public static void main(String[] args) {
        // Find the subarray with the maximum sum. 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements : ");
        int arr[] = new int[8];
        for(int i =0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int maxSum =0;
        int start =0,end=0;
        for(int i =0;i<arr.length;i++){
         int sum=0;
         for(int j=i;j<arr.length;j++){
          sum+= arr[j];
           if(maxSum<sum){
            maxSum = sum;
              start = i;
              end = j;  
         }
         }
        }
        System.out.print("The Max sum is : "+maxSum+" and the subarray is :");
        for(int i = start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }

        // Find the longest subarray with sum 0.

      int[] startArr = new int[2*arr.length];
  int[] endArr = new int[2*arr.length];
  start =0;
  end =0;

        for(int i =0;i<arr.length;i++){
            int sum =0;
            for(int j=i;j<arr.length;j++){
              sum += arr[j];
              if(sum == 0){
                startArr[start++] = i;
                endArr[end++] = j;
              }
            }
        }
        int maxDiff = 0;
        for(int i=0;i<startArr.length;i++){
            int diff = endArr[i] - startArr[i];
            if(maxDiff <diff){
                maxDiff =diff;
                start = startArr[i];
               end = endArr[i];
            }
        }
        System.out.println();
        System.out.print("The Length of longest subarray with sum as zero is "+(maxDiff+1)+" and the subarray is :");
        for(int i = start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

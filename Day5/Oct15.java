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
//         int maxSum =0;
//         int start =0,end=0;
//         for(int i =0;i<arr.length;i++){
//          int sum=0;
//          for(int j=i;j<arr.length;j++){
//           sum+= arr[j];
//            if(maxSum<sum){
//             maxSum = sum;
//               start = i;
//               end = j;  
//          }
//          }
//         }
//         System.out.print("The Max sum is : "+maxSum+" and the subarray is :");
//         for(int i = start;i<=end;i++){
//             System.out.print(arr[i]+" ");
//         }

//         // Find the longest subarray with sum 0.

//       int[] startArr = new int[2*arr.length];
//   int[] endArr = new int[2*arr.length];
//   start =0;
//   end =0;

//         for(int i =0;i<arr.length;i++){
//             int sum =0;
//             for(int j=i;j<arr.length;j++){
//               sum += arr[j];
//               if(sum == 0){
//                 startArr[start++] = i;
//                 endArr[end++] = j;
//               }
//             }
//         }
//         int maxDiff = 0;
//         for(int i=0;i<startArr.length;i++){
//             int diff = endArr[i] - startArr[i];
//             if(maxDiff <diff){
//                 maxDiff =diff;
//                 start = startArr[i];
//                end = endArr[i];
//             }
//         }
//         System.out.println();
//         System.out.print("The Length of longest subarray with sum as zero is "+(maxDiff+1)+" and the subarray is :");
//         for(int i = start;i<=end;i++){
//             System.out.print(arr[i]+" ");
//         }

        // Find the median of two sorted arrays.

    //     System.out.println("Enter 1 array elements in sorted order ");
    //       int arr1[] = new int[3];
    //       for(int i =0;i<arr1.length;i++){
    //        arr1[i]  = sc.nextInt();
    //       }
    //  System.out.println("Enter sedond array elements in sorted order ");
    //            int arr2[] = new int[3];
    //       for(int i =0;i<arr2.length;i++){
    //        arr2[i]  = sc.nextInt();
    //       }
    //     int temp[]= new int[arr1.length+arr2.length];

    //     double median = 0;
    //     int first=0 ,second =0,merge=0;
       
    //     while (first < arr1.length && second < arr2.length) {
    //         if(arr1[first] < arr2[second]){
    //             temp[merge++] = arr1[first++];
    //         }else{
    //             temp[merge++] = arr2[second++];
    //         }
    //     }

    //     while(first < arr1.length){
    //           temp[merge++] = arr1[first++];
    //     }
    //     while (second < arr2.length) {
    //         temp[merge++] = arr2[second++];
    //     }

    //     for(int i : temp){
    //         System.out.println(i);
    //     }
    //     if(temp.length%2 != 0){
    //         median = temp[temp.length/2];
    //     }else{
    //         median = (temp[temp.length/2 - 1] + temp[temp.length/2])/2.0;
    //     }
 
    //     System.out.println(median);

    //     Find the equilibrium index (where left sum = right sum). 
    // int start = 0;
    // int end = arr.length-1;

    //  int rightSum = 0,leftSum =0;
    //  while( start <= end){
    //     if(rightSum < leftSum){
    //      rightSum += arr[end--];
    //     }else{
    //     leftSum += arr[start++];
    //     }
    //     if(rightSum == leftSum){
    //         break;
    //     }
    //  }

    //  if(leftSum == rightSum){
    // System.out.println("Equilibrium index where rightsum = leftsum is : "+start);
    // System.out.println(leftSum+" "+rightSum);
    //  }else{
    //     System.out.println("NO Equlibrium Index exists .");
    //  }

    // Find the majority element (appears > n/2 times).

    int majority = Integer.MIN_VALUE;
    for(int i =0;i<arr.length;i++){
      int count= 0;
     for(int j=0;j<arr.length;j++){
       if(arr[i] == arr[j]){
        count++;
       }
       if(count > arr.length/2){
         majority = arr[i];
       }
     }
    }

    if(majority != Integer.MIN_VALUE){
        System.out.println("Majority  Element : "+ majority);
    }else{
        System.out.println("No majority elemnt exists ");
    }
      sc.close(); 
        }
    }
 
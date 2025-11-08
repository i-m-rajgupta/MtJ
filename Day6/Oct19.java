import java.util.Scanner;

public class Oct19 {
   public static void main(String[] args) {
    // Find the maximum sum of a subarray of size k.
   //  System.out.println("Enter the array elements : ");
   //  int arr[] = new int[8];
    Scanner sc = new Scanner(System.in);
   //  for(int i=0;i<arr.length;i++){
   //       arr[i] = sc.nextInt();
   //  }
    System.out.println("Enter the size of subarray : ");
   // System.out.println("Enter the target sum value : ");
    int k = sc.nextInt();
    int sum =0;
   //  for(int i=0;i<k;i++ ){
   //      sum += arr[i];
   //  }
    int start =0;
   //  int maxSum = sum;
   //  for(int i=k;i<arr.length;i++){
   //     sum = sum +arr[i]-arr[i-k];
   //     if(sum >maxSum){
   //      start = i;
   //      maxSum = sum;
   //     }
   //  }
   //  System.out.println("Maxsum : "+maxSum);
   //  System.out.println("Subarray starting and ending index : "+start+" "+(start-k));

    // Find the smallest subarray whose sum ≥ k.
    int end =0,startIdx =0, endIdx = 0, minLen = Integer.MAX_VALUE;
   //   start =0;
   //   sum =0;

   //   for(end =0;end <arr.length;end++){
   //    sum += arr[end];

   //    while(sum >=k){
   //       startIdx = start;
   //       endIdx = end;
   //       minLen = Math.min(minLen, endIdx - startIdx+1);
   //       sum -= arr[start];
   //       start++;
   //    }
   //   }

   //  System.out.println("The minimum length for the subarray whose sum is >= than k is : "+minLen +" and subarray is ");
   //  for(int i=startIdx;i<=endIdx;i++){
   //    System.out.print(arr[i]+" ");
   //  }

    //Print first negative number in every subarray window of size K.
    int window[] = new int[k];
    int res =0;
   //  for(int i=0;i<k;i++){
   //     window[i] = arr[i];
   //     if(window[i]<0 && res == 0){
   //       res = window[i];
   //     }
   //  }

   //  System.out.println("First negative number in every subarray window of size k");
   //  for(int i=k;i<arr.length;i++){
   //     System.out.print(res+" ");
   //       res =0;
   //     for(int j=0;j<k;j++){
   //       if(j == k-1){
   //          window[j] = arr[i];
   //       }else{
   //           window[j] = window[j+1];
   //       }

   //        if(window[j]<0 && res == 0){
   //       res = window[j];
   //     }
   //     }
   //  }

   //     System.out.print(res+" ");
   //     System.out.println();

   //  Find the maximum element in every window of size K.
   // res = arr[0];
   //  for(int i=0;i<k;i++){
   //     window[i] = arr[i];
   //     if(window[i]>res){
   //       res = window[i];
   //     }
   //  }

   //  System.out.println("Maximum number in every window of size k");
   //  for(int i=k;i<arr.length;i++){
   //     System.out.print(res+" ");
   //       res =0;
   //     for(int j=0;j<k;j++){
   //       if(j == k-1){
   //          window[j] = arr[i];
   //       }else{
   //           window[j] = window[j+1];
   //       }

   //        if(window[j]>res){
   //       res = window[j];
   //     }
   //     }
   //  }

   //     System.out.print(res+" ");
   //     System.out.println();

      //  Find the length of the longest substring with exactly K unique characters.
      System.out.println("Enter a string with random word : ");
      int count =0;
      String s = sc.next();
      int freq[] = new int[256];
      int maxLen=0;
      startIdx = 0;
      endIdx = 0;
      start =0;
      char res1[] = new char[s.length()];

    for( end=0;end<s.length();end++){
         char ch = s.charAt(end);
         if(freq[ch] == 0){
            count++;
         }

         freq[ch]++;
         res1[end] = ch;
         while(count > k && start<=end){
            ch = s.charAt(start);
              freq[ch]--;
            if(freq[ch] == 0){
               count--;
            }
            start++;
         }
         if(count == k && maxLen<end-start+1){
            startIdx = start;
            endIdx = end;
            maxLen = endIdx - startIdx+1;
         }
    }

     System.out.println("Length of longest substring with exactly k unique charcters : "+maxLen+" and substring ");
      
      for(int i=startIdx;i<=endIdx;i++){
         System.out.print(res1[i]);
      }
      System.out.println();
   } 
}

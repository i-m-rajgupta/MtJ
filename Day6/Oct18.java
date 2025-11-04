import java.util.Scanner;
public class Oct18 {
    public static void main(String[] args) {
        // Print the Longest subarray with equal 0s and 1s. 
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[7];
        // System.out.println("Enter the elements for the Binary Array : ");
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }
        int start =0,end =0,diff=0,count=0,maxcount=0;
        // for(int i=0;i<arr.length;i++){
        //     diff=0;
        //     for(int j=i;j<arr.length;j++){
        //     diff = (arr[j] == 0)?diff-1:diff+1;
        //     if(diff == 0){
        //         count = j - i +1;
        //         if(maxcount<count){
        //             maxcount = count;
        //             start =i;
        //             end =j;
        //         }
        //     }
        // }  
        // }
        // System.out.println("Maxcount with equal zeros and ones is : "+maxcount);
        // System.out.println("Starting and ending index is : "+start+" "+end);

        // Longest subarray with given sum.
        int arr1[] = new int[5];
        System.out.println("Enter array elements : ");
        for(int i=0;i<arr1.length;i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the target sum ");
        int k = sc.nextInt();
        int sum =0;
        for(int i=0;i<arr1.length;i++){
            sum =0;
            for(int j=i;j<arr1.length;j++){
                sum += arr1[j];
                
                if(sum == k){
                    count = j-i+1;
                     if(maxcount<count){
                      maxcount = count;
                      start = i;
                      end = j;
                     }
                }
            }
        }
        if(maxcount>0){
            System.out.println("Longest subarray with target sum is : "+maxcount);
            System.out.println(" Starting and Ending Index "+start+" and "+end);
        }else{
            System.out.println("Subarray with target sum not exists .");
        }
    }
}

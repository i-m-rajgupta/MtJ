import java.util.Arrays;
import java.util.Scanner;

public class Oct21 {
    public static void main(String[] args) {
        //  Sum of Two Numbers in a Sorted Array. 
        System.out.println("Enter array in the sorted order ");
        int arr[] = new int[6];
        Scanner sc = new Scanner(System.in);
        for(int i =0;i<arr.length;i++){
           arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter value of target sum : ");
        int k = sc.nextInt();
            int startIdx = 0,endIdx = arr.length-1;
                boolean isFound = false;
        while(startIdx<endIdx){
             int sum = arr[startIdx]+arr[endIdx];
            if(sum == k ){
            isFound = true;
                break;
            }else if(sum<k){
                startIdx++;
            }else{
                endIdx--;
            }
        }
        if(isFound){
            System.out.println("Elements which sum equal to target sum are : "+arr[startIdx]+" and "+arr[endIdx]);
        }else{
            System.out.println("No two elements exist which sum equal to target sum ");
        }
       
        // Reverse elements in-place using two pointers. 
        // startIdx =0;
        // endIdx =arr.length-1;
        // for(int i=0;i<arr.length/2;i++){
        //     int temp = arr[startIdx];
        //     arr[startIdx++] = arr[endIdx];
        //     arr[endIdx--] = temp;
        // }
        //     for(int i =0;i<arr.length;i++){
        //   System.out.println(arr[i]);
        // }
    
    //   Use slow–fast pointers to find middle index.
    // int slowIdx =0;
    // int fastIdx =0; 
        
    // while (fastIdx < arr.length-1) {
    //     slowIdx++;
    //     fastIdx += 2;
    //     System.out.println(slowIdx+" "+fastIdx);
    // }
    // System.out.println("Middle element is "+arr[slowIdx]);

    //  Find if there exists a pair with difference K.
    startIdx =0;
    endIdx =1;
    System.out.println("Enter the target difference : ");
    k = sc.nextInt();
    Arrays.sort(arr);
     isFound = false;
    while( startIdx <arr.length && endIdx <arr.length){
      int diff =  arr[endIdx]-arr[startIdx];
       if(startIdx != endIdx && diff == k ){
        isFound = (diff == k) ?  true : false;
        break;
       }else if(diff < k){
        endIdx++;
       }else{
        startIdx++;
       }
    }

    if(isFound){
        System.out.println("A pair with difference k is : "+arr[startIdx]+" and "+arr[endIdx]);
    }else{
        System.out.println("No pair found with differnce k");
    }

    // Check if Two Strings Are Reverses .
    String s1 = "abcd";
    String s2 = "dcba";
    char ch[] = s1.toCharArray();
    startIdx =0;
    endIdx = ch.length-1;

    for(int i=0;i<ch.length/2;i++){
       char temp = ch[startIdx];
       ch[startIdx++] = ch[endIdx];
       ch[endIdx--] = temp; 
    }
   
    s1 = new String(ch);
    if(s1.equals(s2)){
        System.out.println("Two string are reverse ");
    }else{
        System.out.println("Two string are not reverse ");
    }
    
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Oct22 {
    public static void main(String[] args) {
        // Remove Duplicates from Sorted Array.
        System.out.println("Enter the array elements : ");
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int leftIdx =0,rightIdx = 1;
        while (rightIdx<arr.length) {
            if(arr[leftIdx] != arr[rightIdx]){
                arr[++leftIdx] = arr[rightIdx];
            }else{
                rightIdx++;
            }
        }
        System.out.println("After removing duplicates : ");
        for(int i=0;i<=leftIdx;i++){
            System.out.println(arr[i]);
        }

        //  Move zeros to the end without changing order of non-zeros.
        int arr1[]={10,5,0,0,12};

        leftIdx =0;
        rightIdx=0;
        while (rightIdx<arr1.length) {
            if(arr1[leftIdx] != 0){
                if(arr1[rightIdx] == 0){
                  leftIdx = rightIdx;
                }else{
                    rightIdx++;
                } 
            }else{
            if(arr1[rightIdx] != 0){
               int temp = arr1[leftIdx];
               arr1[leftIdx++] = arr1[rightIdx];
               arr1[rightIdx++] = temp;
            }else{
                rightIdx++;
            }
            }
        }
        System.out.println("After moving zeroes to the end ");
        for(int i:arr1){
            System.out.println(i);
        }

        // Check if String is Palindrome.
        String s1 = "racecar";
        leftIdx =0;
        rightIdx = s1.length()-1;
        boolean isPalindrome = true;
        while (leftIdx<rightIdx) {
            if(s1.charAt(leftIdx++) != s1.charAt(rightIdx--)){
             isPalindrome = false;
             break;
            }
        }
        if(isPalindrome){
           System.out.println("This string is palindrome");
        }else{
               System.out.println("This string is not a palindrome");
        }
       
        // Container With Most Water. 
        int height[] = { 6, 9, 3, 4, 5, 8};
        leftIdx =0;
        rightIdx = height.length-1;
        int maxArea = 0,leftMax =0,rightMax =0;
        while (leftIdx<rightIdx) {
            int breadth = rightIdx-leftIdx;
            int length = Math.min(height[rightIdx],height[leftIdx] );
            int area = length*breadth;
            System.out.println(area+" "+leftIdx+" "+rightIdx);
            if(maxArea <area){
                maxArea = area;
                leftMax = height[leftIdx];
                rightMax = height[rightIdx];
            }
            if(height[leftIdx]<height[leftIdx+1]){
                leftIdx++;
            }else{
                rightIdx--;
            }
        }
        System.out.println("Max area : "+maxArea+" and  height of left and right bars are  : "+leftMax+" and "+rightMax);

        // Trapping Rain Water
        int height1[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        leftIdx = 0;
        rightIdx = height1.length-1;
        int totalWater = 0;
        leftMax = height1[leftIdx];
        rightMax= height1[rightIdx];
        int curr_height =0;
        while(leftIdx<=rightIdx){
            if(leftMax<rightMax){
                curr_height = height1[leftIdx];
                if(leftMax>curr_height){
                    totalWater += leftMax - curr_height;
                }else{
                    leftMax = curr_height;
                }
                leftIdx++;
            }else{
             curr_height = height1[rightIdx];
             if(rightMax>curr_height){
                totalWater += rightMax-curr_height;
             }else{
                rightMax = curr_height;
             }
              rightIdx--;
            }
        }
        System.out.println("Trap rain water "+totalWater);
    }
}

import java.util.Scanner;

public class Oct13 {
    public static void main(String[] args) {
        //  Merge two arrays into one
        int[] arr1 = {23,24,56,67};
        int[] arr2 = {56,45,78,12};
        int [] mergeArr = new int[arr1.length+arr2.length];
        for(int i =0;i<mergeArr.length;i++){
            if(i<arr1.length){
             mergeArr[i] = arr1[i];
            }else{
                int j = i-arr1.length;
                  mergeArr[i] = arr2[j];  
            }
        }
        for(int el:mergeArr){
            System.out.println(el);
        }
        // Find the difference between max and min elements in the array. 
        int max = mergeArr[0];
        int min = mergeArr[0];
        for(int i=1;i<mergeArr.length;i++){
            if(mergeArr[i]>max){
                max= mergeArr[i];
            }
            if(mergeArr[i]<min){
                min = mergeArr[i];
            }
        }

        int diff = max-min;
        System.out.println("Difference between the max and min is "+diff);

        // Check if the array is sorted.
        System.out.println(" Give a sorted array elements :");
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        boolean isSorted = true;
        for(int i =0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                isSorted = false;
                System.out.println("The given array is not sorted in ascending order");
                break;
            }
        }
        if(isSorted){
                 System.out.println("The given array is  sorted in ascending order");
        }

        //  Search an element in array .
        System.out.println("Enter an element to search in the array :"); 
        int el = sc.nextInt();
        boolean isPresent = false;
        for(int ele :arr){
            if(ele == el){
                System.out.println("Element is present in the array ");
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
        System.out.println("Element is not present in the array");
        }

        // Remove duplicates from a sorted  array.
        int[] modifiedArr = new int[arr.length];
        int j = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] != arr[i+1]){
                modifiedArr[j++] = arr[i]; 
            }
        }
        modifiedArr[j++] = arr[arr.length-1];
        System.out.println("Array after removing the duplicates");
        for(int i =0;i<j;i++){
            System.out.println(modifiedArr[i]);
        }

        System.out.println("Enter any number : ");
        int n = sc.nextInt();
        int sum = 0;
        do{
           int lastDigit = n%10;
           sum = sum+lastDigit;
           n=n/10;
        }while(n>0);
        System.out.println("Sum of the digit in number is : "+sum);
        sc.close();
    }
}

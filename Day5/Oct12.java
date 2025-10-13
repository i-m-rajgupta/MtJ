import java.util.Scanner;

public class Oct12 {
public static void main(String[] args) {
    // Find the sum and average of all array elements.
    double[] arr = new double[5];
    System.out.println("Enter arr elements");
    Scanner sc= new Scanner(System.in);
    for(int i=0;i<arr.length;i++){
        arr[i] = sc.nextDouble();
    }
    double sum = 0;
        for(int i=0;i<arr.length;i++){
        sum = sum + arr[i];
    }
    double avg = sum/arr.length;
    System.out.println("The sum and average of array elements is "+sum+" and "+avg);

    // .Find the maximum and minimum element in an array.
    double max = arr[0];
    double min = arr[0];
     for(int i=0;i<arr.length;i++){
        if(max < arr[i]){
            max = arr[i];
        }
        if(min > arr[i]){
            min = arr[i];
        }
    }
    System.out.println("The maximum and minimum of the array is "+max+" and "+min);
    // Count even and odd numbers in an array.
    int evenCount = 0,oddCount=0;
    for(int i =0;i<arr.length;i++){
     if((int)arr[i]%2 == 0){
        evenCount++;
     }else{
        oddCount++;
     }
    }
    System.out.println("The total even and odd number in array is "+evenCount+" and "+oddCount);

    //  Count the number of prime elements in the array.
    int prime =arr.length;
    for(int i=0;i<arr.length;i++){
        int n = (int) arr[i]-1;
        while(n>1){
            if((int)arr[i] % n == 0){
                prime--;
                break;
            }
             n--;
        }
    }
    System.out.println("Total prime no. in array is : "+prime);

    // Find the second largest and second smallest element. 
    int firLargest,firSmallest,secLargest,secSmallest;
    if((int)arr[0] > (int)arr[1]){
          firLargest = (int)arr[0];
         secLargest = (int)arr[1];
         firSmallest = (int)arr[1];
          secSmallest = (int)arr[0];
    } else if((int)arr[1]>(int)arr[0]){
         firLargest = (int)arr[1];  // 45   78  
         secLargest = (int)arr[0];   //12   45
         firSmallest = (int)arr[0];  // 12   12
          secSmallest = (int)arr[1];  //45    45
    }else{
          firLargest = (int)arr[0];
         secLargest = Integer.MIN_VALUE;
         firSmallest = (int)arr[0];
          secSmallest = Integer.MAX_VALUE;
    }

    for(int i =2;i<arr.length;i++){
         if((int) arr[i]>firLargest){
             secLargest = firLargest;
            firLargest = (int)arr[i];
         }else if((int)arr[i]>secLargest && arr[i] != firLargest){
            secLargest = (int)arr[i];
         }

            if((int) arr[i]<firSmallest){
                 secSmallest = firSmallest;
            firSmallest = (int)arr[i];
         }else if((int)arr[i]<secSmallest && arr[i] != firSmallest){
            secSmallest = (int)arr[i];
         }
    }
    if(secLargest != Integer.MIN_VALUE ){
        System.out.println("Second Largest number is : "+secLargest);
    }else{
        System.out.println("No second largest exist in the array");
    }
     if(secSmallest != Integer.MAX_VALUE ){
        System.out.println("Second Smallest number is : "+secSmallest);
    }else{
        System.out.println("No second smallest exist in the array");
    }
}    
}

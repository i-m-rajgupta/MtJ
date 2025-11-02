import java.util.Scanner;

public class Oct17 {
    public static void main(String [] args){
        // Maximum consecutive one’s or zeros in binary array
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[5];
        // System.out.println("Enter binary elements  for array :");
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }

        // int prev = arr[0],maxNum = arr[0],maxCount =0,count=1;
        // for(int i =1;i<arr.length;i++){
        //    if(arr[i] == prev){
        //     count++;
        //    }else{
        //     if(maxCount < count){
        //         maxNum = prev;
        //         maxCount = count;
        //     }
        //     prev = arr[i];
        //     count =1;
        //    }
        // }

        //  if(maxCount < count){
        //         maxNum = prev;
        //         maxCount = count;
        // }

        // if(maxNum == 0){
        //     System.out.println("Maximum consecutive zeroes is : "+maxCount);
        // }else{
        //      System.out.println("Maximum consecutive ones is : "+maxCount);
        // }

        //  Sort an array in wave form.
        //  int arr1[] = new int[8];
        // System.out.println("Enter elements  for array in sorted form  :");
        // for(int i=0;i<arr1.length;i++){
        //     arr1[i] = sc.nextInt();
        // }

        // for(int i =0;i<arr1.length;i=i+2){
        //     if(i == arr1.length-1){
        //         break;
        //     }
        //     int temp = arr1[i];
        //     arr1[i] = arr1[i+1];
        //     arr1[i+1] = temp;
        // }

        // System.out.println("Array in wave form ");
        // for(int i :arr1){
        //     System.out.println(i);
        // }

    //   Give the maximum profit from Stock buy and sell – Maximum one transaction is allowed. Stock should be bought 
    // earlier before being sold. 

    int price[] = new int[8];
    System.out.println("Enter the price of stock ");
    for(int i=0;i<price.length;i++){
        price[i] = sc.nextInt();
    }

    int profit =0,minPrice = price[0],minIndex = 0,sell = 0,sellIndex=0;
    for(int i=1;i<price.length;i++){
         if(minPrice> price[i]){
            minPrice = price[i];
            minIndex = i;
         }
    }
    for(int i=minIndex+1;i<price.length;i++){
        if(profit < price[i] - minPrice){
            profit = price[i] - minPrice;
            sell = price[i];
            sellIndex =i;
        }
    }

    if(profit>0){
        System.out.println("Max profit is "+profit);
        System.out.println("Bought stock at day "+(minIndex+1)+" in price "+minPrice+" and sold stock at day "+(sellIndex+1)+" in price "+sell);
    }else{
        System.out.println("No Maximum profit exists ");
    }

    //  Give the maximum profit from Stock buy and sell – Multiple transaction is allowed. Stock should be bought earlier before being sold and 
    // we cannot have multiple stock at any day.

    
    }
}

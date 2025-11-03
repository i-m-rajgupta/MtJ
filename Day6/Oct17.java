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

    // int price[] = new int[6];
    // System.out.println("Enter the price of stock ");
    // for(int i=0;i<price.length;i++){
    //     price[i] = sc.nextInt();
    // }

    // int profit =0,minPrice = price[0],minIndex = 0,sell = 0,sellIndex=0;
    // for(int i=1;i<price.length;i++){
    //      if(minPrice> price[i]){
    //         minPrice = price[i];
    //         minIndex = i;
    //      }
    // }
    // for(int i=minIndex+1;i<price.length;i++){
    //     if(profit < price[i] - minPrice){
    //         profit = price[i] - minPrice;
    //         sell = price[i];
    //         sellIndex =i;
    //     }
    // }

    // if(profit>0){
    //     System.out.println("Max profit is "+profit);
    //     System.out.println("Bought stock at day "+(minIndex+1)+" in price "+minPrice+" and sold stock at day "+(sellIndex+1)+" in price "+sell);
    // }else{
    //     System.out.println("No Maximum profit exists ");
    // }

    //  Give the maximum profit from Stock buy and sell – Multiple transaction is allowed. Stock should be bought earlier before being sold and 
    // we cannot have multiple stock at any day.


    // int buyDay = 0,maxProfit=0,sellDay =0;
    // boolean isHolding = false;

    // for(int i=1;i<price.length;i++){
    //     if(!isHolding && price[i]>price[i-1] ){
    //             buyDay = i-1;
    //             isHolding = true;
    //     }

    //     if( isHolding && (i == price.length-1 || price[i]<price[i-1])){
    //         sellDay = (price[i]<price[i-1])? i-1: i;
    //         System.out.println("Buy at "+price[buyDay]+" Sell at "+price[sellDay]);
    //         maxProfit += price[sellDay]-price[buyDay];
    //         isHolding = false;
    //     }
    // }

    // if(maxProfit>0){
    //     System.out.println("Max profit : "+maxProfit);
    // }else{
    //     System.out.println("No maxprofit exists .");
    // }

    // Rearrange array elements by sign.
    
    int arr2[] = new int[10];
    System.out.println("Enter array elements with mixed positive and negative value : ");
    for(int i=0;i<arr2.length;i++){
        arr2[i] =  sc.nextInt();
    }

    int next =0,prev=0,changingIndex=0;
    for(int i=0;i<arr2.length;i++){
        if(arr2[i] < 0){
            int temp2 = arr2[i];
             for(int j=changingIndex;j<i;j++){
                 if(j == changingIndex){
                    prev = arr2[changingIndex];
                 }
                 next = arr2[j+1];
                 arr2[j+1] = prev;
                 prev = next;
             }
             arr2[changingIndex++] = temp2;
        }
    }

    int requiredIndex =0;

    for(int i=0;i<arr2.length;i++){
      if(arr2[i] >=0 ){
        int temp = arr2[i];
      for(int j=requiredIndex;j<i;j++){
        if(j==requiredIndex){
         prev = arr2[requiredIndex];
        }
        next = arr2[j+1];
        arr2[j+1] = prev;
        prev = next;
      }
      arr2[requiredIndex] = temp;
      requiredIndex = requiredIndex+2;
      }
      
    }

    System.out.println("Rearranged Array");
    for(int i=0;i<arr2.length;i++){
        System.out.println(arr2[i]);
    }
    }
}

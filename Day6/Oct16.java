import java.util.Scanner;
public class Oct16 {
    public static void main(String [] args){
        // Move all the zeroes at the beggining of the array. 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements");
        int arr[] = new int[5];
        for(int i =0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        // int count = 0;
        // int newArr[] = new int[arr.length];
        // int j=0;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i] == 0){
        //         count++;
        //     }else{
        //         newArr[j++] = arr[i];
        //     }
        // }

        // j=0;
        
        // for(int i =0;i<arr.length;i++){
        //     if(i<count){
        //         arr[i] =0;
        //     }else{
        //         arr[i] = newArr[j++];
        //     }
        // }
        // for(int i:arr){
        //     System.out.println(i);
        // }

        // Replace all negative numbers with 0. 
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i] < 0){
        //         arr[i] =0;
        //     }
        // }
        // for(int i:arr){
        //     System.out.println(i);
        // }

        // Replace all even numbers with their square. 
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i] %2 == 0){
        //         arr[i] = arr[i]*arr[i];
        //     }
        // }
        // for(int i:arr){
        //     System.out.println(i);
        // }

        // Replace all odd numbers with their cube. 
        // for(int i =0;i<arr.length;i++){
        //     if(arr[i] %2 != 0){
        //         arr[i] = arr[i]*arr[i]*arr[i];
        //     }
        // }
        // for(int i : arr){
        //     System.out.println(i);
        // }

        // Find first occurrence of an element. 
        System.out.println("Enter the element to find : ");
        int element = sc.nextInt();
        for(int i =0;i<arr.length;i++){
            if(arr[i] == element){
              System.out.println("Element is found at index : "+i);
              break;
            }
        }
        sc.close();
    }
}

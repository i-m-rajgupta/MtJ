import java.util.Scanner;

public class Oct14 {
  public static void main(String[] args) {
    // Find the sum of positive and negative numbers separately.
    int arr[] = new int[5];
    Scanner sc = new Scanner(System. in);
    System.out.println("Enter array elements consisting of positive and negative numbers");
    for(int i =0;i<arr.length;i++){
        arr[i] = sc.nextInt();
    }

    int posSum =0;
    int negSum =0;
    for(int el : arr){
        if(el>0){
            posSum += el; 
        }else{
            negSum += Math.abs(el);
        }
    }
    System.out.println("The positive and negative sum is "+posSum+" and -"+negSum);

    // Find the frequency of each element. 

    int[] map = new int[arr.length];

    for(int i =0;i<map.length;i++){
        map[i] = 1;
    }

    for(int i=0;i<arr.length;i++){
       for(int j=0;j<i;j++){
        if(arr[j] == arr[i]){
            map[j]++;
            map[i]--;
            break;
        }
       }
  }
   
  for(int i=0;i<map.length;i++){
    if(map[i] != 0){
     System.out.println(arr[i]+ " -> "+map[i]);
    }
  }

//   Rotate array elements ( right by k positions).
System.out.print("Enter any k position to rotate the array : ");
int k = sc.nextInt(); 
while (k>0) {
        int temp =arr[0];
    for(int i =0;i<arr.length-1;i++){
    arr[i] = arr[i+1];
    }
    arr[arr.length-1] = temp;
    k--; 
}

   for(int el:arr){
    System.out.println(el);
  }

//   Find intersection and union of two arrays. 
  int arr1[] =new int[6];
  System.out.println("Enter elements for array 1 : ");
  for(int  i =0;i<arr1.length;i++){
    arr1[i] = sc.nextInt();
  }
  int arr2[] =new int[4];
  System.out.println("Enter elements for array 2 : ");
  for(int  i =0;i<arr2.length;i++){
    arr2[i] = sc.nextInt();
  }

  int union[] = new int[arr1.length+arr2.length];
  int intersection[] = new int[Math.min(arr1.length, arr2.length)];
  
  int count =0;
  for(int i = 0;i<union.length;i++){
    boolean isPresent = false;
    for(int j=0;j<count;j++){
        if(i<arr1.length && union[j] == arr1[i]){
           isPresent = true;
           break;    
        }
         if(i>=arr1.length && union[j] == arr2[i-arr1.length]){
            isPresent = true;
            break;
        }
    }
    if(!isPresent){
        if(i<arr1.length){
       union[count++] = arr1[i];
        }else{
            union[count++] = arr2[i-arr1.length];
        }
    }
  }
    
  System.out.println("Union of two array is");
    for(int i=0;i<count;i++){
        System.out.print(union[i]+" ");
    }
    count =0;
    if(arr1.length<=arr2.length){
   for(int i =0;i<intersection.length;i++){
        for(int j =0;j<arr2.length;j++){
           if(arr1[i] == arr2[j]){
            intersection[count++] = arr1[i];
            break;
           }
        }
    }
    }else{
    for(int i =0;i<intersection.length;i++){
        for(int j =0;j<arr1.length;j++){
           if(arr2[i] == arr1[j]){
            intersection[count++] = arr2[i];
            break;
           }
        }
    }}
    System.out.println();
    System.out.println("Intersection is :");
     for(int i=0;i<count;i++){
        System.out.print(intersection[i]+" ");
    }
    // Find subarray with given sum.
    System.out.println();
    System.out.println("Enter the target sum to find : ");
    int target = sc.nextInt();
    boolean isFound = false;
    int start =0;
    int end = 0;
    for(int i =0;i<arr1.length;i++){
           int sum =0;
        for(int j=i;j<arr.length;j++){
         sum += arr1[j];
         if(sum == target){
            isFound = true;
           start = i;
           end = j;
           break;
         }
        }
        if(isFound){
            break;
        }
    }
    if(isFound){
           System.out.println("subarray with sum "+target+" is present and the element are: ");
       for(int i = start;i<=end;i++){
            System.out.print(arr1[i]+" ");
       }
    }else{
        System.out.println("subarray with sum "+target+" is not present");
    }
    sc.close();
  }  
}

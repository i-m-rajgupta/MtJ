
public class Nov28 {
    public static int calculateGcd(int n1,int n2){
        // Euclidean Algorithm loop 
        if(n1 == 0 && n2 == 0){
            System.out.println("Gcd for both the number being  0 is undefined ");
            return 0;
        }

        if(n1 == 0){
            System.out.println("GCD of n1 and n2 is "+n2);
            return n2;
        }

        n1 = Math.abs(n1);
        n2 = Math.abs(n2);
        System.out.println("n1 "+n1+" n2 "+n2);
       return calculateGcd(n2%n1, n1);
    }

    public static int calculateLcm(int a,int b){
        int gcd = calculateGcd(a, b);
        return (a*b)/gcd;
    }

    public static int count(String str,int count){
        if(str == ""){
           return count;
        }

        return count(str.substring(1),count+1);
    }

    public static boolean isSorted(int[] arr,int idx){
        if(idx == arr.length-1){
            return true;
        }

        if(arr[idx] < arr[idx+1]){
           return isSorted(arr, idx+1);
        }else{
            return false;
        }
    }

    public static int max(int[] arr,int max,int idx){
        if(idx == arr.length){
            return max;
        }
      
        if(max<arr[idx]){
            max = arr[idx];
        }

        return max(arr, max, idx+1);
    }
    public static void main(String[] args) {
    //    Find the GCD of two numbers using recurssion.   
    calculateGcd(16, 4);

    // Find the LCM of two numbers using recurssion.
    System.out.println("Lcm : "+calculateLcm(11, 10));

    // Count the occurrences of a character in a string using recurssion.
    System.out.println("Count : "+count("hello world",0));

    // Check if an array is sorted using recurssion.
    int arr[] = {5,6,7,8};
   System.out.println("Array is sorted : "+ isSorted(arr,0));

//    Find the maximum element in an array using recurssion.
    System.out.println("Maximum Element in the array is : "+max(arr, 0, 0));
    }
}

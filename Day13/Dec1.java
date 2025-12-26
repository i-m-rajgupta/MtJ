import java.util.ArrayList;

public class Dec1 {
    public static void print(ArrayList<Integer> arr,int idx){
        if(idx == arr.size()){
            return;
        }
        print(arr, idx+1);
        System.out.println(arr.get(idx)+" ");
    }

    public static void sum(ArrayList<Integer> arr,int idx,int sum){
        if(idx == arr.size()){
            System.out.println("Sum of array "+arr+" is : "+sum);
            return;
        }

        sum(arr,idx+1,sum+arr.get(idx));
    }

    public static void secondMax(ArrayList<Integer> arr,int secondMax,int max,int idx){
        if(idx == arr.size()){
            if(secondMax == Integer.MIN_VALUE){
                System.out.println("No second max exists ");
            }else{
                System.out.println("Second max in "+arr+" is : "+secondMax);
            }
            return;
        }
  
        int num = arr.get(idx);
         if(max<num){
            secondMax = max;
            max = num;
         }

         if(max > num &&  secondMax <num){
            secondMax = num;
         }

         secondMax(arr,secondMax,max,idx+1);
    }

    public static void removeOccurences(ArrayList<Integer> arr,int element,int idx){
        if(idx == arr.size()){
            System.out.println("After removing of occurences of "+element+" from array is : "+arr);
            return;
        }

        if(arr.get(idx) == element){
            arr.remove(idx);
        }
        removeOccurences(arr, element, idx+1);
    }

    public static void count(ArrayList<Integer> arr,int odd,int even,int idx){
        if(idx == arr.size()){
            System.out.println("Total even and odd no. present in arr"+arr+" is : "+even+" and "+even);
            return;
        }

        if(arr.get(idx)%2 == 0){
            count(arr, odd, even+1, idx+1);
        }else{
            count(arr, odd+1, even, idx+1);
        }
    }
    public static void main(String[] args) {
        // Print all elements of an ArrayList in reverse order recursively.
         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(45);
         arr.add(56);
         arr.add(89);
         arr.add(79);
         print(arr, 0);

        //  Find the sum of all elements in an ArrayList.
         sum(arr, 0, 0);
       
       //Find the second largest element in an ArrayList.
       secondMax(arr, Integer.MIN_VALUE, Integer.MIN_VALUE, 0);

       //Remove all occurrences of a particular element from an ArrayList.
      ArrayList<Integer> arr2 = new ArrayList<>();
      arr2.add(52);
        arr2.add(22);
        arr2.add(52);
        arr2.add(552);
       arr2.add(525);
      removeOccurences(arr2, 52, 0);

    //   Count the number of even/odd elements.
     count(arr2, 0, 0, 0);
    }    
}

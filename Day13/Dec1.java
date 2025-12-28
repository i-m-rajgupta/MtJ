import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
        // Given an ArrayList<Integer>, perform the following operations in sequence:
        ArrayList<Integer> list = new ArrayList<>();
          list.add(5);
          list.add(6);
              list.add(7);
                  list.add(8);
                      list.add(9);
                      list.add(3);
          list.add(4,90);

         System.out.println("Element at index 1 : "+list.get(1)); 
         System.out.println("Element at index 3 : "+list.get(3));  

         
         System.out.println("Element at index 2 : "+list.set(2,90));
         
         System.out.println("Removed element from 3 : "+list.remove(3));
         System.out.println("Remove element of value 90 : "+list.remove(Integer.valueOf(90)));

         System.out.println("Contains : 25 "+list.contains(25));
         System.out.println("At index  "+list.indexOf(3)+" , 3 is present");
          System.out.println("At index "+list.lastIndexOf(3)+" , last 3 is present ");

          System.out.println("Size of arraylist : "+list.size());
          System.out.println("Is empty "+list.isEmpty());

          System.out.println("Iteration using the simple for loop : ");
          for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
          }

          System.out.println("Using enhanced for loop ");
          for(int num : list){
            System.out.println(num);
          }

          System.out.println("Using Iterator ");
          Iterator<Integer> it = list.iterator();
          while (it.hasNext()) {
            System.out.println(it.next()+" ");
          }

          Collections.sort(list);
          System.out.println("Sorted "+list);

          Collections.reverse(list);
          System.out.println("Reverse : "+list);

          System.out.println(list.subList(2, 4));
          
          list.clear();
          System.out.println(list);

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

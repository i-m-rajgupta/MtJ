import java.util.ArrayList;

public class Dec2 {
    public static void merge(ArrayList<Integer> arr1,ArrayList<Integer> arr2,ArrayList<Integer> merge,int idx){
        if(idx == (arr1.size()+arr2.size())){
            System.out.println("Merged  array : "+merge);
            return;
        }   

        if(idx < arr1.size()){
        merge.add(arr1.get(idx));
        }else{
            merge.add(arr2.get(idx-arr1.size()));
        }

         merge(arr1, arr2, merge, idx+1);
    }
    public static void intersection(ArrayList<Integer> arr1,ArrayList<Integer> arr2 ,ArrayList<Integer> intersection ,int idx1,int idx2){
        if(idx1 == arr1.size() ){
            System.out.println("Intersection Array "+intersection);
            return;
        }

        if(idx2 == arr2.size()){
            idx2 = 0;
            idx1 += 1;
            intersection(arr1,arr2,intersection,idx1,idx2);
            return;
        }
        
            int num = arr1.get(idx1);
         if( num == arr2.get(idx2) && !intersection.contains(num) ){
                intersection.add(num);          
        }

        intersection(arr1, arr2, intersection, idx1, idx2+1);
    }

    public static void moveZero(ArrayList<Integer> arr, int idx,int limit ) {
    if (idx == limit) {
        System.out.println(arr);
        return;
    }

    if (arr.get(idx) == 0) {
        arr.add(arr.remove(idx));
        moveZero(arr, idx,limit-1);
    } else {
        moveZero(arr, idx + 1,limit);
    }
}

    public static void moveZero2(ArrayList<Integer> arr,int pos,int idx){
        if(idx == arr.size()){
            while (pos < arr.size()) {
                arr.set(pos, 0);
                pos++;
            }
            System.out.println(arr);
            return;
        }
        
        if(arr.get(idx) != 0){
            arr.set(pos, arr.get(idx));
            moveZero2(arr, pos+1, idx+1);
        }else{
          moveZero2(arr, pos, idx+1);
        }
    }

    public static void moveNegative(ArrayList<Integer> arr,int pos,int idx){
       if(idx == arr.size()){
        System.out.println(arr);
        return;
       }

       if(arr.get(idx) < 0){
        int temp = pos;
        int num1 = arr.get(temp);
        int num2 ;
        while(temp < idx){
           num2 = arr.get(temp+1);
           arr.set(temp+1, num1);
           num1 = num2;
           temp++;
        }
        arr.set(pos,num1);
        pos++;
       }

       moveNegative(arr, pos, idx+1);
    }

    public static void main(String[] args) {
        // Merge two ArrayLists recursively.
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        merge(arr1, arr2, new ArrayList<>(), 0);

        // Find the intersection of two ArrayLists.
        intersection(arr1, arr2, new ArrayList<>(), 0, 0);

        // Move all zeros to the end of an ArrayList.
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(5);
          arr3.add(0);
             arr3.add(0);
             arr3.add(3);
                arr3.add(0);
                arr3.add(8);
                   arr3.add(6); 
                      arr3.add(0);
         moveZero(arr3, 0,arr3.size());  
         moveZero2(arr3, 0, 0);
         
        //  Move all negative numbers to the beginning.
        ArrayList<Integer> arr4 = new ArrayList<>();
        arr4.add(522);
        arr4.add(-788);
        arr4.add(-769);
        arr4.add(855);
        arr4.add(-899);
        arr4.add(965);
        arr4.add(-785);

        moveNegative(arr4, 0, 0);

        // Rotate an ArrayList by k positions.

    }
}

import java.util.*;

class MinimumArrow{
    static class Balloon{
        int start,end;
        Balloon(int start,int end){
            this.start = start;
            this.end = end;
        }
        public String toString(){
            return "("+start+","+end+")";
        }
    }
    public static int minimumArrow(int start[],int end[]){
      if(start.length == 0 && end.length == 0){
        return 0;
      }
        if (start.length != end.length) {
        System.out.println("Some data has been missing !!");
         return -1;
      }

      ArrayList<Balloon> balloons = new ArrayList<>();
      for(int i =0;i<start.length;i++){
        balloons.add(new Balloon(start[i], end[i]));
      }

      balloons.sort(Comparator.comparing((MinimumArrow.Balloon b)->b.end).thenComparing((MinimumArrow.Balloon b)->b.start));
      System.out.println(balloons);
      int arrowCount = 1;
      int currArrow = balloons.get(0).end; 
      for(int i = 1;i<balloons.size();i++){
         if(currArrow < balloons.get(i).start){
           currArrow = balloons.get(i).end;
           arrowCount++;
         }
      }
      return arrowCount;
    }
}

class Cookies{
    public static int assignCookies(int greed[],int cookies[]){
        if(greed.length == 0 || cookies.length == 0){
            return 0;
        }

        Arrays.sort(greed);
        Arrays.sort(cookies);
        int idx = 0;
        for(int i = 0;i<cookies.length;i++){
            if(idx<greed.length && cookies[i] >= greed[idx]){
                idx++;
            }
        }

      return idx;
    }
}

class MinimumStop{
    
      public static int getMinimumStop(int fuel[],int distance[],int target,int startFuel){
          int stops = 0,range = startFuel;
          PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
          int n = fuel.length;
          int i =0;
 
          while (range < target) {
            while (i<n && distance[i]<=range) {
                maxHeap.add(fuel[i]);
                i++;
            }

            if(maxHeap.isEmpty()){
                return -1;
            }

            range += maxHeap.poll();
            stops++;
          }
          return stops;
      }
}
public class Jan5 {
    public static int largestSum(int arr[],int k){
      if(arr.length == 0){
        return 0;
      }

      if(arr.length == 1){
        return arr[0];
      }
      Arrays.sort(arr);
 
      int i = 0;
      while (k>0 && arr[i] <0) {
        arr[i] = Math.abs(arr[i]);
        i++;
        k--;
      }

      if(k != 0 && k%2 != 0){
          Arrays.sort(arr);
          arr[0] = -arr[0];
      }
      int sum = 0;
      for(int j =0;j<arr.length;j++){
        sum += arr[j];
      }

      return sum;
    }

    static class Interval{
        int start,end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int removeOverlappingIntervals(ArrayList<Interval> intervals){
          intervals.sort(Comparator.comparing((Interval i)->i.end));
          int prevEnd = intervals.get(0).end;
          int remove =0;
          for(int i = 1;i<intervals.size();i++){
              if(prevEnd > intervals.get(i).start){
                 remove++;
              }else{
                 prevEnd = intervals.get(i).end;
              }
          }

          return remove;
    }
    public static void main(String[] args) {
        // Write a Java program to find minimum number of arrows to burst balloons.
        int start[] ={10,5,9,8,7,6};
        int end[] = {16,9,12,15,13,9};
       System.out.println( MinimumArrow.minimumArrow(start, end));

       int start2[] = {1,2,4,7,11,14};
int end2[]   = {3,5,6,10,13,15};
          System.out.println( MinimumArrow.minimumArrow(start2, end2));

        //   Implement assign cookies to children problem.
         int greed[] = {4,5,3};
         int cookies[] = {1,2,3};
         System.out.println(Cookies.assignCookies(greed, cookies));

        //  Write a Java program to find minimum number of refueling stops.
         int distance[] = {25,50,70};
         int fuel[] = {50,20,60};
         int target = 100;
         int startingFuel = 40;
        System.out.println(MinimumStop.getMinimumStop(fuel,distance, target, startingFuel));

        // Implement largest sum after K negations.
        int arr[] = {45,56,23,-25,-78,15};
        System.out.println(largestSum(arr, 5));

        // Write a Java program to minimum number of intervals to remove to avoid overlap.
         ArrayList<Interval> intervals = new ArrayList<>();
         int start3[] = {10,25,30,35,60,70};
         int finish3[] = {30,30,60,50,65,80};
         for(int i =0;i<start3.length;i++){
            intervals.add(new Interval(start3[i], finish3[i]));
         }
         System.out.println(removeOverlappingIntervals(intervals));
    }
}

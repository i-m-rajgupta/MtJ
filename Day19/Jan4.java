import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class ActivitySelection{
    private static class Activity{
        int idx,startTime,finishTime;
        Activity(int idx,int startTime,int finishTime){
            this.idx = idx;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }
        public String toString(){
            return "Activity ("+idx+","+startTime+","+finishTime+")";
        }
    }


    public static ArrayList<Activity> maxActivity(int [] startTime,int []finishTime){
           if(startTime.length == 0 || finishTime.length == 0){
            return new ArrayList<>();
           }
          if(startTime.length != finishTime.length){
            System.out.println("Some start time or finish time data are missing !! ");
            return new ArrayList<>();
          }

          ArrayList<Activity> activities = new ArrayList<>();
          for(int i = 0;i<finishTime.length;i++){
            activities.add(new Activity(i, startTime[i], finishTime[i]));
          }

          activities.sort(Comparator.comparing((ActivitySelection.Activity a)->a.finishTime).thenComparing((ActivitySelection.Activity a)->a.startTime));
          ArrayList<Activity> res = new ArrayList<>();
          res.add(activities.get(0));
          for(int i =1;i<activities.size();i++){
            if(res.get(res.size()-1).finishTime <= activities.get(i).startTime){
                 res.add(activities.get(i));
            }
          }

          res.sort(Comparator.comparing((ActivitySelection.Activity a)->a.idx));
          return res;
    }
}

class MinimumCoin{
     private static int coins[] = {1,2,5,10,20};
      
     private static void getMinimum(int amount,ArrayList<Integer> selectedCoins,int idx){
        if(amount == 0 || idx <0){
            return ;
        }

         if(amount<coins[idx]){
            getMinimum(amount, selectedCoins, idx-1);
         }else{
        selectedCoins.add(coins[idx]);
             amount -= coins[idx];
            getMinimum(amount, selectedCoins,idx);
         }
     }
     public static int minimumCoin(int amount){
        ArrayList<Integer> selectedCoins = new ArrayList<>();
        getMinimum(amount,selectedCoins,coins.length-1);
        System.out.println("Selected coins are ");
        System.out.println(selectedCoins);
        return selectedCoins.size();
     }
}

class FractionalKnapsack{
    static class Item{
        double value;
        double weight;
        double valueDensity;
        Item(double value,double weight){
            this.value = value;
            this.weight = weight;
            this.valueDensity = value/weight;
        }

        public String toString(){
            return "Item ("+value+","+weight+")";
        }
    }
    public static double getMaxValue(double capacity,double value[],double weight[]){
           if(value.length != weight.length || capacity <=0){
            return 0;
           }
           ArrayList<Item> items = new ArrayList<>();
           for(int i = 0;i<value.length;i++){
            items.add(new Item(value[i], weight[i]));
           }

           items.sort((s1,s2)->Double.compare(s2.valueDensity, s1.valueDensity));
           System.out.println(items);
           double totalValue = 0;
           int idx = 0;
           while (idx<items.size() && capacity>0 ) {
               if(capacity>=items.get(idx).weight){
                   capacity -= items.get(idx).weight;
                   totalValue += items.get(idx).value;
               }else{
                    totalValue += capacity*items.get(idx).valueDensity;
                    capacity = 0;
               }
               idx++;
           }

           return totalValue;
    }
}

class MaximumProfit{
   private static class Job{
        int time;
        double profit;
        int idx;
       Job(int idx,int time,double profit){
        this.time = time;
        this.idx = idx;
        this.profit = profit;
       }

       int getTime(){
        return time;
       }

       double getProfit(){
        return profit;
       }

       public String toString(){
        return "("+idx+","+time+","+profit+")";
       }
    }

    public static int[] getMaxProfit(int time[],double profit[]){
        if(time.length != profit.length){
            return new int[0];
        }
         ArrayList<Job> jobs = new ArrayList<>();
         for(int i = 0;i<time.length;i++){
            jobs.add(new Job(i,time[i], profit[i]));
         }

         jobs.sort(Comparator.comparingDouble(Job::getProfit).reversed().thenComparing(Job::getTime));
         int schedule[] = new int[jobs.size()];
         for(int i = 0;i<jobs.size();i++){
            schedule[i] = jobs.get(i).idx;
         }
         System.out.println(jobs);
         return schedule;
    }

}

class MinimumPlatform{
    static class Train{
        LocalTime arrivalTime ,departureTime;
        Train(LocalTime arrivalTime,LocalTime departureTime){
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }

        public String toString(){
            return "("+arrivalTime+","+departureTime+")";
        }
    }

    public static int checkFreePlatform(Train temp,Map<Integer,Train> map){
        for(int i =1;i<=map.size();i++){
            if(temp.arrivalTime.compareTo(map.get(i).departureTime)>0){
                return i;
            }
        }
        return map.size()+1;
    }
    public static int getMinimumPlatform(LocalTime arrivalTime[],LocalTime departureTime[]){
        if(arrivalTime.length != departureTime.length){
            System.out.println("Some data of arrival time or departure time is missing");
            return -1;
        }

        int platform =1;
        ArrayList<Train> trainList = new ArrayList<>();
        for(int i = 0;i<arrivalTime.length;i++){
           trainList.add(new Train(arrivalTime[i], departureTime[i]));
        }

        trainList.sort(Comparator.comparing((Train t)->t.arrivalTime).thenComparing((Train t)->t.departureTime));
        System.out.println(trainList);
        Map<Integer,Train> map = new TreeMap<>();
        map.put(1, trainList.get(0));
        for(int i = 1;i<trainList.size();i++){
             int free = MinimumPlatform.checkFreePlatform(trainList.get(i), map) ;
             Train curr = trainList.get(i);
              if(free<= map.size()){
                  map.replace(free, curr);
              }else{
                  map.put(free,curr);
              }
        }
      for(Map.Entry<Integer,Train> e : map.entrySet()){
          System.out.println(e.getKey());
          System.out.println(e.getValue());
        }
            return map.size();
    }

}
public class Jan4 {
   public static void main(String[] args) {
    // Implement a Java program to select maximum number of activities (Activity Selection Problem).
    int startTime[] = {0,1,3,5,3,4,7};
    int finishTime[] = {10,8,9,6,4,5,8};
     System.out.println(ActivitySelection.maxActivity(startTime, finishTime));

    //  Write a Java program to find minimum number of coins for a given amount.
    int amount = 159;
     System.out.println(MinimumCoin.minimumCoin(amount));

    //  Implement fractional knapsack problem using greedy approach.
    double values[] = {60,40,50,80};
    double weights[] = {10,20,60,70};
   System.out.println( String.format("%.2f",FractionalKnapsack.getMaxValue(150,values,weights)));

//    Write a Java program to schedule jobs to maximize profit.
    int time[] = {9,7,6,10,12,3};
    double profit[] = {23,45,23,49,46,50}; 
   int res[] =  MaximumProfit.getMaxProfit(time, profit);
   for (int i : res) {
      System.out.println(i);
   }
  
   
//    Implement minimum number of platforms required for trains.
 LocalTime arrivalTime[] = {
    LocalTime.of(17, 30, 0),
    LocalTime.of(17,35,0),
       LocalTime.of(10,20,0),
        LocalTime.of(10,35,0),
        LocalTime.of(10, 50, 0)
};

 LocalTime departureTime[] = {
    LocalTime.of(17, 50, 0),
    LocalTime.of(18,0,0), 
    LocalTime.of(10,55,0),
       LocalTime.of(11,10,0),
        LocalTime.of(11,20,0),
};

    MinimumPlatform.getMinimumPlatform(arrivalTime, departureTime);
   }  
}

import java.util.ArrayList;

class ActivitySelection{
    private static class Activity{
        int idx,startTime,finishTime;
        Activity(int idx,int startTime,int finishTime){
            this.idx = idx;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }
    }

    public static void maxActivity(int [] startTime,int []finishTime){
          if(startTime.length != finishTime.length){
            System.out.println("Some start time or finish time data are missing !! ");
            return;
          }

          ArrayList<Activity> activities = new ArrayList<>();
          for(int i = 0;i<finishTime.length;i++){
            
          }
    }

}
public class Jan4 {
   public static void main(String[] args) {
    // Implement a Java program to select maximum number of activities (Activity Selection Problem).
    int startTime[] = {0,1,3,5,5,9,8};
    int finishTime[] = {10,8,9,6,4,5};



   }    
}

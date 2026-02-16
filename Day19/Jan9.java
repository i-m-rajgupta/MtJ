import java.util.ArrayList;
import java.util.Arrays;

public class Jan9 {
    static class Job implements Comparable<Job>{
        int id;
        double profit;
        int deadline;
        Job(int id,double profit,int deadline){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public int compareTo(Job e){
           return Double.compare(e.profit, this.profit);
        }

        public String toString(){
            return "Job ("+id+","+profit+","+deadline+")";
        }
    }

    public static void jobSequence(int maxTime,int profit[],int deadline[]){
        if(profit.length == 0 || profit.length != deadline.length){
            return;
        }
        
        Job jobs[] = new Job[profit.length];
        for(int i =0;i<jobs.length;i++){
            jobs[i] = new Job(i+1, profit[i], deadline[i]);
        }
        
        Arrays.sort(jobs);
            for(int i =0;i<jobs.length;i++){
            System.out.println(jobs[i]);
        }
        int time = 0;
        ArrayList<Job> selected = new ArrayList<>();
        for(int i =0;i<jobs.length;i++){
         if(time <= jobs[i].deadline){
            selected.add(jobs[i]);
            time++;
         }
         if(time == maxTime){
            break;
         }
        }
        System.out.println(selected);
    }
    public static void main(String[] args) {
    //  Implement job sequencing with deadlines.   
  int profit[] = {100,20,50,40,60,90};
  int deadline[] = {3,1,4,3,2,2};
    jobSequence(3,profit, deadline);

    // Write a Java program to minimum spanning tree using Kruskal’s algorithm.
    
    }
}

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Dec24 {

     static class Process{
        int burstTime;
        int processId;
        Process(int burstTime,int processId){
            this.burstTime = burstTime;
            this.processId = processId;
        }
    }

    public static void fcfs(int []arr){
        if(arr.length == 0){
            return;
        }

        Queue<Process> processQueue = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            processQueue.offer(new Process(arr[i], i+1));
        } 

        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        int currentTime = 0;
        int totalWaitingTime = 0,totalTurnAroundTime =0;

        while (!processQueue.isEmpty()) {
            int waitingTime = currentTime;
            Process p  = processQueue.poll();
            int turnAroundTime = waitingTime+p.burstTime;

            System.out.println("P"+p.processId+"\t\t"+p.burstTime+"\t\t"+waitingTime+"\t\t"+turnAroundTime);
            totalTurnAroundTime += turnAroundTime;
            totalWaitingTime += waitingTime;
            currentTime += p.burstTime;
        }

        double avgWaitingTime = (double) totalWaitingTime / arr.length;
        double avgTurnaroundTime = (double) totalTurnAroundTime / arr.length;

        System.out.printf("\nAverage Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
    }

    static class printJob{
        int jobId ;
        int numPages;
        printJob(int jobId,int numPages){
            this.jobId = jobId;
            this.numPages = numPages;
        }

        @Override
        public String toString(){
           return "(Job ID "+jobId+" , Pages : "+numPages +") ";
        }
    }

    public static void printPages(int numPages[]){
         if(numPages.length == 0){
            return;
         }

         Queue<printJob> printQueue = new LinkedList<>();
            for(int i=0;i<numPages.length;i++){
            printQueue.offer(new printJob( i+1,numPages[i]));
        } 

         while(!printQueue.isEmpty()){
            printJob p = printQueue.poll();
            System.out.println("Printing ID "+p.jobId+" with "+p.numPages+" numbers of pages ");
            if(!printQueue.isEmpty()){
                       System.out.println("Total Job Pending to print "+printQueue.size());
            System.out.println("Next job "+printQueue.peek());
            }
         }
    }

    static class Customer{
        int customerID;
        int serviceTime;
        Customer(int customerID,int serviceTime){
            this.customerID = customerID;
            this.serviceTime = serviceTime;
        }
 
        @Override
        public String toString(){
        return "(Customer ID "+customerID+" , Service Time : "+serviceTime +")";
        }
    }

    public static void bankQueue(int serviceTime[]){
        if(serviceTime.length == 0){
            return;
        }

        Queue<Customer> customerQueue = new LinkedList<>();
        for(int i =0;i<serviceTime.length;i++){
            customerQueue.offer(new Customer(i+1, serviceTime[i]));
        }

        while (!customerQueue.isEmpty()) {
              Customer c = customerQueue.poll();
            System.out.println("Providing service to Customer with customer ID "+c.customerID+" with "+c.serviceTime+" Service Time ");
            if(!customerQueue.isEmpty()){
                       System.out.println("Total Pending Customer "+customerQueue.size());
            System.out.println("Next customer  "+customerQueue.peek());
            }
        }
    }

    public class MultipleQueue{
        private Map <String,Queue<Integer> queues;
        
    }
    public static void main(String[] args) {
        // Write a Java program for CPU scheduling using queue.
         int burstTime[] = { 5,8,7,6,4,9};
         fcfs(burstTime);

        //  Write a Java program to simulate a printer queue system.
        int numPages[] = {5,7,9,2,7};
         printPages(numPages);

        //  Write a Java program for bank counter queue simulation.
        int serviceTime[] = {10,8,14,15};
        bankQueue(serviceTime);

        //Write a Java program to handle multiple queues.

    }
}

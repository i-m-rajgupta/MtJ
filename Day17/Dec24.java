import java.util.*;

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

    public static class MultipleQueue<T>{
        private Map<String,Queue<T>> queues;
        
        MultipleQueue(){
            queues = new HashMap<>();
        }

        public boolean createQueue(String name){
             if(queues.containsKey(name)){
                System.out.println(name+" queue already exists ");
                return false;
             }
             queues.put(name, new ArrayDeque<>());
             System.out.println("Queue "+name+" Created");
             return true;
        }
        
        public boolean deleteQueue(String name){
           if(queues.remove(name)== null){
            System.out.println("Queue "+name+" does not exists. ");
            return false;
           }
               System.out.println("Queue "+name+" Deleted ");
           return true;
        }

        public boolean enqueueValue(String name,T data){
             Queue<T> temp = queues.get(name);
             if(temp == null){
                System.out.println(name+" does not exists . ");
                 return false;
             }
             temp.offer(data);
             System.out.println(data+" added to "+name);
             return true;
        }

        public T dequeValue(String name){

            Queue<T> temp = queues.get(name);
            if(temp == null){
                System.out.println("Queue "+name+" does not exists ");
                return null;
            }

            if(temp.isEmpty()){
                System.out.println("Queue "+name+" is empty");
            }

            T data =temp.poll();
            System.out.println(data+" deleted from "+name);
            return data;
        }
    }

    static class ThreadSafeQueue<T>{
        private int capacity;
        private final Queue<T> queue;

        ThreadSafeQueue(int capacity){
            queue = new LinkedList<>();
            this.capacity = capacity;
        }

        public synchronized void enqueue(T data) throws InterruptedException{
            while (queue.size() == capacity) {
                 wait();
            }

            queue.offer(data);
            notifyAll();
        }

        public synchronized T dequeue() throws InterruptedException{
           while (queue.isEmpty()) {
               wait();
           }

           T data = queue.poll();
           notifyAll();
           return data;
        }

        public synchronized int size(){
            return queue.size();
        }
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
        MultipleQueue<String> queues = new MultipleQueue<>();
        queues.createQueue("Counter 1");
        queues.createQueue("Counter 2");
        queues.enqueueValue("Counter 1", "Ram");
        queues.deleteQueue("Counter 1");

        //Write a Java program to implement thread-safe queue.
         ThreadSafeQueue<Integer> q = new ThreadSafeQueue<>(3);

         Thread producer = new Thread(()->{
            try{
               for(int i =0;i<=10;i++){
                q.enqueue(i);
                System.out.println("Produced "+i);
               }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
         }) ;
         producer.start();

         Thread consumer = new Thread(()->{
            try{
                for(int i=0;i<= 10;i++){
                    int data = q.dequeue();
                    System.out.println("Consumed "+data);
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
         });
         consumer.start();

        //  “Why is Consumed 5 printed before Produced 5?”
        // “Because thread scheduling is non-deterministic.
// The item was produced before consumption, but the print statements executed in a different order.”
    }
}

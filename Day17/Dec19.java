import java.util.Scanner;

class MyQueue{
    private int[] queue ;
    private final int capacity;
    private int front,rear;

    MyQueue(int n){
        capacity = n;
        queue = new int[n];
        front = 0;
        rear = -1;
    }

    public boolean isFull(){
        return rear == capacity-1;
    }

    public boolean isEmpty(){
        return front>rear;
    }

    public int count(){
        return !isEmpty()?(rear-front+1):0;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    public int lastElement(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[rear];
    }

    public void enqueue(int data){
        if(isFull()){
           System.out.println("Queue Overflows ");
           return;
        }

        queue[++rear] = data;
        System.out.println(data+" Enqueued");
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflows");
            return;
        }

        System.out.println(queue[front++]+" Dequeued ");
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Queue Elements ");
        for(int i= front;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
}
public class Dec19 {
    public static void performTask(MyQueue q,int choice){
       if(choice == 0){
        return;
       }
 
       switch (choice) {
        case 1:
             System.out.println("Enter the data for enqueue: ");
            Scanner sc = new Scanner(System.in);
            int data = sc.nextInt();
             q.enqueue(data);
            break;
        case 2:
            q.dequeue();
            break;
             case 3:
            q.display();
            break;
        case 4:
            System.out.println("Queue front data : "+q.peek());
            break;
             case 5:
            System.out.println("Queue last stored data : "+q.lastElement());
            break;
        case 6:
            System.out.println("Total elements present in queue : "+q.count());
            break;
             case 7:
            System.out.println("Queue is full : "+q.isFull());
            break;
        case 8:
            System.out.println("Queue is Empty : "+q.isEmpty());
            break;
        default:
            System.out.println("Invalid choice ");
            break;
       }
       System.out.println();
    }
   public static void main(String[] args) {
    // Implement a menu-driven program for queue operations using array.
     System.out.println("Welcome to the Menu-Driven Program for Queue ");
     System.out.println("Enter the size for element storing in queue ");
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     MyQueue q = new MyQueue(n);
     int choice;
     do{
           System.out.println("\n--- Queue Operations Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Peek (Front element)");
            System.out.println("5. Last Element");
            System.out.println("6. Count Elements");
            System.out.println("7. Check if Full ");
               System.out.println("8. Check if Empty ");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            performTask(q, choice);
     }while(choice != 0);

     sc.close();
   }    
}

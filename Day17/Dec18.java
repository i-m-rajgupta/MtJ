import java.util.Queue;

class MyQueue1{
    private int[] queue ;
    private final int capacity;
    private int front,rear;
    MyQueue1(int n){
        capacity = n;
        queue = new int[n];
        front = 0;
        rear = -1;
    }

    public void enqueue(int data){
        if(rear == capacity-1){
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = data;
        System.out.println(data+" Enqueued ");
    }

    public void dequeue(){
        if(front>rear){
            System.out.println("Queue Underflow ");
            return;
        }
        System.out.println(queue[front++]+" Dequeued ");
    }

    public void display(){
        if(front>rear){
            System.out.println("Queue is Empty");
            return;
        }
        for(int i= front;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }

    public void isFullOrEmpty(){
        if(front>rear){
            System.out.println("Queue is Empty");
        }else if(rear == capacity-1){
             System.out.println("Queue is full");
        }else{
            System.out.println("Queue is neither full nor Empty");
        }
    }

    public int count(){
        return (front<=rear)?(rear-front+1):0;
    }

    public int peek(){
        if(front>rear){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    public int lastElement(){
        if(front>rear){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[rear];
    }
}

class MyQueue2{
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private Node head,tail;
    MyQueue2(){
        head = null;
        tail = null;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
       if(head == null){
         head = tail = newNode;
       }else{
        tail.next = newNode;
        tail = newNode;
       }
         System.out.println(data+" Enqueued");   
    }

    public void dequeue(){
        if(head == null){
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(head.data+" Dequeued");
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }
    }
    
    public int peek(){
        if(head == null){
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.data;
    }
    public void display(){
        if(head == null){
            System.out.println("Queue is empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
public class Dec18 {
  public static void main(String[] args) {
    // Implement a Queue using array in Java (enqueue, dequeue, display).
        MyQueue1 q = new MyQueue1(10);
        q.dequeue();
        q.enqueue(7);
        q.enqueue(5);
        q.display();

    //  Implement a Queue using custom Linked List in Java.
       MyQueue2 q2 = new MyQueue2();
       q2.dequeue();
       q2.enqueue(5);
       q2.dequeue();
       q2.enqueue(7);
       q2.enqueue(8);
       q2.display();
       q2.dequeue();
       System.out.println(q2.peek());

    //    Write a Java program to check if a queue is empty or full.
        q.isFullOrEmpty();

        // Write a Java program to find the no. of elements in a queue.
        System.out.println(q.count());

        // Write a Java program to find the front and rear elements of a queue.
        System.out.println(q.peek());
        System.out.println(q.lastElement());
  }    
}

import java.util.*;

public class Dec20 {
     static class MyStack{
     static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
     }
    private int size =0;
    private Node head = null;
     public void push(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head =  newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
     }

     public int pop(){
        if(head == null){
            return -1;
        }

          int data;
          data = head.data;
          head = head.next;
          size--;
          return data;
     }

     public int peek(){
        if(head== null){
            return -1;
        }
        return head.data;
     }

     public boolean isEmpty(){
        return head == null;
     }

     public int size(){
        return size;
     }
     }
     
     static class MyQueue{
        private MyStack inStack;
        private MyStack outStack;
        MyQueue(){
            inStack = new MyStack();
            outStack = new MyStack();
        }

        public void enqueue(int data){
            inStack.push(data);
            System.out.println(data+" enqueued");
        }

        private void shiftQueue(){
            if(outStack.isEmpty()){
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        public int dequeue(){
            if(outStack.isEmpty()){
            shiftQueue();
            }
            if(outStack.isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            System.out.println(outStack.peek()+" dequeued");
            return outStack.pop();
        }

        public int size(){
           return inStack.size() + outStack.size();
        }

        public void display(){
            if(outStack.isEmpty() && inStack.isEmpty()){
                return ;
            }
            MyStack temp = new MyStack();
         
               while (!outStack.isEmpty()) {
               int data = outStack.pop();
              System.out.print(data+" ");
              temp.push(data);
           }
           while (!temp.isEmpty()) {
            outStack.push(temp.pop()); 
           }

             while (!inStack.isEmpty()) {
            temp.push(inStack.pop()); 
           }
          while (!temp.isEmpty()) {
               int data = temp.pop();
              System.out.print(data+" ");
              inStack.push(data);
           }
         
       System.out.println();
        }
     }

     static class MyQueue2{
        Queue<Integer> q = new LinkedList<>();
        public boolean enqueue(int data){
            return q.offer(data);
        }

        public int dequeue(){
            return q.poll();
        }

        public int peek(){
            return q.peek();
        }
     }
    public static void main(String[] args) {
        // Implement a Queue using two stacks in Java.
        MyQueue q = new MyQueue();
        q.enqueue(5);
        q.dequeue();
        q.enqueue(8);
        q.display();
        System.out.println(q.size());

        // Implement a queue using Queue interface and LinkedList.
         MyQueue2 q2 = new MyQueue2();
         System.out.println(q2.enqueue(5));
         System.out.println(q2.dequeue());
         System.out.println(q2.enqueue(8));
         System.out.println(q2.peek());

        //  Implement a queue using ArrayDeque.
         Queue<Integer> q3 = new ArrayDeque<>();
         System.out.println(q3.offer(3));
         System.out.println(q3.poll());
         System.out.println(q3.offer(4));
         System.out.println(q3.peek());

        
    }
}

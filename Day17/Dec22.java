import java.util.*;

public class Dec22 {
    public static boolean isPalindrome(Queue<Integer> q){
      if(q.isEmpty() || q.size() == 1){
        return true;
      }

      int size = q.size();
      int mid = ((size/2)-1);
      Queue<Integer> restore = new ArrayDeque<>();
      ArrayDeque<Integer> temp = new ArrayDeque<>();
      int i = 0;
      while (i<= mid) {
         int data = q.poll();
         temp.push(data);
         restore.offer(data);
         i++;
      }
   
      if(size %2 != 0){
        restore.offer(q.poll());
      }
   
     boolean palindrome = true;
      while (!q.isEmpty()) {
         if(!q.peek().equals(temp.pop())){
           palindrome = false;
         }
         restore.offer(q.poll());
      }

      while (!restore.isEmpty()) {
        q.offer(restore.poll());
      }
      return palindrome;
    }

    public static void removeDuplicate(Queue<Integer> q){
        if(q.isEmpty() || q.size() == 1){
            return;
        }
        
        int idx = 0;
        int arr[] = new int[q.size()];
      
        while (!q.isEmpty()) {
              boolean isFound = false;
            for(int i = 0;i<idx;i++){
              if(q.peek().equals(arr[i])){
                isFound = true;
                break;
              }
            }
            if(!isFound){
                arr[idx++] = q.poll(); 
            }else{
                q.poll();
            }
        }
  
        for(int i =0;i<idx;i++){
            q.offer(arr[i]);
        }
    }

    static class MyStack<T>{
        private  Queue<T> pushq ;
      private  Queue<T> popq;
      private int size;
        MyStack(){
            pushq = new ArrayDeque<>();
            popq = new ArrayDeque<>();
            size = 0;
        }

        public boolean isEmpty(){
            return size == 0 ;
        }
        public void push(T data){
           pushq.offer(data);
        }

        private void shiftStack(){
            ArrayList<T> arr = new ArrayList<>();
            while (!popq.isEmpty()) {
                arr.add(0,popq.poll());
            }
            while (!pushq.isEmpty()) {
                arr.add(pushq.poll());
            }
            while (!arr.isEmpty()) {
                popq.offer(arr.remove(arr.size()-1));
            }
        }

        public T pop(){
                if(!pushq.isEmpty()){
                shiftStack();
                }
              if(popq.isEmpty()){
                System.out.println("Stack is empty");
                return null;
              }
              return popq.poll();
        }

        public T peek(){
                if(!pushq.isEmpty()){
                shiftStack();
                }
              if(popq.isEmpty()){
                System.out.println("Stack is empty");
                return null;
              }
              return popq.peek();
        }

        public void display(){
            if(!pushq.isEmpty()){
            shiftStack();
            }
            Queue<T> temp = new ArrayDeque<>();
             while (!popq.isEmpty()) {
                T data = popq.poll();
                System.out.print(data+" ");
                temp.offer(data);
             }
             while (!temp.isEmpty()) {
                popq.offer(temp.poll());
             }
             System.out.println();
        }
    }

    static class MinPriorityQueue{
        private ArrayList<Integer> heap ;
         
         MinPriorityQueue(){
          heap = new ArrayList<>();
         }

         public int parent(int i){
            return (i-1)/2;
         }

         public int left(int i){
          return 2*i+1;
         }

         public int right(int i){
          return 2*i+2;
         }

         public void swap(int i,int j){
          int temp = heap.get(i);
          heap.set(i, heap.get(j));
          heap.set(j, temp);
         }

         public void heapifyUp(int index){
              while (index>0 && ( heap.get(index) < heap.get(parent(index)))) {
                swap(index,parent(index));
                index = parent(index);
              }
         }

         public void heapifyDown(int index){
            int smallest = index;

            int left = left(index);
            int right = right(index);

            if(left<heap.size() && heap.get(smallest) > heap.get(left) ){
              smallest = left;
            }

            if(right<heap.size() && heap.get(smallest) > heap.get(right)){
              smallest = right;
            }

            if(smallest != index){
              swap(index, smallest);
              heapifyDown(smallest);
            }
         }

         public void offer(int data){
             heap.add(data);
             heapifyUp((int)heap.size()-1);
         }

         public int poll(){
             if(heap.isEmpty()){
              throw new NoSuchElementException("Queue is Empty");
             }
            int min = heap.get(0);
            int last = heap.remove(heap.size()-1);
            if(!heap.isEmpty()){
              heap.set(0, last);
              heapifyDown(0);
            }
            return min;
         }

         public int peek(){
          if(heap.isEmpty()){
            throw new NoSuchElementException("Queue is Empty");
          }
          return heap.get(0);
         }

         public void display(){
          for(int i =0;i<heap.size();i++){
            System.out.print(heap.get(i)+" ");
          }
          System.out.println();
         }
    }

    static class  MaxPriorityQueue<T extends Comparable<T>> {
          private ArrayList<T> heap;
          MaxPriorityQueue(){
            heap = new ArrayList<>();
          }

          public int parent(int i){
            return (i-1)/2;
          }

          public int left(int i){
            return 2*i+1;
          }

          public int right(int i){
            return 2*i+2;
          }

          public void swap(int i,int j){
           T temp = heap.get(i);
           heap.set(i, heap.get(j));
           heap.set(j, temp);
          }

          public void heapifyUp(int index){
             while (index>0 && heap.get(index).compareTo(heap.get(parent(index))) > 0) {
              swap(index, parent(index));
              index = parent(index);
             }
          }

          public void heapifyDown(int index){
              int largest = index;
              int leftChild = left(index);
              int rightChild = right(index);
              if(leftChild<heap.size() && heap.get(leftChild).compareTo(heap.get(largest))>0){
                largest = leftChild;
              }
              if(rightChild<heap.size() && heap.get(rightChild).compareTo(heap.get(largest))>0){
                largest = rightChild;
              }
              if(largest != index){
                swap(largest, index);
                heapifyDown(largest);
              }
          }

          public void offer(T data){
            heap.add(data);
            heapifyUp(heap.size()-1);
          }

          public T poll(){
            if(heap.isEmpty()){
              throw new NoSuchElementException("Queue is Empty");
            }
            
            T max = heap.get(0);
            T last = heap.remove(heap.size()-1);
            if(!heap.isEmpty()){
              heap.set(0, last);
              heapifyDown(0);
            }
            return max;
          }

          public T peek(){
            if(heap.isEmpty()){
              throw new NoSuchElementException("Queue is empty");
            }
            return heap.get(0);
          }

          public int size(){
            return heap.size();
          }

          public boolean isEmpty(){
            return heap.isEmpty();
          }
          public void display(){
            for(int i = 0;i<heap.size();i++){
              System.out.print(heap.get(i)+" ");
            }
            System.out.println();
          }
    }

    static class MyDeque{
       private int q[];
       private final int capacity;
       private int front ,rear;
       MyDeque(int n){
        q = new int[n];
        capacity = n;
        front = -1;
        rear = -1;
       }

       public boolean isEmpty(){
         return front == -1;
       }

       public boolean isFull(){
        return (front == 0 && rear == capacity-1) || front == rear+1;
       }
       public void insertAtBeginning(int data){
           if(isFull()){
             System.out.println("Queue is Full");
          return;
           }

          if(isEmpty()){
            front = rear = 0;
          }else if(front == 0){
            front = capacity-1;
          }else{
            front--;
          }

          q[front] = data;
       }

       public void insertAtEnd(int data){
        if(isFull()){
          System.out.println("Queue is Full");
          return;
        }

        if(isEmpty()){
          front = rear = 0;
        }else if(rear == capacity-1){
          rear =0;
        }else{
          rear++;
        }

        q[rear] =data;
       }

       public int deleteAtBeginning(){
          if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
          }

          int data = q[front];
          if(front == rear){
             front = rear = -1;
          }else if(front == capacity-1){
              front = 0;
          }else{
            front++;
          }
        return data;
       }

       public int deleteAtEnd(){
        if(isEmpty()){
          System.out.println("Queue is Empty ");
          return -1;
        }

        int data = q[rear];

        if(front == rear){
          front = rear = -1;
        }else if(rear == 0){
           rear = capacity-1;
        }else{
          rear--;
        }
         return data;
       }

       public int peek(){
        if(isEmpty()){
          System.out.println("Queue is Empty");
          return -1;
        }
        return q[front];
       }

       public void display(){
        if(isEmpty()){
          System.out.println("Queue is Empty");
          return;
        }

        int i = front;
        while(true){
          System.out.print(q[i]+" ");
          if(i == rear){
            break;
          }
          i = (i+1)%capacity;
        }
        System.out.println();
       }
    }
    public static void main(String[] args) {
        // Write a Java program to check if a queue is palindrome.
        Queue<Integer> q = new ArrayDeque<>();
        System.out.println(isPalindrome(q));
        q.offer(7);
        System.out.println(isPalindrome(q));
        q.offer(7);
          System.out.println(isPalindrome(q));
          q.offer(1);
          System.out.println(isPalindrome(q));

        Queue<Integer> q2 = new ArrayDeque<>();
        q2.offer(1);
        q2.offer(2);
             q2.offer(3);
        q2.offer(3);
             q2.offer(2);
           q2.offer(1);
        System.out.println(isPalindrome(q2));

        // Write a Java program to remove duplicate elements from a queue.
        Queue<Integer> q3 = new ArrayDeque<>();
        q3.offer(1);
        q3.offer(1);
        q3.offer(1);
               q3.offer(3);
        q3.offer(2);
        q3.offer(2);
        System.out.println(q3);
        removeDuplicate(q3);
        System.out.println(q3);

        // Implement a Stack using two queues in Java.
         MyStack<Integer> s = new MyStack<>();
        s.push(5);
        s.push(7);
        System.out.println(s.peek());
        s.push(8);
        System.out.println(s.peek());
        s.display();
        s.pop();
        s.display();

        // Implement a Priority Queue in Java.
         MinPriorityQueue q4 = new MinPriorityQueue();
         q4.offer(5);
         q4.offer(7);
         q4.offer(4);
         System.out.println(q4.peek());
         q4.poll();
         System.out.println(q4.peek());

         MaxPriorityQueue<String> q5 = new MaxPriorityQueue<>();
         q5.offer("Ram");
         q5.offer("Mahesh");
         q5.offer("shiv");
         q5.offer("anu");
         q5.offer("Yash");
         System.out.println(q5.poll());
         System.out.println(q5.peek());
         q5.display();

         MaxPriorityQueue<Integer> q6 = new MaxPriorityQueue<>();
         q6.offer(2);
         q6.offer(8);
         q6.offer(4);
         q6.offer(1);
         q6.offer(7);
         q6.offer(6);
         q6.offer(9);
         q6.display();
         q6.poll();
         q6.display();

        //Write a Java program to implement Deque (Double Ended Queue).

        // Modulus is optional. Circular behavior can be implemented either using % or boundary conditions — both are correct.
         MyDeque q7 = new MyDeque(10);
         q7.insertAtEnd(7);
         q7.insertAtBeginning(4);
         q7.deleteAtBeginning();
         q7.deleteAtEnd();
         q7.insertAtEnd(5);
             q7.display();
      }
}

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class ProducerConsumerWithBuffer {

    static class Buffer<T> {
        private T[] buffer;
        private final int capacity;
        private int front, rear, size;

        @SuppressWarnings("unchecked")
        Buffer(int n) {
            capacity = n;
            buffer = (T[]) new Object[n];
            front = 0;
            rear = 0;
            size = 0;
        }

        public synchronized void add(T item) throws InterruptedException {
            while (isFull()) {
                System.out.println("Producer waits until space is available in the buffer");
                 while (isFull()) {
                 wait();
                 }
            }
            buffer[rear] = item;
            rear = (rear + 1) % capacity;
            size++;
            notifyAll();
        }

        public synchronized T remove() throws InterruptedException {
            while (isEmpty()) {
                System.out.println("Consumer waits until an item is available in the buffer");
                wait();
            }
            T item = buffer[front];
            front = (front + 1) % capacity;
            size--;
            notifyAll(); 
            return item;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    static class Producer<T> implements Runnable {
        private final Buffer<T>buffer;
        private final java.util.function.Supplier<T> generator;
        private final int maxItems;
        private final T endSignal;

        Producer(Buffer<T> buffer,java.util.function.Supplier<T> generator,int maxItems,T endSignal) {
            this.buffer = buffer;
            this.generator = generator;
            this.maxItems = maxItems;
            this.endSignal = endSignal;
        }

        @Override
        public void run() {
            try {
                for(int i =0;i<maxItems;i++){
                    T value = generator.get();
                    buffer.add(value);
                    System.out.println("Produced: " + value);
                    Thread.sleep(500); 
                }
                System.out.println("Producer produces "+maxItems+" Items successfully .");
                buffer.add(endSignal);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer<T> implements Runnable {
        private final Buffer<T> buffer;
        private final T endSignal;

        Consumer(Buffer<T> buffer,T endSignal) {
            this.buffer = buffer;
            this.endSignal  = endSignal;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    T value = buffer.remove();
                    
                    if(value.equals(endSignal)){
                        System.out.println("Consumer consumed all the items successfully .");
                        break;
                    }
                    System.out.println("Consumed: " + value);
                    Thread.sleep(800); 
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class Dec23 {
    public static void reverse(Queue<Integer> q ,int k){
        if(q.isEmpty() || q.size() == 1 || k <= 0 || k > q.size()){
            return;
        }
       
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<k;i++){
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        for(int i = 0;i<q.size()-k;i++){
            q.offer(q.poll());
        }
    }

    public static int middle(Queue<Integer> q){
       if(q.size() == 0){
        return -1;
       }
        int size = q.size();
       int mid =  q.size()/2;
        for(int i =0;i<mid;i++){
         q.offer(q.poll());
        }
        int data = q.peek();
        for(int i =0;i<size-mid;i++){
            q.offer(q.poll());
        }
        return data;
    }

    public static void rightRotation(Queue<Integer> q,int k){
        if(q.isEmpty() || q.size() ==1||k <=0){
            return;
        }
  
        int size = q.size();
        k = size-(k%size);
        for(int i = 0;i<k;i++){
            q.offer(q.poll());
        }
    }

    public static void leftRotation(Queue<Integer> q,int k){
        if(q.isEmpty() || q.size() == 1|| k<=0){
            return;
        }

        int size = q.size();
        k = (k%size);
       for(int i = 0;i<k;i++){
            q.offer(q.poll());
        }
    }

    public static boolean isSorted(Queue<Integer> q){
        if(q.isEmpty() || q.size() == 1){
            return true;
        }
        boolean sort = true;

        int size = q.size();
        int prev = q.peek();
        q.offer(q.poll());
        for(int i=1;i<size;i++){
            int data = q.poll();
            if(prev>data){
                sort = false;
            }
            prev = data;
            q.offer(data);
        }
        return sort;
    }

    
    public static void main(String[] args) {
        // Write a Java program to reverse first K elements of a queue.
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(5);
        q.offer(7);
        q.offer(8);
        q.offer(6);
        q.offer(9);
        System.out.println(q);
        reverse(q, 1);
        System.out.println(q);

        // Write a Java program to find the middle element of a queue.
        System.out.println(middle(q));
        System.out.println(q);

        // Write a Java program to rotate queue elements by K positions.
        System.out.println("After Right Rotation : ");
        rightRotation(q, 2);
        System.out.println(q);
       
            System.out.println("After Left Rotation : ");
        leftRotation(q,2);
        System.out.println(q);

        //  Write a Java program to check whether queue elements are sorted.
        Queue<Integer> q2 = new ArrayDeque<>();
        q2.offer(-1);
        q2.offer(2);
        q2.offer(3);
        q2.offer(4);
        System.out.println(isSorted(q));
        System.out.println(isSorted(q2));
        System.out.println(q2);

        // Implement a producer-consumer problem using queue in Java.
        ProducerConsumerWithBuffer.Buffer<String> b = new ProducerConsumerWithBuffer.Buffer<>(4);
        AtomicInteger counter = new AtomicInteger();
        String endSignal = "Poison";
        Thread producer = new Thread(new ProducerConsumerWithBuffer.Producer<String>(b, ()->"Item -> "+counter.getAndIncrement(),50,endSignal));
         Thread consumer = new Thread(new ProducerConsumerWithBuffer.Consumer<String>(b,endSignal));

         producer.start();
         consumer.start();

         
    }
}

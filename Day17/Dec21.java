import java.util.*;

public class Dec21 {
    public static void clear(Queue<Integer> q){
         if(q.isEmpty()){
            return;
         }

         while (!q.isEmpty()) {
            q.poll();
         }
    }

    public static void reverse(Queue<Integer> q){
        if(q.isEmpty() || q.size() == 1){
            return;
        }

       Stack<Integer> temp = new Stack<>();
        while (!(q.isEmpty())) {
          temp.push(q.poll());
        }
         
        while (!(temp.isEmpty())) {
          q.offer(temp.pop());
        }
      }

   public static void display(Queue<Integer> q){
           if(q.isEmpty()){
            return;
           }
          Queue<Integer> temp = new ArrayDeque<>();
          while (!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            temp.offer(q.poll());
          }

          while (!temp.isEmpty()) {
            q.offer(temp.poll());
          }
          System.out.println();
   }

   public static void removeEven(Queue<Integer> q){
        Queue<Integer> temp = new ArrayDeque<>();
        while (!q.isEmpty()) {
           if(q.peek()%2 != 0){
              temp.offer(q.poll());
           }else{
            q.poll();
           }
        }

        while (!temp.isEmpty()) {
          q.offer(temp.poll());
        }
   }

   public static boolean search(Queue<Integer> q,int target){
        boolean isFound = false;
        Queue<Integer> temp = new ArrayDeque<>();
        while (!q.isEmpty()) {
           if(q.peek().equals(target)){
            isFound = true;
           }
          temp.offer( q.poll());
        }

        while (!temp.isEmpty()) {
          q.offer(temp.poll());
        }
        return isFound;
   }

   public static Queue<Integer> merge(Queue<Integer> q1,Queue<Integer> q2){
    if(q1.isEmpty() && q2.isEmpty()){
      return new ArrayDeque<>();
    }
    Queue<Integer> merged = new ArrayDeque<>();
      while (!q1.isEmpty()) {
        merged.offer(q1.poll());
      }

      while (!q2.isEmpty()) {
        merged.offer(q2.poll());
      }

      return merged;
   }
  public static void main(String[] args) {
    // Write a Java program to clear all elements from a queue.
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(7);
    q.offer(8);
    clear(q);
    System.out.println(q.peek());
    System.out.println(q.isEmpty());

    // Write a Java program to reverse a queue.
  q.offer(1);
    q.offer(2);
    q.offer(3);
      q.offer(4);
      reverse(q);
      display(q);
       System.out.println(q.peek());

      //  Write a Java program to remove even numbers from a queue.
      removeEven(q);
      display(q);

      // Write a Java program to search an element in a queue.
      System.out.println(search(q, 2));
      System.out.println(search(q, 3));

      // Write a Java program to merge two queues.
      Queue<Integer> res = merge(new ArrayDeque<>(), new ArrayDeque<>());
      Queue<Integer> q2 = new ArrayDeque<>();
      q2.offer(5);
      q2.offer(7);
      display(res);
      display(merge(q, q2));
  
  }    
}

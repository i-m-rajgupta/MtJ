import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class MyStack{
   private  int size;
    private int [] stack;
     private int top ;

   MyStack(int n){
      size = n;
      stack  = new int[size];
      top = -1;
   }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public void push(int x){
        if(isFull()){
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = x;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        return stack[top--];
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        return stack[top];
    }

    public int size(){
        return top+1;
    }

    public void display(){
        for(int i = top; i >= 0 ; i--){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}

class Stack2<T>{
    private static class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }

   private Node<T> top = null;
   private int  size = 0;
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void push(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty ");
        }
        T deletedData = top.data;
        top = top.next;
        size--;
        return deletedData;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty ");
        }
        return top.data;
    }

    public void display(){
        if(isEmpty()){
            return;
        }

        Node<T> curr = top;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class Stack3<T>{
    private  LinkedList<T> stack = new LinkedList<>();
    private int size = 0;
    
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public void push(T data){
        stack.addFirst(data);
        size++;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty ");
        }
        T data = stack.getFirst();
        stack.removeFirst();
        size--;
        return data;
    }

    public T peek(){
         if(isEmpty()){
            throw new RuntimeException("Stack is Empty ");
        }
        return stack.getFirst();
    }

   public void display(){
       System.out.println(stack);
   }
}

class Stack4<T>{
    private ArrayList<T> stack = new ArrayList<>();
     
    public boolean isEmpty(){
        return stack.size() == 0;
    } 

    public int size(){
        return stack.size();
    }
    public void push(T data){
       stack.add(data);
    }
    public T pop(){
         if(isEmpty()){
            throw new RuntimeException("Stack is Empty ");
        }
        T deletedData = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return deletedData;
    }

    public T peek(){
         if(isEmpty()){
            throw new RuntimeException("Stack is Empty ");
        }
        return stack.get(stack.size()-1);
    }

    public void display(){
        System.out.println(stack);
    }
}
public class Dec12 {
    public static void main(String[] args) {
        // . Create a class MyStack that implements a stack of integers using an array.
//  Your class should support the following operations:
// 1.	push(int x) → adds an element to the top
// 2.	pop() → removes and returns the top element
// 3.	peek() → returns the top element without removing it
// 4.	isEmpty() → returns true if the stack is empty
// 5.	isFull() → returns true if the stack is full
// The stack should have a fixed size provided through the constructor.
     
     MyStack s1 = new MyStack(5);
     s1.push(5);
     s1.push(8);
     s1.pop();
     System.out.println(s1.peek());
     s1.push(9);
     s1.push(4);
     s1.push(4);
     s1.push(4);
    System.out.println(s1.isEmpty());
    System.out.println(s1.isFull());
    // Implement the size() in Mystack which Returns the number of elements currently in the stack.
    System.out.println(s1.size());

    // Implement the display() in Mystack which Prints all elements in the stack from top to bottom.
    s1.display();

    //  Implement a stack using a singly linked list.
//  Use the linked list head as the top of the stack.
//  Provide methods for push(), pop(), and peek().
    Stack2<Character> s2 = new Stack2<>();
    s2.push('a');
    s2.push('u');
    s2.push('7');
    s2.display();
    System.out.println(s2.isEmpty());
    s2.pop();
    System.out.println(s2.size());
    System.out.println(s2.peek());

    Stack3<String> s3 = new Stack3<>();
    s3.push("Ram");
    s3.push("Rohan");
    s3.display();
    s3.pop();
    System.out.println(s3.peek());
    s3.pop();
    System.out.println(s3.isEmpty());

    // Create a stack using an ArrayList.
//  Implement the usual stack operations and ensure elements are added/removed from the end of the list.

     Stack4<Double> s4 = new Stack4<>();
     s4.push(5.4);
     System.out.println(s4.peek());
     s4.pop();
    System.out.println(s4.isEmpty());
    s4.push(5.6);
    s4.push(8.6);
    System.out.println(s4.size());
    s4.display();

    // Create a stack using the Java Built-in Stack Class.
    Stack<Integer> s5 = new Stack<>();
    s5.push(56);
    s5.push(68);
    s5.peek();
    s5.capacity();
    s5.pop();
    System.out.println(s5);
    System.out.println(s5.contains(56));
    System.out.println(s5.empty());
// “Stack is a legacy class that extends Vector, causing unnecessary synchronization and poor design. Java recommends using Deque 
    // implementations like ArrayDeque for stack operations because they are faster, cleaner, and follow proper stack abstraction.”
  
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(8);
    stack.push(78);
    System.out.println(stack.pop());
    System.out.println(stack);
    System.out.println(stack.isEmpty());
    System.out.println(stack.contains(8));
}
}

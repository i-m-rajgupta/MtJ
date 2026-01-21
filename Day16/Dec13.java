import java.util.ArrayDeque;
import java.util.Deque;

import javax.sound.midi.Track;

class MyStack<T>{
    private final int capacity;
    private final T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    MyStack(int n){
       capacity = n;
       top = -1;
       stack = (T[]) new Object[capacity];
    }

    public int size(){
      return top+1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    public void push(T data){
        if(isFull()){
           throw new IllegalStateException("Stack is full");
        }
        stack[++top] = data;
    }

    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty ");
        }
        return stack[top--] ;
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        return stack[top];
    }

    public void print(){
        if(isEmpty()){
            return;
        }
        for(int i =top;i>=0;i--){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}

class MyBooks{
    private int top;
    private final String[] stack ;

    MyBooks(int capacity){
        top = -1;
        stack = new String[capacity];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == stack.length -1 ;
    }

    public void placeBooks(String book){
        if(isEmpty()){
            System.out.println("Stack is Empty. Placing the first book..");
        }
        if(isFull()){
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = book;
    }

    public String removeBook(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        return stack[top--];
    }

    public void allBooks(){
        if(isEmpty()){
            return;
        }
        for(int i = top;i>=0;i--){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}
public class Dec13 {

    public static String reverse(String str){
        if(str == null){
            return null;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for(char c :str.toCharArray()){
            stack.push(c);
        }

        StringBuilder res = new StringBuilder(str.length());
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        return res.toString();
    }
    public static void main(String[] args) {
        // Implement a stack using an array to store the daily temperature readings.
         MyStack<Double> temperatureReadings = new MyStack<>(3);
         temperatureReadings.push(5.8);
         temperatureReadings.push(6.9);
         temperatureReadings.push(8.7);
         temperatureReadings.pop();
         temperatureReadings.print();

        //  Push and pop items from a grocery basket (simulate shopping).
        MyStack<String> groceryItems = new MyStack<>(100);
        groceryItems.push("Milk");
        groceryItems.push("Bread");
        groceryItems.push("Jam");
        groceryItems.print();
        groceryItems.pop();
        System.out.println(groceryItems.peek());

        // Check if the stack of books is empty before placing a new book.
       MyBooks book = new MyBooks(5);
       book.placeBooks("Java");
       book.removeBook();
       book.placeBooks("DSA");
       book.placeBooks("DBMS");
       book.allBooks();

    //    Track customer tokens in a bank queue using a stack and print the top token.
       MyStack<Integer> tokens = new MyStack<>(5);
       tokens.push(101);
       tokens.push(102);
       tokens.push(103);
       System.out.println(tokens.peek());

    //    Convert a string to reverse order using a stack.
       System.out.println(reverse("Jar"));
    }
}

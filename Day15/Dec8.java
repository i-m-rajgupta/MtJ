import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList{
    Node head ;

    public void print(){
        if(head == null){
            System.out.println("No element exists in the linked list. ");
            return;
        }

        System.out.print(head.data);
         Node curr= head;
        while (curr.next != null) {
            System.out.print("->"+curr.next.data);
            curr = curr.next;
        }
        System.out.println();
    }
   public void insertAtEnd(int data){
    if(head == null){
        Node newNode = new Node(data);
      head = newNode;
      return;
    }
    Node curr = head;
      while ( curr.next != null ) {
        curr = curr.next;
      }
      Node newNode = new Node(data);
      curr.next = newNode;
   }

   public void insertAtBeginning(int data){
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
   }

   public void insertAtPosition(int data,int pos){
    if(pos <0){
        System.out.println("Invalid Position ");
        return;
    }
    if(pos == 0){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return;
    }

    int count =0;
    Node curr = head;
    while (count != pos-1) {
        if(curr == null){
            System.out.println("Position out of bounds ");
            return;
        }
        curr = curr.next;
        count++;
    }
    Node newNode = new Node(data);
    Node temp = curr.next;
    curr.next = newNode;
    newNode.next = temp;
   }

   public int delete(int data){
    int deletedData = 0;
    if(head == null){
        System.out.println("List is empty !!");
        return -1;
    }
    if(head.data == data){
        deletedData = head.data;
        Node temp = head.next;
        head = temp;
        return deletedData;
    }

    Node prev = head;
    Node curr = head.next;
    while (curr != null) {
        if(curr.data == data){
            deletedData = curr.data;
           Node temp = curr.next;
           prev.next = temp;
           return deletedData;
        }
        prev = curr;
        curr = curr.next;
    }

    System.out.println("Element not found !! ");
    return -1;
   }

   public int search(int data){
    if(head == null ){
        System.out.println("List is empty !!");
        return -1;
    }

    int pos = 0;
    Node curr = head;
    while (curr != null) {
        if(curr.data == data){
          return pos;
        }
        curr = curr.next;
        pos++;
    }
    System.out.println("Element not found ");
    return -1;
   }

   public void reverse(){
    if(head == null){
        System.out.println("No element exists ");
        return;
    }

    if(head.next == null){
        System.out.println("Reverse Linked list ");
        print();
        return;
    }

    Node prev = null;
    Node curr = head;
    while (curr != null) {
       Node nextTemp = curr.next;
       curr.next =prev;
       prev = curr;
       curr = nextTemp;
    }

    head = prev;
     System.out.println("Reverse Linked list ");
        print();
   }

   public int count(){
    int count = 0;
    Node curr = head;
    while (curr != null) {
      curr = curr.next;
      count++;  
    }

    return count;
   }
}
public class Dec8 {
   public static void main(String[] args) {
    // Create a class LinkedList that implements a stack of integers using another class Node which contain data and next attributes.
// Your class should support the following operations:
// •	Insertion at end: Traverse to the last node and append the new node.
// •	Insertion at beginning: Point the new node to head, then update head.
// •	Insertion at position: Traverse to the node before the position, adjust pointers.
// •	Deletion by value: Find the node and skip it in the link.
// •	Search: Traverse and check each node.
// •	Reverse: Iteratively reverse the next pointers.
// •	Count nodes: Traverse and increment a counter.

   MyLinkedList linkedList = new MyLinkedList();
   linkedList.insertAtEnd(5);
   linkedList.insertAtEnd(8);
   linkedList.insertAtEnd(9);
   linkedList.insertAtBeginning(4);
   linkedList.insertAtPosition(3, 0);
     linkedList.insertAtPosition(3, 0);
   linkedList.insertAtPosition(7, 1);
   linkedList.insertAtPosition(6, 5);
 System.out.println( linkedList.delete(3));
 System.out.println( linkedList.delete(3));
 System.out.println(linkedList.search(5));
 System.out.println(linkedList.count());
   linkedList.print();
   linkedList.reverse();

//    Create a Linked List using the Java Built-in Linked List Class.
       LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.addFirst(7);
        linkedList2.addLast(8);
        linkedList2.add(9);
        System.out.println(linkedList2);
        System.out.println( linkedList2.get(0));
        System.out.println(linkedList2.contains(7));
        System.out.println(linkedList2.isEmpty());
        System.out.println(linkedList2.removeFirst());
   }    
}

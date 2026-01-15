class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Using the head only 
class DoublyLinkedList{
    Node head;

    public void print(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.next != null){
            System.out.print("->");
            }
            curr = curr.next;
        }
        System.out.println();
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
          head = newNode;
          return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        newNode.prev = curr;
        curr.next= newNode;
    }

    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

   
    public void insert(int data,int pos){
         if(pos < 0 ){
            System.out.println("Invalid Position ");
            return;
         }

         Node newNode = new Node(data);

         if(pos == 0){
        if(head != null){
        head.prev = newNode;
        newNode.next = head;
        }
        head = newNode;
        return;
       }

         int count = 0;
         Node curr = head;
         while (curr != null && count<pos-1) { 
            curr = curr.next;
            count++;
         }

         if(curr == null){
            System.out.println("Position out of bounds ");
            return;
         }
         
                 if(curr.next != null){
             curr.next.prev = newNode;
            }
             newNode.next = curr.next;
             curr.next = newNode;
              newNode.prev = curr;
    }
    public void delete(int data){
        if(head == null){
        System.out.println("List is empty");
        return;
        }
    
        Node curr = head;
        
        if(curr.data == data){
            head = curr.next;
            if(head != null){
                head.prev = null;
            }
            return;
        }
        
        while (curr != null && curr.data != data) {
            curr = curr.next;
        }

        if(curr == null){
            System.out.println("Data not found !!");
            return;
        }
       
         Node prev = curr.prev;
        Node next = curr.next;

        prev.next = next;
        if(next != null){
        next.prev = prev;
        }
    }
     public int search(int data){
        if (head == null) {
           System.out.println("List is empty ");
           return -1;  
        }

        Node curr = head;
        int count = 0;
        while (curr != null) {
            if(curr.data == data){
                System.out.println(data+" is found at "+count+" position ");
                return count;
            }
            curr = curr.next;
            count++;
        }

        System.out.println("Data not found in list ");
        return -1;
    }

    public void reverse(){
        if(head == null || head.next == null){
            return;
        }

        Node curr = head;
        Node newHead = head;
        while (curr != null) {     //null<-1<->2<->3->null
            Node tempNext = curr.next;   // null<-3<->2<->1->null
            curr.next = curr.prev;
            curr.prev = tempNext;

            newHead = curr;
            curr = tempNext;
        }
        head = newHead;
    }

    public int count(){
        if(head == null){
            return 0;
        }

        int count = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    public void traverseForward(){
        print();
    }

    public void traverseBackward(){
        if(head == null){
            System.out.println("List is empty ");
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        while (curr != null) {
            System.out.print(curr.data);
            if(curr.prev != null){
                System.out.print("->");
            }
            curr = curr.prev;
        }
        System.out.println();
    }
}

// Using head and tail both 
class DoublyLinkedList2{
    Node head;
    Node tail;
    int size;
    public int getHead(){
        if(head == null){
         throw new RuntimeException("List is empty");   
        }
        return head.data;
    }

    public int getTail(){
        if(tail == null){
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }
    public void print(){
        if(head == null){
            System.out.println("List is empty ");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print("->");
            }
            curr = curr.next;
        }
        System.out.println();
    }
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
            return ;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data){
        size++;
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insert(int data,int pos){
         if(pos<0 || pos > count()){
            System.out.println("Invalid position ");
            return;
         }

        if(head == null || pos == 0){
            insertAtBeginning(data);
            return;
        }
        
        Node curr = head;
        int count = 1;                                               
        while (curr.next != null && count < pos) {    // null<-1<->2<->3->null
            curr = curr.next;
            count++;
        }

        if(curr.next == null){
            insertAtEnd(data);
            return;
        }

        size++;
         Node newNode = new Node(data);
         newNode.next = curr.next;
         newNode.prev = curr;
         curr.next = newNode;
         newNode.next.prev = newNode;
    }

    public void delete(int data){
         if(head == null){
            System.out.println("List is empty ");
            return;
         }

         Node curr = head;
         if(curr.data == data){
            size--;
             head = curr.next;
            if(head != null){
                head.prev = null;
            }else{
                tail = null;
            }   
            return;
         }

         while (curr != null && curr.data != data) {
            curr = curr.next;
         }

         if(curr == null){
            System.out.println("Data not found !! ");
            return;
         }

         size--;
         Node next = curr.next;
         Node prev = curr.prev;

         prev.next = next;
         if(next != null){
            next.prev = prev;
         }else{
            tail = prev;
         }
    }
    public void search(int data){
        if(head == null){
            System.out.println("List is empty ");
            return ;
        }

        int pos =0;
        Node curr = head;
        while (curr != null) {
            if(curr.data == data){
                System.out.println(data+" is found at "+pos+" position ");
                return;
            }
            curr = curr.next;
            pos++;
        }
        System.out.println("Data not found !! ");
    }

     public void reverse(){
        if(head == null || head.next == null){
            return;
        }

        Node curr = head;
        tail = head;
        Node newHead = null;

        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = curr.prev;
            curr.prev = nextTemp;

            newHead = curr;
            curr = nextTemp;
        }
        head = newHead;
     }  

     public int count(){
        return size;
     }

     public void traverseForward(){
       print();
     }

     public void traverseBackward(){
        if(tail == null){
            System.out.println("List is empty ");
            return;
        }

        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.prev != null){
                System.out.print("<-");
            }
            curr = curr.prev;
        }
        System.out.println();
     }
}
public class Dec11b {
    public static void main(String[] args) {
//        Create a class DoublyLinkedList that implements a doubly linked list of integers using another class Node, which contains the following attributes:
// •	data
// •	prev
// •	next
// Your DoublyLinkedList class should support the following operations:
// 1.	Insertion at the end: Traverse to the last node and append the new node by updating both next and prev pointers.
// 2.	Insertion at the beginning: Point the new node’s next to the head and update the head’s prev.
// 3.	Insertion at a specific position: Traverse to the required position and adjust both prev and next pointers.
// 4.	Deletion by value: Locate the node containing the given value and remove it by updating adjacent nodes’ links.
// 5.	Search: Traverse the list to check whether a given value exists.
// 6.	Reverse the doubly linked list by swapping the next and prev pointers of each node.
// 7.	Count the total number of nodes in the list by traversal.
// 8.	Traverse and display the list in both forward and backward directions.
         DoublyLinkedList list = new DoublyLinkedList();
         list.insertAtEnd(7);
         list.insertAtEnd(8);
         list.insertAtEnd(9);
         list.insertAtBeginning(5);
         list.insert(6, 0);
         list.print();
         list.search(8);
         list.search(4);
        list.reverse();
        list.print();
        System.out.println(list.count());
        list.traverseForward();
        list.traverseBackward();

        DoublyLinkedList2 list2 = new DoublyLinkedList2();
        list2.insertAtBeginning(1);
        list2.insertAtBeginning(2);
        list2.print();
        list2.insertAtEnd(3);
        list2.insertAtEnd(4);
        list2.print();
        list2.insert(5, 0);
        list2.insert(6, 6);
        list2.insert(7, 3);
         list2.getHead();
        list2.getTail();
        list2.print();
        list2.delete(7);
        list2.delete(5);
        list2.delete(6);
        list2.getHead();
        list2.getTail();
        list2.print();
        list2.search(4);
        list2.search(5);
        list2.reverse();
        list2.getHead();
        list2.getTail();
        list2.print();
        System.out.println(list2.count());
        list2.traverseForward();
        list2.traverseBackward();


        
        // Using Java’s built-in LinkedList class (which implements a doubly linked list), write a program to perform the following operations on a list of integers:
// 1.	Insertion
//   	Insert an element at the beginning of the list.
//  	Insert an element at the end of the list.
//  	Insert an element at a specific position in the list.
// 2.	Deletion
//  	Delete an element by value.
//      Delete the first element.
//  	Delete the last element.
// 3.	Searching
//  	Search for a specific element in the list and report whether it exists.
// 4.	Traversal
//  	Display the list in forward order.
//  	Display the list in reverse order.
// 5.	Counting Nodes
//  	Count and display the total number of nodes in the list.


     
    }
}

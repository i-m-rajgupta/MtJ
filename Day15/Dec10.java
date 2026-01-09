class Node {
   int data;
   Node next;
   Node(int data){
     this.data = data;
     this.next = null;
   }  
}

class MyLinkedList {
    Node head ;
    public  void print(){
        if(head == null){
            System.out.println("List is empty ");
            return;
        }

        Node curr = head;
        System.out.print(curr.data);
        while (curr.next != null) {
            System.out.print("->"+curr.next.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    public boolean detectAndRemoveLoop(){
        if(head == null || head.next == null){
           return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                removeLoop(slow);
                return true;
            }
        }

        System.out.println("No Loop Detected ");
        return false;
    }
   
    private void removeLoop(Node meetingPoint){
       Node ptr1 = head;
       Node ptr2 = meetingPoint;

       if(ptr1 == ptr2){
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
        return;
       }

       while (ptr1.next != ptr2.next) {
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
       }
       ptr2.next = null;
    }

    public void swap(int pos1,int pos2){
        if(pos1 < 0 || pos2 <0 ||pos1 == pos2){
            System.out.println("Invalid Position for Swapping ");
            return;
        }

        if(head == null){
            System.out.println("List is empty ");
            return;
        }

        if(pos1>pos2){
            int temp = pos1;
            pos1 = pos2;
            pos2 = temp;
        }

        Node prev1 = null;
        Node curr1 = head;
        int i=0;
        while (i<pos1 && curr1 != null) {
            prev1 = curr1;
            curr1 = curr1.next;
            i++;
        }

        i =0;
        Node prev2 = null;
        Node curr2 = head;
        while (i<pos2 && curr2 != null) {
            prev2 = curr2;
            curr2 = curr2.next;
            i++;
        }
       

        if(curr1 == null|| curr2 == null){
            System.out.println("Position out of bounds for swapping ");
            return;
        }

        if(prev1 != null){
            prev1.next = curr2;
        }else{
            head = curr2;
        }

        if(prev2 != null){
            prev2.next = curr1;
        }

        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

    }

    public void rotate(int k){
       if(head == null && head.next != null || k<= 0){
        return ;
       }

       Node tail = head;
       int length = 1;
       while (tail.next != null) {
        tail = tail.next;
        length++;
       }

       k = k%length;
       if(k == 0){
        return;
       }
        
       Node newTail = head;
       for(int i = 0;i<length-k-1;i++){
        newTail = newTail.next;
       }

       Node newHead = newTail.next;
       newTail.next = null;
       tail.next = head;
       head = newHead;
    }
}
public class Dec10 {
    public static void main(String[] args) {
        // Detect and Remove a loop/cycle in a linked list.
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(7);
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        Node curr = linkedList.head;
        Node loopNode = null;

        while (curr.next != null) {
            if(curr.data == 4){
                loopNode = curr;
            }
            curr = curr.next;
        }

        curr.next = loopNode;
       System.out.println( "Loop Detected "+linkedList.detectAndRemoveLoop());
        linkedList.print();
        MyLinkedList list2 = new MyLinkedList();
        list2.add(10);
        list2.add(11);
        list2.add(12);

        Node head = list2.head;   
         curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        System.out.println("Loop Detected "+list2.detectAndRemoveLoop());

        // Swap two nodes in a linked list without swapping data.
        list2.print();
        list2.swap(0, 2);
        list2.print();

        // Rotate a linked list by k positions.
        linkedList.rotate(10);
        linkedList.print();

    }
}

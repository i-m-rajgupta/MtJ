class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList{
    Node head;
    public void print(){
       print(head);
    }

    private void print(Node head){
        if(head == null){
            System.out.println("List is empty");
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

    public int update(int data,int pos){
        if(pos<0){
            System.out.println(pos+" is Invalid Position ");
            return -1;
        }
        if(head == null){
            System.out.println("Cannot update because List is empty");
            return -1;
        }
        int count =0;
        Node curr = head;
        while (curr != null) {
            if(count == pos){
                int originalData = curr.data;
                curr.data = data;
                return originalData;
            }
            curr = curr.next;
            count++;
        }
        System.out.println("Position "+pos+" out of bounds ");
        return -1;
    }

    public Node copyList(Node head){
        if(head == null){
            return null;
        }

        Node newHead = new Node(head.data);
        Node currNew = newHead;
        Node currOld = head.next;

        while (currOld != null) {
            Node  newNode = new Node(currOld.data);
            currNew.next = newNode;
            currNew = currNew.next;
            currOld = currOld.next;
        }
        return newHead;
    }
    public Node merge(MyLinkedList list2){
        if(head == null && list2.head == null){
            System.out.println("Both Linked lists are empty ");
            return null;
        }
        if(head == null){
            head = copyList(list2.head);
           return head; 
        }
        if(list2.head == null){
            return head;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }
        Node head2 = copyList(list2.head);
        curr.next = head2;
        return head;
    }

    public void removeDuplicates(){
        if(head == null){
            System.out.println("List is empty ");
            return;
        }
         //5 4 4 3 2 2 
        Node curr = head;
        while (curr.next != null) {
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            } 
        }
    }

    public int middleElement(){
        if(head == null){
         System.out.println("Linked List is empty");
         return -1;
        }
        Node slow = head;
        Node fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int nodeFromEnd(int pos){
        if(pos<0){
            System.out.println(pos+" is Invalid ");
            return -1;
        }
        if(head == null){
            System.out.println("List is empty ");
            return -1;
        }

        Node prev = null;   
        Node curr = copyList(head);
        print(curr);
        while (curr != null) {
            Node tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        curr = prev;
        int count = 0;
        while (curr.next != null && count!= pos) {
            curr = curr.next;
            count++;
        }
        if(count == pos){
           System.out.println(curr.data +" is present at "+pos+" position from end of node ");
           return curr.data;
        }
       
        System.out.println("Position "+pos+" is out of bounds ");
        return -1;
    }

    public int nodeFromEnd2(int pos){
        if(pos<0){
            System.out.println(pos+"is Invalid position");
            return -1;
        }
        
        if(head == null){
            System.out.println("List is emoty ");
            return -1;
        }

        Node slow = head;
        Node fast = head;

        for(int i =0;i<pos;i++){
            if(fast.next == null){
                System.out.println("Position "+pos+" is out of bounds ");
                return -1;
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println(slow.data +" is present at  "+pos+" position from end of node ");
        return slow.data;
    }
}

public class Dec9 {
    public static void main(String[] args) {
        // Update the value of a node at a specific position.
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(9);
        linkedList.add(8);
        linkedList.add(7);
        linkedList.print();
        System.out.println(linkedList.update(10, 0));
        System.out.println(linkedList.update(5, 3));
        System.out.println(linkedList.update(6, -1));
        linkedList.print();

        // Merge two singly linked lists (simply append one to another).
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        list1.merge( list2);
        list1.add(9);
        list1.merge( list2);
        list1.print();
        list2.add(8);
        list1.merge( list2); 
        list1.print();
        MyLinkedList list3 = new MyLinkedList();
        MyLinkedList list4 = new MyLinkedList();
        list3.add(7);
        list3.add(7);
        list3.add(7);
        list3.add(6);
        list3.add(5);
        list4.add(5);
        list4.add(4);
        list4.add(4);
        list4.add(4);
        list4.add(3);
        list4.add(2);
        list4.add(2);
        list4.add(2);
    
          list3.merge(list4);
          list3.print();

        //Remove duplicates from a sorted linked list.
       list3.removeDuplicates();
       list3.print();
    list4.removeDuplicates();
    list4.print();
   
     //Find the middle element of a linked list in one traversal.
     list4.add(1);
     list3.print();
    System.out.println( list3.middleElement());
    list4.print();
    System.out.println( list4.middleElement());

    // Find the nth node from the end of a linked list.
   list4.nodeFromEnd(2);
   list4.nodeFromEnd2(2);
    }
}

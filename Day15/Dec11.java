class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next= null;
    }
}

class MyLinkedList{
    Node head;
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
    public void  print(){
        if(head == null){
            System.out.println("List is emppty ");
            return;
        }
        Node curr = head;
        System.out.print(head.data);
        while (curr.next != null) {
          System.out.print("->"+curr.next.data);   
          curr = curr.next;
        }
        System.out.println();
    }
}

public class Dec11 {
     public static void moveLast(MyLinkedList list){
            if(list.head == null || list.head.next == null){
               return;
            }

            Node curr = list.head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            Node temp = curr.next;
            curr.next = null;
            temp.next = list.head;
            list.head = temp;
        }
        
        private static Node reverse(Node head) {
    Node prev = null, curr = head;
    while (curr != null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
      }

        public static void deleteRightgreater(MyLinkedList list){
            if(list.head == null || list.head.next == null){
                return;
            }

            Node curr = reverse(list.head);

            Node tail = curr;
            int maxSoFar = curr.data;
    
            while (curr.next != null) {
                if(curr.next.data < maxSoFar){
                    curr.next = curr.next.next;
                }else{
                    curr = curr.next;
                    maxSoFar = curr.data;
                }
            }
          
            list.head = reverse(tail);
        }
        public static boolean isValid(Node head){
            Node curr = head;
            while (curr != null ) {
                if(curr.data <0 || curr.data >9){
                    return false;
                }
                curr = curr.next;
            }
            return true;
        }
        public static void addOne(MyLinkedList list){
            if(list.head == null || !isValid(list.head)){
              return;
            }

            Node curr = reverse(list.head);
            Node tail= curr;

            while ( curr != null) {
                if(curr.data != 9){
                    curr.data += 1;
                    list.head = reverse(tail);
                    return;
                }else{
                    curr.data = 0;
                    curr = curr.next;
                }
            }
            list.head = reverse(tail);
            Node newNode = new Node(1);
            newNode.next = list.head;
            list.head = newNode;
        }

        public static void reorder(MyLinkedList list){
          if(list.head == null || list.head.next == null){
            return;
          }

          Node slow = list.head;
          Node fast = list.head;
          while (fast != null && fast.next != null) {
               slow = slow.next;
               fast = fast.next.next;    // 1 2 3 4 5 6 7
          }

          Node midNext = slow.next;
          slow.next = null;

          Node reverseMidNext = reverse(midNext);
          Node curr = list.head;
          while (reverseMidNext != null) {
            Node temp1 = curr.next;
            Node temp2 = reverseMidNext.next;

            curr.next = reverseMidNext;
            reverseMidNext.next = temp1;

            curr = temp1;
            reverseMidNext = temp2;
          }
        }

        public static void swapAdjacent(MyLinkedList list){
            if(list.head == null || list.head.next == null){
               return;
            }

            Node curr = list.head ;
            Node prev = null;

            while (curr != null && curr.next != null) {
                Node temp1 = curr;
                Node temp2 = curr.next;
                Node tempNext = temp2.next;

                if(prev != null){
                    prev.next = temp2;

                }else{
                    list.head = temp2;
                }

                temp2.next = temp1;
                temp1.next = tempNext;
                prev = temp1;
                curr = temp1.next;
            }
        }

    public static void main(String[] args) {
        // Move the last node to the front of a linked list.
       
        MyLinkedList list1 = new MyLinkedList();
        list1.add(8);
        list1.add(6);
        list1.add(5);
        list1.add(7);
        list1.print();
        moveLast(list1);
        list1.print();

        // Delete nodes that have a greater value on the right.
        MyLinkedList list2 = new MyLinkedList();
        list2.add(12);
        list2.add(15);
        list2.add(10);
        list2.add(11);
         list2.add(5);
          list2.add(6);
           list2.add(2);
            list2.add(3);
        deleteRightgreater(list2);
        list2.print();

    // Add one to a number represented by a linked list.
     MyLinkedList list3 = new MyLinkedList();
     list3.add(9);
    list3.add(9);
    list3.add(9);
     addOne(list3);
     list3.print();

    //  Reorder a linked list in the pattern L0 → Ln → L1 → Ln-1 → ....
   MyLinkedList list4 = new MyLinkedList();
   list4.add(1);
   list4.add(2);
   list4.add(3);
   list4.add(4);
   list4.add(5);
   reorder(list4);
   list4.print();
   
//    Swap every two adjacent nodes in a linked list.
  swapAdjacent(list4);
  list4.print();
    }
}

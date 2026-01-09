      class Node{
         int data;
         Node next;
            Node(int data ){
              this.data=data;
              this.next=null;
            }
      }

      class MyLinkedList{
         Node head;
         public void print(){
            if(head == null){
               System.out.println("Linked list is empty");
               return;
            }
   
            System.out.print(head.data);
            Node curr = head;
            while (curr.next != null) {
               System.out.print("->"+curr.next.data);
               curr = curr.next;
            }
         }
         public void insertAtBeginning(int data){
           Node newNode = new Node(data);   // 3-> 4->5->6->null
           if(head == null){
            head = newNode;
            return;
           }
         newNode.next = head;
          head = newNode;
         }

         public void insertAtEnd(int data){   //3->4->5->6->null
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
      }
public class Program1 {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();

        obj.insertAtEnd(3);
        obj.insertAtEnd(4);  
        obj.print();
     
    }
}

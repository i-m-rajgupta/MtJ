class CircularLinkedList<T>{
    private static class Node<T>{
        T data;
        Node<T> next;
     
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

   private Node<T> head = null;
    private Node<T> tail = null;
    int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public void insertAtBeginning(T data){
      Node<T> newNode = new Node<>(data);
      if(isEmpty()){
        head = tail = newNode;
        tail.next = head;
      }else{
         tail.next = newNode;
         newNode.next = head;
         head = newNode;
      }
      size++;
    }
    
    public void insertAtEnd(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            head = tail = newNode;
            tail.next = head;
        }else{
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void insert(T data,int pos){
        if(pos <0 || pos > size){
            throw new RuntimeException("Invalid Position ");
        }
        
        if(pos == 0){
            insertAtBeginnig(data);
            return;
        }
        if(pos == size){
            insertAtEnd(data);
            return;
        }
        Node<T> curr = head;
        for(int i =0;i<pos-1;i++){
            curr = curr.next;
        }

        Node<T> newNode = new Node<>(data);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public boolean removeFirst(){
        if(isEmpty()){
            return false;
        }

        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
            tail.next = head;
        }
        size--;
        return true;
    }

    public boolean removeLast(){
        if(isEmpty()){
            return false;
        }

        if(head == tail){
            head = tail = null;
        }else{
            Node<T> curr = head;
            while (curr.next != tail ) {
                curr = curr.next;
            }
            curr.next = head;
            tail = curr;
        }
        size--;
        return true;
    }
    public boolean remove(T data){
        if(isEmpty()){
            return false;
        }

        if((head.data == null ? data == null : head.data.equals(data))){
            return  removeFirst();
        }

        Node<T> prev = head;
        Node<T> curr = head.next;
        while (curr != head ) {
             if( (curr.data == null ? data != null : curr.data.equals(data))){
                if(curr == tail){
                    return removeLast();
                }
                prev.next = curr.next;
                size--;
                return true;
             }
             prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public void print(){
        if(isEmpty()){
            return ;
        }

        Node<T> curr = head;
        do{
            System.out.print(curr.data);
            if(curr.next != head){
                System.out.print("->");
            }
            curr = curr.next;
        }while(curr != head);
    }
}

public class program3 {
    public static void main(String[] args) {
        // Circular linked list - A Circular Linked List is a linked list in which the last node points to the first node, 
        // forming a circle.
       CircularLinkedList<Character> cll = new CircularLinkedList<>();
       cll.insertAtBeginnig('5');
       cll.insert('a', 0);
       cll.insertAtEnd(null);
       cll.removeFirst();
       cll.removeFirst();
       cll.removeLast();
       cll.print();

    }
}

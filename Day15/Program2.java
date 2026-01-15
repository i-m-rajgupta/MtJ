class DoublyLinkedList<T>{
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T getHead(){
        if(isEmpty()){
            throw new RuntimeException("List is Empty");
        }
        return head.data;
    }

    public T getTail(){
        if(isEmpty()){
            throw new RuntimeException("List is Empty");
        }

        return tail.data;
    }

    public void insertAtBeginning(T data){
      Node<T> newNode = new Node<>(data);
      if(isEmpty()){
        head = tail = newNode;
      }else{
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
      }
      size++;
    }

    public void insertAtEnd(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insert(T data,int pos){
       if(pos<0 || pos>size){
        throw new IndexOutOfBoundsException("Invalid positions ");
       }

       if(pos == 0){
        insertAtBeginning(data);
        return;
       }

       if(pos == size){
          insertAtEnd(data);
          return;
       }

       Node<T> curr = head;
       for(int i=0;i<pos-1;i++){
        curr = curr.next;
       }

       Node<T> newNode = new Node<>(data);
       newNode.prev = curr;
       newNode.next = curr.next;
       curr.next.prev = newNode;
       curr.next = newNode;

       size++;
    }

    public boolean delete(T data){
        if(isEmpty()){
            return false;
        }

        Node<T> curr = head;
        while (curr != null && !curr.data.equals(data)) {
            curr = curr.next;
        }

        if(curr == null){
            return false;
        }

        if(curr.prev != null){
            curr.prev.next = curr.next;
        }else{
            head = curr.next;
        }

        if(curr.next != null){
          curr.next.prev = curr.prev;
        }else{
            tail = curr.prev;
        }
        
        size--;
        return true;
    }

    public int indexOf(T data){
        int index = 0;
        Node<T> curr = head;

        while (curr != null) {
            if(curr.data.equals(data)){
                return index;
            }
            curr = curr.next;
            index++;
        }

        return -1;
    }

    public void reverse(){
        if(head == null || head.next == null){
            return;
        }

        Node<T> curr = head;
        tail = head;
        Node<T> prev = null;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

   public void printForward(){
    Node<T> curr = head;
    while (curr != null) {
        System.out.print(curr.data);
        if(curr.next != null){
            System.out.print("->");
        }
        curr = curr.next;
    }
    System.out.println();
   }

   public void printBackward(){
    Node<T> curr = tail;
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

public class Program2 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtBeginning(8);
        list.insertAtBeginning(7);
        list.printForward();
        list.delete(8);
        System.out.println(list.getTail());
        list.insert(9, 1);
        list.printBackward();
        list.delete(9);
        list.delete(4);
        list.indexOf(4);
    }
}

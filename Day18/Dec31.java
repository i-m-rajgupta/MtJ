import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
}

class MyBinaryTree{
    Node root;
    MyBinaryTree(){
        root = null;
    }

    public void insertion(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if(curr.left == null){
                curr.left = newNode;
                return;
            }else{
                queue.offer(curr.left);
            }

            if(curr.right == null){
                curr.right = newNode;
                return;
            }else{
                queue.offer(curr.right);
            }
        }
    }

    static class Pair{
        Node node;
        int hd;
        Pair(Node node,int horizontal_distance){
            this.node = node;
            this.hd = horizontal_distance;
        }
    }

    public void verticalOrderTraversal( ){
      if(root == null){
        return;
      }

      Map<Integer,List<Integer>> map = new TreeMap<>();
      
      Queue<Pair> queue = new LinkedList<>();
      queue.offer(new Pair(root, 0));

       while (!queue.isEmpty()) {
         Pair curr = queue.poll();
        int hd = curr.hd;
          
         map.putIfAbsent(hd, new ArrayList<>());
         map.get(hd).add(curr.node.data);

         if(curr.node.left != null){
             queue.offer(new Pair(curr.node.left, hd-1));
         }
         if(curr.node.right != null){
            queue.offer(new Pair(curr.node.right, hd+1));
         }
       }

       for(List<Integer> column : map.values()){
            System.out.print(column+" ");
       }
      System.out.println();
    }

    public void topView(){
        if(root == null){
            return;
        }

        Map<Integer,Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int hd = curr.hd;
            Node currNode = curr.node;

            map.putIfAbsent(hd, currNode.data);
            
            if(currNode.left != null){
                queue.offer(new Pair(currNode.left, hd-1));
            }

            if(currNode.right !=  null){
                queue.offer(new Pair(currNode.right, hd+1));
            }
        }

        for(Integer num : map.values()){
          System.out.print(num+" ");   
        }
        System.out.println();
    }

    public void bottomView(){
        if(root == null){
            return;
        }

        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int hd = curr.hd;
            Node currNode = curr.node;

            map.put(hd, currNode.data);

            if(currNode.left != null){
                queue.offer(new Pair(currNode.left,hd-1));
            }

            if(currNode.right != null){
                queue.offer(new Pair(currNode.right,hd+1));
            }
        }

        for(Integer num : map.values()){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public void leftView(){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0;i<size;i++){
            Node curr = queue.poll();
            
            if(i == 0){
                System.out.print(curr.data+" ");
            }
            if(curr.left != null){
                queue.offer(curr.left);
            }
            
            if(curr.right != null){
                queue.offer(curr.right);
            }
            }
        }
        System.out.println();
    }

    public void rightView(){
        if(root == null){
            return ;
        }
   
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0;i<size;i++){
                Node curr = queue.poll();
                if(i == size-1){
                    System.out.print(curr.data+" ");
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        System.out.println();
    }

}

public class Dec31 {
    public static boolean isComplete(Node node){
        if(node == null){
            return true;
        }
         
        Queue<Node> queue = new LinkedList<>();
        boolean seenNull = false;
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if(curr == null){
                seenNull = true;
            }else{
                if(seenNull){
                    return false;
                }

                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return true;
    }

    public static Node convertToDLL(Node node){
        if(node == null){
            return null;
        }

        Node head = null,prev = null;
        Node current = node;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if(prev == null){
                head = current;
            }else{
               prev.right = current;
               current.left = prev;
            }

            prev = current;

            current = current.right;
        }
        return head;
    }

    public static void printDLL(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Write a Java program to vertical order traversal.
        MyBinaryTree b1 = new MyBinaryTree();
        b1.insertion(8);
        b1.insertion(9);
        b1.insertion(10);
        b1.insertion(4);
        b1.insertion(5);
        b1.insertion(6);
        b1.insertion(7);
        b1.insertion(11);
        b1.insertion(12);
        b1.insertion(13);
        b1.insertion(14);
        b1.insertion(15);
        b1.insertion(16);
        b1.insertion(17);
        b1.verticalOrderTraversal();

        // Implement top view and bottom view  of a binary tree.
        b1.topView();
        b1.bottomView();

        // Implement left view and right view of a binary tree.
        b1.leftView();
       b1.rightView();

    //  Write a Java program to check if binary tree is complete.
        System.out.println(isComplete(b1.root));

        //Implement convert binary tree to doubly linked list.
        printDLL(convertToDLL(b1.root));

        
    }
}

import java.util.LinkedList;
import java.util.Queue;

class MyBinaryTree<T>{
    private class Node<T>{
        T data;
        Node<T> left,right;
        Node(T data){
            this.data = data;
        }
    }

    Node<T> root;
    MyBinaryTree(){
        root = null;
    }

    public void insertion(T data){
        Node<T> newNode = new Node<>(data);

        if(root == null){
            root = newNode;
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            
            if(current.left == null){
                current.left = newNode;
                return;
            }else{
                queue.offer(current.left);
            }

            if(current.right == null){
                current.right = newNode;
                return;
            }else{
                queue.offer(current.right);
            }
        }
    }

    public void inorder(Node<T> node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    public void levelOrder(){
         if(root == null){
            return;
         }

         Queue<Node<T>> queue = new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                Node<T> node = queue.poll();
            System.out.print(node.data+" ");

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
        }

        System.out.println();
         }
    }
    public int count(Node<T> node){
        if(node == null){
           return 0;
        }

        return 1 + count(node.left) + count(node.right);
    }
}
public class Dec26 {
  public static void main(String[] args) {
    // Write a Java program to count total nodes in a binary tree.
     MyBinaryTree<Integer> b = new MyBinaryTree<>();
     b.insertion(7);
     b.insertion(8);
     b.insertion(9);
     b.insertion(5);
     System.out.println("In order ");
     b.inorder(b.root);
     System.out.println("Count "+b.count(b.root));
     System.out.println("Level order ");
     b.levelOrder();
  }    
}

import java.util.LinkedList;
import java.util.Queue;

  class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }
class MyBinaryTree{

    Node root ;
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

    public boolean isEmpty(){
        return root == null;
    }

    public int size(Node node){
         if(node == null){
            return 0;
         }

         int left = size(node.left);
         int right =size(node.right);

         return 1+left+right;
    }

    public void clear(){
        root = null;
    }
}
public class Dec28 {
    public static boolean isIdentical(MyBinaryTree b1,MyBinaryTree b2){
        if(b1.isEmpty() && b2.isEmpty()){
            System.out.println("1");
            return true;
        }else if(b1.isEmpty() || b2.isEmpty() || b1.size(b1.root) != b2.size(b2.root)){
              System.out.println("2");
            return false;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.offer(b1.root);
        q2.offer(b2.root);
        while (!q1.isEmpty()) {
            Node curr1 = q1.poll();
            Node curr2 = q2.poll();

            if(curr1.data != curr2.data){
                return false;
            }

            if(curr1.left != null && curr2.left ==null || curr1.left == null && curr2.left != null){
                return false;
            }

            if(curr1.left != null){
             q1.offer(curr1.left);
                q2.offer(curr2.left);
            }
            if(curr1.right == null && curr2.right !=null || curr1.right != null && curr2.right == null){
              return false;
            }
            if(curr1.right != null){
                q1.offer(curr1.right);
                q2.offer(curr2.right);
            }
        }
        return true;
    }

    public static boolean isFull(Node node){
         if(node == null || node.left == null && node.right == null){
            return true;
         }

         if(node.left != null && node.right == null || node.left == null && node.right != null){
            return false;
         }
         boolean left = isFull(node.left);
         boolean right = isFull(node.right);
        return left && right;
    }

    public static boolean isBalanced(Node node){
        return checkHeight(node) != -1;
    } 

    public static int checkHeight(Node node){
        if(node == null){
            return 0;
        }

        int left = checkHeight(node.left);
        if(left == -1){
            return -1;
        }

        int right = checkHeight(node.right);
        if(right == -1){
            return -1;
        }

        if(Math.abs(left-right) > 1){
            return -1;
        }
        return 1+left+right;
    }

    public static int sum(Node node){
        if(node == null){
           return 0;
        }

        int left = sum(node.left);
        int right =sum(node.right);

        return node.data+left+right;
    }

    public static int depth(Node node){
        if(node == null){
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        return 1+Math.max(left, right);
    }

    public static boolean isMirror(Node a,Node b){
        if(a == null && b != null){
            return false;
        }
          if(a == null&& b == null){
            return true;
          }
              return a.data == b.data &&
           isMirror(a.left, b.right) &&
           isMirror(a.right, b.left);
// /
    }
    public static boolean isSymmetric(Node node){
        if(node == null){
            return true;
        }

    return isMirror(node.left,node.right);
    }
    public static void main(String[] args) {
        //Write a Java program to check if two binary trees are identical.
         MyBinaryTree b1 = new MyBinaryTree();
        MyBinaryTree b2 = new MyBinaryTree();
        b1.insertion(7);
        b1.insertion(8);
        b1.insertion(9);
        b2.insertion(7);
        b2.insertion(9);
        b2.insertion(8);
        System.out.println(isIdentical(b1, b2));

        b1.clear();
        b2.clear();
        b1.insertion(2);
        b1.insertion(5);
        b2.insertion(2);
        b2.insertion(5);        
       System.out.println(isIdentical(b1, b2));
       b2.insertion(8);

    //    Implement check if a binary tree is Full and balanced.
    System.out.println(isFull(b1.root));
    System.out.println(isFull(b2.root));
    System.out.println(isBalanced(b1.root));
    System.out.println(isBalanced(b2.root));

    //  Write a Java program to check if a binary tree is symmetric.
     MyBinaryTree b3 = new MyBinaryTree();
     b3.insertion(2);
     b3.insertion(3);
     b3.insertion(3);
     b3.insertion(4);
     b3.insertion(5);
     b3.insertion(5);
     b3.insertion(4);

     System.out.println("Symmetry "+isSymmetric(b3.root));
    
    // Implement sum of all nodes in a binary tree.
      System.out.println(sum(b1.root));
      System.out.println(sum(b2.root));

    //   Write a Java program to find depth of a given node.
     System.out.println(depth(b1.root));
     System.out.println(depth(b2.root));
    }
}

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
    Node root = null;
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
}

class Distance{
    private static Node LCA(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }

        return (left != null)?left:right;
    }

    private static int findLevel(Node LCA,int n1,int level){
          if(LCA == null){
            return -1;
          }

          if(LCA.data == n1){
            return level;
          }

          int left = findLevel(LCA.left, n1, level+1);
          if(left != -1){
            return left;
          }

          return findLevel(LCA.right, n1, level+1);
    }
    public static int findDistance(Node root,int n1,int n2){
     Node LCA = LCA(root, n1, n2);
     int d1 = findLevel(LCA, n1, 0);
     int d2 = findLevel(LCA, n2, 0);
     return d1+d2;
    }
}

public class Jan3 {
    public static void main(String[] args) {
        // Write a Java program to find distance between two nodes.
         MyBinaryTree b = new MyBinaryTree();
         b.insertion(9);
         b.insertion(8);
         b.insertion(7);
         b.insertion(6);
         b.insertion(5);
      System.out.println(  Distance.findDistance(b.root, 9, 5));

      



    }
}

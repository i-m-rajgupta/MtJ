import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }
class MyBST{

    private Node root = null;

    public Node getRoot(){
        return root;
    }
    private Node insertion(int data,Node node){
        if(node == null){
            return new Node(data);
        }

        if(node.data >data){
            node.left = insertion(data, node.left);
        }else{
            node.right = insertion(data, node.right);
        }

        return node;
    }
    public void insertion(int data){
       root = insertion(data, root);
    }
}
public class Jan28 {
      public static void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    private static ArrayList<Integer> list;
    private static void arrUtil(Node node){
      if(node == null){
        return;
      }
      arrUtil(node.left);
      list.add(node.data);
      arrUtil(node.right);
    }
    public static int[] getArr(Node node){
        list = new ArrayList<>();
        arrUtil(node);
        return list.stream().mapToInt(i->i).toArray();
    }

    private static Node BSTutil(int arr[],int start,int end){
        if(start>end){
            return  null;
        }
          int mid = start+(end-start)/2;
          Node node = new Node(arr[mid]);
          node.left = BSTutil(arr, start, mid-1);
          node.right = BSTutil(arr, mid+1, end);

          return node;
    }
    public static Node getBST(int arr[]){
           int n = arr.length;
        if(n == 0){
         return null;
        }

      Arrays.sort(arr);
      return BSTutil(arr, 0, n-1);
    }

    public static void levelOrder(Node node){
        if(node == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int size;
        while (!q.isEmpty()) {
            size = q.size();
            for(int i =0;i<size;i++){
            Node curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left != null){
                q.offer(curr.left);
            }
            if(curr.right != null){
                q.offer(curr.right);
            }
        }
        System.out.println();
        }
    }
    public static Node inorderSuccessor(Node node){
        if(node.right == null){
            return null;
        }
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Node inorderPredecessor(Node node){
        if(node.left == null){
            return null;
        }
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public static void main(String[] args) {
        // Convert BST to sorted array.
       MyBST b1 = new MyBST();
       b1.insertion(8);
       b1.insertion(6);
       b1.insertion(2);
       b1.insertion(3);
       b1.insertion(9);
       b1.insertion(7);
        b1.insertion(1);
  b1.insertion(4);
       int res[] = getArr(b1.getRoot());
       for(int i : res){
        System.out.print(i+" ");
       }
       
       System.out.println();
    //   Convert sorted array to balanced BST.
       Node  root = getBST(res);
       inorder(root);
    System.out.println();
    //    Perform level order traversal of BST.
     levelOrder(b1.getRoot());
     levelOrder(root);

    //  Find inorder successor of a given node.
    System.out.println(inorderSuccessor(root).data);
    System.out.println(inorderSuccessor(root.left).data);
        System.out.println(inorderSuccessor(root.right).data);
    // Find inorder predecessor of a given node.
    System.out.println(inorderPredecessor(root).data);
    System.out.println(inorderPredecessor(root.right).data);
    System.out.println(inorderPredecessor(root.left).data);

    }
}

class MyBinarySearchTree{
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }

    private Node root = null;
    public Node getRoot(){
        return root;
    }
    private Node insertion(Node node,int data){
        if(node == null){
            return new Node(data);
        }

        if(node.data>data){
            node.left = insertion(node.left, data);
        }else {
            node.right = insertion(node.right, data);
        }
        return node;
    }
    public void insertion(int data){
      root = insertion(root, data);
    }

    public void inorder(Node node){
        if(node == null){
            return ;
        }

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public void printAscending(){
        inorder(root);
        System.out.println();
    }

    private void descending(Node node){
        if(node == null){
            return;
        }

        descending(node.right);
        System.out.print(node.data+" ");
        descending(node.left);
    }
    public void printDescending(){
        descending(root);
        System.out.println();
    }

    private void range(Node node,int k1,int k2){
        if(node == null){
            return;
        }

        range(node.left, k1, k2);
        if(node.data >= k1 && node.data <= k2){
            System.out.print(node.data+" ");
        }
         range(node.right, k1, k2);
    }
    
    public void printRange(int k1,int k2){
        range(root, k1, k2);
        System.out.println();
    }

        int result ,count;
    private void kSmallest(Node node,int k){
        if(node == null){
            return;
        }

        kSmallest(node.left, k);
        count++;
        if(k == count){
            result = node.data;
            return ;
        }
       kSmallest(node.right, k);
      }
    public int kSmallest(int k){
       result = -1;
       count = 0;
        kSmallest(root,k);
        return result;
    }

    private void kLargest(Node node,int k){
        if(node == null){
            return;
        }

        kLargest(node.right, k);
          count++;
        if(count == k){
            result = node.data;
            return;
        }
        kLargest(node.left, k);
    }
    public int kLargest(int k){
           result = -1;
           count = 0;
           kLargest(root, k);
           return result;
    }

}
public class Jan27 {
 public static void main(String[] args) {
    // Print BST elements in ascending order.
    MyBinarySearchTree b1 = new MyBinarySearchTree();
    b1.insertion(10);
    b1.insertion(5);
    b1.insertion(8);
    b1.insertion(7);
    b1.insertion(11);
    b1.insertion(2);
    b1.printAscending();

    // Print BST elements in descending order.
    b1.printDescending();

    // Print all elements between two given values k1 and k2.
    b1.printRange(9, 13);

    // Print k-th smallest element in BST.
    System.out.println(b1.kSmallest(6));

    // Print k-th largest element in BST.
     System.out.println(b1.kLargest(6));
    
 }   
}

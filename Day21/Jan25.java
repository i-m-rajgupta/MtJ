class MyBinarySearchTree{
    private Node root ;
    MyBinarySearchTree(){
        root = null;
    }
    static class Node {
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }

    public Node getRoot(){
        return root;
    }
    private Node insertion(Node node,int data){
        if(node == null){
            node =  new Node(data);
            return node;
        }

        if(node.data < data){
            node.left = insertion(node.left,data);
        }else{
            node.right = insertion(node.right,data);
        }
        return root;
    }

    public void insertion(int data){
       root = insertion(root, data);
    }

    public void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
}
public class Jan25 {
 public static void main(String[] args) {
    // Implement insertion in a Binary Search Tree.
    MyBinarySearchTree b1 = new MyBinarySearchTree();
    b1.insertion(8);
    b1.insertion(4);
    b1.insertion(7);
    // b1.insertion(9);
    System.out.println(b1.getRoot().data);
    b1.inorder(b1.getRoot());
 }   
}

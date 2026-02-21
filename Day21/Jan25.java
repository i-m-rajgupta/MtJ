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

        if(node.data > data){
            node.left = insertion(node.left,data);
        }else{
            node.right = insertion(node.right,data);
        }
        return node;
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

    public Node search(Node node,int data){
        if(node == null){
            return null;
        }

        if(node.data>data){
          return search(node.left, data);
        }else if(node.data<data){
           return search(node.right, data);
        }

        return node;
    }
    private Node inorderSuccessor(Node node){
          while (node.left != null) {
            node = node.left;
          }
          return node;
    }
    private Node delete(Node node,int data){
        if(node == null){
            return null;
        }
       if(node.data > data){
           node.left = delete(node.left, data);
       }else if(node.data < data){
        node.right = delete(node.right, data);
       }else{
           if(node.left == null && node.right == null){
            return null;
           }
           if(node.left == null){
            return node.right;
           }
           if(node.right == null){
            return node.left;
           }

           Node isNode = inorderSuccessor(node.right);
           node.data = isNode.data;
            node.right = delete(node.right, isNode.data);
       }

       return node;
    }
    public int delete(int data){
        Node res = search(root, data);
       if(res == null){
        System.out.println(data+"not exists in the binary tree ");
        return -1;
       }
     root =  delete(root,data);
       return data;
    }

    public int min(){
        if(root == null){
            System.out.println("Tree is empty");
            return -1;
        }

        Node node = root;
        while (node.left != null) {
             node = node.left;
        }
        return node.data;
    }

    public int max(){
        if(root == null){
            System.out.println("Tree is empty");
              return -1;
         }
      Node node = root;
         while (node.right != null) {
             node = node.right;
         }
 
         return node.data;
    }
}
public class Jan25 {
 public static void main(String[] args) {
    // Implement insertion in a Binary Search Tree.
    MyBinarySearchTree b1 = new MyBinarySearchTree();
    b1.insertion(13);
    b1.insertion(4);
    b1.insertion(11);
    b1.insertion(7);
    b1.insertion(10);
    b1.insertion(9);
    b1.inorder(b1.getRoot());

    // Implement deletion in a BST (all 3 cases).
    System.out.println();
     b1.delete(9);
        b1.inorder(b1.getRoot());
        System.out.println();
        // Implement search operation in a BST.
       System.out.println(b1.search(b1.getRoot(), 8));
       System.out.println(b1.search(b1.getRoot(), 10).data);

    //    Write a program to find minimum element in BST.
      System.out.println(b1.min());

    //   Write a program to find maximum element in BST.
     System.out.println(b1.max());
 }   
}

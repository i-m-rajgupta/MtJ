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

    private Node insertion(Node node,int data){
        if(node == null){
            return new Node(data);
        }

        if(node.data>data){
            node.left = insertion(node.left, data);
        }else{
            node.right = insertion(node.right, data);
        }

        return node;
    }
    public void insertion(int data){
       root =  insertion(root,data);
     }    
}
public class Jan29 {
    public static Node LCA(Node node,Node node1,Node node2){
      while (node != null) {
        if(node1.data <node.data && node2.data <node.data){
            node = node.left;
        }else if(node1.data > node.data && node2.data > node.data){
            node = node.right;
        }else{
            return node;
        }
      }
   
      return null;
    }

    public static int getFloor(Node node,int key){
       while (node.data < key) {
          
       }
    }
    public static void main(String[] args) {
        // Find lowest common ancestor (LCA) in BST.
         MyBST b1 = new MyBST();
         b1.insertion(7);
         b1.insertion(9);
         b1.insertion(4);
            b1.insertion(9);
         b1.insertion(6);
         b1.insertion(5);
     Node root = b1.getRoot();
      System.out.println(LCA(root, root.left, root.left).data);

    //   Find floor of a given key in BST


    }
}

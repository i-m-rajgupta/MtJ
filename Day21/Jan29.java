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
         insertion(root,data);
     }    
}
public class Jan29 {
    public static Node LCA(Node node,Node node1,Node node2){
       if(node1 == null && node2 == null){
          return null;
       }

       if(node == node1){
        
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


    }
}

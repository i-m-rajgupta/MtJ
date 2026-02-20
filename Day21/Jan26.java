import java.util.LinkedList;
import java.util.Queue;

class MyBinarySearchTree{
   static class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
   }

   private Node root;
   MyBinarySearchTree(){
    root = null;
   }

   public Node getRoot(){
    return root;
   }

   private Node insertion(Node node,int data){
    if(node == null){
        return new Node(data);
    }

    if(data<node.data){
        node.left = insertion(node.left, data);
    }else if(data >= node.data){
        node.right = insertion(node.right, data);
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


      if(data == node.data){
        return node;
      }else if(data <node.data){
        return search(node.left, data);
      }else{
        return search(node.right, data);
      }
   }

   private Node inorderSuccesor(Node node){
      while (node.left != null) {
        node = node.left;
      }
      return node;
   }
   private Node deletion(Node node,int data){
       if(node.data >data){
         node.left = deletion(node.left, data);
       }else if(node.data < data){
           node.right = deletion(node.right, data);
       }else{
            if(node.left == null && node.right == null){
                return null;
            }else if(node.left == null){
                return node.right;
            }else if(node.right == null){
                 return node.left;
            }
         
            Node inorderNode = inorderSuccesor(node.right);
            node.data = inorderNode.data;
           node.right =   deletion(node.right, node.data);
       }

       return node;
   }
   public int deletion(int data){
      if(search(root, data) == null){
        System.out.println(data+" does not exist in the Binary Search Tree");
          return -1;
      }

     root = deletion(root,data);
     return data;      
   }

    public int countNodes(Node node){
         if(node == null){
            return 0;
         }

         return 1+countNodes(node.left)+countNodes(node.right);
    }

    public int countLeaf(Node node){
         if(node == null){
            return 0;
         }

         if(node.left == null && node.right == null){
            return 1;
         }

         return countLeaf(node.left)+countLeaf( node.right);
    }

    public int height(Node node){
        if(node == null){
            return 0;
        }

        return 1+Math.max(height(node.left),height(node.right) );
    }
}

class MyBinaryTree{
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
        }
    }

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

    public boolean isBST(Node node){
        if(node == null){
            return true;
        }

        if(node.right != null){
        if(node.right.data < node.data){
            return false;
        }
    }

    if(node.left != null){
        if(node.left.data >= node.data){
            return false;
        }
    }

        return isBST(node.left) && isBST(node.right);
    }
}
public class Jan26 {
    public static void main(String[] args) {
        // Count total nodes in a BST.
        MyBinarySearchTree b1 = new MyBinarySearchTree();
        b1.insertion(19);
        b1.insertion(8);
        b1.insertion(7);
        b1.insertion(15);
        b1.insertion(6);
        b1.insertion(8);
       System.out.println(b1.search(b1.getRoot(), 7).data);
       System.out.println(b1.deletion(8));
       System.out.println(b1.countNodes(b1.getRoot()));

    //    Count leaf nodes in a BST.
       System.out.println(b1.countLeaf(b1.getRoot()));

    //    Find height of a BST.
        System.out.println(b1.height(b1.getRoot()));
       
        // Print BST in inorder traversal.
   b1.inorder(b1.getRoot());
   System.out.println();

//    Check whether a given binary tree is a BST.
      MyBinaryTree b2 = new MyBinaryTree();
      b2.insertion(8);
      b2.insertion(7);
      b2.insertion(15);
      System.out.println(b2.isBST(b2.root));
      b2.insertion(16);
      System.out.println(b2.isBST(b2.root));
    }
}

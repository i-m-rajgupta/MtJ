import java.util.LinkedList;
import java.util.Queue;

enum DeleteMode{
    DELETE_ALL,
    FIRST_OCCURENCE,
    LAST_OCCURENCE,
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
 }
 class MyBinaryTree{
    Node root;
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

    public void inorder(Node node){
      if(node == null){
        return;
      }

      inorder(node.left);
      System.out.print(node.data+" ");
      inorder(node.right);
    }

    public boolean search(Node node,int data ){
        if(node == null){
            return false;
        }

        if(node.data == data){
            return true;
        }

        return search(node.left, data) || search(node.right, data);
    }
    
    public void delete(int data,DeleteMode mode){
         if(root == null){
            return;
         }

         if(mode == DeleteMode.DELETE_ALL){
            while (search(root,data)) {
                deleteOne(data, false);
            }
         }else if(mode == DeleteMode.FIRST_OCCURENCE){
            deleteOne(data, true);
         }else{
            deleteOne(data, false);
         }
    }

    private void deleteOne(int data,boolean onlyFirst){
           if(root == null){
            return;
           }

           if(root.left == null && root.right == null){
            if(root.data == data){
                root = null;
            }
            return;
           }

           Queue<Node> queue = new LinkedList<>();
           queue.offer(root);

           Node target = null;
           Node deepest = null;
           while (!queue.isEmpty()) {
              Node curr = queue.poll();
              deepest = curr;
              
              if(curr.data == data){
              if(onlyFirst){
                if(target == null){
                target =curr;
                }
              }else{
                target = curr;
              }
            }

            if(curr.left != null){
                queue.offer(curr.left);
            }

            if(curr.right != null){
                queue.offer(curr.right);
            }
           }

           if(target != null ){
            target.data = deepest.data;
            deleteDeepest(deepest);
           }
    }

    private void deleteDeepest(Node node){
        if(root == null){
            return ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.left != null){
                if(curr.left == node){
                    curr.left = null;
                    return;
                }else{
                    queue.offer(curr.left);
                }
            }

            if(curr.right != null){
                if(curr.right == node){
                    curr.right = null;
                    return;
                }else{
                    queue.offer(curr.right);
                }
            }
        }
    }
 }
public class Dec29 {

    public static void printNode(Node node,int level){
        if(node == null){
            return;
        }

       if(level == 0){
        System.out.print(node.data+" ");
       }else{
        printNode(node.left, level-1);
        printNode(node.right, level-1);
       }
    }

    static int diameter = 0;
    public static int height(Node node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(diameter, right+left+1);
        return 1+Math.max(left,right);
    }

    public static Node LCA(Node node,Node p,Node q){
        if(node == null || node == p||node == q){
            return node;
        }
 
        Node left = LCA(node.left, p, q);
        Node right = LCA(node.right, p, q);
        if(left != null && right != null){
            return node;
        }
        
        return (left != null)?left:right;
    }

    public static void mirror(Node node){
        if(node == null ){
            return;
        }

        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    public static void main(String[] args) {
        // Implement print nodes at a given level.
        MyBinaryTree b1 = new MyBinaryTree();
        b1.insertion(8);
        b1.insertion(9);
        b1.insertion(7);
        b1.insertion(1);
          b1.insertion(2);
        b1.insertion(3);
        b1.insertion(4);
        b1.insertion(5);

        b1.inorder(b1.root);
        System.out.println();
         printNode(b1.root, 1);
         System.out.println();
         printNode(b1.root, 2);
         System.out.println();
         printNode(b1.root, 3);
         System.out.println();
        
        //   Write a Java program to find diameter of a binary tree.
         System.out.println(height(b1.root));
         System.out.println("Diameter : "+diameter);
         diameter = 0;
         
        // Implement lowest common ancestor (LCA) in a binary tree.
       MyBinaryTree b2 = new MyBinaryTree();
       b2.insertion(8);
       b2.insertion(7);
       b2.insertion(6);
       b2.insertion(5);
       b2.insertion(4);
       b2.insertion(3);
       System.out.println(LCA(b2.root, b2.root.left, b2.root.right).data);

    //     Write a Java program to convert binary tree to its mirror.
      MyBinaryTree b3 = new MyBinaryTree();
      b3.insertion(7);
      b3.insertion(4);
      b3.insertion(5);
      b3.insertion(6);
        b3.insertion(4);
      b3.insertion(3);
      b3.insertion(2);
      b3.insertion(5);
      b3.insertion(1);
      mirror(b3.root);
      b3.inorder(b3.root);
      System.out.println();

    //   Implement delete a node from a binary tree.
       b3.delete(7, DeleteMode.DELETE_ALL);
       b3.inorder(b3.root);
       System.out.println();

          b3.delete(4, DeleteMode.FIRST_OCCURENCE);
       b3.inorder(b3.root);
       System.out.println();

          b3.delete(5, DeleteMode.LAST_OCCURENCE);
       b3.inorder(b3.root);
       System.out.println();
       

    }
}

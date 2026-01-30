import java.util.LinkedList;
import java.util.Queue;

enum DeleteMode{
    DELETE_ALL,
    FIRST_OCCCURRENCE,
    LAST_OCCURRENCE
}

class MyBinaryTree{
       private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

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
            Node current = queue.poll();

            if(current.left == null){
                current.left = newNode;
                return;
            }else{
                queue.offer(current.left);
            }

            if(current.right == null){
                current.right = newNode;
                return;
            }else{
                queue.offer(current.right);
            }
         }
      }

      public void delete(int data,DeleteMode mode){
        if(root == null){
            return;
        }

        if(mode == DeleteMode.DELETE_ALL){
            while (search(root, data)) {
                deleteOne(data,false);
            }
        }else if(mode == DeleteMode.FIRST_OCCCURRENCE){
            deleteOne(data, true);
        }else{
            deleteOne(data, false);
        }
      }

      private void deleteOne(int data, boolean onlyOne) {
    if (root == null) return;

      if (root.left == null && root.right == null) {
        if (root.data == data) {
            root = null;
        }
        return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    Node target = null;
    Node deepest = null;

    while (!queue.isEmpty()) {
        Node current = queue.poll();
        deepest = current;

        if (current.data == data) {
            if (onlyOne && target == null) {
                target = current;
            } else if (!onlyOne) {
                target = current;
            }
        }

        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
    }

    if (target != null) {
        target.data = deepest.data;
        deleteDeepestNode(deepest);
    }
}

      private void deleteDeepestNode(Node delNode){
             Queue<Node> queue = new LinkedList<>();
             queue.offer(root);

             while (!queue.isEmpty()) {
                Node current = queue.poll();

                if(current.left != null){
                if(current.left == delNode){
                    current.left = null;
                    return;
                }else{
                    queue.offer(current.left);
                }
            }

            if(current.right != null){
                if(current.right == delNode){
                    current.right = null;
                    return;
                }else{
                    queue.offer(current.right);
                }
            }
             }
      }
      public void inorder(Node node){
          if(node == null){
            return;
          }

          inorder(node.left);
          System.out.println(node.data);
          inorder(node.right);
      }

      public void preorder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
      }

      public void postorder(Node node){
        if(node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data);
      }

      public boolean search(Node node,int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            return true;
        }

        return search(node.left, data) || search(node.right, data);
      }
    }

public class Dec25 {
  public static void main(String[] args) {
    // Implement a binary tree using a Node class in Java.
      MyBinaryTree b = new MyBinaryTree();
      b.insertion(7);
      b.insertion(8);
      b.insertion(9);
      b.insertion(10);
      b.insertion(11);
      b.insertion(12);
      b.insertion(13);

      System.out.println("Inorder Traversal ");
      b.inorder(b.root);

      System.out.println("Preorder Traversal ");
      b.preorder(b.root);

      System.out.println("Postorder Traversal ");
      b.postorder(b.root);

      System.out.println("Search for 12 : "+b.search(b.root, 12));
      System.out.println("Search for 14 : "+b.search(b.root, 14));

      System.out.println("Inorder ");
      b.delete(12, DeleteMode.DELETE_ALL);
      b.inorder(b.root);

      System.out.println("Preorder ");
      b.delete(7, DeleteMode.FIRST_OCCCURRENCE);
       b.preorder(b.root);

       MyBinaryTree b2 = new MyBinaryTree();
       b2.insertion(7);
       b2.delete(7,DeleteMode.FIRST_OCCCURRENCE);
      b2.inorder(b2.root);
  }    
}

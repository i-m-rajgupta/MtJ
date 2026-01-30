import java.util.LinkedList;
import java.util.Queue;

enum DeleteMode{
       DELETE_ALL,
       FIRST_OCCURENCE,
       LAST_OCCURENCE,
}

class MyBinaryTree<T extends Comparable<T>>{
    private class Node<T>{
        T data;
        Node<T> left,right;
        Node(T data){
            this.data = data;
        }
    }

    Node<T> root;
    MyBinaryTree(){
        root = null;
    }

    public void insertion(T data){
        Node<T> newNode = new Node<>(data);

        if(root == null){
            root = newNode;
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            
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

    public void inorder(Node<T> node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    public void levelOrder(){
         if(root == null){
            return;
         }

         Queue<Node<T>> queue = new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                Node<T> node = queue.poll();
            System.out.print(node.data+" ");

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
        }

        System.out.println();
         }
    }

    public void delete(T data,DeleteMode mode){
       if(root == null){
        return;
       }       
       
       if(mode == DeleteMode.DELETE_ALL){
           while (search(data,root)) {
             deleteOne(data, false);
           }
       }else if(mode == DeleteMode.FIRST_OCCURENCE){
          deleteOne(data, true);
       }else{
        deleteOne(data, false);
       }
    }

    private void deleteOne(T data,boolean firstOnly){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(root.data.equals(data)){
                root = null;
            }
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        Node<T> target = null;
        Node<T> deepestNode = null;

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            deepestNode = current;

           if(firstOnly && target == null){
            target = current;
           }else{
            target = current;
           }

            if(current.left != null){
                queue.offer(current.left);
            }

            if(current.right != null){
                queue.offer(current.right);
            }
        }

        if(target != null){
            target.data = deepestNode.data;
            deleteDeepest(deepestNode);
        }
    }

    private void deleteDeepest(Node<T> node){
          if(node == null){
            return;
          }

          Queue<Node<T>> queue = new LinkedList<>();
          queue.offer(root);
          while (!queue.isEmpty()) {
            Node<T> curr = queue.poll();
            if(curr.left != null){
            if(curr.left == node){
               curr.left = null;
            }else{
                queue.offer(curr.left);
            }
        }

        if(curr.right != null){
            if(curr.right == node){
                curr.right = null;
            }else{
                queue.offer(curr.right);
            }
        }
          }
    }

    public boolean search(T key,Node<T> node){
        if(node == null){
            return false;
        }

        if(node.data.equals(key)){
            return true;
        }
        return search(key, node.left) || search(key, node.right);
    }

    public int count(Node<T> node){
        if(node == null){
           return 0;
        }

        return 1 + count(node.left) + count(node.right);
    }

    public int countLeafNode(Node<T> node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        return countLeafNode(node.left) + countLeafNode(node.right);
    }

    public int height(Node<T> node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1+Math.max(leftHeight,rightHeight);
    }

    public T maxElement(Node<T> node){
        if(node == null){
            return null;
        }

       T leftMax = maxElement(node.left);
       T rightMax = maxElement(node.right);

       T max = node.data;

       if(leftMax != null && leftMax.compareTo(max) >0){
          max = leftMax;
       }
      
       if(rightMax != null && rightMax.compareTo(max) >0){
         max = rightMax;
       }
     return max;   
    }
}

public class Dec26 {
  public static void main(String[] args) {
    // Write a Java program to count total nodes in a binary tree.
     MyBinaryTree<Integer> b = new MyBinaryTree<>();
     b.insertion(7);
     b.insertion(8);
     b.insertion(9);
     b.insertion(5);
     System.out.println("In order ");
     b.inorder(b.root);
     System.out.println("Count "+b.count(b.root));
     System.out.println("Level order ");
     b.levelOrder();

    b.delete(5, DeleteMode.FIRST_OCCURENCE);
    System.out.println("Inorder ");
    b.inorder(b.root);

     //  Implement a method to count leaf nodes in a binary tree.
     System.out.println("Level Order ");
     b.levelOrder();
     System.out.println("Leaf Nodes counts "+b.countLeafNode(b.root));

    //  Write a Java program to find the height of a binary tree.
    b.insertion(15);
    b.insertion(9);
    System.out.println("Height of binary tree "+b.height(b.root));

    // Implement a program to find maximum element in a binary tree.
    System.out.println("Level order ");
    b.levelOrder();
     System.out.println(b.maxElement(b.root));

    //  Implement search for a given key in a binary tree.
    System.out.println(b.search(15, b.root));

    
  }    
}

import java.util.LinkedList;
import java.util.Queue;

enum DeleteMode{
    DELETE_ALL,
    FIRST_OCCURENCE,
    LAST_OCCURENCE
}

class MyBinaryTree<T extends Comparable <T>>{
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

    public boolean search(T data,Node<T> node ){
        if(node == null){
            return false;
        }

        if(node.data.equals(data)){
            return true;
        }

        return search(data, node.left) || search(data, node.right);
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

    private void deleteOne(T data,boolean onlyFirst){
          if(root == null){
            return;
          }

          if(root.left == null && root.right == null ){
            if(root.data.equals(data)){
                root = null;
            }
            return;
          }

          Queue<Node<T>> queue = new LinkedList<>();
          queue.offer(root);
        
          Node<T> target = null;
          Node<T> deepest = null;

          while (!queue.isEmpty()) {
             Node<T> curr = queue.poll();
             deepest = curr;

             if(curr.data.equals(data)){
             if(onlyFirst && target == null){
                target = curr;
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

          if(target != null){
            target.data = deepest.data;
            deleteDeepestNode(deepest);
          }
        }

        private void deleteDeepestNode(Node<T> node){
            if(root == null){
                return;
            }

            Queue<Node<T>> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node<T> curr = queue.poll();
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
             for(int i =0;i<levelSize;i++){
            Node<T> curr = queue.poll();
             System.out.print(curr.data+" ");

             if(curr.left != null){
                queue.offer(curr.left);
             }

             if(curr.right != null ){
                queue.offer(curr.right);
             }
            }
            System.out.println();
          }
        }

        static class TreeInfo{
            int height;
            int maxDiameter;
            TreeInfo(int height,int maxDiameter){
               this.height = height;
               this.maxDiameter = maxDiameter;
            }

            @Override
            public String toString(){
               return height+" , "+maxDiameter;
            }
        }

        public TreeInfo diameter(Node<T> node){
             if(node == null){
                return new TreeInfo(0, 0);
             }

             TreeInfo leftInfo = diameter(node.left);
             TreeInfo rightInfo = diameter(node.right);

              int height = 1+Math.max(leftInfo.height, rightInfo.height);
              int maxDiameter = 1+leftInfo.height+rightInfo.height;

              maxDiameter = Math.max(maxDiameter, Math.max(leftInfo.maxDiameter, rightInfo.maxDiameter));
             return new TreeInfo(height, maxDiameter);
        }

        public int countNonLeaf(Node<T> node){
            if(node == null){
                return 0;
            }

            int leftCount = countNonLeaf(node.left);
            int rightCount = countNonLeaf(node.right);

            if(node.left == null && node.right == null){
                return 0;
            }
  
            return 1+leftCount+rightCount;
        }

        public void printLeaf(Node<T> node){
            if(node == null){
                return;
            }

            printLeaf(node.left);
            printLeaf(node.right);

            if(node.left == null && node.right == null){
                System.out.println(node.data);
            }
        }

        public void mirror(Node<T> node){
            if(node == null){
                return;
            }

            // The swap can happen either before or after recursion — the final mirrored tree is the same.
            
             mirror(node.left);
            mirror(node.right);
            Node<T> temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
}

public class Dec27 {
    public static void main(String[] args) {
       
         // Implement level order traversal using queue.
        MyBinaryTree<String> b = new MyBinaryTree<>();
        b.insertion("Ram");
             b.insertion("Rohan");
        b.insertion("Mohan");
        b.insertion("Shiv");
        b.insertion("Ganesh");
             b.insertion("Ram");
        b.insertion("Rohan");
        b.insertion("Lakhan");
              b.insertion("Shiv");
                   System.out.println("Level Order Traversal");
             b.levelOrder();
        b.delete("Rohan",DeleteMode.DELETE_ALL);
                  System.out.println("Level Order Traversal");
             b.levelOrder();
        System.out.println();
          b.delete("Shiv",DeleteMode.LAST_OCCURENCE);
                    System.out.println("Level Order Traversal");
             b.levelOrder();
        System.out.println();
            b.delete("Ram",DeleteMode.FIRST_OCCURENCE);
                  System.out.println("Level Order Traversal");
             b.levelOrder();
        System.out.println();

    //  Write a Java program to find the diameter of a binary tree
         System.out.println(b.diameter(b.root));

        //  Implement a method to count internal (non-leaf) nodes.
         System.out.println(b.countNonLeaf(b.root));

        //  Write a Java program to print all leaf nodes.
        b.printLeaf(b.root);

        // Implement mirror of a binary tree.
     b.mirror(b.root);
     b.levelOrder();
     b.inorder(b.root);
    }
}

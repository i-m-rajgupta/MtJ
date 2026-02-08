import java.util.*;


class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
}

class MyBinaryTree{
     Node root ;
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
}
public class Jan2 {
    public static void levelOrder(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int level = queue.size();
          for(int i =0;i<level;i++){
            Node curr = queue.poll();
            System.out.print(curr.data+" ");
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
          }
           System.out.println();
        }
    }
  static  class MaxPath{
        static int maxSum = Integer.MIN_VALUE;
        public static int maxPathSum(Node node){
           if(node == null){
            return 0;
           }

           if(node.left == null && node.right == null){
            return node.data;
           }

           int leftSum = Math.max(maxPathSum(node.left),0);
           int rightSum = Math.max(maxPathSum(node.right),0);

           int currentPathMax = node.data+leftSum+rightSum;
            maxSum = Math.max(maxSum, currentPathMax);
            return node.data+Math.max(leftSum, rightSum);
        }
    }

    public static void printPath(Node node,ArrayList<Integer> res){
        if(node == null){
            return;
        }

        res.add(node.data);
        if(node.left == null && node.right == null){
            System.out.println(res);
        }else{
        printPath(node.left, res);
        printPath(node.right, res);
        }
        res.remove(res.size()-1);
    }

    public static void printCount(Node node){
    if(node == null){
        return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    int level = 0;
    while (!queue.isEmpty()) {
        int count = queue.size();
        System.out.println("Level "+level+" has "+count+"  nodes.");
        level++;
        for(int i = 0;i<count;i++){
            Node curr = queue.poll();
            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
    }
    }

    public static int height(Node node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        if(left == -1){
            return -1;
        }

        int right = height(node.right);
        if(right == -1){
            return -1;
        }
        return 1+Math.max(left,right);
    }
    public static boolean isBalanced(Node node){
        return height(node) != -1;
    }

    public static void diagonalTraversal(Node node){
        if(node == null){
            return;
        }

       Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
       filldiagonal(node, 0, map);

       for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
          System.out.print("Diagonal "+entry.getKey()+" : ");
          ArrayList<Integer> list = entry.getValue();
          for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
          }
          System.out.println();
       }
    }

    private static void filldiagonal(Node node,int diagonal,Map<Integer,ArrayList<Integer>> map){
        if(node == null){
            return;
        }

        map.putIfAbsent(diagonal, new ArrayList<>());
        map.get(diagonal).add(node.data);

        filldiagonal(node.left, diagonal+1, map);
        filldiagonal(node.right, diagonal, map);
    }

    public static void diagonalTraversal2(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int diagonal = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("Diagonal "+diagonal+" : ");
            for(int i =0;i<size;i++){
                Node curr = queue.poll();
                while (curr != null) {
                    System.out.print(curr.data+" ");

                    if(curr.left != null){
                        queue.offer(curr.left);
                    }
                    curr = curr.right;
                }
            }
            System.out.println();
            diagonal++;
        }
    }
    public static void main(String[] args) {
        // Implement maximum path sum in a binary tree.
         MyBinaryTree b = new MyBinaryTree();
         b.insertion(-10);
         b.insertion(4);
         b.insertion(9);
         b.insertion(10);
         b.insertion(11);
         b.insertion(6);
         b.insertion(7);
         levelOrder(b.root);
         MaxPath.maxPathSum(b.root);
         System.out.println("Max : "+MaxPath.maxSum);

        //  Write a Java program to print all root-to-leaf paths.
         printPath(b.root, new ArrayList<>());

        //  Implement count of nodes at each level.
       printCount(b.root);

    //    Write a Java program to check if binary tree is height balanced.
        System.out.println(isBalanced(b.root));

        // Implement diagonal traversal of a binary tree.
        // Diagonal traversal of a binary tree is a way to print nodes that lie on the same diagonal line when 
        // the tree is viewed from the top-right (or top-left).

       diagonalTraversal(b.root);
         diagonalTraversal2(b.root);
    }
}

import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
}

class MyBinaryTree{
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
}

class Distance{
    private static Node LCA(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }

        return (left != null)?left:right;
    }

    private static int findLevel(Node LCA,int n1,int level){
          if(LCA == null){
            return -1;
          }

          if(LCA.data == n1){
            return level;
          }

          int left = findLevel(LCA.left, n1, level+1);
          if(left != -1){
            return left;
          }

          return findLevel(LCA.right, n1, level+1);
    }
    public static int findDistance(Node root,int n1,int n2){
     Node LCA = LCA(root, n1, n2);
     int d1 = findLevel(LCA, n1, 0);
     int d2 = findLevel(LCA, n2, 0);
     return d1+d2;
    }
}

 class BurnNode {
         int data ;
         BurnNode left,right,parent;
         BurnNode(int data){
            this.data = data;
         } 
            
        }

class MyBurnTree{
       BurnNode root ;
       MyBurnTree(){
           root = null;
       }

       public void insertion(int data){
        BurnNode newNode  = new BurnNode(data);
        if(root == null){
            root = newNode;
            return;
        }

        Queue<BurnNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BurnNode curr = queue.poll();
            if(curr.left == null){
                curr.left = newNode;
                curr.left.parent = curr;
                 return;
            }else{
                queue.offer(curr.left);
            }

            if(curr.right == null){
                curr.right = newNode;
                curr.right.parent = curr;
                return;
            }else{
                queue.offer(curr.right);
            }
        }
       }

       public void levelOrder(BurnNode node){
        if(node == null){
            return;
        }
        Queue<BurnNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0;i<size;i++){
              BurnNode curr = queue.poll();
              if(curr.parent == null){
                System.out.print(curr.data+" ");
              }else{
                System.out.print(curr.data+","+curr.parent.data+" ");
              }

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

        public boolean search(BurnNode node,int data){
               if(node == null){
                return false;
               }
               
               if(node.data == data){
                return true;
               }
               return search(node.left, data) || search(node.right, data);
        }

 private int burn(BurnNode target) {
    Queue<BurnNode> queue = new LinkedList<>();
    Set<BurnNode> visited = new HashSet<>();

    queue.offer(target);
    visited.add(target);

    int time = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        boolean burnedThisSecond = false;

        for (int i = 0; i < size; i++) {
            BurnNode curr = queue.poll();

            if (curr.left != null && !visited.contains(curr.left)) {
                visited.add(curr.left);
                queue.offer(curr.left);
                burnedThisSecond = true;
            }

            if (curr.right != null && !visited.contains(curr.right)) {
                visited.add(curr.right);
                queue.offer(curr.right);
                burnedThisSecond = true;
            }

            if (curr.parent != null && !visited.contains(curr.parent)) {
                visited.add(curr.parent);
                queue.offer(curr.parent);
                burnedThisSecond = true;
            }
        }

        if (burnedThisSecond) {
            time++;
        }
    }

    return time;
}

        public int burnTime(int Burndata){
           if(!search(root, Burndata)){
              System.out.println(Burndata+" not found !! ");
              return -1;
           }

           Queue<BurnNode> queue = new LinkedList<>();
           queue.offer(root);
           BurnNode target = null;
           while (target == null) {
              BurnNode curr = queue.poll();
              if(curr.data == Burndata){
                target = curr;
              }
               if(curr.left != null){
                queue.offer(curr.left);
               }
               if(curr.right != null){
                queue.offer(curr.right);
               }
           }

         return burn(target);
        }
    }

    class MyBST{
       private static ArrayList<Integer> arr = new ArrayList<>();
        private static void binaryToArr(Node node){
              if(node == null){
                return;
              }

              binaryToArr(node.left);
              arr.add(arr.size(),node.data);
              binaryToArr(node.right);
        }

        private static void arrToBst(Node node){
            if(node == null){
                return;
            }

            arrToBst(node.left);
            node.data = arr.remove(0);
            arrToBst(node.right);
        }

        public static void binaryToBst(Node node){
            if(node == null){
                return;
            }

            binaryToArr(node);
            Collections.sort(arr);
            arrToBst(node);
        }
    }

   class MyLargestBst{
     static class Info{
        boolean isBst;
        int min,max,size;

        Info(boolean isBst,int min,int max,int size){
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.size = size;
        }
     }

     private static int maxBst = 0;
    private  static Info largestBst(Node node){
        if(node == null){
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

       Info leftInfo = largestBst(node.left);
        Info rightInfo = largestBst(node.right);
        Info currInfo = new Info(false, 0, 0, 0);
       if(leftInfo.isBst && rightInfo.isBst && node.data > leftInfo.max && node.data < rightInfo.min){
        currInfo.isBst = true;
        currInfo.min = Math.min(leftInfo.min, node.data);
        currInfo.max = Math.max(rightInfo.max, node.data);
        currInfo.size = leftInfo.size+rightInfo.size+1;

        maxBst = Math.max(maxBst, currInfo.size);
       }else{
        currInfo.min = Integer.MIN_VALUE;
        currInfo.max = Integer.MAX_VALUE;
        currInfo.size = Math.max(leftInfo.size, rightInfo.size);
       }

       return currInfo;
     }

     public static int maxBst(Node node){
        maxBst = 0;
        largestBst(node);
        return maxBst;
     }
    
    }
public class Jan3 {
    public static void serialize(Node node,ArrayList<String> res){
        if(node == null){
            res.add("null");
            return;
        }

        res.add(String.valueOf(node.data));
        serialize(node.left, res);
        serialize(node.right, res);
    }

    public static Node deserialize(ArrayList<String> res){
        if(res.get(0).equals("null")){
            res.remove(0);
            return null;
        }
        
        String data = res.remove(0);
         Node newNode = new Node(Integer.parseInt(data));
        newNode.left = deserialize(res);
        newNode.right = deserialize(res);
        return newNode;
    }

    public static void levelOrder(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size;i++){
            Node curr = queue.poll();
             System.out.print(curr.data +" ");
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

    
    public static void main(String[] args) {
        // Write a Java program to find distance between two nodes.
         MyBinaryTree b = new MyBinaryTree();
         b.insertion(9);
         b.insertion(8);
         b.insertion(7);
         b.insertion(6);
         b.insertion(5);
         b.insertion(4);
         b.insertion(3);
      System.out.println(  Distance.findDistance(b.root, 9, 5));

    //   Implement serialize and deserialize a binary tree.
    // Serialize → convert a tree into a string (or list) so it can be stored or sent over a network
// Deserialize → convert that string back into the exact same tree structure

     ArrayList<String> serialize = new ArrayList<>();
     serialize(b.root, serialize);
     System.out.println(serialize);
    Node node = deserialize(serialize);
      levelOrder(node);

// Write a Java program to burning tree problem.
     MyBurnTree b2 = new MyBurnTree();
     b2.insertion(8);
     b2.insertion(7);
     b2.insertion(3);
     b2.insertion(5);
     b2.insertion(4);
     b2.insertion(3);
     b2.levelOrder(b2.root);
   System.out.println(b2.burnTime(3));

//    Implement convert binary tree to BST.
     MyBinaryTree b3 = new MyBinaryTree();
     b3.insertion(8);
      b3.insertion(9);
       b3.insertion(7);
        b3.insertion(6);
         b3.insertion(5);
          b3.insertion(3);
           levelOrder(b3.root);
     MyBST.binaryToBst(b3.root);
    levelOrder(b3.root);

    System.out.println(MyLargestBst.maxBst(b3.root));

    }
}

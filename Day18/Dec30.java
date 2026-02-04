import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left ;
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

    public void inorder(){
        if(root == null){
            return;
        }

       ArrayList<Integer> res = new ArrayList<>();
       ArrayDeque<Node> stack = new ArrayDeque<>();

       Node current = root;

       while (current != null || !stack.isEmpty()) {
           while (current != null) {
               stack.push(current);
               current = current.left;
           }

           current = stack.pop();
           res.add(current.data);

           current = current.right;
       }
       System.out.println(res);
    }

    public void preorder(){
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
    
        stack.push(root);
        while ( !stack.isEmpty()) {
           Node curr = stack.pop();
           res.add(curr.data);

           if(curr.right != null){
            stack.push(curr.right);
           }

           if(curr.left != null){
            stack.push(curr.left);
           }
        }
        System.out.println(res);
    }

    public void postorder(){
        if(root == null){
            return;
        }

        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();

        Node current = root;
        Node lastVisited = null;
        while (!stack.isEmpty() || current != null) {
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                Node peekNode = stack.peek();
                if(peekNode.right != null && lastVisited != peekNode.right){
                    current = peekNode.right;
                }else{
                    stack.pop();
                    res.add(peekNode.data);
                    lastVisited = peekNode;
                }
            }
        }
        System.out.println(res);
    }

    public void printZigZag(){
        if(root == null){
            return;
        }
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Node> currentLevel = new ArrayDeque<>();
        ArrayDeque<Node> nextLevel = new ArrayDeque<>();

        currentLevel.push(root);
        boolean leftToRight = true;
        while(!currentLevel.isEmpty()){
           Node curr = currentLevel.pop();
           res.add(curr.data);
           if(leftToRight){
             if(curr.left != null){
                nextLevel.push(curr.left);
             }
             if(curr.right != null){
                nextLevel.push(curr.right);
             }
           }else{
              if(curr.right != null){
                nextLevel.push(curr.right);
              }

              if(curr.right != null){
                nextLevel.push(curr.left);
              }
           }

           if(currentLevel.isEmpty()){
            ArrayDeque<Node> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            leftToRight = !leftToRight;
           }
        }
        System.out.println(res);
    }

    public boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(Node node,ArrayList<Integer> result){
         if(node == null){
            return;
         }

         Node curr = node.left;
         while (curr != null) {
        if(!isLeaf(curr)){
            result.add(curr.data);   
         }

         if(curr.left != null){
            curr = curr.left;
         }else{
            curr = curr.right;
         }
         }
    }

    private void addLeaves(Node node,ArrayList<Integer> result){
        if(node == null){
            return;
        }

        if(isLeaf(node)){
            result.add(node.data);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(Node node ,ArrayList<Integer> result){
        if(node == null){
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Node curr = node.right;
        while (curr != null) {
            if(!isLeaf(curr)){
                stack.push(curr.data);
            }

            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
    }

    public void boundaryTraversal(Node node){
        if(node == null){
            return;
        }

        ArrayList<Integer> result = new ArrayList<>();

        if(!isLeaf(node)){
            result.add(node.data);
        }

        addLeftBoundary(node, result);
        addLeaves(node, result);
        addRightBoundary(node, result);
        System.out.println(result);
    }
}
public class Dec30 {

    public static void main(String[] args) {
        // Implement iterative inorder traversal using stack.
          MyBinaryTree b1 = new MyBinaryTree();
           b1.insertion(1);
          b1.insertion(2);
          b1.insertion(3);
          b1.insertion(4);
          b1.insertion(5);
          b1.insertion(6);
          b1.insertion(7);
          b1.inorder();

        //  Implement iterative preorder traversal using stack.
         b1.preorder();

        //  Implement iterative postorder traversal.
         b1.postorder();

        //  Write a Java program to print zig-zag (spiral) traversal.
        b1.printZigZag();

        // Implement boundary traversal of a binary tree.
       b1.boundaryTraversal(b1.root);

    }
}

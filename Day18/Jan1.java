import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
}

class MyBinaryTree{
    int preIndex;
    Map<Integer,Queue<Integer>> inorderMap;

    MyBinaryTree(){
        preIndex = 0;
        inorderMap = new HashMap<>();
    }

    public  Node constructBinaryTree(int[] preOrder,int []inOrder){
        if(preOrder.length != inOrder.length){
            return null;
        }

          for(Integer i =0;i<inOrder.length;i++){
            inorderMap.computeIfAbsent(inOrder[i], k->new LinkedList<>()).add(i);
          }

        return  constructBinaryTree(preOrder, preIndex, preOrder.length-1);
    }


    private Node constructBinaryTree(int [] preorder,int inStart,int inEnd){
        if(inStart>inEnd){
            return null;
        }
        int rootVal = preorder[preIndex++]; 
        Node rootNode = new Node(rootVal);

        int inIndex = inorderMap.get(rootVal).poll();
        rootNode.left = constructBinaryTree(preorder, inStart, inIndex-1);
        rootNode.right = constructBinaryTree(preorder, inIndex+1, inEnd);

        return rootNode;
    }
}
public class Jan1 {
    public static void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public static void levelOrder(Node node){
        if(node == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int level = q.size();
            for(int i =0;i<level;i++){
                Node curr = q.poll();
                
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            System.out.println();
        }
    }
    public static void preorder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.data+" ");
           preorder(node.left);
        preorder(node.right);
    }
    public static void main(String[] args) {
        // Write a Java program to construct binary tree from inorder and preorder.
        int[] inorder = {10,8,8,7,12,9,13};
        int[] preorder = {7,8,10,8,9,12,13};
        MyBinaryTree b = new MyBinaryTree();
        Node head = b.constructBinaryTree(preorder, inorder);
        inorder(head);
        System.out.println();
        preorder(head);
        System.out.println();
        levelOrder(head);

        // Implement construct binary tree from inorder and postorder.

    }
}

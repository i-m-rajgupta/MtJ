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

        return  constructBinaryTree(preOrder, 0, inOrder.length-1);
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

class MyBinaryTree2{
    private int postIndex ;
    
    public Node buildTree(int inorder[],int postorder[]){
         if(inorder.length != postorder.length){
            return null;
         }  
        postIndex = postorder.length-1;
       return build(inorder,postorder, 0, inorder.length-1);
    }

    private int findIdx(int inorder[],int start,int end,int rootVal){
        for(int i = start;i<= end;i++){
            if(inorder[i] == rootVal){
                return i;
            }
        } 
       throw new RuntimeException("Value not found in inorder segment : "+rootVal);
    }
    private Node build(int inorder[],int postorder[],int inStart,int inEnd){
        if(inStart>inEnd){
            return null;
        }

        int rootVal = postorder[postIndex--];
        Node rootNode = new Node(rootVal);

        int inIndex = findIdx(inorder,inStart,inEnd,rootVal);
        rootNode.right = build(inorder,postorder, inIndex+1, inEnd);
        rootNode.left = build(inorder,postorder, inStart, inIndex-1);

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
    public static void postorder(Node node){
        if(node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }
    public static Node binaryToFlattenBinary(Node node){
          if(node == null){
            return null;
          }

          ArrayList<Integer> list = new ArrayList<>();
          ArrayDeque<Node> stack = new ArrayDeque<>();
          stack.push(node);
           while (!stack.isEmpty()) {
                Node current = stack.pop(); 
                list.add(current.data);

                if(current.right != null){
                    stack.push(current.right);
                }

                if(current.left != null){
                    stack.push(current.left);
                }
           }

           node = null;
          Node curr = null;
          while (!list.isEmpty()) {
            int val = list.remove(0);
            Node newNode = new Node(val);
            if(node == null){
               node = newNode;
               curr = node;
            }else{
                curr.right = newNode;
                curr = curr.right;
            }
          }
          return node;
    }

    public static Node flattenToLinkedList(Node node){
        if(node == null){
            return null;
        }

        Node head = null;
        Node prev = null;
        Node currNode = node;
        while (currNode != null) {
            if(head == null){
                head = currNode;
                prev = head;
            }else{
                prev.right = currNode;
                currNode.left = prev;
                prev = currNode;
            }
            currNode = currNode.right;
        }

        return head;
    }
    public static void main(String[] args) {
        // Write a Java program to construct binary tree from inorder and preorder.
        int[] inorder = {4,2,2,1,2,3};
        int[] preorder = {1,2,4,2,3,2};
        MyBinaryTree b = new MyBinaryTree();
        Node head = b.constructBinaryTree(preorder, inorder);
        inorder(head);
        System.out.println();
        preorder(head);
        System.out.println();
        levelOrder(head);

        // Implement construct binary tree from inorder and postorder.
        int inorder2[] = {4,2,5,1,6,3};
        int postorder2[] = {4,5,2,6,3,1};
        MyBinaryTree2 b2 = new MyBinaryTree2();
        Node head2 = b2.buildTree(inorder2, postorder2);
        inorder(head2);
        System.out.println();
        postorder(head2);
        System.out.println();
        levelOrder(head2);

         int inorder3[] = {4,2,2,1,2,3};
        int postorder3[] = {4,2,2,2,3,1};
        MyBinaryTree2 b3 = new MyBinaryTree2();
        Node head3 = b3.buildTree(inorder3, postorder3);
        inorder(head3);
        System.out.println();
        postorder(head3);
        System.out.println();
        levelOrder(head3);

        // Write a java program to flatten binary tree to linked list 
        Node  newNode = binaryToFlattenBinary(head3);
        levelOrder(newNode);

        Node headLL = flattenToLinkedList(newNode);
        Node curr = headLL;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.right;
        }

        System.out.println();

        // Implement sum tree conversion.
    }
}

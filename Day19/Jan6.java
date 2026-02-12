import java.util.*;


class HuffmanCoding{
    static class Node implements Comparable<Node>{
        char ch;
        int freq;
        Node left,right;

        Node(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq,Node left,Node right){
            this.ch = '\0';
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
        public int compareTo(Node other){
            return this.freq - other.freq;
        }

        public String toString(){
            return "("+ch+","+freq+")";
        }
    }

    public static void getHuffman(String str){
        if(str.length() == 0){
            return;
        }

        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
           map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Map.Entry<Character,Integer> e :map.entrySet()){
            pq.add(new Node(e.getKey(), e.getValue()));
        } 

        while (pq.size() >1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left.freq+right.freq, left,right));
        }

        Node root = pq.poll();
        HashMap<Character,String> res = new HashMap<>();
        buildCodes(root, "", res);

        for(Map.Entry<Character,String> e : res.entrySet()){
          System.out.println(e.getKey()+" "+e.getValue());
        }
    }

    private static void buildCodes(Node node,String code,Map<Character,String> res){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            res.put(node.ch,code);
            return;
        }
        buildCodes(node.left, code+"0", res);
        buildCodes(node.right, code+"1", res);
    }
}
public class Jan6 {

    public static void main(String[] args) {
        // Implement Huffman coding algorithm.
       String str = "Hello Java";
       HuffmanCoding.getHuffman(str);
    }
}

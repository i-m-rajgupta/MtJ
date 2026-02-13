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
    public static int getMinimumCost(int ropes[]){
        if(ropes.length <=1){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost =0;

        for(int i = 0;i<ropes.length;i++){
             pq.add(ropes[i]);
        }

        while (pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();
            int newCost = first+second;
            cost += newCost;
            pq.add(newCost);
        }
        return cost;
    }

    public static int getMinimumCostBoard(Integer horizontalCut[],Integer verticalCut[]){
        if(horizontalCut.length == 0 && verticalCut.length == 0){
            return 0;
        }
        Arrays.sort(horizontalCut,Collections.reverseOrder());
           Arrays.sort(verticalCut,Collections.reverseOrder());

        int cost = 0;
        int horizontalPieces = 1,verticalPieces = 1;
        int i =0,j=0;
        while (i<horizontalCut.length && j<verticalCut.length) {
              if(horizontalCut[i] > verticalCut[j]){
                cost += horizontalCut[i]*verticalPieces;
                horizontalPieces++;
                i++;
              }else{
                cost += verticalCut[j]*horizontalPieces;
                verticalPieces++;
                j++;
              }
        }

        while (i<horizontalCut.length) {
            cost += horizontalCut[i]*verticalPieces;
            horizontalPieces++;
            i++;
        }

        while (j<verticalCut.length) {
            cost += verticalCut[j]*horizontalPieces;
            verticalPieces++;
            j++;
        }
        return cost;
    }

    public static int min(int arr[],int start){
       int min = arr[start];
       int minIdx = start;
       for(int i =start+1;i<arr.length;i++){
        if(min > arr[i]){
            minIdx = i;
            min = arr[i];
        }
       }
       return minIdx;
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int minSwap(int arr[]){
        if(arr.length <= 1){
            return 0;
        }
        int swap = 0;
        for(int i =0;i<arr.length;i++){
            int j = min(arr, i);
            if(i != j ){
                swap(arr, i, j);
                swap++;
            }
        }
        return swap;
    }

    static class Chain implements Comparable<Chain>{
        int firstVal ,secondVal;
        Chain(int firstVal,int secondVal){
            this.firstVal = firstVal;
            this.secondVal = secondVal;
        }

        public int compareTo(Chain other){
            return this.secondVal - other.secondVal ; 
        }

        public String toString(){
            return "Chain ("+firstVal+","+secondVal+")";
        }
    }

    public static int maxLength1(int firstVal[],int secondVal[]){
        if(firstVal.length == 0){
            return 0;
        }
        if(firstVal.length != secondVal.length){
            System.out.println("Some data is missing !");
            return -1;
        }

        int length = 1;
        PriorityQueue<Chain> pq = new PriorityQueue<>();
        for(int i = 0;i<firstVal.length;i++){
          pq.add(new Chain(firstVal[i], secondVal[i]));
        }

        int last = pq.poll().secondVal;
        while (!pq.isEmpty()) {
            if(last < pq.peek().firstVal){
               last = pq.peek().secondVal;
               length++;
            }
            pq.poll();
        }
        return length;
    }

    public static int maxLength2(int firstVal[],int secondVal[]){
        if(firstVal.length == 0){
            return 0;
        }

        if(firstVal.length != secondVal.length){
           System.out.println("Some data has missing !!");
            return -1;
        }

        int length = 1;
        Chain chains[] = new Chain[firstVal.length];
        for(int i =0;i<chains.length ;i++){
            chains[i] = new Chain(firstVal[i], secondVal[i]);
        }
        Arrays.sort(chains);
        for(Chain c : chains){
            System.out.println(c);
        }
        int last = chains[0].secondVal;
        for(int i =1;i<chains.length;i++){
         if(last < chains[i].firstVal){
            last = chains[i].secondVal;
            length++;
         }
        }
        return length;
    }
    public static void main(String[] args) {
        // Implement Huffman coding algorithm.
       String str = "Hello Java";
       HuffmanCoding.getHuffman(str);

    //    Write a Java program to connect ropes with minimum cost.
    int ropes[] = {12,17,14,19,23};  
    int ropes1[]  = {1,2,3,4,5};
    System.out.println(getMinimumCost(ropes));
    System.out.println(getMinimumCost(ropes1));

    // Implement minimum cost to cut a board into squares.
   Integer horizontalCut[]= {1,4,2,1,3};
   Integer verticalCut[] = {1,2,4};
   System.out.println("Cost "+getMinimumCostBoard(horizontalCut, verticalCut));

//    Write a Java program to minimum number of swaps to make array sorted.
    int arr[] = {7,6,4,5,9};
    System.out.println("Minimum "+minSwap(arr));
    for(int i : arr){
        System.out.print(i+" ");
    }
    System.out.println();
    // Implement maximum length chain of pairs.
    int firstValue[] = {1,2,4,7};
    int secondValue[] = {8,3,6,9};
    System.out.println(maxLength1(firstValue, secondValue));
     System.out.println(maxLength2(firstValue, secondValue));
    }
}

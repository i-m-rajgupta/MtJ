import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Jan7 {
    public static int minimumDeletion(String str){
        if(str.length() <= 1){
            return 0;
        }
        int deletion = 0;
        int b_count = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
             deletion = Math.min(deletion+1, b_count);
            }else{
                b_count++;
            }
        }
        return deletion;
    }

    public static void minimumDeletionWithString(String str){
        int n = str.length();
        int prefixB[] = new int[n+1];
        int suffixA[] = new int[n+1];

        for(int i =0;i<n;i++){
            prefixB[i+1] = prefixB[i]+ ((str.charAt(i)=='b')?1:0);
        }

        for(int i = n-1;i>=0;i--){
            suffixA[i] = suffixA[i+1]+((str.charAt(i)=='a')?1:0);
        }

        int splitIdx = 0,minDeletion = Integer.MAX_VALUE;
        for(int i = 0;i<=n;i++){
            int deletion = suffixA[i]+prefixB[i];
            if(deletion<minDeletion){
                splitIdx = i;
                minDeletion = deletion;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<splitIdx;i++){
            if(str.charAt(i) == 'a'){
                sb.append('a');
            }
        }

        for(int i = splitIdx;i<n;i++){
            if(str.charAt(i) == 'b'){
                sb.append('b');
            }
        }
        System.out.println("Balanced String : "+sb.toString());
        System.out.println("Minimum Deletions : "+minDeletion);
    }

    public static int minJump(int arr[]){
      if(arr.length <= 1){
        return 0;
      }

      if(arr[0] == 0){
        return -1;
      }

      int jumps =0,currentEnd =0,farthest =0;
      for(int i =0;i<arr.length-1;i++){
        farthest = Math.max(farthest, i+arr[i]);
        if(currentEnd == i){
            jumps++;
            currentEnd = farthest;
            if(currentEnd <= i){
                return -1;
            }
            if(currentEnd >= arr.length-1){
                return jumps;
            }
           
        }
      }
      return jumps;
    }

    public static int candyDistribution(int rating[]){  //{2,6,4,3,5,8,9};
        if(rating.length <= 0){
            return 0;
        }

        int distributed[] = new int[rating.length];
        Arrays.fill(distributed,1);
        for(int i = 1;i<rating.length;i++){
           if(rating[i]>rating[i-1]){
              distributed[i] = distributed[i-1] +1;
           }
        }

        for(int i = rating.length-2;i>=0;i--){
            if(rating[i]>rating[i+1]){
                distributed[i] = Math.max(distributed[i], distributed[i+1]+1);
            }
        }
        int min =0;
        for(int i =0;i<distributed.length;i++){
            min += distributed[i];
            System.out.print(distributed[i]+" ");
        }
        System.out.println();
        return min;
    }

    static class Node implements Comparable<Node>{
        int freq;
        char ch;
        Node(char ch,int freq){
            this.freq = freq;
            this.ch = ch;
        }
 
        public int compareTo(Node other){
            return other.freq-this.freq;
        }

        public String toString(){
            return "("+ch+","+freq+")";
        }
    }
    public static void rearrange(String str){
       if(str.length() <= 1){
          return;
       }

       int n = str.length();
       Map<Character,Integer> map = new HashMap<>();
       PriorityQueue<Node> pq = new PriorityQueue<>();
       for(char c:str.toCharArray()){
           map.put(c, map.getOrDefault(c, 0)+1);
       }

       for(Map.Entry<Character,Integer> e: map.entrySet()){
        pq.offer(new Node(e.getKey(),e.getValue()));
       }

       if(pq.peek().freq >((n+1)/2)){
        System.out.println("Rearrange not possible");
         return;
       }

       StringBuilder sb = new StringBuilder();
       Node prev = null;
       while (!pq.isEmpty()) {
          Node curr = pq.poll();
          sb.append(curr.ch);
          curr.freq--;

          if(prev != null && prev.freq > 0){
            pq.offer(prev);
          }

          prev = curr;
       }
       
       System.out.println(sb.toString());
    }

    static class Meeting{
        int start,finish;
        Meeting(int start,int finish){
            this.start = start;
            this.finish = finish;
        }

        public String toString(){
            return "Meeting ("+start+","+finish+")";
        }
    }

    public static int getMinimumRoom(int start[],int finish[]){
        if(start.length == 0){
            return 0;
        }

        if(start.length != finish.length){
            System.out.println("Some data is missing !!");
            return -1;
        }

        Meeting[] meetings = new Meeting[start.length];
        for(int i =0;i<start.length;i++){
            meetings[i] = new Meeting(start[i], finish[i]);
        }

        Arrays.sort(meetings,Comparator.comparing((Meeting m)->m.start).thenComparing((Meeting m)->m.finish));
         
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.offer(meetings[0].finish);
        for(int i=1;i<meetings.length;i++){
            if(meetings[i].start>=ends.peek()){
               ends.poll();
            }
            ends.add(meetings[i].finish);
        }

        return ends.size();
    }
    public static void main(String[] args) {
        // Write a Java program to minimum deletions to make string balanced.
         String str = "aababbab";
         String str1 = "aaabbbaabb";
         System.out.println(minimumDeletion(str));
         minimumDeletionWithString(str);
         System.out.println(minimumDeletion(str1));
         minimumDeletionWithString(str1);

        // Implement minimum number of jumps to reach end of array.
        int arr[] = {2,2,1,2,1,1};
        System.out.println(minJump(arr));

        // Write a Java program to candy distribution problem.
        int rating1[] = {2,6,4,3,5,8,9};
        //  Every person get atleast one candy and person with higher rating get more than the immediate neighbors 
        //1,2,3,1,2,3,4
         System.out.println( candyDistribution(rating1));
         int rating2[] = {1,0,2};
          System.out.println( candyDistribution(rating2));

        // Implement rearrange string so that no two adjacent characters are same.
         rearrange("aaabbca");
         rearrange("aabaaccbbdd");

        // Write a Java program to minimum number of meeting rooms.
        int startTime[] = {2,5,7,7,6,4,3};
        int finishTime[] = {10,9,12,15,13,9,6};
        System.out.println(getMinimumRoom(startTime, finishTime));
    }
}

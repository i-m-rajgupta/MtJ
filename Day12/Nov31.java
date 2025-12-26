import java.util.ArrayList;

public class Nov31 {

    public static void coinCombination(int amount,int [] coins,int idx ,ArrayList<Integer> arr){
          if(amount == 0){
            System.out.println(arr);
            return;
        }

        if(idx == coins.length || amount < 0){
            return;
        }

        int coin =coins[idx]; 
        arr.add(coin);
        coinCombination(amount-coin, coins, idx, arr);
        arr.remove(arr.size()-1);
        coinCombination(amount, coins, idx+1, arr);
    }

    public static void segmentation(String str,int idx,StringBuilder word,ArrayList<String> arr,String [] dictionary){
       if(idx == str.length()){
        if(word.length() == 0 ){
        System.out.println(arr);
        }
        return;
       }

        word.append(str.charAt(idx));
       
        for(String dictWord : dictionary){
            if(word.toString().equals(dictWord)){
              arr.add(dictWord);

              segmentation(str, idx+1, new StringBuilder(),arr , dictionary);

              arr.remove(arr.size()-1);
            }
        }

        segmentation(str, idx+1, word, arr, dictionary);
         word.deleteCharAt(word.length()-1);
    }

    public static void parentheses(int N,int open,int close,StringBuilder str){
       if(open > N || close > N || close>open){
        return;
       }

       if(open == N && close == N){
        System.out.println(str);
        return;
       }

       if(open<N){
       str.append('(');
       parentheses(N, open+1, close, str);
       str.deleteCharAt(str.length()-1);
       }

       str.append(')');
       parentheses(N, open, close+1, str);
        str.deleteCharAt(str.length()-1);
    }

    public static String keypad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void keypadCombinations(ArrayList<String> result,String num,StringBuilder curr,int idx){
        if(num == null || num == "0" || num == "1"){
            return;
        }

        if(idx == num.length()){
            System.out.println(curr);
            return;
        }
          
        String letters = keypad[num.charAt(idx)-'0'];
        for(char ch : letters.toCharArray()){
            curr.append(ch);
            keypadCombinations(result, num, curr, idx+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public static void subsets(int[] arr,ArrayList<Integer> curr,int target,int sum,int idx){
             if(sum == target){
              System.out.println(curr); 
              return;
             }
            
        for(int i=idx;i<arr.length;i++){
           curr.add(arr[i]);
           subsets(arr,curr, target, sum+arr[i], i+1);
           curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        // Compute all possible coin change combinations for a given amount.
        int coins[] = {1,2,5,10,20};
        ArrayList<Integer> arr = new ArrayList<>();
        coinCombination(11, coins, 0, arr);

        // Word break problem: check if a string can be segmented into dictionary words.
        String dictionary[] = {"cats","cat","sand","and","dog","catsandd","og"};
        StringBuilder word = new StringBuilder("");
        ArrayList<String> arr1 = new ArrayList<>();
       segmentation("catsanddog", 0, word ,arr1 , dictionary);

       String dictionary1[] =  {"ilikesamsung","i","like","sam","sung","cat","samsung"};
       segmentation("ilikesamsungcat", 0, word, arr1, dictionary1);

    //    Generate all valid parentheses combinations for N pairs.
       parentheses(3, 0, 0, word);

    //    Generate all possible phone keypad combinations.
    ArrayList<String> result = new ArrayList<>();
    String num = "53";
    keypadCombinations(result,num,new StringBuilder(),0);

    // Find all subsets of an array with sum equal to a target.
     int arr2[] = {1,2,4,3,5};
    subsets(arr2,new ArrayList<Integer>(), 6,0, 0);
    }
}

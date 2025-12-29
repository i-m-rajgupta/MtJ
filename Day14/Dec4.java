import java.util.ArrayList;

public class Dec4 {
    public static void subsequences(String str,ArrayList<Character> word,int idx){
        if(idx == str.length()){
           System.out.println(word);
           return;
        }

        subsequences(str,word,idx+1);
    
         char ch = str.charAt(idx);
         word.add(ch);
         subsequences(str, word, idx+1);

          word.remove(word.size()-1);
    }

    public static void substrings(String str,int start ,int end){
         if(start == str.length()){
            return;
         }

         if (end>str.length()) {
            substrings(str, start+1, start+2);
            return;
         }

         System.out.println(str.substring(start, end));
         substrings(str, start, end+1);
    }
    public static void permutations(String str,String per){
         if(str.length() == 0){
            System.out.println(per);
            return;
         }

         for(int i = 0;i<str.length();i++){
             char curr =  str.charAt(i);
             String word = str.substring(0, i)+str.substring(i+1);
            permutations(word,per+curr);
         }
    }

    public static void parentheses(StringBuilder parentheses,int open,int close,int n){
        if(open == n && close == n){
            System.out.println(parentheses.toString());
            return;
          }

        if(open >n || close > open ){
            return;
        }

        if(open <n){
          parentheses.append("(");
          parentheses(parentheses,open+1,close,n);
           parentheses.deleteCharAt(parentheses.length()-1);
        }

          parentheses.append(")");
          parentheses(parentheses,open,close+1,n);
          parentheses.deleteCharAt(parentheses.length()-1);
    }

    public static void coinChange(int[] coin,int idx,int amount,ArrayList<Integer> coins){
        if(amount < 0 || idx >= coin.length){
            return;
        }

        if(amount == 0){
            System.out.println(coins);
            return;
        }  

        coins.add(coin[idx]);
        coinChange(coin, idx, amount-coin[idx], coins);
        coins.remove(coins.size()-1);
        coinChange(coin, idx+1, amount, coins);
    }

    public static void binaryToGray(ArrayList<Integer> binary,ArrayList<Integer> gray){
         gray.add(binary.get(0));
         for(int i=0;i<binary.size()-1;i++){
            gray.add((binary.get(i)^binary.get(i+1)));
         }
         System.out.println("Gray code for the binary "+binary+" is : "+gray);
    }

    public static void grayToBinary(ArrayList<Integer> gray,ArrayList<Integer> binary){
        binary.add(gray.get(0));
        for(int i=1;i<gray.size();i++){
           binary.add(gray.get(i)^binary.get(i-1));
        }
            System.out.println("Binary code for the Gray "+gray+" is : "+binary);
    }

    public static void genrateGray(int total,int n,ArrayList<String> result){
       if(n == 0){
         result.add("");
        return;
       }

       ArrayList<String> prev = new ArrayList<>();
       genrateGray(total,n-1,prev);
       
       for(String code : prev){
        result.add("0"+code);
       }
       
       for(int i =prev.size()-1;i>=0;i--){
        result.add("1"+prev.get(i));
       }

        if(total == n){
        System.out.println(result);
       }
    }
    
   public static void main(String[] args) {
    // Generate all substrings of a string.
    String str = "abc";
    substrings(str, 0, 1);
      subsequences(str, new ArrayList<>(), 0);
    // Generate all permutations of a string (without duplicates).
    permutations(str,"");

    // Generate all balanced parentheses for N pairs.
    parentheses(new StringBuilder(), 0, 0, 3);

    // Coin change problem (find all combinations).
    int coin[] = {1,2,5,10,20};
    coinChange(coin, 0, 5, new ArrayList<>());

    // N-bit Gray code generation
    ArrayList<Integer> binary = new ArrayList<>();
    binary.add(1);
    binary.add(0);
    binary.add(1);
    binary.add(1);
    binaryToGray(binary, new ArrayList<>());


    ArrayList<Integer> gray = new ArrayList<>();
    gray.add(1);
      gray.add(0);   // 1 1 1 1 => 
        gray.add(1);
          gray.add(1);
     grayToBinary(gray, new ArrayList<>());
          
    genrateGray(3, 3, new ArrayList<>());
   }    
}

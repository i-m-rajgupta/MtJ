public class demo {
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
   public static void main(String[] args) {
      substrings("abcd", 0, 1);
      
       
   }
}
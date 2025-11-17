import java.util.Arrays;

public class Oct26 {
    public static void main(String[] args) {
        // Convert a string to a char array (toCharArray()) and print all characters. 
        String s = "Adam";
        char ch[] = s.toCharArray();
        for(char i :ch)
        System.out.println(i);

        // Check if a string contains a specific word or letter (contains()). 
        System.out.println("String contains e : "+s.contains("e"));

        // Replace vowels in a string with *. 
     
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            if(c == 'a'|| c == 'e'||c == 'i'||c == 'o'||c == 'u'){
                s =s.replace(s.charAt(i), '*');
            }
        }
        System.out.println(s);

        // Check if two strings are anagrams (using sorting). 
        String s1 = "triangle";
        String s2 = "integral";
        
         ch= s1.toCharArray();
         Arrays.sort(ch);
         s1 = new String(ch);
         ch = s2.toCharArray();
         Arrays.sort(ch);
         s2 = new String(ch);
         if(s1.equalsIgnoreCase(s2)){
            System.out.println("These two strings are anagrams ");
         }else{
               System.out.println("These two strings are not anagrams ");
         }


        //  Swap case of each letter (convert lowercase → uppercase and vice versa). 
        String res = "";
        String s3 = new String("WaDali BroThers");
        for(int i=0;i<s3.length();i++){
            char c = s3.charAt(i);
          if(Character.isLowerCase(c)){
           res= res+ Character.toUpperCase(c);
          }else{
              res= res+ Character.toLowerCase(c);
          }
        }
        System.out.println(res);
        }
}

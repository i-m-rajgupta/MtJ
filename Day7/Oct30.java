import java.util.Scanner;

public class Oct30 {
    public static void main(String[] args) {
        // Remove all digits from a string (replaceAll("\\d","")). 
        System.out.println("Enter a string containing the digit : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s1 = s.replaceAll("\\d", "");
        System.out.println("After removing the digits : "+s1);

        // Count number of uppercase, lowercase, digits, and special characters. 
        int uppercase = 0,lowercase =0,digit =0,special =0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= 65 && ch<91){
               uppercase++;
            }else if(ch >=97 &&  ch <123){
                lowercase++;
            }else if(ch >= 48 && ch < 58){
                digit++;
            }else{
                special++;
            }
        }
        System.out.println("Number of uppercase ,lowercase,digit,special char in string is : "+uppercase+" , "+lowercase+" , "+digit+" , "+special);
          
        // Find the longest substring without repeating characters. 
        System.out.println("Enter any string : ");
        int longest = 0;
        String substring = "";
        String s2 = sc.next();
        for(int i=0;i<s2.length();i++){
            for(int j=i+1;j<=s2.length();j++){
                String str = s2.substring(i, j);
                boolean isRepeating = false;
                String res = "";
                for(int k=0;k<str.length();k++){
                    char ch = str.charAt(k);
                    if(res.indexOf(ch) != -1){
                      isRepeating = true;
                      break;
                    }
                    res += ch;
                }
                if(!isRepeating && longest<str.length()){
                    longest = str.length();
                    substring = str;
                }
            }
        }
   
        System.out.println("Longest sustring with non repeating characters is : "+substring);

        // Find the first non-repeating character in a string. 
        boolean isRepeating = false;
        char ch = ' ';
        for(int i=0;i<s2.length();i++){
          ch = s2.charAt(i);
             isRepeating = false;
            for(int j=i+1;j<s2.length();j++){
               if(ch == s2.charAt(j)){
                  isRepeating = true;
                  break;
               }
            }
            if(!isRepeating){
              break;
            }
        }
        System.out.println("The first non repeating character is : "+ch);

        // Remove all occurrences of a specific substring from a main string. 
        String s4 = "javaprogramprogram";
        String res = s4.replaceAll("pro", "");
        System.out.println("After removing all occurences of pro in the string : "+res);
    }
}

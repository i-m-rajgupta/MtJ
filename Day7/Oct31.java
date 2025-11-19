import java.util.Arrays;

public class Oct31 {
    public static void main(String[] args) {
        // Longest Common Prefix (Among Strings).
        String arr[] = {"flower","flow","flowing"};
        String word = arr[0];
        boolean isPrefix = true;
        String prefix = "";
        for(int i=0;i<word.length();i++){
        char ch = word.charAt(i);
        for(int j =1;j<arr.length;j++){
            if(arr[j].length() == i || ch != arr[j].charAt(i)){
                isPrefix = false;
                break;
            }
        }
        if(!isPrefix){
            break;
        }else{
            prefix += ch;
        }    
        }
        System.out.println("Longest common prefix is : "+prefix);

        // Check if Two Strings are Anagrams.
        String s1 = "listen";
        String s2 = "silent";

        char charArr[] = s1.toCharArray();
        Arrays.sort(charArr);
        s1 = new String(charArr);
        charArr = s2.toCharArray();
        Arrays.sort(charArr);
        s2 = new String(charArr);
        if(s1.length() == s2.length() && s1.equals(s2)){
            System.out.println("Two strings are Anagrams");
        }else{
            System.out.println("These string are not anagrams ");
        }

        // Encode and Decode Strings.
       String arr1[] = {"india","nepal","srilanka"};
       String code = "#4";
       String res = code;
       res += String.join(code, arr1);
       System.out.println(res);

    //    Check if a String Can Be Formed by Rotation.
    String s4 = "abcde";
    String s5 = "cdeab";
    String merge = s4+s4;
    if(s4.length() == s5.length() && merge.contains(s5)){
      System.out.println("A string can be formed by rotation ");
    }

    // String Compression. 
    String s6 = "wwwwaaadexxxxxxywww";
    res = "";
    int count =0;
    for(int i=0;i<s6.length();i++){
        char ch = s6.charAt(i);
        count++;

        if(i == s6.length()-1){
            res += ch ;
            res += count;
            break;
        }

        if(ch != s6.charAt(i+1)){
            res += ch ;
            res += count;
            count =0;
        }
    }
    System.out.println(res);
    }
}

import java.util.Scanner;

public class Oct29 {
    public static void main(String[] args) {
        //  Check if string s2 is a rotation of string s1 (using s1+s1).
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string ");
        String s1 = sc.next();
        System.out.println("Enter string made by rotating by first string ");
        String s2 = sc.next();
         String merge = s1+s1;
       if(s2.length() == s1.length() && merge.contains(s2)){
        System.out.println("s2 is rotation of string s1");
       }else{
          System.out.println("s2 is not the rotation of string s1");
       }

    //    Check if one string is substring of another (contains() or indexOf() > -1). 
    System.out.println("Enter the substring of string ");
    String s3 = sc.next();
    if(s1.contains(s3)){
        System.out.println("s3 is substring of s1");
    }else{
         System.out.println("s3 is not a substring of s1");
    }

    // Check if two strings are equal ignoring case (equalsIgnoreCase()). 
    String s4 = "ram";
    String s5 = "Ram";
    System.out.println(s4.equalsIgnoreCase(s5));

    // Validate if a string is a valid palindrome ignoring spaces/case. 
    String s6 = "A man a plan a canal Panama";
     s6 = s6.toLowerCase();
     s6 = s6.replaceAll(" ", "");
     System.out.println(s6);
     int start =0,end = s6.length()-1;
     boolean isPalindrome = true;
     while (start<end) {
        if(s6.charAt(start) != s6.charAt(end)){
            isPalindrome = false;
            break;
        }
        start++;
        end--;
     }
     System.out.println("This String is palindrome : "+isPalindrome);

    //  Check if a string starts or ends with a particular substring (startsWith(), endsWith()). 
    String s7 = "Java Programming ";
    System.out.println(s7.startsWith("jav"));
    System.out.println(s7.endsWith("ing "));
    }
}

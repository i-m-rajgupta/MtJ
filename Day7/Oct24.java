import java.util.Scanner;

public class Oct24 {
    public static void main(String[] args) {
        // Check if a string is palindrome or not. 
        System.out.println("Enter any String : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int start =0,end = s.length()-1;
        boolean isPalindrome = true;
        while(start<end){
           if(s.charAt(start) != s.charAt(end)){
                isPalindrome =false;
                break;
           }
           start++;
           end--;
        }

        if(isPalindrome){
            System.out.println(s+" is Palindrome.");
        }else{
               System.out.println(s+" is not a Palindrome.");
        }

        // Compare two strings lexicographically (compareTo()). 
        String s1 = "Aoor";
        String s2 = "aork";
        System.out.println(s1.compareTo(s2)); 

        // Convert a string to uppercase and lowercase. 
        System.out.println("Uppercase : "+s1.toUpperCase());
             System.out.println("Lowercase : "+s1.toLowerCase());

    //   Trim leading and trailing spaces from a string (trim()). 
        String s3 = "   hello";
        System.out.println("Trimmed : "+s3.trim()); 

        // Replace all spaces with underscores (replace(" ", "_")). 
        String s4 = "I Like Coding";
        System.out.println(s4.replace(" ", "_"));
    }
}

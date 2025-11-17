import java.util.Scanner;

public class Oct25 {
    public static void main(String [] args){
        // Print every character of a string using charAt(i).
        System.out.println("Enter  any string");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("Each character of string are : ");
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i));
        }
        // Count occurrences of a particular character. 
        System.out.println("Enter character of string to count : ");
        char ch = sc.next().charAt(0);
        int count =0;
        for(int i=0;i<s.length();i++){
         if(ch == s.charAt(i)){
            count++;
         }
        }
        System.out.println("Count of character in the string is : "+count);

        // Find the index of the first and last occurrence of a character (indexOf(), lastIndexOf()). 
        System.out.println("First Occurence of character in the string at "+s.indexOf(ch));
        System.out.println("Last Occurence of character in the string at "+s.lastIndexOf(ch));

        // Extract a substring using substring(start, end). 
        System.out.println("Substring from string is "+s.substring(2, 5));

        // Reverse a string manually using charAt(). 
        int start =0;
        int end = s.length()-1;
        for(int i=0;i<s.length()/2;i++){
            char f = s.charAt(end);
            s.charAt(end);
            s.charAt(f);
        }
        System.out.println(s);
    }
}

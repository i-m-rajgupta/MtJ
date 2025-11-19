import java.util.Scanner;

public class Oct28 {
    public static void main(String[] args) {
        // Extract domain name from an email (using split("@")). 
        System.out.println("Enter your email address : ");
        Scanner sc = new Scanner(System.in);
        String email =  sc.next();
        String afterSplit[] = email.split("@");
        System.out.println("Domain name : "+afterSplit[0]);

        // Find all substrings of a given string. 
        System.out.println("Enter any string : ");
        String s = sc.next();
        for(int i =0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
            System.out.println(s.substring(i, j));
            }
        }

        // Remove duplicate characters from a string. 
        int map[] = new int[256];
        System.out.println("Enter string for removing duplicates : ");
        String s1 = sc.next();
        String res = "";
        for(int i =0;i<s1.length();i++){
           char ch = s1.charAt(i);
        if(map[ch] == 0){
            res += ch;
            map[ch]++;
        }
        }

        res ="";
        // without using the extra space 
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
           
          if(res.indexOf(ch) == -1){
            res += ch;
          }
        }
        System.out.println("After removing the duplicates from the string is :"+res);

        int map2[] = new int[256];
        // Count frequency of each character using an array. 
        for(int i =0;i<s1.length();i++){
            char ch = s1.charAt(i);
             map2[ch]++;
        }
        System.out.println("Frequency of each char at string : ");
            for(int i =0;i<res.length();i++){
            char ch = res.charAt(i);
            System.out.println(ch+" : "+ map2[ch]);
        }

        // Find the longest word in a sentence. 
        System.out.println("Enter any sentence : ");
        sc.nextLine();
        String sent = sc.nextLine();
        String arr[] = sent.split(" ");
        String longest ="";
        for(String word:arr){
           if(longest.length() < word.length()){
            longest = word;
           } 
        }
        System.out.println("Longest word in the sentence is : "+longest);
    }
}

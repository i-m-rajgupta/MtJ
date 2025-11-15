import java.util.Scanner;

public class Oct23 {
   public static void main(String [] args){
      // Create a string using both literals and new String(). Compare them using == and .equals(). 
      String s1 = "Raj";
      String s2 = new String("Raj");
      System.out.println(s1 == s2);
      System.out.println(s1.equals(s2));

      // Find the length of a string using length(). 
      System.out.println(s1.length());

      // Concatenate two strings using + and concat(). 
      System.out.println(s1+""+s2);
      System.out.println(s1.concat(s2));

      // Take a sentence input and count total characters (including spaces). 
      System.out.println("Enter a beautiful sentence : ");
      Scanner sc = new Scanner(System.in);
      String sen = sc.nextLine();
      System.out.println("Length of "+sen+" is "+sen.length());

      // Count the number of vowels and consonants in a string. 
      int vowels =0,consonants =0;
      for(int i=0;i<s2.length();i++){
         char ch = s2.charAt(i);
         if(ch == 'a' || ch == 'e' || ch == 'i' || ch=='o'||ch=='u'){
            vowels++;
         }else{
            consonants++;
         }
      }

      System.out.println("Vowels and Consonants in "+s2+" is "+vowels+" and "+consonants);

      sc.close();
   } 
}

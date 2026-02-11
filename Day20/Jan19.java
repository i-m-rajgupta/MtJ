import java.util.*;

public class Jan19 {
    public static int compareByte(byte a,byte b){
     return Byte.compare(a,b);
    }

    public static int compareCharacter(char a,char b){
        return Character.compare(a,b);
    }

    public static int compareBoolean(boolean a,boolean b){
        return Boolean.compare(a,b);
    }
    public static void main(String[] args) {
        // Write a program to compare two Byte values using Byte.compare().
         System.out.println(compareByte((byte) 5, (byte) 8));
           System.out.println(compareByte((byte) 8, (byte) 5));
       
        //    Write a program to compare two characters using Character.compare().
        System.out.println(compareCharacter('a', 'A'));
          System.out.println(compareCharacter('A', 'a'));

        //   Write a program to compare two boolean values using Boolean.compare().
        System.out.println(compareBoolean(false, false));
        System.out.println(compareBoolean(false, true));
        System.out.println(compareBoolean(true, false));

        // Write a Java program to compare two strings ignoring case using equalsIgnoreCase().
        String s1 = "Hello";
        String s2 = "Java";
        String s3 = "hello";
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.equalsIgnoreCase(s3));

        // Write a program to sort strings ignoring case using compareToIgnoreCase().
        List<String> list = Arrays.asList("Banana","Grapes","Apples","Kiwi");

        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}

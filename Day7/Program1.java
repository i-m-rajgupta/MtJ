public class Program1 {
    public static void main(String[] args) {
              // String literal 
   String s = "Raj";              
   System.out.println(s);

// new keyword
   String s1 = new String("Raj");
   System.out.println(s1);

   String s2 = "Raj";
   System.out.println(s1 == s2);
   System.out.println(s == s2);

//   == checks refrence  
//   .equals()
    System.out.println(s1.equals(s));

    // Array
    char ch[] = {'J','a','v','a'};
    String s4 = new String(ch);
    System.out.println(s4);
    byte cn[] = {97,98,99};     // a -> 97 b-> 98 c -> 99   byte - 1 char - 2 
    String s5 = new String(cn);
    System.out.println(s5);

    System.out.println("Length "+s5.length());
    System.out.println(s5.charAt(0));
    String s6 = "ILIKECODING";
    System.out.println(s6.substring(0,5));
      System.out.println(s6.substring(2,7));
          System.out.println(s6.substring(5));

          System.out.println(s.equals("raj"));
          System.out.println(s.equalsIgnoreCase("raj"));
        //  lexicographically 97 65
        System.out.println(s.compareTo("Raj"));

        System.out.println(s5.toUpperCase().toLowerCase());
        System.out.println(s.toLowerCase());

        String s7 = "    heello    ";
        System.out.println(s7.trim().concat(s));

       System.out.println("raj "+"gupta");
       System.out.println(s6.startsWith("ILIK"));
         System.out.println(s6.endsWith("ING"));
         System.out.println(s6.contains("CODING"));
         System.out.println(s.indexOf('a'));

         System.out.println(s.replace('a', 'o'));
    }
}

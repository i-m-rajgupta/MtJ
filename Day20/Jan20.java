import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Jan20 {
        public static void main(String[] args) {
        // Write a program showing difference between == and equals() for strings.
        String s1 = new String("Hello");
        String s2 = "Hello";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(52.10+85.605);
        // Write a program comparing two BigDecimal values using compareTo().
        BigDecimal num1 = new BigDecimal("52.10");
        BigDecimal num2 = new BigDecimal("85.605");
        System.out.println(num1.compareTo(num2));

        BigDecimal num3 = new BigDecimal("52.10");
        // Write a program showing different results of BigDecimal.equals() and compareTo().
        System.out.println(num1.equals(num3));
        System.out.println(num1.compareTo(num3));

        // Write a Java program to compare two BigInteger values using compareTo().
        BigInteger i1 = new BigInteger("8");
        BigInteger i2 = new BigInteger("9");
        System.out.println(i1.compareTo(i2));
       
        // Write a program to check equality of two BigInteger objects using equals().
        System.out.println(i1.equals(i2));
    }
}

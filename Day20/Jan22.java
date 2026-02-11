import java.time.LocalDate;
import java.util.*;

public class Jan22 {
    public static void main(String[] args) {
        // Write a program to find the maximum element in a list using Collections.max().
        List<Integer> list1 = Arrays.asList(8,7,7,56);
        List<Integer> list2 = Arrays.asList(4,3,2);
        System.out.println(Collections.max(list1));

        // Write a program to count the frequency of an element using Collections.frequency().
        System.out.println(Collections.frequency(list1, 7));
        System.out.println(Collections.frequency(list1,8));
        System.out.println(Collections.frequency(list1, 9));

        // Write a program to check whether two collections are disjoint using Collections.disjoint().
        System.out.println(Collections.disjoint(list1, list2));

        // Write a Java program to compare two LocalDate objects using isBefore().
        System.out.println(LocalDate.now().compareTo(LocalDate.ofYearDay(85, 9)));
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2006, 5, 11)));

        // Write a program to compare two LocalDateTime objects using isAfter().
        System.out.println(LocalDate.now().isAfter(LocalDate.of(2004, 5, 15)));

        
    }
}

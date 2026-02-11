import java.text.Collator;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
enum level  {LOW,MIDDLE,HIGH};

public class Jan23 {
    public static void main(String[] args) {
        // Write a program to check if two dates are equal using isEqual().
        System.out.println(LocalDate.now().isEqual(LocalDate.of(2026, 2, 11)));
        System.out.println(LocalDate.of(1987, 5,14 ).isEqual(LocalDate.of(1986,2,11)));

        // Write a program to sort dates using compareTo().
        LocalDate[] dates=  {
            LocalDate.of(1987, 5, 6),
             LocalDate.of(1947, 8, 15),
              LocalDate.of(2000, 4, 6),
        };

        Arrays.sort(dates,(d1,d2)->d1.compareTo(d2));
        for(LocalDate date : dates){
            System.out.println(date);
        }

        // Write a program to compare two Optional<Integer> objects using equals().
        Optional<Integer> opt1 =  Optional.of(5);
             Optional<Integer> opt2 =  Optional.of(5);
                  Optional<Integer> opt3 =  Optional.of(7);
                  Optional<Integer> opt4 = Optional.ofNullable(null);
                  Optional <Integer> opt5 = Optional.empty();
        System.out.println(opt1.equals(opt5));
        System.out.println(opt1.equals(opt4));
        System.out.println(opt1.equals(opt3));
        System.out.println(opt1.equals(opt2));

        // Write a program to compare two locale-specific strings using Collator.compare().
        String str2 = "z";
        String str1 = "ä";
    
        Locale locale = Locale.GERMAN;
        Collator collator = Collator.getInstance(locale);
        System.out.println(collator.compare(str1, str2));

        // Write a Java program that:
// •	Finds min and max using streams
// •	Compares two enum constants using compareTo()
// •	Uses regex matches() and find()

      
    List<Integer> numbers = Arrays.asList(5,8,7,6);
    System.out.println(numbers.stream().min(Integer::compareTo).get());
    System.out.println(numbers.stream().max(Integer::compareTo).get());
    level l1 = level.LOW;
    level l3 = level.HIGH;
     System.out.println(l1.compareTo(level.LOW));
     System.out.println(l3.compareTo(level.LOW));

     String str3 = "96755a00";
     String str4 = "95687"; 
     System.out.println(str3.matches("\\d+"));
     System.out.println(str4.matches("\\d+"));

     Pattern pattern = Pattern.compile("\\d+");
     Matcher matcher = pattern.matcher(str4);

     if(matcher.find()){
        System.out.println(matcher.group());
     }

     matcher = pattern.matcher(str3);
     if(matcher.find()){
        System.out.println(matcher.group());
     }
    }
}

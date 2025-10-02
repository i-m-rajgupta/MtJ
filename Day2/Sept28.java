import java.util.Scanner;

public class Sept28 {
    public static void main(String [] args){

        // Unicode is the most fundamental and universal 
        // character encoding standard. For every character, there is a unique 4 to 6-digit unique hexadecimal number.

        // ASCII is a subset of Unicode.  For the character 'A', the ASCII representation is 0065 and the unicode point is U+0041.
        // This is because the U+0041 is in hexadecimal form! which corresponds to 0065 in Decimal.(0041)16 = (0065)10

        Scanner sc = new Scanner(System.in);
    //    System.out.println("Enter any integer ");
    //    int var = sc.nextInt();
    //    char v = (char) var;
    //    System.out.println(v);

        // // Write a program to check whether a character is uppercase, lowercase, a digit, or a special symbol. 
        // System.out.println("Enter any single character : ");
        // char ch = sc.next().charAt(0);
         
        // System.out.println(ch);
        // int charInt =  ch ;
        // System.out.println(charInt); 
    //A-65 90-Z a-97 z-122 0-48 9-57
        // if(charInt >= 65 && charInt <91){ 
        //     System.out.println("Character is a Upper Case ");
        // }else if(charInt >= 97 && charInt <123){
        //      System.out.println("Character is a Lower Case");
        // }else if(charInt >= 48 && charInt <58){
        //        System.out.println("Character is a digit");
        // } else {
        //     System.out.println("Character is a Special symbol");
        // }

        // // Write a program to check if a number is divisible by 5 and 11. 
        // System.out.println("Enter any number");
        // int num = sc.nextInt();
        // if(num %5 == 0 && num % 11 == 0){
        //     System.out.println(num+" is divisible by 5 and 11");
        // } else {
        //         System.out.println(num+" is not divisible by 5 and 11");
        // }
        //  if(num %55 == 0){
        //     System.out.println(num+" is divisible by 5 and 11");
        // } else {
        //         System.out.println(num+" is not divisible by 5 and 11");
        // }

        // // Write a program to check whether a triangle is equilateral, isosceles, or scalene. 
        // System.out.println("Enter three side of Triangle");
        // float s1 = sc.nextFloat(); // 4 4 4
        // float s2 = sc.nextFloat();
        // float s3 = sc.nextFloat();
        // if(s1 != s2){
        //     if(s2 != s3 && s1 != s3){
        //         System.out.println("Triangle is Scalene Triangle");
        //     }else {
        //           System.out.println(" Triangle is an Isoceles Triangle ");
        //     }
        // }else if(s2 != s3){
        //     System.out.println("Triangle is Isoceles Triangle ");
        // } else {
        //        System.out.println("Triangle is Equilateral Triangle ");
        // }

        // // Write a program to calculate grade of a student based on marks: 
        // System.out.println("Enter your marks");
        // float marks = sc.nextFloat();
        // if(marks < 60){
        //     System.out.println("Fail");
        // } else if(marks >= 60 && marks < 70){
        //     System.out.println("D");
        // } else if(marks >= 70 && marks < 80){
        //     System.out.println("C");
        // } else if(marks >= 80 && marks <90){
        //     System.out.println("B");
        // } else if(marks >= 90 && marks <= 100){
        //     System.out.println("A");
        // } else {
        //     System.out.println("Enter valid marks out of 100");
        // }

        // // Write a program to check whether the entered day number (1–7) corresponds to a weekday or weekend. 
        // System.out.println("Enter day no. between 1 to 7");
        // int day = sc.nextInt();
        // if(day >= 1 && day <= 5){
        //     System.out.println(day+"th day is Weekday"); 
        // }else if(day > 5 && day <= 7 ){
        //       System.out.println(day+"th day is Weekend");
        // }else {
        //     System.out.println("Enter valid day no.");
        // }

        // switch (day) {
        //     case 1:
        //       case 2:
        //        case 3:
        //         case 4:
        //          case 5:
        //           System.out.println(day+"th day is Weekday");   
        //         break;
        //     case 6:
        //     case 7 :
        //     System.out.println(day+"th day is Weekend");
        //     break ;
        //     default:
        //     System.out.println("Enter valid day no.");
        //         break;
        // }
  sc.close();
    }
}

import java.util.Scanner;

public class Program2 {
    public static void main(String [] args){
//    Conditional Statements 
// if statement
    //   syntax if(boolean){condition}
    // int age = 17;
    // if(age>=18){
    //     System.out.println("You are eligible to vote ");
    // }
    // System.out.println("Block executed");
    // you have to take input from user and if the color is black then you have to print this is a black color 
 
    Scanner sc = new Scanner(System.in);
    // System.out.println("Enter any color");
    // String color = sc.next();
    // String color2 = "black";
    // if(color.equals(color2)){
    //     System.out.println("This is a black color");
    // }
    // System.out.println("This is  not a black color");
    // System.out.println("Enter any number");
    // int num = sc.nextInt();
    // if((num%2) == 0){
    //     System.out.println("This is an even number");
    // }else{
    //     System.out.println("This is an odd number ");
    // }
    // System.out.println("Code Executed");
    // sc.close();
   
    //Nested if-else statement 
//   take a input from user and print you are eligible for vote 18>= or you are minor 
//  System.out.println("Enter any number");
//     int age = sc.nextInt();
//     if(age >= 18){
//         if(age>=60){
//             System.out.println("You are senior citizen");
//         }else{
//            System.out.println("You are Youth");
//         }
//         System.out.println("Eligible to vote ");
//     }else{
//         System.out.println("You are minor ");
//     }
//     System.out.println("Code Executed");
//     sc.close();

    // take marks 33 pass else fail 60 first division second division

// System.out.println("Enter any marks");
//     int marks = sc.nextInt();
//     if(marks >= 33){
//         if(marks >=60){
//             System.out.println("Pass with First Division ");
//         }else{
//            System.out.println("Pass with Second Division ");
//         }
//         System.out.println("You are Pass");
//     }else{
//         System.out.println("You are Fail");
//     }
//     System.out.println("Code Executed");


    // ifelseif

    System.out.println("Enter month no.");
    //  String trafficColor = sc.next();

    //  if(monthNum <=4){
    //     System.out.println("Our month will come in between Janauary to a April");
    //  }else if(monthNum >4 && monthNum<9){
    //    System.out.println("Month will be coming in May to August");
    //  }else{
    //       System.out.println("Month will be coming in September to December"); 
    //  }
 

    //   switch(monthNum){
    //     case 1 :
    //     case 2 :
    //     case 3 :
    //     case 4 :
    //     System.out.println("Our month will come in between Janauary to a April");
    //     break;
    //     case 5 :
    //     case 6 :
    //     case 7 :
    //    case 8:
    //     System.out.println("Our month will come in between May to a August");
    //     break;
    //     case 9 :
    //     case 10 :
    //     case 11:
    //      case 12:
    //     System.out.println("Our month will come in between Sept to a Dec");
    //     break;
    //     default:
    //     System.out.println("Enter a valid number");
    //   }
 String grade = sc.next();

// String result = switch (monthNum) {
//     case 1, 2, 3, 4 -> "Our month will come in between January to April";
//     case 5, 6, 7, 8 -> "Month will be coming in May to August";
//     case 9, 10, 11, 12 -> "Month will be coming in September to December";
//     default -> "Invalid month number provided"; 
// };
    
// System.out.println(result);
//    switch(trafficColor){
//     case "red" :
//     System.out.println("Stop Please");
//     break;
//     case "yellow" :
//     System.out.println("Wait");
//     break ;
//     case "green" :
//     System.out.println("Go now");
//     break;
//     default :
//     System.out.println("Invalid value");
//    }
    //   traffic light : red => stop ,yellow => wait green => Go now
    // to check a no. is even or not 
    // Take grade switch a -> outstacing b-> excellence c -> very good ,d -> good e -> improvement needed f -> fail
    switch (grade) {
        case "A":
            System.out.println("OutStanding");
            break;
        case "B":
            System.out.println("Excellence");
            break;
                case "C":
            System.out.println("Very Good");
            break;
                case "D":
            System.out.println("Good");
            break;
                case "E":
            System.out.println("Improvement Needed");
            break;
               case "F":
            System.out.println("Fail");
            break;
        default:
          System.out.println("Invalid Grade");
    }
         sc.close();
    }
}

import java.util.Scanner;

public class Sept30 {
    public static void main(String [] args){
        // Write a program to calculate the electricity bill based on the following conditions: 
// Up to 100 units → ₹5/unit 
// 101–200 units → ₹6/unit 
// Above 200 units → ₹8/unit 
Scanner sc = new Scanner(System.in);
System.out.println("Enter the consumed unit of your electricity :");
float unit = sc.nextFloat();
float Amount;
if(unit <= 100){
    Amount = unit*5;
}else if(unit > 100 && unit<=200){
    Amount = unit*6;
}else{
    Amount = unit*7;
}
    System.out.println("You have to pay "+Amount+" Rupees only.");

// Write a program to find the profit or loss from given cost price and selling price. 
System.out.println("Enter the cost price and selling price of your product");
     float cp = sc.nextFloat();
     float sp = sc.nextFloat();

     if(cp < sp){
        float profit = sp-cp;
        System.out.println("Congratulations , you have make profit of "+profit);
     }else if(cp >sp){
                float loss = cp-sp;
        System.out.println("Better luck next time , today loss is "+loss);
     }else {
        System.out.println("Today you dont have any profit");
     }

    //  .Write a program to calculate income tax and print the amount after applying tax: 
// Income ≤ 2,50,000 → No tax 
// 2,50,001 – 5,00,000 → 5% tax 
// 5,00,001 – 10,00,000 → 20% tax 
// Above 10,00,000 → 30% tax 

System.out.println("Enter your Annual Income :");
double Income = sc.nextDouble();

double tax;
if(Income <= 250000){
     tax = 0;
}else if(Income > 250000 && Income<= 500000){
    tax = 0.05*Income;
}else if(Income > 500000 && Income <= 100000){
    tax = 0.2*Income;
}else{
    tax = 0.3*Income;
}

System.out.println("You have to the Total tax on your income is "+tax);

System.out.println("Enter three side of triangle : ");
float s1 = sc.nextFloat();
float s2 = sc.nextFloat();
float s3 = sc.nextFloat();

if(s1 > s2+s3 && s2>s1+s3 && s3 >s1+s2){
    System.out.println("The triangle is not a valid triangle");
}else {
   System.out.println("The triangle is valid triangle ");
}

// Write a program using switch to simulate a simple ATM: options like 1. Check Balance, 2. Withdraw, 3. Deposit, 4. Exit. 
   System.out.println("Press 1. Check Balance, 2. Withdraw, 3. Deposit, 4. Exit ");
   byte opt = sc.nextByte();
   switch (opt) {
    case 1:
        System.out.println("Your balance is ZZZ Rupees ");
        break;
   case 2:
        System.out.println("Your with draw is successfull !!");
        break;
        case 3:
        System.out.println("Your deposit is successful !!");
        break;
        case 4:
        System.out.println("Thanks for choosing our services !!");
        break;
    default:
    System.out.println("Enter valid value");
        break;
   }
    sc.close();
    }
}

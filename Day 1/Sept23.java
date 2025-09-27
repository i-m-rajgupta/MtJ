public class Sept23 {
    public static void main(String [] args){
        // Take a user’s name and greet them using a variable.  
        String name = "Raj";
        System.out.println("Good Morning "+name);

        // Store marks of 5 subjects in separate variables and print total.  
        int java = 60,ds = 34, r = 78, data = 87,digital = 70;
        double avg = (java+ds+r+data+digital)/5;
        System.out.println(avg);

        // Assign a value to a variable, change it, and print both values.  
        boolean a  = true;
        a = false;
        System.out.println(a);

        // Use a string variable to store your city name and print it. 
        String name2 = "Raj";
        String city = "Maihar";
        System.out.println(name2+" "+city);
        
        // Declare and initialize variables of all primitive types.  
            int a1 = 23;  
        float b = 34.3f; 
        short c = 34;
        char d = 'c';  
        boolean e = true;  
        double f = 3.223; 

     System.out.println(a1+" "+b+" "+c+" "+d+" "+e+" "+f);

    //   Store height and weight in variables and display BMI formula (no calculation).
    double height = 1.75; //(in meters)
    double weight = 70; //(in kg)
    double bmi = weight/(height*height);
    System.out.println("BMI "+bmi);

    // Assign the same value to two different variables and print them. 

    int r1 = 234;
    double r2 = 234;
    System.out.println(r1 +" " + r2);

//  Create a variable for grade (A, B, etc.) and print a message with it.
     char grade1  = 'A';
  char grade2  = 'B';
    char grade3  = 'C';
    System.out.println(grade1+" "+grade2+" "+grade3);

    }
}

public class Sept22 {
    public static void main(String [] args){
        // Check if a year is leap year  
        int year = 1600;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println(year +" is leap year");
        }
    
        // camelCase → variables, methods (studentName, getMarks())
        // PascalCase → classes, interfaces (StudentData, CarEngine)
        // UPPERCASE → constants (PI, MAX_VALUE)

        // Calculate simple interest  
        double principle = 40000;
        double intrest = 2.5;
        int time = 4;

        double simpleIntrest = (principle*intrest*time)/100;
        System.out.println(simpleIntrest);

        // Calculate circumference of circle  

        double PI = 3.14;
        double r = 33;
        double circumference = 2*PI*r;
        System.out.println(circumference);

        // Convert temperature Celsius to Fahrenheit  

        double celciusTemp = 37.5;
        double fahrenheitTemp = (9.0/5*celciusTemp)+32;
        System.out.println(fahrenheitTemp);

        // Convert kilometers to miles

        double kilo = 34;
        double miles = kilo*1.6;
        System.out.println(miles);
       

    }
}


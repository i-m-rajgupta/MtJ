public class Sept25 {
    public static void main(String[] args) {
        // Write a program to calculate the area of an equilateral triangle.
        double side = 34;
        double Area = (Math.sqrt(3)/4)*Math.pow(side, 2);
        System.out.println(Area);

        // Write a program to calculate the distance travelled by light in given seconds (speed of light = 3 × 10^8 m/s).
        int time = 44;
        double speed = 3*(Math.pow(10, 8));
        System.out.println(speed);
        double distance = speed*time ;
        System.out.println(distance);

        // Write a program to calculate the gravitational force (F = Gm1m2/r², take G = 6.67 × 10^-11).
        double m1 = 32.5,m2 = 67, r = 67;
       double G = 6.67 * Math.pow(10, -11);

       double F = G*m1*m2/(Math.pow(r, 2));
       System.out.println(F);

    //    Write a program to calculate the kinetic energy of a body (KE = ½mv²).
    double m = 23;
    double v = 25.33;
 
    double KE = (1.0/2*m*v*v);
    System.out.println(KE);

    // Write a program to calculate the potential energy of a body (PE = mgh).
    double g = 9.81,m3=44,h=45;
    double PE = m3*g*h;
    System.out.println(PE);
    System.out.println(Math.sqrt(3));
    }
}

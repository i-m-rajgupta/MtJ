public class Sept26 {
    public static void main(String[] args) {
        // Write a program to calculate the surface area of a hemisphere given radius.
        double r1 = 34;
        double surfaceArea = 3*(Math.pow(r1, 2))*Math.PI;
        System.out.println(surfaceArea);

        // Write a program to calculate the volume of a hemisphere.
        double r2 = 35;
        double volume = (2.0/3)*Math.PI*Math.pow(r2, 3);
        System.out.println(volume);

        // Write a program to calculate the volume of a cylinder given radius and height.
        double r3 = 45,h = 34;
        double v2 = Math.PI*Math.pow(r3, 2)*h;
        System.out.println(v2);
        
        // Write a program to calculate the surface area of a cylinder.
        double r4 = 45,h2 = 37;
        double csa = 2*(Math.PI)*r4*h2;
        double tsa = 2*(Math.PI)*r4*(r4+h2);
        System.out.println(csa+" "+tsa);

        // Write a program to calculate the volume of a prism given base area and height.
        double baseArea  = 564,h3 = 34;
        double v4 = baseArea*h3;
        System.out.println(v4);
    }
}

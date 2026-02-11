public class Jan18 {
    public static int compareInt(int a,int b){
        return Integer.compare(a, b);
    }

    public static int compareLong(long a,long b){
        return Long.compare(a, b);
    }

    public static int compareDouble(double a,double b){
        return Double.compare(a, b);
    }

    public static int compareFloat(float a,float b){
        return Float.compare(a, b);
    }

    public static int compareShort(short a,short b){
        return Short.compare(a, b);
    }
    public static void main(String[] args) {
        // Write a program to compare two integers using Integer.compare().
        System.out.println(compareInt(5, 6));
        System.out.println(compareInt(6, 5));
        System.out.println(compareInt(5, 5));

        // Write a Java program to compare two Long values using Long.compare().
        System.out.println(compareLong(85566, 84476));
        System.out.println(compareLong(5235, 5874));
        System.out.println(compareLong(4566, 4566));

        // Write a program that compares two Double values using Double.compare().
        System.out.println(compareDouble(45.55, 89.55));
        System.out.println(compareDouble(95.88, 78.55));
        // Write a program to compare two Float values using Float.compare().
        System.out.println(compareFloat(45.8f, 78.9f));
        System.out.println(compareFloat(58.3f, 45.7f));
        // Write a program to compare two Short values using Short.compare().
        System.out.println(compareShort((short)9, (short)7));

        // Integer.compare, Long.compare, Float.compare, Double.compare
// 👉 guarantee returning only -1, 0, or 1
// Short.compare (and Byte.compare)
// 👉 internally does: return a-b
    }
}

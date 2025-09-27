public class Program1 {
    public static void main(String [] args){
        int a = 3;
        System.out.println(a);
        int b =a++ + ++a;  //7 8

        System.out.println(b); 
        System.out.println(a); 
      int  x = 1, y = 2;
      int z = x++ * --y + ++x; //5 4
      System.out.println(x+" "+y+" "+z);
    }
}
 

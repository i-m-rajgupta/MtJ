public class Sept27 {
 public static void main(String [] args){
    // Compute (a + b) * c and a + (b * c) for var and show the difference. 
    int a = 5,b=4,c=6;
    int res1 = (a + b) * c ; //54 
    int res2 =  a + (b * c) ; //29
    System.out.println(res1+" "+res2);

   //  .Check if (x + y > z && y % 2 == 0) is true or false for var.
   double x = 4,y=10,z=9;
   boolean res3 = (x + y > z && y % 2 == 0) ; //true  
   System.out.println(res3);

   // Implement a program to test short-circuit evaluation:
   // (x != 0 && (y / x) > 2)
   boolean res4 = (x != 0 && (y / x) > 2); //false //true && true
   System.out.println(res4);

    boolean res5 = (x != 0 & (y / x) > 2); //true
   System.out.println(res5);

   int t = 5 & 6;   //101 & 110    100 = 4
   System.out.println(t);

   // n / 2 * 2 and (n >> 1) << 1. 
   int n = 10;
   double res6 =  n / 2 * 2 ; //10
   double res7 = (n >> 1) << 1; //10    
   System.out.println(res6+" "+res7);
 }    
}


public class Nov27 {
   public static void print(int n){
        if(n <= 0){
            return;
        }
         print(n-1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        int factorial = factorial(n-1)*n;
        return factorial;
    }

    public static int sum(int n){
        if(n/10 == 0){
           return n%10;
        }

        int sum = sum(n/10)+n%10;
        return sum;
    }

    public static int fibonacci(int n){
      if(n == 1){
        return 1;
      }
      if(n == 0){
        return 0;
      }

       int fibonacci = fibonacci(n-1) + fibonacci(n-2);
       return fibonacci;
    }

    public static int power(int x ,int n){
        if(n == 0){
            return 1;
        }
        return power(x,n-1)*x;
    }
    public static void main(String[] args){
    //  Print numbers from 1 to N recursively.
      print(5);

    //   Find the factorial of a number using recurssion . 
     System.out.println("Factorial : "+factorial(3));

    //Compute the sum of digits of a number using recurssion.
       System.out.println("Sum : "+sum(8558));

    //    Find the N-th Fibonacci number.
     System.out.println(fibonacci(6));

    //  Compute power of a number (x^n).
    System.out.println(power(5,3));

    
    }
}

import java.util.*;


public class Dec17 {
    public static class WindowPathVerifier{
        private static class Result{
            boolean valid;
            String path;

            Result(boolean valid,String path){
                this.valid = valid;
                this.path = path;
            }

            public String toString(){
                return "( Valid "+valid+" , path "+path+" )";
            }
        }

        public static Result verifyWindowPath(String path){
            path = path.replace("\\", "/");
            
            String drive = "";
            if(path.length() >= 2 && path.charAt(1) == ':'){
                drive = path.substring(0, 2);
                path = path.substring(2);
            }

            boolean isAbsolute = path.startsWith("/");

            String parts[] = path.split("/");
            Deque<String> stack = new ArrayDeque<>();

            for(String part : parts){
                if(part.equals("") || part.equals(".")){
                    continue;
                }else if(part.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }else{
                        if(isAbsolute){
                            return new Result(false, "Invalid path : goes above root ");
                        }else{
                            stack.push("..");
                        }
                    }
                }else{
                    stack.push(part);
                }
            }

            StringBuilder normalizedPath = new StringBuilder();
            normalizedPath.append(drive);
            if(isAbsolute){
                normalizedPath.append("\\");
            }

            // Why "\\“ and not just "\“
// In Java, the backslash \ is a special escape character in strings.
// Some common escape sequences:
// \n → newline
// \t → tab
// \" → double quote
// So if you write just "\\" in Java, it actually means a single backslash character.

            ArrayList<String> reversed = new ArrayList<>(stack);
            Collections.reverse(reversed);
            normalizedPath.append(String.join("\\", reversed));
            return new Result(true, normalizedPath.toString());
        } 
    }

    static class Restaurant{
        private final int capacity;
        private final int[] arr;
        private int top;
        Restaurant(int n){
            this.capacity = n;
            arr = new int[n];
            top = -1;
        }

        public boolean isEmpty(){
            return top == -1;
        }

        public boolean isFull(){
            return top == capacity-1;
        }
        public int size(){
            return top+1;
        }

        public boolean servePlate(){
            if(isEmpty()){
                System.out.println("Cannot serve plate .No plates avilable. ");
                return false;
            }
            System.out.println("Serving plate with id "+arr[top--]); 
            return true;
        }

        public boolean putPlate(int id){
            if(isFull()){
                System.out.println("Cannot take extra plate . Stack is Full");
            }
            arr[++top] = id;
            return true;
        }
    }
    public static String decode(String msg){
        if(msg.isEmpty()){
            return "" ;
        }
  
         Stack<Character> stack = new Stack<>();
         
         for(int i=0;i<msg.length();i++){
            char c = msg.charAt(i);
            if(c == ']'){
               ArrayList<Character> tempList = new ArrayList<>();
               while (!stack.empty() && !stack.peek().equals('[')) {
                    tempList.add(stack.pop());
               }

                Collections.reverse(tempList);

              if(!stack.empty() && stack.peek().equals('[')){
                    stack.pop();
              }

              int multiplier = 1;
              int base = 0;
              while (!stack.empty() && Character.isDigit(stack.peek())) {
                   int num = Character.digit(stack.pop(), 10);
                   base = num*multiplier + base;
                   multiplier *= 10;
              }
            
              int count = base;
                     while (count>0) {
                      for(int j =0;j<tempList.size();j++){
                        stack.push(tempList.get(j));
                      }
                     count--;
                     }
            }else{
                stack.push(c);
            }
         }
         StringBuilder res = new StringBuilder();
         res.setLength(stack.size());
         int n = stack.size();
         while (!stack.isEmpty()) {
            res.setCharAt(--n, stack.pop());
         }
         return res.toString();
    }

    public static int[] collide(int arr[]){
          if(arr.length == 0 || arr.length == 1){
              return arr;
          }

          ArrayDeque<Integer> stack = new ArrayDeque<>();
          for(int i=0;i<arr.length;i++){
            if(arr[i] <0){
                int car;
                boolean crashed = false;
                while (!stack.isEmpty() && stack.peek()>0) {
                    if(Math.abs(arr[i]) > stack.peek()){
                  car =  stack.pop();
                  System.out.println("Car "+car+" collides with "+arr[i]);
                    }else if(Math.abs(arr[i]) == stack.peek()){
                         car =  stack.pop();
                  System.out.println("Car "+car+" collides with "+arr[i]+" (both cars crashed) ");
                  crashed = true;
                      break;
                    }
                    else{
                        car = stack.peek();
                        System.out.println("Car "+arr[i]+" collides with "+car+" (incoming car crashed) ");
                        crashed = true;
                        break;
                    }
                }
                if(!crashed){
                   stack.push(arr[i]);
                }
            }else{
                stack.push(arr[i]);
            }
          }

          int res[] = new int[stack.size()];
          for(int j =res.length-1;j>=0;j--){
             res[j] = stack.pop();
          }
           return res;

    }
    public static void print(int [] arr){
         for(int el : arr){
                System.out.print(el+" ");
             }
             System.out.println();
    }
     
    public static int precedence(String str){
         if(str.equals("+") || str.equals("-")){
            return 1;
         }else if(str.equals("*") || str.equals("/") || str.equals("%")){
            return 2;
         }else if(str.equals("^")){
            return 3;
         }else if(str.equals("(") || str.equals(")")){
            return 0;
         }

        return -1;
    }

    public static boolean isRightAssociative(String str){
       return str.equals("^");
    } 
    
    public static int evaluator(String[] expr){
           if(expr.length == 0){
            return 0;
           }

           ArrayDeque<Integer> operand = new ArrayDeque<>();
           ArrayDeque<String> operator = new ArrayDeque<>();
           for(int i=0;i<expr.length;i++){
              String str = expr[i];
              if(str.matches("-?\\d+")){
                operand.push(Integer.parseInt(str));
              }else{
                   if(str.equals(")")){
                      while (!operator.isEmpty() && ) {
                        
                      }
                   }else{
                    operator.push(str);
                   }
              }
           }
    }
    public static void main(String[] args) {
        // Verify the correctness of nested folder paths in a file manager using stack.
          System.out.println(WindowPathVerifier.verifyWindowPath( "C:\\Users\\John\\Documents\\..\\Pictures\\.\\Vacation"));
           System.out.println(WindowPathVerifier.verifyWindowPath(  "C:\\..\\Windows"));
            System.out.println(WindowPathVerifier.verifyWindowPath( "Folder\\Subfolder\\..\\..\\Another"));

        // Simulate plate-serving system in a restaurant using a custom stack with size limit.
            Restaurant res = new Restaurant(10);
            res.putPlate(101);
            res.putPlate(102);
            res.servePlate();
            System.out.println(res.isEmpty());
            System.out.println(res.isFull());
            System.out.println(res.size());

            // Use a stack to decode compressed messages (e.g., "3[a2[b]]").
            System.out.println( decode("1[a11[b]]"));

            // Implement the asteroid collision problem as crashing cars on a single-lane road.
            int arr1[] = {1,2,3};
             print( collide(arr1));
             int arr2[] = {2,8,-3,-4};
             print(collide(arr2));
             int arr3[] = {-1,-2,4,5};
             print(collide(arr3)); 

            //  Design an expression evaluator for an online billing system using two stacks.

    }
}

import java.util.*;

public class Dec15 {
    public static boolean isSorted(ArrayDeque<Integer> stack){
           if(stack.isEmpty()){
            return true;
           }

           ArrayDeque<Integer> temp = new ArrayDeque<>();
           int prev = Integer.MAX_VALUE;
           int curr;
           boolean sorted = true;

           while (!stack.isEmpty()) {
            curr =  stack.pop();
            temp.push(curr);

            if(curr>prev){
                sorted = false;
                break;
            }
            prev = curr;
           }
         
           while (!temp.isEmpty()) {
              stack.push(temp.pop());
           }

           return sorted;
    }

    public static boolean isValidParentheses(ArrayDeque<Character> stack){
        if(stack.isEmpty()){
            return true;
        }

        ArrayDeque<Character> temp = new ArrayDeque<>();
        ArrayDeque<Character> restore = new ArrayDeque<>();

        boolean valid = true;

        while (!stack.isEmpty()) {
                char c  = stack.pop(); 
                restore.push(c);

            if(c == ')'){
                temp.push(c);
            }else if(c == '('){
                if(temp.isEmpty()){
                    valid = false;
                    break;
                }
                 temp.pop();
            }
        }

        while (!restore.isEmpty()) {
            stack.push(restore.pop());
        }
    
        return valid && temp.isEmpty();
    }

    public static int evaluate(ArrayDeque<String> expr){
        ArrayDeque<String> postfix = new ArrayDeque<>();
        while (!expr.isEmpty()) {
            postfix.push(expr.pop());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (!postfix.isEmpty()) {
            String token = postfix.pop();

            if(token.matches("-?\\d+")){
                stack.push(Integer.parseInt(token));
            }else{
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                      case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        if(b!=0){
                            stack.push(a/b);
                        }else{
                            throw new RuntimeException("Divide by Zero ");
                        }
                        break;   
                         case "^":
                          stack.push((int) Math.pow(a, b));
                        break;
                    case "%":
                         stack.push(a%b);
                        break;   
                    default:
                        throw new IllegalArgumentException("Undefined Operator ");
                }
            }
        }
        return stack.pop();
    }

    public static int precedence(String token){
        if(token.equals("+") || token.equals("-")){
            return 1;
        }else if(token.equals("*") || token.equals("/") || token.equals("%")){
            return 2;
        }else if(token.equals("^")){
            return 3;
        }else if(token.equals("(") || token.equals(")")){
            return 0;
        }

        return -1;
    }

    public static boolean isRightAssociative(String token){
        return token.equals("^");
    }

    public static void printRes(StringBuilder res){
          String res1 = res.toString();
          System.out.println(res1.trim());
    }

    public static void infixToPostFix(ArrayDeque<String> expr){
        ArrayDeque<String> infix = new ArrayDeque<>();
           while (!expr.isEmpty()) {
            infix.push(expr.pop());
           }
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        while (!infix.isEmpty()) {
            String token = infix.pop();

            if(token.matches("[a-zA-Z0-9]+")){
              res.append(token).append(" ");
            }else if(token.equals("(")){
              stack.push(token);
            }else if(token.equals(")")){
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    res.append(stack.pop()).append(" ");
                }

                if(!stack.isEmpty() && stack.peek().equals( "(")){
                stack.pop();
                }
            }else{   // (+)*(-)^
                     while(!stack.isEmpty() && !stack.peek().equals("(") &&
                  ((isRightAssociative(token) && precedence(token) < precedence(stack.peek())) ||
                   (!isRightAssociative(token) && precedence(token) <= precedence(stack.peek())))) {
                res.append(stack.pop()).append(" ");
            }
            stack.push(token);
        }
    }
      while (!stack.isEmpty()) {
            res.append(stack.pop()).append(" ");
        }
         printRes(res);
}
    public static void main(String[] args) {
        // Push names of friends attending a party and print the last arrived person.
        ArrayDeque<String> friends = new ArrayDeque<>();
        friends.push("Mahesh");
        friends.push("Kamal");
        friends.push("Lokesh");
        System.out.println(friends.peek());

        // Check whether a given stack of integers is sorted.
        ArrayDeque<Integer> stack = new  ArrayDeque<>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(isSorted(stack));
        System.out.println(stack.peek());

        // Validate parentheses in a mathematical expression typed by a student.
        ArrayDeque<Character> parentheses = new ArrayDeque<>();
        parentheses.push('(');
        parentheses.push('(');
        parentheses.push(')');
        parentheses.push(')');
      System.out.println( isValidParentheses(parentheses));
      System.out.println(parentheses);

    //   Evaluate a postfix expression generated by a calculator app.
      ArrayDeque<String> postfix = new ArrayDeque<>();
      postfix.push("-56");
      postfix.push("57");
      postfix.push("+");
      postfix.push("78");
      postfix.push("90");
      postfix.push("-");
      postfix.push("*");
     System.out.println(evaluate(postfix));

     ArrayDeque<String> postfix2 = new ArrayDeque<>();
postfix2.push("2");
postfix2.push("3");
postfix2.push("^");
postfix2.push("10");
postfix2.push("*");
postfix2.push("5");
postfix2.push("/");
postfix2.push("7");
postfix2.push("+");
postfix2.push("4");
postfix2.push("-");
postfix2.push("3");
postfix2.push("%");
   System.out.println(evaluate(postfix2));

//    Convert infix shopping discount expressions into postfix form.
    ArrayDeque<String> infix = new ArrayDeque<>();
infix.push("26");
infix.push("+");
infix.push("3");
infix.push("+");
infix.push("2");
infix.push("*");
infix.push("3");
infix.push("^");
infix.push("2");
infixToPostFix(infix);

ArrayDeque<String> infix1 = new ArrayDeque<>();
infix1.push("5");
infix1.push("+");
infix1.push("2");
infix1.push("*");
infix1.push("3");
infix1.push("^");
infix1.push("2");
infixToPostFix(infix1);

ArrayDeque<String> infix2 = new ArrayDeque<>();
infix2.push("4");
infix2.push("*");
infix2.push("(");
infix2.push("6");
infix2.push("+");
infix2.push("2");
infix2.push("^");
infix2.push("3");
infix2.push(")");
infixToPostFix(infix2);

ArrayDeque<String> infix3 = new ArrayDeque<>();
infix3.push("10");
infix3.push("+");
infix3.push("5");
infix3.push("-");
infix3.push("2");
infix3.push("^");
infix3.push("3");
infixToPostFix(infix3);

ArrayDeque<String> infix4 = new ArrayDeque<>();
infix4.push("20");
infix4.push("/");
infix4.push("4");
infix4.push("*");
infix4.push("3");
infix4.push("%");
infix4.push("2");
infix4.push("^");
infix4.push("2");
infixToPostFix(infix4);

ArrayDeque<String> infix5 = new ArrayDeque<>();
infix5.push("(");
infix5.push("3");
infix5.push("+");
infix5.push("5");
infix5.push(")");
infix5.push("*");
infix5.push("(");
infix5.push("2");
infix5.push("-");
infix5.push("1");
infix5.push(")");
infix5.push("^");
infix5.push("3");
infixToPostFix(infix5);



    }
}

import java.util.*;

public class Dec6 {

    static int rowDir[] = {-1,1,0,0};
    static  int colDir[] = {0,0,-1,1};
    public static void search(String word,char[][] grid){

        int freq[] = new int[256];
        
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                char c = grid[i][j];
                freq[c]++;
            }
        }

        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);
            if(--freq[c] < 0){
                System.out.println(word+" does not exist ");
                return;
            }
        }
   
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == word.charAt(0) && search(word, grid,  i, j, 0)){
                          System.out.println(word+" is exist in grid.");
                   return;
                }
            }
            }
                  System.out.println(word+" does not exist in grid.");
        }

    public static boolean search(String word,char[][] grid,int row,int col,int idx){
        if(idx == word.length()){
            return true;
        }

        if(row < 0 || col <0 ||row>=grid.length || col >= grid[0].length || grid[row][col] == '#'|| grid[row][col] != word.charAt(idx)){
            return false;
        }

        char temp = grid[row][col];
        grid[row][col] = '#'; 
       
        for(int i =0;i<4;i++){
             int newRow = row + rowDir[i];
             int newCol = col+colDir[i];
             if(search(word, grid, newRow, newCol, idx+1)){
                   grid[row][col] = temp;
                return true;
             }
        }

        grid[row][col] = temp;
        return false;
    }

   
     public static boolean isValidKnightTour(int chessBoard[][],int row,int col,int totalnum){
         if( row <0||col<0||row>= chessBoard.length||col >= chessBoard.length|| chessBoard[row][col] != totalnum ){
            return false;
         }
         if(totalnum == chessBoard.length*chessBoard.length ){
            return true;
         }

         int rowDir[] = {-2,-2,-1,-1,1,1,2,2};
         int colDir[] = {-1,1,-2,2,-2,2,-1,1};

         for(int i =0;i<8;i++){
           if(isValidKnightTour(chessBoard, row+rowDir[i], col+colDir[i], totalnum+1)){
               return true;
           }
         }
         return false;
     }

      private static double EPSILON = 1e-6; 
    static class Numexpr {
            double value ;
            String expr;
            Numexpr(double value,String expr){
                this.value = value;
                this.expr = expr;
            }
    }

    public static ArrayList<Numexpr> compute(Numexpr a,Numexpr b){
            ArrayList<Numexpr> result = new ArrayList<>();
            result.add(new Numexpr((a.value+b.value),"("+a.expr+"+"+b.expr+")"));
             result.add(new Numexpr((a.value-b.value),"("+a.expr+"-"+b.expr+")"));
              result.add(new Numexpr(b.value - a.value, "(" + b.expr + "-" + a.expr + ")"));
              result.add(new Numexpr((a.value*b.value),"("+a.expr+"*"+b.expr+")"));
              if(Math.abs(b.value) > EPSILON){
              result.add(new Numexpr((a.value/b.value),"("+a.expr+"/"+b.expr+")"));
              }
              if(Math.abs(a.value)>EPSILON){
               result.add(new Numexpr((b.value/a.value),"("+b.expr+"/"+a.expr+")"));
              }
              return result;
    }
    public static void findExpression(ArrayList<Numexpr> nums,int target,HashSet<String> Solutions){
            if (nums.size() == 1) {
            if (Math.abs(nums.get(0).value - target) < EPSILON) {
                Solutions.add(nums.get(0).expr);
                return ;
            }
            return ;
        }

        for(int i =0;i<nums.size();i++){
            for(int j =i+1;j<nums.size();j++){
                if(i == j){
                    continue;
                }
                ArrayList<Numexpr> next = new ArrayList<>();
                for(int k = 0;k<nums.size();k++){
                    if(k != i && k != j){
                      next.add(nums.get(k));
                    }
                }

                Numexpr a = nums.get(i);
                Numexpr b = nums.get(j);
                for(Numexpr result : compute(a, b)){
                    next.add(result);
                     findExpression(next, target,Solutions);
                    next.remove(next.size()-1);
                }
            }
        }
    }
     
    public static HashSet<String> validExpression(ArrayList<Double> nums,int target){
        ArrayList<Numexpr> number = new ArrayList<>();
      for(double num : nums){
         number.add(new Numexpr(num, String.valueOf((int) num)));
      }
      HashSet<String> Solutions = new HashSet<>();
      findExpression(number, target, Solutions);
      return Solutions;
    }
    public static void main(String[] args) {
        // Word search in a 2D grid
        char[][] grid = {
    {'C','A','T','D','O','G','S'},
    {'B','O','O','K','L','I','N'},
    {'D','A','T','A','S','E','T'},
    {'H','E','L','L','O','W','R'},
    {'M','A','T','R','I','X','E'},
    {'N','U','M','B','E','R','S'},
    {'S','E','A','R','C','H','X'}
};
     
    search("MATRIX", grid);
    search("OLSOIEC", grid);
    search("DATASETHELLO", grid);
    search("BOOKASET", grid);
    search("DOGSNILSET", grid);
    search("HHELLONH", grid);

    // Knight’s tour problem

    int[][] knightTour1 = {
    { 1,  6, 15, 10, 21},
    {14,  9, 20,  5, 16},
    {19,  2,  7, 22, 11},
    { 8, 13, 24, 17,  4},
    {25, 18,  3, 12, 23}
};
     System.out.println(isValidKnightTour(knightTour1, 0, 0, 1));

   int[][] knightTour2 = {
    {17,  4, 15, 10, 21},
    {14,  9, 20,  5, 16},
    { 3, 18,  1, 22, 11},
    { 8, 13, 24, 19,  6},
    {25,  2,  7, 12, 23}
};
    System.out.println(isValidKnightTour(knightTour2, 2, 2, 1));
      
    // All possible expressions with numbers and +,-,*,/ to evaluate to target.
    ArrayList<Double> num = new ArrayList<>();
    num.add(1.0);
    num.add(2.0);
    num.add(3.0);
    num.add(4.0);

    // EPSILON is a tiny tolerance value. Instead of checking if two doubles are exactly equal, we check if they are close enough
    // 1e-6 = 0.000001
// Small enough for most calculations
// Big enough to avoid tiny floating-point errors messing up equality checks
    HashSet<String> res = validExpression(num, 30);
    System.out.println("All unique expression ");
   if(res.isEmpty()){
    System.out.println("No valid expression exist !!");
   }else{
    for(String expr : res){
        System.out.println(expr);
    }
   }


   
    }
    }


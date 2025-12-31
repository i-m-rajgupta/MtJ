import java.util.ArrayList;

public class Dec5 {
    public static void sequences(int N,int dice[],ArrayList<Integer> result){
        if(N<0){
            return;
        }

        if(N == 0){
            if(result.size()>0){
            System.out.println(result);
        }
            return;
        }

        for(int idx = 0;idx<dice.length;idx++){
             int num = dice[idx];
             result.add(num);
             sequences(N-num, dice, result);
             result.remove(result.size()-1);
        }
    }

    public static void kLengthStrings(int k,char ch[],ArrayList<Character> result){
        if(k<0){
            return;
        }

        if(k ==0){
            System.out.println(result);
            return;
        }

        for(char c : ch){
            result.add(c);
            kLengthStrings(k-1, ch, result);
            result.remove(result.size()-1);
        }
    }

    public static boolean isSafe(ArrayList<ArrayList<Integer>> chessboard,int row,int col){

        for(int i=0;i<row;i++){
            if(chessboard.get(i).get(col) == 1){
                return false;
            }
        }

        int i = row;
        int j = col;

        while (i > 0 && j>0){
            if(chessboard.get(i-1).get(j-1) == 1){
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;

        while (i > 0 && j < chessboard.get(0).size()-1) {
            if(chessboard.get(i-1).get(j+1) == 1){
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void nQueens(ArrayList<ArrayList<Integer>> chessboard ,int row){
        if(row == chessboard.size()){
            System.out.println(chessboard);
            return;
        }

        for(int col =0;col<chessboard.get(0).size();col++){
            if(isSafe(chessboard, row, col)){
                chessboard.get(row).set(col, 1);
                nQueens(chessboard, row+1);
                chessboard.get(row).set(col, 0);
            }
        }
    }

    public static boolean isPossible(int sudoku[][],int row,int col,int num){

        for(int i =0;i<sudoku.length;i++){
            if(sudoku[i][col] == num || sudoku[row][i] == num){
               return false;
            }
        }

        int  k = (row/3)*3;
        int l = (col/3)*3;
        for(int i = k;i<k+3;i++){
         for(int j=l;j<l+3;j++){
            if(sudoku[i][j] == num){
                return false;
            }
         }
        }

        return true;
    }

    public static void print(int sudoku[][]){
        for(int i =0;i<sudoku.length;i++){
            for(int j =0;j<sudoku[0].length;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        if(row == sudoku.length){
            print(sudoku);
            return true;
        }

        if(col == sudoku.length){
            return sudokuSolver(sudoku, row+1, 0);
        }

        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, row, col+1);
        }

        for(int num = 1;num<10;num++){
            if(isPossible(sudoku, row, col, num)){
                sudoku[row][col] = num;
                sudokuSolver(sudoku, row, col+1);
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
             if(str.charAt(i) !=str.charAt(str.length()-1-i)){
                return false;
             }
        }

        return true;
    }
    public static void palindrome(String str,ArrayList<String> result,int n){
        if(n == str.length()){
            System.out.println(result);
            return;
        }
        
        for(int idx = n;idx <str.length();idx++){
           String sub = str.substring(n, idx+1);
           if(isPalindrome(sub)){
            result.add(sub);
            palindrome(str, result, idx+1);
            result.remove(result.size()-1);
           }
        }
         } 
    public static void main(String[] args) {
        // Palindrome partitioning of a string
         String str = "level";
         palindrome(str, new ArrayList<>(), 0);
        //  Print all sequences of dice throws to reach N
           int arr[] = {1,2,3,4,5,6};
           System.out.println("All sequences of dice to reach the N");
            sequences(5, arr, new ArrayList<>());
        // K-length strings from given characters
           char ch[] = {'a','b','c','d'};
           System.out.println("K-length string for the given character ");
           kLengthStrings(2, ch, new ArrayList<>());
        // N-Queens problem
           ArrayList<ArrayList<Integer>> chessboard = new ArrayList<>();
           for(int i =0;i<4;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<4;j++){
                row.add(0);
            }
            chessboard.add(row);
           }

           nQueens(chessboard, 0);

         //  Sudoku solver
          int[][] sudoku = {
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9}
};

    sudokuSolver(sudoku, 0, 0);
    

    }
}

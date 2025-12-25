import java.util.ArrayList;

public class Nov30 {
    
    public static int climb(int n,int sum){
        if(sum == n){
           return 1;
        }
        if(sum>n){
            return 0;
        }
        int ways = 0;
        for(int i = 1;i <= n-sum;i++){
           ways += climb(n,sum+i);
        }
        return ways;
    }

    public static void paths(int arr[][],int right,int down,ArrayList<Integer> path){
         if(right == arr[0].length-1 && down == arr.length-1){
            System.out.println(path);
            path.remove(path.size()-1);
            return;
         }

         if(right == arr[0].length || down == arr.length){
            return;
         }
         
         if(right == 0 && down == 0){
             path.add(arr[down][right]);
         }

         if(right+1 < arr[0].length){
         path.add(arr[down][right+1]);
         }
         paths(arr, right+1, down, path);
         if(down+1 < arr.length){
          path.add(arr[down+1][right]);
         }
         paths(arr, right, down+1, path);
            if(path.size()>0){
            path.remove(path.size()-1);
            } 
    }

    public static int sum(int arr[][],int right,int down){
       if(right == arr[0].length && down == arr.length){
        return 0;
       }

       return arr[right][down]+sum(arr, right+1, down+1);
    }

   static boolean check(int el){
        return el == 1;
    }
    static boolean isSafe(int arr[][],int top,int right){
     
        for(int i = 0;i<top;i++){
            if(check(arr[i][right])){
                return false;
            }
        }

        int i = top-1;
        int j= right-1;
        while(i>=0 && j>=0){
            if(check(arr[i][j])){
                return false;
            }
            i--;
            j--;
        }
        i = top-1;
        j = right+1;
        while (i>=0 && j < arr.length) {
              if(check(arr[i][j])){
                return false;
            }
            i--;
            j++;
        }  

     return true;
    }

    public static void print(int chessboard[][]){
        System.out.println("--- Chessboard with n queens -----");
        for(int i= 0;i<chessboard.length;i++){
            for(int j =0;j<chessboard[0].length;j++){
                if(chessboard[i][j] == 1){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    public static void nqueens(int arr[][],int top){
        if(top == arr.length){
          print(arr);
          return;
        }
        for(int i=0;i<arr[0].length;i++){
            if(isSafe(arr, top, i)){
                arr[top][i] = 1;
                nqueens(arr, top+1);
                arr[top][i] = 0;
            }
        }   
    }

    public static boolean isValid(int sudoku[][],int top,int left,int num){
      
           for(int j=0;j<sudoku.length;j++){
            if(sudoku[top][j] == num || sudoku[j][left] == num ){
               return false;
            }
           }


           int row = (top/3)*3;
           int col = (left/3)*3;
           for(int j=row;j<row+3;j++){
            for(int k= col;k<col+3;k++){
                if(sudoku[j][k] == num){
                    return false;
                }
            }
           }

         return true;
    }

    public static void printSudoku(int sudoku[][]){
        for(int i =0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[0].length;j++){
                 System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
   public static boolean sudokuSolver(int sudoku[][],int row,int col){
        if(row == sudoku.length){
            printSudoku(sudoku);
            return true; 
        }

        if(col == sudoku[0].length){
            return sudokuSolver(sudoku, row+1, 0);
        }

        if(sudoku[row][col] != 0){
                return sudokuSolver(sudoku, row, col+1);
        }

           for(int j=1;j<=sudoku[0].length;j++){
                if(isValid(sudoku, row, col, j)){
                    sudoku[row][col] = j;

                    if(sudokuSolver(sudoku, row, col+1)){
                        return true;
                    }

                    sudoku[row][col] = 0;
                }
           }  
           return false;
   }

    public static void main(String[] args) {
        // Count ways to climb stairs with variable jumps.
        System.out.println( climb(4,0));

        // Print all paths from top-left to bottom-right in a matrix (only down/right moves). 
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer>path = new ArrayList<>();
        paths(matrix, 0, 0, path);

        // Compute the sum of principal diagonal elements in a matrix.
        System.out.println("Sum : "+sum(matrix, 0, 0));

        // Solve N-Queens problem recursively.
        int chessboard[][] = new int[4][4];
        nqueens(chessboard, 0);

        // Solve Sudoku using recursion.
       int sudoku[][] = {
       {5 ,3, 0, 0, 7, 0 ,0, 0, 0},
       {6 ,0 ,0 ,1 ,9 ,5 ,0 ,0 ,0},
       {0, 9, 8, 0 ,0 ,0 ,0 ,6, 0},
       {8 ,0 ,0 ,0 ,6 ,0 ,0 ,0 ,3},
       {4 ,0, 0, 8, 0, 3, 0, 0, 1},
       {7, 0 ,0 ,0 ,2 ,0 ,0 ,0 ,6},
       {0 ,6 ,0 ,0, 0, 0 ,2 ,8 ,0},
       {0 ,0 ,0 ,4 ,1 ,9 ,0 ,0, 5},
       {0, 0, 0, 0, 8, 0, 0, 7, 9},
       };

        

       sudokuSolver(sudoku, 0, 0);
    //  System.out.println( numberFinder(sudoku1, 0, 6));

    }
}

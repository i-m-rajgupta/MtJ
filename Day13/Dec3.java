import java.util.ArrayList;

public class Dec3 {

    public static ArrayList<ArrayList<Integer>> convertToArrayList(int matrix[][]){
          ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

          for(int i=0;i<matrix.length;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<matrix[0].length;j++){
                row.add(matrix[i][j]);
            }
            arr.add(row);
          }

          return arr;
    }

    public static void printPath(ArrayList<ArrayList<Integer>> path){
        System.out.println("Path of Rat");
        System.out.println(path);
       
        int top = 0;
        int left = 0;
        int bottom = path.size();
    int right = path.get(0).size();

    while (top != bottom - 1 || left != right - 1) {

        if (left + 1 < right && path.get(top).get(left + 1) == 1) {
            System.out.print("Right => ");
            left++;
        } else if (top + 1 <bottom && path.get(top + 1).get(left) == 1) {
            System.out.print("Down => ");
            top++;
        } else {
            break; 
        }
    }
        System.out.println("Finish ");
        System.out.println();
    }

    public static void path(ArrayList<ArrayList<Integer>> arr,int row,int col ,ArrayList<ArrayList<Integer>> path ){
       
        if(row == arr.size()-1 && col == (arr.get(0)).size() -1){
        path.get(row).set(col, 1);
        printPath(path);
        path.get(row).set(col, 0);
        return;
      }

      if(row >= arr.size() || col >= arr.get(0).size() || arr.get(row).get(col) == 0 || path.get(row).get(col) == 1){
        return;
      }

      path.get(row).set(col, 1);
      path(arr, row, col+1, path);
         path(arr, row+1, col, path);
      path.get(row).set(col, 0);
    }

    public static void replace(ArrayList<Integer> arr,int X,int idx){
          if(idx == arr.size()){
            System.out.println("Array with element equal to and greater than X is : "+arr);
            return;
          }
          if(arr.get(idx) < X){
            arr.set(idx, 0);
          }
          replace(arr, X, idx+1);
    }

    public static boolean isSafe(ArrayList<ArrayList<Integer>> chesssBoard,int row,int col){
        for(int i =0;i<row;i++){
        if(chesssBoard.get(i).get(col) == 1){
            return false;
        }
        }
        
        int i = row;
        int j = col;
        while (i-1 >= 0 && j-1 >= 0) {
            if(chesssBoard.get(i-1).get(j-1) == 1 ){
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;
        while (i-1 >= 0 && j+1 <= chesssBoard.get(0).size()-1) {
            if(chesssBoard.get(i-1).get(j+1) == 1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void nQueens(ArrayList<ArrayList<Integer>> chessBoard,int row){
         if(row == chessBoard.size()){
            System.out.println(chessBoard);
            return;
         }
        
         for(int col=0;col<chessBoard.get(row).size();col++){
           if(isSafe(chessBoard, row, col)){
           chessBoard.get(row).set(col, 1);
           nQueens(chessBoard, row+1);
           chessBoard.get(row).set(col, 0);
            }
        }
    }

    public static void reverseAlternate(ArrayList<Integer> arr,int pos,int idx){
         if(idx == arr.size()){
            System.out.println(arr);
            return;
         }

        if(idx %2 == 1){
            int removed = arr.remove(arr.size()-1);
            arr.add(pos,removed);
            pos += 1;
        }
        reverseAlternate(arr, pos ,idx+1);
    }

    public static void removeDuplicates(ArrayList<Integer> arr,int idx){
        if(idx == arr.size()){
            System.out.println(arr);
            return;
        }

        if(idx != arr.indexOf(arr.get(idx))){
              arr.remove(idx);
              removeDuplicates(arr, idx);
        }else{
        removeDuplicates(arr, idx+1);
       }
    }
    public static void main(String[] args) {
        // Solve the “Rat in a Maze” problem using a grid stored as an ArrayList<ArrayList<Integer>>.
        int maze [][] ={
    {1, 1, 0, 1, 1},
    {1, 1, 1, 1, 0},
    {0, 1, 0, 1, 1},
    {1, 1, 1, 0, 1},
    {1, 0, 1, 1, 1}
        };
        int path [][] = new int[5][5];    
       path(convertToArrayList(maze),0,0,convertToArrayList(path));

    //    Replace all elements smaller than X with zero.
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(10);
        arr.add(2);
            arr.add(3);
                arr.add(9);
                    arr.add(1);
                        arr.add(5);
    // replace(arr, 4, 0);

    // Solve N-Queens problem using ArrayList for positions.
    int nQueens[][] = new int[5][5];
    // System.out.println(isSafe(convertToArrayList(nQueens), 2, 1));
    nQueens(convertToArrayList(nQueens), 0);

    // Reverse alternate elements in an ArrayList.
     System.out.println(arr);
reverseAlternate(arr, 0, 0);

//  Remove duplicates but maintain order recursively.
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(4);
    removeDuplicates(list, 0);
    }
}

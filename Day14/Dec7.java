import java.util.ArrayList;

public class Dec7 {
    public static boolean isSafe(int[][] chessBoard,int row,int col){
        for(int i=0;i<row;i++){
           if(chessBoard[i][col] == 1){
            return false;
           }
        }

        return true;
    }

    public static void printBoard(int[][] chessBoard){
        for(int i = 0;i<chessBoard.length;i++){
            for(int j = 0;j<chessBoard.length;j++){
                System.out.print(chessBoard[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void nRook(int[][] chessBoard,int row){
        if(row == chessBoard.length){
            printBoard(chessBoard);
            return;
        }
   

        for(int i = 0;i<chessBoard[0].length;i++){
           if(isSafe(chessBoard, row, i)){
                chessBoard[row][i] = 1;
                nRook(chessBoard, row+1);
                chessBoard[row][i] = 0;
           }
        }
    }

    public static void print(int arr[][]){
        for(int i =0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                System.out.printf("%4d",arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[][] oddOrderGeneration(int n,boolean print){
        if(n %2 == 0){
            return null;
        }
        int i = 0,j=n/2;
        int magicSquare[][] = new int[n][n];

        for(int num = 1;num <= n*n;num++){
            magicSquare[i][j] = num;
            int newI = (i-1+n)%n;
            int newJ = (j+1)%n;

            if(magicSquare[newI][newJ] != 0){
                i = (i+1)%n;
            }else{
                i = newI;
                j = newJ;
            }
        }
        if(print){
        print(magicSquare);
        }
        return magicSquare;
    }

    public static void doublyEvenGeneration(int n){
        if(n%4 != 0){
             return;
        }

        int magicSquare[][] = new int[n][n];
        int num = 1;
        for(int i =0;i<magicSquare.length;i++){
            for(int j =0;j<magicSquare[0].length;j++){
                magicSquare[i][j] = num++;
            }
        }

         for(int i =0;i<magicSquare.length;i++){
            for(int j =0;j<magicSquare[0].length;j++){
                if(i%4 == j%4 || j%4 + i%4 == 3){
                magicSquare[i][j] = n*n+1-magicSquare[i][j];
                }
            }
        }
        print(magicSquare);
    }

public static void singlyEvenGeneration(int n) {
    if (n % 4 != 2) {
        return;
    }

    int half = n / 2;
    int subsize = half * half;

    int[][] magicSquare = new int[n][n];
    int[][] submagicSquare = oddOrderGeneration(half,false);
    

    for (int i = 0; i < half; i++) {
        for (int j = 0; j < half; j++) {
            magicSquare[i][j] = submagicSquare[i][j];
            magicSquare[i][j + half] = submagicSquare[i][j] + 2 * subsize;
            magicSquare[i + half][j] = submagicSquare[i][j] + 3 * subsize;
            magicSquare[i + half][j + half] = submagicSquare[i][j] + subsize;
        }
    }

      int k = (n - 2) / 4; 
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < k; j++) {
                int temp = magicSquare[i][j];
                magicSquare[i][j] = magicSquare[i + half][j];
                magicSquare[i + half][j] = temp;
            }
            for (int j = n - k + 1; j < n; j++) {
                int temp = magicSquare[i][j];
                magicSquare[i][j] = magicSquare[i + half][j];
                magicSquare[i + half][j] = temp;
            }
        }

        int mid = k;
        int temp = magicSquare[mid][mid];
        magicSquare[mid][mid] = magicSquare[mid + half][mid];
        magicSquare[mid + half][mid] = temp;

    print(magicSquare);
}

    public static void magicSquareGeneration(int n){
          if(n == 0||n==2){
            System.out.println("No magic Square exists ");
            return;
          }
          System.out.println("Magic square for "+n);
          if(n%2 != 0 ){
          oddOrderGeneration(n,true);
          }else if(n%4 == 0){
          doublyEvenGeneration(n);
          }else{
        singlyEvenGeneration(n);
          }  
    }
    
    public static boolean wordDiff(String src,String dest,int idx,int count){
        if(src.length() != dest.length()){
            return false;
        }

        if(idx == src.length()){
            if(count == 1){
                return true;
            }else{
                return false;
            }
        }

        if(src.charAt(idx) != dest.charAt(idx)){
            count++;
        }
         return wordDiff(src, dest, idx+1, count);    
    }
    
    public static void allWords(String src,String list[],int idx,ArrayList<String> res){
        if(idx == list.length){
            System.out.println(res);
            return;
        }

        if(wordDiff(src, list[idx], 0, 0)){
            res.add(list[idx]);
        }
        allWords(src, list, idx+1, res);
    }

     public static boolean isValidParenthesis(String str,int open,int close,int idx){
         if(idx == str.length()){
           return open==close;
         }
         if(str.charAt(idx) == '('){
            open++;
         }else{
            close++;
         }

         return isValidParenthesis(str, open, close, idx+1);
     }
    public static void main(String[] args) {
        // All valid arrangements of N rooks on a chessboard
         nRook(new int[3][3], 0);

        //  Magic square generation
        // A magic square is a square arrangement of numbers where the sum of each row, column, and both diagonals is the same.
         magicSquareGeneration(3);

        //  Return true if two words differ by exactly one character.
        System.out.println(wordDiff("hit", "hot", 0, 0));

        // Generate All Words One Letter Away from wordlist.
         String src = "hit";
         String list[] = {"hot","dot","dog","hat","lot","log"};
          allWords(src, list, 0, new ArrayList<>());

        // All valid parenthesis strings with multiple types of brackets
        String str = "(())";
       System.out.println(isValidParenthesis(str, 0, 0, 0));
        

    }
}

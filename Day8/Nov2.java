public class Nov2 {
    public static void print(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void multipy(int arr1[][],int arr2[][]){
            if(arr1[0].length != arr2.length){
                System.out.println("Multiplication is not possible as column of matrix 1 is not equal to row of matrix 2 ");
                return;
            }
            int res[][] = new int[arr1.length][arr2[0].length]; 
            for(int i=0;i<arr1.length;i++){
                    for(int n=0;n<arr2[0].length;n++){
                        int sum =0;
                        for(int  m=0;m<arr2.length;m++){
                     sum += arr1[i][m] * arr2[m][n];
                    }
                      res[i][n] = sum;
                }
            }
            System.out.println("Multiplication product : ");
            print(res);
    }

    public static void spiral(int matrix[][],int top,int left,int bottom,int right){
         if(top > bottom || left>right){
            System.out.println();
            return;
         }

         for(int i=top;i<= bottom;i++){
            System.out.print(matrix[i][left]+" ");
         }
    
        if(top < bottom){
         for(int i=left+1;i<=right;i++){
            System.out.print(matrix[bottom][i]+" ");
         }
        }
         
        if(left < right){
         for(int i= bottom-1;i>=top+1;i--){
            System.out.print(matrix[i][right]+" ");
         }
        }        

         for(int i=right;i>= left+1;i--){
            System.out.print(matrix[top][i]+" ");
         }

         spiral(matrix, top+1, left+1,bottom-1,right-1);
    }

    public static void spiral(int matrix[][]){
        int top = 0,bottom = matrix.length-1;
        int left = 0,right = matrix[0].length-1;

        while(top<= bottom && left<= right){

            for(int i=top;i<= bottom;i++){
                System.out.print(matrix[i][left]+" ");
            }

            if(top != bottom){
            for(int i=left+1;i<=right;i++){
                System.out.print(matrix[bottom][i]+" ");
            }
           }

           if(right != left){
            for(int i = bottom-1;i>= top+1;i--){
                System.out.print(matrix[i][right]+" ");
            }
           }

            for(int i= right;i>=left+1;i--){
                System.out.print(matrix[top][i]+" ");
            }

            top++;
            left++;
            bottom--;
            right--;
        }
    }

    public static void rotate90(int matrix[][]){
        int row = matrix.length-1;   
        int col = matrix[0].length-1;   
        int res[][] = new int[col+1][row+1];    
        
        for(int i=0;i<res.length;i++){   
            for(int j=0;j<res[0].length;j++){  
                res[i][j] = matrix[row-j][i];
            }
        }
        System.out.println("AFter rotating matrix by 90 in clockwise direction : ");
        print(res);
    }
    public static void rotate180(int matrix[][]){
        int res[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                  res[i][j] = matrix[matrix.length-1-i][matrix[0].length-1-j];
            }
        }
          System.out.println("AFter rotating matrix by 180  : ");
        print(res);
    }

    public static void zigzag(int matrix[][]){
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int res[][] = new int[row+1][col+1];

        for(int i =0;i<= row;i++){
             for(int j=0;j<= col;j++){
            if(i %2 == 0){
                    res[i][j] = matrix[i][j];       
            }else{
                     res[i][j] = matrix[i][col-j];
            }
        }
        }
        System.out.println("Matrix in zigzag : ");
        print(res);
    }
    public static void alternate(int matrix[][]){
       int row = matrix.length-1;
       int col = matrix[0].length-1;
       int res[][] = new int[row+1][col+1];
       int start =0;
       int end = (row+1)*(col+1)-1;
       int idx = 0;

       col++;
       while (start <= end) {
             res[idx/col][idx%col] = matrix[start/col][start%col];
             idx++;

             if(start == end){
                break;
             }
 
             res[idx/col][idx%col] = matrix[end/col][end%col];
             idx++;

             start++;
             end--;
                    
       }
       
       System.out.println("Alternate of Matrix is : ");
       print(res);
    }

    public static void main(String[] args) {
        // Matrix Multiplication.
         int matrix1[][] = {{1,2,3}};
         int matrix2[][] = {{4},{5},{6}};
         int matrix3[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}} ;
         int matrix4[][] = {{1,2,3},{4,5,6},{7,8,9}};
         multipy(matrix1, matrix2);
         multipy(matrix2, matrix1);
         
        //  Print the matrix in anti-clockwise spiral order. - Recursive approach and  Iterative approach 
          System.out.println("Matrix 1 in Spiral order ");
          spiral(matrix1);
          System.out.println();
         spiral(matrix1, 0, 0,matrix1.length-1,matrix1[0].length-1);
        System.out.println("Matrix 2 in Spiral order ");
         spiral(matrix2);
            System.out.println();
        spiral(matrix2, 0, 0,matrix2.length-1,matrix2[0].length-1 );
             System.out.println("Matrix 3 in Spiral order ");
              spiral(matrix3);
                 System.out.println();
         spiral(matrix3, 0, 0,matrix3.length-1,matrix3[0].length-1);
              System.out.println("Matrix 4 in Spiral order ");
               spiral(matrix4);
                  System.out.println();
         spiral(matrix4, 0, 0,matrix4.length-1,matrix4[0].length-1);

        //  Rotate Matrix by 90° (clockwise).
         rotate90(matrix1);
           rotate90(matrix2);
             rotate90(matrix3);
               rotate90(matrix4);
    
        // Rotate Matrix by 180°.
        rotate180(matrix1);
        rotate180(matrix2);
          rotate180(matrix3);
          rotate180(matrix4);

        //    Print Matrix Row wise in Zig-Zag (Wave Traversal).
        zigzag(matrix1);
        zigzag(matrix2);
        zigzag(matrix3);
        zigzag(matrix4);

        //  Print Matrix in Alternating from start and end.
          alternate(matrix1);
            alternate(matrix2);
              alternate(matrix3);
        alternate(matrix4);
    }
}

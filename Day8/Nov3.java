public class Nov3 {
    public static void search(int arr[][],int target){
        int right = arr[0].length-1;
        int top =0;

        while(top <= arr.length-1 && 0 <= right){
            int el = arr[top][right];
            if(target == el){
                System.out.println("Target is found at index : ("+top+","+right+")" );
                break;
            }else if(target <el){
                right--;
            }else{
                top++;
            }
        }
    }

    public static void searchRow(int arr[][],int target){
        int bottom = arr.length-1;
        int left =0;

        while (bottom >= 0 && left <= arr[0].length) {
            int el = arr[bottom][left];
            if(el == target){
                System.out.println("Target is found at index : ("+bottom+","+left+")");
                break;
            }else if(el > target){
                bottom--;
            }else{
                left++;
            }
        }
        }
    
        public static int[] kadane1d(int arr[]){
            int currSum = arr[0];
            int maxSum = arr[0];
            int start =0,end =0;
            int tempStart = 0;
            for(int i=1;i<arr.length;i++){
              if(arr[i]>arr[i]+currSum){
                 tempStart = i;
                 currSum += arr[i];
              }else{
                   currSum += arr[i];
              }

              if(maxSum < currSum){
                maxSum = currSum;
                start = tempStart;
                end = i;
              }
            }
            return new int[]{maxSum,start,end};
        }

        public static void printMatrix(int matrix[][],int top,int bottom,int left,int right){
            System.out.println("Largest sum submatrix : ");
            for(int i = top;i<=bottom;i++){
                for(int j=left;j<= right;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }
        public static void kadane2d(int matrix[][]){
            int finalMax = Integer.MIN_VALUE;
            int finalleft =0,finalRight =0;
            int finalTop = 0,finalBottom =0;

            for(int left =0;left<matrix[0].length;left++){
                int temp[] = new int[matrix.length]; 
               for(int right = left;right<matrix[0].length;right++){
                 for(int i =0;i<temp.length;i++){
                    temp[i] += matrix[i][right];
                 }
                 int tempMax[] = kadane1d(temp);
                 int max = tempMax[0];
                 int top = tempMax[1];
                 int bottom = tempMax[2];
                 if(max > finalMax ){
                    finalMax = max;
                     finalleft = left;
                     finalRight = right;
                     finalTop = top;
                     finalBottom = bottom;
                 }
               }
            }

            System.out.println("Largest sum of submatrix is : "+finalMax);
            printMatrix(matrix,finalTop,finalBottom,finalleft,finalRight);
        }
        public static void print(int matrix[][]){
           int top=0,bottom = matrix.length-1;
           int left =0,right = matrix[0].length-1;

          for(int i=top;i<=bottom;i++){
            System.out.print(matrix[i][left]+" ");
          }
       

          if(top != bottom){
          for(int i = left+1;i < right;i++){
            System.out.print(matrix[bottom][i]+" ");
          }
        }

        if(left != right){
          for(int i = bottom ;i > top;i--){
            System.out.print(matrix[i][right]+" ");
          } 
        }

        for(int i = right;i>left;i--){
            System.out.print(matrix[top][i]+" ");
        }
        System.out.println();
        }

        public static void snake(int arr[][]){
            for(int col =0;col < arr[0].length;col++){
                for(int row =0;row<arr.length;row++){
               if(col % 2 == 0){
                System.out.print(arr[row][col] +" ");
               }else{
                System.out.print(arr[arr.length-1-row][col]+" ");
               }
            }
            }
            System.out.println();
        }

        public static boolean isSymmetric(int arr[][]){
            if(arr.length != arr[0].length){
                return false;
            }

            for(int i =0;i<arr.length;i++){
                for(int j=i+1;j<arr[0].length;j++){
                    if(  arr[i][j] != arr[j][i]){
                      return false;
                    }
                }
            }
            return true;
        }
    public static void main(String[] args) {
        // Search in a Row-Wise and Column-Wise Sorted Matrix.
      
      int matrix[][] = {
        {10  ,20 , 30 , 40},
        {15 , 25  ,35,  45},
        {27  ,29 , 37,  48},
        {32  ,33  ,39  ,50}
      };
         int matrix1[][] = {{1,2,3}};
         int matrix2[][] = {{4},{5},{6}};

     search(matrix, 32);
     searchRow(matrix, 35);

    //  Largest Sum Submatrix (Kadane’s 2D).
    int matrix5[][] = {
        {-10  ,-20 , 30 , 40},
        {15 , -25  ,35,  45},
        {27  ,-29 , 37,  -48},
        {-32  ,-33  ,39  ,-50}
      };
      kadane2d(matrix5);

    // Print Boundary Elements Only.
     print(matrix);
     print(matrix1);
     print(matrix2);

    //  Snake Pattern (Column-wise).
     snake(matrix);

    // Check if Matrix is Symmetric.
   int matrix4[][] ={
    {2,-1,3},
    {-1,5,9},
    {3,9,6}
   };

   System.out.println("The matrix is symmetric : "+isSymmetric(matrix4));

    }
}

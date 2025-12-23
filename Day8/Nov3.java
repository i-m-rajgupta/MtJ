public class Nov3 {
    public static void search(int arr[][],int target){
        int right = arr[0].length-1;
        int top =0;

        while(top <= arr.length-1 && 0 <= right){
            int el = arr[top][right];
            if(target == el){
                System.out.println("Target is found at index : ( "+top+","+right+" )" );
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

    // Print Boundary Elements Only.
     print(matrix);
     print(matrix1);
     print(matrix2);
    }
}

public class Nov1 {
    public static void rowSum(int arr[][]){
         int sum = 0;
         for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                sum += arr[i][j];
            }
            System.out.println("Sum of Row "+(i+1)+" is : "+sum);
            sum = 0;
         }
    }
    public static void colSum(int arr[][]){
        int sum =0;
        for(int j =0;j<arr[0].length;j++){
            for(int i=0;i<arr.length;i++){
                sum += arr[i][j];
            }
            System.out.println("Sum of column is "+(j+1)+" is "+sum);
            sum = 0;
        }
    }

    public static void print(int arr[][]){
         for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print( arr[i][j]+" ");
            }
            System.out.println();
         }
    }
    public static void transpose(int arr[][]){
        int newArr[][] = new int[arr[0].length][arr.length];
        System.out.println("Matrix Before Transpose : ");
        print(arr);

        for(int i = 0;i<newArr.length;i++){
            for(int j=0;j<arr.length;j++){
                newArr[i][j] = arr[j][i];
            }
        }

           System.out.println("Matrix After Transpose : ");
        print(newArr);
    }

    public static void printDiagonal(int arr[][]){
        System.out.println("Diagonal elements of the elements are : ");
          for(int i =0;i<arr.length;i++){
                System.out.print( arr[i][i]+" ");
         }
         System.out.println();
    }

    public static void maximum(int arr[][]){
        int max = Integer.MIN_VALUE;

           for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
              if(arr[i][j] > max){
                max = arr[i][j];
              }
            }
         }

         System.out.println("Maximum element in the matrix is : "+max);
    }
    public static void main(String[] args) {
        //  Print the Sum of Each Row.
         int matrix[][] = {{2,5,6},{5,5,9}};
         rowSum(matrix);

        //   Print the Sum of Each Column.
         colSum(matrix);
       
        //  Transpose of a Matrix.
        transpose(matrix);

           int matrix1[][] = {{2,5,6},{7,8,9},{1,4,3}};
        // Print the Diagonal Elements. 
       printDiagonal(matrix1);

    //    Maximum element in a 2D array.
      maximum(matrix1);

    }
}

import java.util.Scanner;
public class Program1 {
    public static void main(String[] args) {
             int [][] arr = new int[3][3];
      System.out.println("Enter matrix elements ");
      Scanner sc= new Scanner(System.in);
      for(int i=0;i<arr.length;i++){
        for(int j =0;j<arr[0].length;j++){
            arr[i][j] = sc.nextInt();
        }
      }

      System.out.println("Enter element to search in the matrix : ");
      int target = sc.nextInt();
     boolean isfound = false;
        for(int i=0;i<arr.length;i++){
        for(int j =0;j<arr[0].length;j++){
             if(arr[i][j] == target){
                isfound = true;
                break;
             }
        }
      }

      if(isfound){
        System.out.println("Element has found");
      }else{
        System.out.println("Element has not found");
      }
    }
}
